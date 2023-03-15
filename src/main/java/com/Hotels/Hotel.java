package com.Hotels;

public class Hotel{
    private Integer hotelid;
    private Integer category;
    private String address;
    private Integer totalrooms;
    private String name;

    public Hotel(Integer category, String address, Integer totalrooms, String name) {
        this.category = category;
        this.address = address;
        this.totalrooms = totalrooms;
        this.name = name;
    }
    public Hotel(Integer hotelid, Integer category, String address, Integer totalrooms, String name) {
        this.hotelid = hotelid;
        this.category = category;
        this.address = address;
        this.totalrooms = totalrooms;
        this.name = name;
    }

    public Integer getHotelid() {
        return hotelid;
    }

    public Integer getCategory() {
        return category;
    }

    public String getAddress() {
        return address;
    }

    public Integer getTotalrooms() {
        return totalrooms;
    }

    public String getName() {
        return name;
    }

    public void setHotelid(Integer hotelid) {
        this.hotelid = hotelid;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setTotalrooms(Integer totalrooms) {
        this.totalrooms = totalrooms;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {

        return "<ul>"
                + "<li>hotelid= " + hotelid + "</li>"
                + "<li>category= " + category + "</li>"
                + "<li>address= " + address + "</li>"
                + "<li>totalrooms= " + totalrooms + "</li>"
                + "<li>name= " + name + "</li>";
    }
}
