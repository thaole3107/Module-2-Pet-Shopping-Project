package com.codegym.customer;

public class CustomerFactory {
    public static Customer createCustomer(String id, String name, double wallet, String type) {
        if (type.equalsIgnoreCase("regular")) {
            return new RegularCustomer(id, name, wallet);
        } else if (type.equalsIgnoreCase("vip")) {
            return new VipCustomer(id, name, wallet);
        } else {
            throw new IllegalArgumentException("Invalid customer type: " + type);
        }
    }
}