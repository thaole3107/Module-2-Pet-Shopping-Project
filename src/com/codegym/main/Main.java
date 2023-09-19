package com.codegym.main;
import com.codegym.customer.*;
import com.codegym.pet.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
         int luaChon = 0;
        do {
            System.out.println("MENU--------------------------------------");
            System.out.println("Please choose the function you need");
            System.out.println(
                  "1. Add pets to the list.\n"
                + "2. Print the list of pets to the screen.\n"
                + "3. Remove pet by id from list.\n "
                + "4. Change info of pet by id from list.\n "
                + "5. Show pet with high to low price.\n "
                + "6. Print the list of customer to the screen.\n "
                + "7. Buy pet.\n "
                + "0. Exit.\n"
                + "");
            luaChon = sc.nextInt();
            sc.nextLine();
            switch (luaChon) {
                case 1:
                    PetManagement.addPets();
                    WriteAndReadPetList.saveFile();
                    break;
                case 2:
                    PetManagement.printPets();
                    break;
                case 3:
                    PetManagement.removePetById();
                    WriteAndReadPetList.saveFile();
                    break;
                case 4:
                    PetManagement.changeInfoById();
                    WriteAndReadPetList.saveFile();
                    break;
                case 5:
                    PetManagement.sortPetByPrice();
                    break;
                case 6:
                    CustomerManagement.printCustomer();
                    break;
                case 7:
                    CustomerManagement.buyPet();
                    break;
                case 0:
                    System.out.println("Exiting the program...");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        } while (luaChon != 0);
    }

            // Create customer list
            public static class CustomerList{
                private static CustomerList instance = null;
                private static List<Customer> customers;
                public CustomerList(){
                    customers = new ArrayList<>();
                    Customer john = CustomerFactory.createCustomer("R1", "John", 800.0, "regular");
                    Customer ben = CustomerFactory.createCustomer("R2", "Ben", 1000.0, "regular");

                    Customer marry = CustomerFactory.createCustomer("V1", "Marry", 5000.0, "vip");
                    Customer lyly = CustomerFactory.createCustomer("V2", "LyLy", 8000.0, "vip");

                    customers.add(john);
                    customers.add(ben);
                    customers.add(marry);
                    customers.add(lyly);
                }
                public static CustomerList getInstance(){
                    if (instance == null) {
                        instance = new CustomerList();
                    }
                    return instance;
                }
                public static List<Customer> getCustomers() {
                    return customers ;
                }
            }

            // Create com.codegym.pet.Pet List
            public static class PetList {
            private static PetList instance = null;
            private static List<Pet> pets;
            public PetList() {
                pets = new ArrayList<>();
                Dog bobby = new Dog.Builder()
                        .id("D1")
                        .name("Buddy")
                        .age(2)
                        .weight(10.5f)
                        .colour("Brown")
                        .gender("Male")
                        .type("Phu Quoc")
                        .price(500)
                        .food("Bone")
                        .build();

                Dog lucy = new Dog.Builder()
                        .id("D2")
                        .name("Lucy")
                        .age(3)
                        .weight(12.2f)
                        .colour("Black")
                        .gender("Male")
                        .type("Bac Kinh")
                        .price(350)
                        .food("cereal")
                        .build();
                Dog lucky = new Dog.Builder()
                        .id("D3")
                        .name("Lucky")
                        .age(1)
                        .weight(8.5f)
                        .colour("White")
                        .gender("Female")
                        .type("Corgi")
                        .price(600)
                        .food("cereal")
                        .build();
                Dog Lisa = new Dog.Builder()
                        .id("D4")
                        .name("Lisa")
                        .age(2)
                        .weight(15.2f)
                        .colour("White")
                        .gender("Female")
                        .type("Alaska")
                        .price(1000)
                        .food("meat")
                        .build();

                pets.add(bobby);
                pets.add(lucy);
                pets.add(lucky);
                pets.add(Lisa);

                Bird dodo = new Bird.Builder()
                        .id("B1")
                        .name("Do")
                        .age(1)
                        .weight(0.5f)
                        .colour("Red")
                        .gender("Female")
                        .type("Canada")
                        .price(1200)
                        .fly(String.valueOf(true))
                        .build();
                Bird rere = new Bird.Builder()
                        .id("B2")
                        .name("Re")
                        .age(2)
                        .weight(2f)
                        .colour("White")
                        .gender("Male")
                        .type("USA")
                        .price(1000)
                        .fly(String.valueOf(false))
                        .build();
                Bird mimi = new Bird.Builder()
                        .id("B3")
                        .name("Mi")
                        .age(1)
                        .weight(1.5f)
                        .colour("Pink")
                        .gender("Male")
                        .type("China")
                        .price(800)
                        .fly(String.valueOf(true))
                        .build();
                Bird fafa = new Bird.Builder()
                        .id("B4")
                        .name("Fa")
                        .age(1)
                        .weight(1.8f)
                        .colour("Green")
                        .gender("Female")
                        .type("ThaiLand")
                        .price(900)
                        .fly(String.valueOf(true))
                        .build();

                pets.add(dodo);
                pets.add(rere);
                pets.add(mimi);
                pets.add(fafa);

            }
//                public PetList() {
//                    pets = new ArrayList<>();
//                }
                public static PetList getInstance() {
                if (instance == null) {
                    instance = new PetList();
                }
                return instance;
            }
            public static List<Pet> getPets() {
                return pets;
            }
        }
     }
