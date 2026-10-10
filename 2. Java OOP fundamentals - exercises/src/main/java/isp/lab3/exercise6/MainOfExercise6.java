package isp.lab3.exercise6;

import isp.lab3.exercise6.VendingMachineSingleton;

public class MainOfExercise6 {
    public static void main(String[] args) {
        VendingMachineSingleton vendingMachine = VendingMachineSingleton.getInstance();
        vendingMachine.userMenu();
    }
}
