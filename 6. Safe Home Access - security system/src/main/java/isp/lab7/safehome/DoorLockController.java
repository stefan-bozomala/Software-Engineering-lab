package isp.lab7.safehome;

import java.time.LocalDateTime;
import java.util.*;

public class DoorLockController implements ControllerInterface {

    private Map<Tenant, AccessKey> validAccess = new HashMap<>();
    private List<AccessLog> accessLogList = new ArrayList<>();
    private int counter = 0;
    private Door door = new Door();

    @Override
    public DoorStatus enterPin(String pin) {
        if (ControllerInterface.MASTER_KEY.equals(pin)) {
            counter = 0;
            door.unlockDoor();
            accessLogList.add(new AccessLog("MasterAdmin", LocalDateTime.now(), "Master Reset", door.getStatus(), "Succeeded"));
            return door.getStatus();
        }

        if (counter >= 3) {
            accessLogList.add(new AccessLog("Unknown", LocalDateTime.now(), "Access Attempt", door.getStatus(), "System Locked"));
            throw new TooManyAttemptsException("Door locked! Use Master Key.");
        }

        Tenant matchedTenant = null;
        for (Map.Entry<Tenant, AccessKey> entry : validAccess.entrySet()) {
            if (entry.getValue().getPin().equals(pin)) {
                matchedTenant = entry.getKey();
                break;
            }
        }

        if (matchedTenant != null) {
            counter = 0;
            if (door.getStatus() == DoorStatus.OPEN) {
                door.lockDoor();
            } else {
                door.unlockDoor();
            }
            accessLogList.add(new AccessLog(matchedTenant.getName(), LocalDateTime.now(), "Door Toggle", door.getStatus(), "Success"));
            return door.getStatus();
        }

        else {
            counter++;
            accessLogList.add(new AccessLog("Unknown", LocalDateTime.now(), "Invalid PIN", door.getStatus(), "Failed"));

            if (counter >= 3) {
                door.lockDoor();
                throw new TooManyAttemptsException("Too Many Attempts - System Locked.");
            }
            throw new InvalidPinException("Wrong PIN.");
        }
    }

    @Override
    public void addTenant(String pin, String name) throws Exception {
        for (Tenant t : validAccess.keySet()) {
            if (t.getName().equals(name)) {
                throw new TenantAlreadyExistsException("Tenant already exists!");
            }
        }
        validAccess.put(new Tenant(name), new AccessKey(pin));
        accessLogList.add(new AccessLog(name, LocalDateTime.now(), "Add Tenant", null, "Admin Action"));
    }

    @Override
    public void removeTenant(String name) throws Exception {
        Tenant toRemove = null;
        for (Tenant t : validAccess.keySet()) {
            if (t.getName().equals(name)) {
                toRemove = t;
                break;
            }
        }

        if (toRemove == null) {
            throw new TenantNotFoundException("Tenant not found");
        }

        validAccess.remove(toRemove);
        accessLogList.add(new AccessLog(name, LocalDateTime.now(), "Remove Tenant", null, "Admin Action"));
    }

    public List<AccessLog> getAccessLogList() {
        return accessLogList;
    }
}