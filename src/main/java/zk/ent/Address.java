package zk.ent;

public class Address {

    private int id;
    private String index;
    private String city;
    private String street;
    private String homeNumber;
    private String apartment;

    public Address() {
    }

    public Address(int id, String index, String city, String street, String homeNumber, String apartment) {
        this.id = id;
        this.index = index;
        this.city = city;
        this.street = street;
        this.homeNumber = homeNumber;
        this.apartment = apartment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHomeNumber() {
        return homeNumber;
    }

    public void setHomeNumber(String homeNumber) {
        this.homeNumber = homeNumber;
    }

    public String getApartment() {
        return apartment;
    }

    public void setApartment(String apartment) {
        this.apartment = apartment;
    }
}