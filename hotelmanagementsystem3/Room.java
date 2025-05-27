/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotelmanagementsystem3;

/**
 *
 * @author hp
 */
public class Room {
    private int roomNumber;
    private String roomType;
    private double price;
    private boolean available;
    private int rating;

    public Room(int roomNumber, String roomType, double price, boolean available) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.price = price;
        this.available = available;
        this.rating = 0;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public String getRoomType() {
        return roomType;
    }

    public double getPrice() {
        return price;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

     public void displayInfo() {
        System.out.println("Room No: " + roomNumber + ", Type: " + roomType + ", Price: BDT " + price +
                ", Available: " + (available ? "Yes" : "No") + ", Rating: " + rating + "/5");
    }

}
