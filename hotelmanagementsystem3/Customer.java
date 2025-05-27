/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotelmanagementsystem3;
import java.util.*;
/**
 *
 * @author hp
 */
public class Customer extends Person {
    public Customer(String name, String contact) {
        super(name, contact);
    }

    @Override
    public void displayInfo() {
        System.out.println("Customer Name: " + name);
        System.out.println("Contact: " + contact);
    }

    public void displayCustomer() {
        displayInfo(); // call the overridden method
 }
}