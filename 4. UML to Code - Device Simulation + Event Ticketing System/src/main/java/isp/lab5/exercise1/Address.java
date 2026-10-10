package isp.lab5.exercise1;

public class Address {
    private String street;
    private String city;

    public Address(String street, String city){
        this.street = street;
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
