package com.Hotels;

/**
 * Student class to store student data
 */

public class Hotelchain {

    private Integer id;
    private String surname;
    private String name;
    private Integer totalhotels;
    private String address;
    private String email;
    private String phoneno;
    /**
     * Constructor to save Hotelchain's data (without name)
     *
     * @param totalhotels total number of hotelchain
     * @param address address of hotelchain
     * @param email email of hotelchain
     * @param phoneno Phone number of hotelchain
     */
    public Hotelchain(Integer totalhotels, String address, String email, String phoneno) {
        this.totalhotels = totalhotels;
        this.address = address;
        this.email = email;
        this.phoneno = phoneno;
    }

    /**
     * Constructor to save Hotelchain's data (without name)
     *
     * @param name name of the hotelchain
     * @param totalhotels total number of hotelchain
     * @param address address of hotelchain
     * @param email email of hotelchain
     * @param phoneno Phone number of hotelchain
     */
    public Hotelchain(String name, Integer totalhotels, String address, String email, String phoneno) {
        this.name = name;
        this.totalhotels = totalhotels;
        this.address = address;
        this.email = email;
        this.phoneno = phoneno;
    }

    // getters
    public String getName() { return this.name; }
    public Integer getTotalHotels() { return this.totalhotels; }
    public String getAddress() { return this.address; }
    public String getEmail() { return this.email; }
    public String getPhoneno() { return this.phoneno; }

    // setters

    public void setName(String name) { this.name = name; }
    public void setTotalhotels(Integer totalhotels) {this.totalhotels = totalhotels; }
    public void setAddress(String address) { this.address = address; }
    public void setEmail(String email) { this.email = email; }
    public void setPhoneno(String phoneno) { this.phoneno = phoneno; }

    @Override
    public String toString() {

        return "<ul>"
                + "<li>name= " + name + "</li>"
                + "<li>totalHotels= " + totalhotels + "</li>"
                + "<li>address= " + address + "</li>"
                + "<li>email= " + email + "</li>"
                + "<li>phoneno= " + phoneno + "</li>";
    }
}
