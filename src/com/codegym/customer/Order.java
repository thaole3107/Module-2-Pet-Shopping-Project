package com.codegym.customer;

public class Order {
    private String customerName;
    private String customerId;
    private String petId;
    private String petName;
    private int price;

    public Order(String customerName, String customerId, String petId, String petName, int price) {
        this.customerName = customerName;
        this.customerId = customerId;
        this.petId = petId;
        this.petName = petName;
        this.price = price;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getPetId() {
        return petId;
    }

    public void setPetId(String petId) {
        this.petId = petId;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Order{" +
                "customerName='" + customerName + '\'' +
                ", customerId='" + customerId + '\'' +
                ", petId='" + petId + '\'' +
                ", petName='" + petName + '\'' +
                ", price=" + price +
                '}';
    }
}
