package com.codegym.customer;

import com.codegym.main.Main;
import com.codegym.pet.Dog;

import java.io.*;
import java.util.List;

public class WriteAndReadCustomerList {
    public static final String FILE_DIR_PATH = "E:\\CODEGYM\\Codegym\\" +
            "Module-02-Advanced-Programming-with-Java 2.1\\" +
            "Training Code\\CaseStudyModel2\\";

    public static void saveFile() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_DIR_PATH + "CustomerList.txt"));
            Main.CustomerList.getInstance();
            List<Customer> customers = Main.CustomerList.getCustomers();
            for (Customer customer : customers) {
                writer.write(String.valueOf(customer));
                writer.newLine();
            }
            writer.close();
            System.out.println("Successfully wrote list of Pet to file.");
        } catch (IOException e) {
            System.out.println("\"An error occurred while writing to the file.\"");
            e.printStackTrace();
        }
    }

    public static void readFile() {
        try {

            Main.CustomerList.getInstance();
            List<Customer> customers = Main.CustomerList.getCustomers();
            BufferedReader reader = new BufferedReader(new FileReader(FILE_DIR_PATH + "CustomerList.txt"));
            String line = ""; //gán tung dong du lieu, ban dau khai bao rong
            while ((line = reader.readLine()) != null) {
                Customer customer = handleLine(line);
                customers.add(customer);
            }
            reader.close();
            System.out.println("Successfully read customer of Pet from file.");
        } catch (IOException e) {
            System.out.println("An error occurred while reading from the file.");
            e.printStackTrace();
        }


    }

    private static Customer handleLine(String line) {
        String[] customerDetails = line.split(", ");
        String customerId = customerDetails[0];
        String customerName = customerDetails[1];
        double customerWallet = Double.parseDouble(customerDetails[2]);

        if (getCustomerCategory(customerId).equals("Regular")) {
            return new RegularCustomer(customerId, customerName, customerWallet);
        }else {
            return new VipCustomer(customerId, customerName, customerWallet);
        }
    }

    private static String getCustomerCategory(String id) {
        return (id.startsWith("R")) ? "Regular" : "Vip";
    }

}

