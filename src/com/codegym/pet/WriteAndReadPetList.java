package com.codegym.pet;
import com.codegym.main.Main;

import java.io.*;
import java.util.List;

public class WriteAndReadPetList {
    public static final String FILE_DIR_PATH = "E:\\CODEGYM\\Codegym\\" +
                                                "Module-02-Advanced-Programming-with-Java 2.1\\" +
                                                "Training Code\\CaseStudyModel2\\";

    public static void saveFile(){
        try {BufferedWriter writer = new BufferedWriter( new FileWriter(FILE_DIR_PATH + "PetList.txt"));
            Main.PetList.getInstance();
            List<Pet> pets = Main.PetList.getPets();
            for (Pet pet : pets) {
                writer.write(String.valueOf(pet));
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
            Main.PetList.getInstance();
            List<Pet> pets = Main.PetList.getPets();
            BufferedReader reader = new BufferedReader(new FileReader(FILE_DIR_PATH + "PetList.txt"));
            String line = ""; //gán tung dong du lieu, ban dau khai bao rong
            while ((line = reader.readLine()) != null) {
                Pet pet = handleLine(line);
                pets.add(pet);
            }
            reader.close();
            System.out.println("Successfully read list of Pet from file.");
        } catch (IOException e) {
            System.out.println("An error occurred while reading from the file.");
            e.printStackTrace();
        }
    }

    private static Pet handleLine(String line) {
        String[] petDetails = line.split(", ");
        String petId = petDetails[0];
        String petName = petDetails[1];
        int petAge = Integer.parseInt(petDetails[2]);
        float petWeight = Float.parseFloat(petDetails[3]);
        String petColor = petDetails[4];
        String petGender = petDetails[5];
        String petType = petDetails[6];
        int petPrice = Integer.parseInt(petDetails[7]);
        String petFoodOrFlyable = petDetails[8];

        if (getPetCategory(petId).equals("Dog")){
            return new Dog.Builder()
                    .id(petId)
                    .name(petName)
                    .age(petAge)
                    .weight(petWeight)
                    .colour(petColor)
                    .gender(petGender)
                    .type(petType)
                    .price(petPrice)
                    .food(petFoodOrFlyable)
                    .build();
        }

        return new Bird.Builder()
                .id(petId)
                .name(petName)
                .age(petAge)
                .weight(petWeight)
                .colour(petColor)
                .gender(petGender)
                .type(petType)
                .price(petPrice)
                .fly(petFoodOrFlyable)
                .build();
    }

    private static String getPetCategory(String id) {
        return (id.startsWith("D")) ? "Dog" : "Bird";
    }

}


