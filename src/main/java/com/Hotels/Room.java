package com.Hotels;

public class Room {
    private Integer roomid;
    private Integer capacity;
    private Boolean status;
    private Integer price;
    private String roomview;
    private Boolean extension;
    private String damages;
    private String amenities;
    private Integer hotelid;

    public Room(Integer capacity, Boolean status, Integer price, String roomview, Boolean extension, String damages, String amenities, Integer hotelid) {
        this.capacity = capacity;
        this.status = status;
        this.price = price;
        this.roomview = roomview;
        this.extension = extension;
        this.damages = damages;
        this.amenities = amenities;
        this.hotelid = hotelid;
    }

    public Room(Integer roomid, Integer capacity, Boolean status, Integer price, String roomview, Boolean extension, String damages, String amenities, Integer hotelid) {
        this.roomid = roomid;
        this.capacity = capacity;
        this.status = status;
        this.price = price;
        this.roomview = roomview;
        this.extension = extension;
        this.damages = damages;
        this.amenities = amenities;
        this.hotelid = hotelid;
    }

    public Integer getRoomid() {
        return roomid;
    }

    public void setRoomid(Integer roomid) {
        this.roomid = roomid;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getRoomview() {
        return roomview;
    }

    public void setRoomview(String roomview) {
        this.roomview = roomview;
    }

    public Boolean getExtension() {
        return extension;
    }

    public void setExtension(Boolean extension) {
        this.extension = extension;
    }

    public String getDamages() {
        return damages;
    }

    public void setDamages(String damages) {
        this.damages = damages;
    }

    public String getAmenities() {
        return amenities;
    }

    public void setAmenities(String amenities) {
        this.amenities = amenities;
    }

    public Integer getHotelid() {
        return hotelid;
    }

    public void setHotelid(Integer hotelid) {
        this.hotelid = hotelid;
    }

    @Override
    public String toString() {
        return "<ul>"
                + "<li>roomid= " + roomid + "</li>"
                + "<li>capacity= " + capacity + "</li>"
                + "<li>status= " + status + "</li>"
                + "<li>price= " + price + "</li>"
                + "<li>roomview= " + roomview + "</li>"
                + "<li>extension= " + extension + "</li>"
                + "<li>damages= " + damages + "</li>"
                + "<li>amenities= " + amenities + "</li>"
                + "<li>hotelid= " + hotelid + "</li>";
    }
}