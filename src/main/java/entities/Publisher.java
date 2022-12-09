/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

/**
 *
 * @author yukit
 */
public class Publisher {
    private int publisher_ID;
    private String name;
    private String address;
    private String phoneNumber;
    
    public Publisher() {
    }

    public Publisher(int publisher_ID) {
        this.publisher_ID = publisher_ID;
    }

    public Publisher(String name,String address,String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public Publisher(int publisher_ID,String name,String address,String phoneNumber) {
        this.publisher_ID = publisher_ID;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public int getPublisher_ID() {
        return publisher_ID;
    }

    public void setPublisher_ID(int publisher_ID) {
        this.publisher_ID = publisher_ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Publisher{" + "publisher_ID=" + publisher_ID + ", name=" + name + ", address=" + address + ", phoneNumber=" + phoneNumber + '}';
    }
    
    
}
