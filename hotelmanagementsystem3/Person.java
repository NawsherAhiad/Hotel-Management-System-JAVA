/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotelmanagementsystem3;

/**
 *
 * @author hp
 */
public abstract class Person {
    protected String name;
    protected String contact;

    public Person(String name, String contact) {
        this.name = name;
        this.contact = contact;
    }

    // ✅ Add these getters if not already present
    public String getName() {
        return name;
    }

    public String getContact() {
        return contact;
    }

    public abstract void displayInfo();
}