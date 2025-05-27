/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

// HotelManagementSystem.java
package hotelmanagementsystem3;



import java.util.ArrayList;
import java.util.InputMismatchException;

import java.util.Scanner;

// Main class implementing the HotelInterface
public class HotelManagementSystem3 implements HotelInterface {
    // Scanner for user input
    static Scanner sc = new Scanner(System.in);
    
    // Lists to store rooms, customers, and reservations
    static ArrayList<Room> rooms = new ArrayList<>();
    static ArrayList<Customer> customers = new ArrayList<>();
    static ArrayList<Reservation> reservations = new ArrayList<>();
    static CompanyAccount companyAccount = new CompanyAccount();

    public static void main(String[] args) {
        // Creating object of HotelManagementSystem
        HotelManagementSystem3 hms = new HotelManagementSystem3();
        

        // Initializing available rooms
        hms.initializeRooms();

        // Flag to control the main menu loop
        boolean running = true;

        System.out.println("\n===== WELCOME TO SKY VIEW HOTEL  =====");

        // Main menu loop
        while (running) {
            try {
                // Displaying menu options
                System.out.println("\nMain Menu:");
                System.out.println("1. View Room Details");
                System.out.println("2. Check Room Availability");
                System.out.println("3. Book a Room");
                System.out.println("4. Make Payment");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");

                // Taking user input
                int choice = getIntInput();

                // Handling menu options using switch-case
                switch (choice) {
                    case 1 -> hms.displayRoomDetails();   // Show all room details
                    case 2 -> hms.checkAvailability();    // Check available rooms
                    case 3 -> hms.bookRoom();             // Start booking process
                    case 4 -> hms.makePayment();          // Proceed with payment
                    case 5 -> {
                        // Exit program
                        System.out.println("\nThank you for choosing Sky View Hotel. Have a pleasant day!");
                        running = false;
                    }
                    default -> System.out.println("Invalid choice. Please try again.");
                }
            } catch (Exception e) {
                // Catch unexpected exceptions in main menu
               //System.out.println("An unexpected error occurred. Please try again. (" + e.getMessage() + ")");
                sc.nextLine(); // clear the buffer
            }
        }
    }

    // Method to initialize a list of rooms
    void initializeRooms() {
        rooms.add(new Room(101, "Deluxe", 2000, true));
        rooms.add(new Room(102, "Executive", 3000, true));
        rooms.add(new Room(103, "Suite", 5000, true));
        rooms.add(new Room(104, "Standard", 1500, true));
        rooms.add(new Room(105, "Presidential", 7000, true));
    }

    // Display details of all rooms
    @Override
    public void displayRoomDetails() {
        System.out.println("\n===== ROOM DETAILS =====");
        for (Room r : rooms) {
            r.displayInfo();
        }
    }

    // Check which rooms are currently available
    @Override
    public void checkAvailability() {
        System.out.println("\n===== AVAILABLE ROOMS =====");
        for (Room r : rooms) {
            if (r.isAvailable()) {
                System.out.println("Room " + r.getRoomNumber() + " (" + r.getRoomType() + ") - BDT " + r.getPrice());
            }
        }
    }

    // Handle room booking
    @Override
    public void bookRoom() {
        try {
            // Get user details and desired room number
            System.out.print("\nEnter your name: ");
            String name = sc.nextLine();
            System.out.print("Enter contact: ");
            String contact = sc.nextLine();
            System.out.print("Enter check-in date (dd-mm-yyyy): ");
            String checkIn = sc.nextLine();
            System.out.print("Enter check-out date (dd-mm-yyyy): ");
            String checkOut = sc.nextLine();
            System.out.print("Enter room number to book: ");
            int roomNum = getIntInput();

            // Find room and book if available
            Room room = findRoom(roomNum);
            if (room != null && room.isAvailable()) {
                room.setAvailable(false); // Set room as unavailable
                Customer c = new Customer(name, contact);
                Reservation r = new Reservation(c, room, checkIn, checkOut);
                customers.add(c);
                reservations.add(r);
                System.out.println("Room allotted successfully! Please proceed to payment to confirm your booking.");
            } else {
                System.out.println("Room not available or invalid room number.");
            }
        } catch (Exception e) {
            System.out.println("Error during booking: " + e.getMessage());
        }
    }

    // Handle payment process
    @Override
public void makePayment() {
    try {
        System.out.print("\nEnter room number for payment: ");
        int roomNum = getIntInput();

        // Find reservation for the given room number
        Reservation matchedReservation = null;
        for (Reservation r : reservations) {
            if (r.getRoom().getRoomNumber() == roomNum) {
                matchedReservation = r;
                break;
            }
        }

        if (matchedReservation != null) {
            Room room = matchedReservation.getRoom();

            // Calculate number of days stayed
            String checkInStr = matchedReservation.getCheckInDate();
            String checkOutStr = matchedReservation.getCheckOutDate();

            java.time.format.DateTimeFormatter formatter = java.time.format.DateTimeFormatter.ofPattern("dd-MM-yyyy");
            java.time.LocalDate checkInDate = java.time.LocalDate.parse(checkInStr, formatter);
            java.time.LocalDate checkOutDate = java.time.LocalDate.parse(checkOutStr, formatter);

            long days = java.time.temporal.ChronoUnit.DAYS.between(checkInDate, checkOutDate);
            if (days <= 0) days = 1;  // Minimum 1-day charge

            double totalCost = room.getPrice() * days;

            System.out.println("Room " + room.getRoomNumber() + " (" + room.getRoomType() + ")");
            System.out.println("Stay Duration: " + days + " day(s)");
            System.out.println("Total Cost: BDT " + totalCost);

            double amountPaid = 0;

            while (amountPaid < totalCost) {
                try {
                    System.out.print("Enter amount to pay: ");
                    double payment = Double.parseDouble(sc.nextLine());
                    amountPaid += payment;

                    if (amountPaid < totalCost) {
                        double remaining = totalCost - amountPaid;

                        System.out.println("Partial payment accepted. Remaining amount: BDT " + remaining);

                        

                    }

                } catch (NumberFormatException nfe) {
                    System.out.println("Invalid input. Please enter a numeric amount.");
                }
            }

            if (amountPaid > totalCost) {
                double change = amountPaid - totalCost;
                System.out.println("Payment successful! Your room is booked.");
                System.out.println("Change to return: BDT " + change);
                companyAccount.addPayment(totalCost);
                System.out.println("Company account updated. Current balance: BDT " + companyAccount.getTotalBalance());
            } else {
                System.out.println("Payment successful! Your room is booked.");
            }

            // Simulate checkout
            room.setAvailable(true);
            System.out.println("Thank you for choosing Sky View Hotel!");

        } else {
            System.out.println("No reservation found for room number " + roomNum);
        }

    } catch (Exception e) {
        System.out.println("Payment error: " + e.getMessage());
    }
}


    // Utility method to get integer input safely
    static int getIntInput() {
        try {
            return Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number.");
            return -1;
        }
    }

    // Find room by room number
    Room findRoom(int roomNumber) {
        for (Room r : rooms) {
            if (r.getRoomNumber() == roomNumber) return r;
        }
        return null;
    }
}


        
       

            
