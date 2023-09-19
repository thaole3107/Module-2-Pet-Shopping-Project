package com.codegym.customer;
import com.codegym.main.Main;
import com.codegym.pet.*;
import com.codegym.pet.Shop;
import java.util.List;
import java.util.Scanner;

public class CustomerManagement {

    //. Show customer list
    public static void printCustomer() {
        Main.CustomerList.getInstance();
        List<Customer> customers = Main.CustomerList.getCustomers();
        if (customers.isEmpty()) {
            System.out.println("There are no customer in the list.");
        } else {
            System.out.println("List of customers:");
            for (Customer customer : customers) {
                System.out.println(customer.toString());
            }
        }
    }
        //phuong thuc mua ban
        //check customer existed or not
        public static boolean checkCustomerId(String id){
        Main.CustomerList.getInstance();
        List<Customer> customers = Main.CustomerList.getCustomers();
        for(Customer customer : customers){
            if(customer.getId().equals(id)){
                return true;
            }
        }
        return false;
        }
        // check pet existed or not
        public static boolean checkPetId(String id){
        Main.PetList.getInstance();
        List<Pet> pets = Main.PetList.getPets();
        for (Pet pet : pets){
            if(pet.getId().equals(id)){
                return true;
            }
        }
        return false;
        }

        //lay khach hang ra
        public static Customer getCustomerById(String id){
        Main.CustomerList.getInstance();
        List<Customer> customers = Main.CustomerList.getCustomers();
        for (Customer customer : customers){
            if(customer.getId().contains(id)){
                return customer;
            }
        }
        return null;
        }
        // lay con pet ra
        public static Pet getPetById(String id) {
        Main.PetList.getInstance();
        List<Pet> pets = Main.PetList.getPets();
        for (Pet pet : pets){
            if(pet.getId().equals(id)){
                return pet;
            }
        }
        return null;
        }

        //mua con pet
        public static void buyPet() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter customer id: ");
        String customerId = sc.nextLine();
        Customer customer=getCustomerById(customerId) ;
        System.out.print("Enter pet id: ");
        String petId = sc.nextLine();
        Pet newPet =getPetById(petId);
        Main.PetList.getInstance();
        List<Pet> pets = Main.PetList.getPets();

        if (checkCustomerId(customerId) && checkPetId(petId)){

            double wallet = CustomerManagement.getCustomerById(customerId).getWallet();
            int price = CustomerManagement.getPetById(petId).getPrice();

            if(wallet > price){
                CustomerManagement.getCustomerById(customerId).setWallet(wallet -= price);
                pets.remove(CustomerManagement.getPetById(petId));
                Shop.addMoney(price);
                System.out.println("you successfully buy a pet");

                Order order = new Order(customer.getName(),customerId,petId,newPet.getName(),price);
                OrderManagement.orderList.add(order);
                OrderManagement.printFile();
                System.out.println("The money in the shop is: " + Shop.getWallet());
                System.out.println("customer's current amount: "
                        + CustomerManagement.getCustomerById(customerId).getWallet() );

            } else System.out.println("you don't have enough money to buy");
        } else System.out.println(" please check again the customer's id or pet's id");
        }



}
