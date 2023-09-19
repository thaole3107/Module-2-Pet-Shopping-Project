package com.codegym.pet;

import com.codegym.main.Main;

import java.util.*;

public class PetManagement {

    public static Scanner sc = new Scanner(System.in);

   // 1. Thêm pet vào trong danh sách
    public static void addPets() {
        System.out.println("Enter the type of pet you want to add (Dog/Bird):");
        String petType = sc.nextLine();

        if (petType.equalsIgnoreCase("Dog")) {
            Dog.Builder builder = new Dog.Builder();
            System.out.println("Enter pet id:");
            String id = sc.nextLine();
            builder.id(id);
            System.out.println("Enter pet name:");
            String name = sc.nextLine();
            builder.name(name);
            System.out.println("Enter pet age:");
            int age = sc.nextInt();
            builder.age(age);
            System.out.println("Enter pet weight:");
            float weight = sc.nextFloat();
            builder.weight(weight);
            sc.nextLine();
            System.out.println("Enter pet colour:");
            String colour = sc.nextLine();
            builder.colour(colour);
            System.out.println("Enter pet gender:");
            String gender = sc.nextLine();
            builder.gender(gender);
            System.out.println("Enter pet type:");
            String type = sc.nextLine();
            builder.type(type);
            System.out.println("Enter pet price:");
            int price = sc.nextInt();
            builder.price(price);
            sc.nextLine();
            System.out.println("Enter pet food:");
            String food = sc.nextLine();
            builder.food(food);
            Dog newDog = builder.build();
            Main.PetList.getInstance();
            Main.PetList.getPets().add(newDog);
        } else if (petType.equalsIgnoreCase("Bird")) {
            Bird.Builder builder = new Bird.Builder();
            System.out.println("Enter pet id:");
            String id = sc.nextLine();
            builder.id(id);
            System.out.println("Enter pet name:");
            String name = sc.nextLine();
            builder.name(name);
            System.out.println("Enter pet age:");
            int age = sc.nextInt();
            builder.age(age);
            System.out.println("Enter pet weight:");
            float weight = sc.nextFloat();
            builder.weight(weight);
            sc.nextLine();
            System.out.println("Enter pet colour:");
            String colour = sc.nextLine();
            builder.colour(colour);
            System.out.println("Enter pet gender:");
            String gender = sc.nextLine();
            builder.gender(gender);
            System.out.println("Enter pet type:");
            String type = sc.nextLine();
            builder.type(type);
            System.out.println("Enter pet price:");
            int price = sc.nextInt();
            builder.price(price);
            sc.nextLine();
            System.out.println("Can the pet fly? (true/false)");
            boolean canFly = sc.nextBoolean();
            builder.fly(String.valueOf(canFly));
            Bird newBird = builder.build();
            Main.PetList.getPets().add(newBird);
        } else {
            System.out.println("Invalid pet type.");
        }
    }
    // 2. Hiển thì danh sách Pet
    public static void printPets() {
        Main.PetList.getInstance();
        List<Pet> pets = Main.PetList.getPets();
        if (pets.isEmpty()) {
            System.out.println("There are no pets in the list.");
        } else {
            System.out.println("List of pets:");
            for (Pet pet : pets) {
                System.out.println(pet.toString());
            }
        }
    }
    // 3. Xóa pet khỏi danh sách
    public static void removePetById() {
        System.out.print("Enter the id of the pet you want to remove: ");
        String id = sc.nextLine();
        Main.PetList.getInstance();
        List<Pet> pets = Main.PetList.getPets();
        boolean removed = false;
        for (Pet pet : pets) {
            if (pet.getId().equals(id)) {
                pets.remove(pet);
                System.out.println("The pet with id " + id + " has been removed from the list.");
                removed = true;
                break;
            }
        }
        if (removed == false) {
            System.out.println("No pet with id " + id + " was found in the list.");
        }
    }
    // 4. Sửa thông tin cua pet theo id
    public static void changeInfoById() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter pet id: ");
        String id = sc.nextLine();
        Main.PetList.getInstance();
        List<Pet> pets = Main.PetList.getPets();

        // có id cần tìm
        Pet pet = null;
        for (Pet p : pets) {
            if (p.getId().equals(id)) {
                pet = p;
                break;
            }
        }
        if (pet == null) {
            System.out.println("No pet with id " + id + " found.");
            return;
        }

    // 3. Nhập thông tin mới cho pet

        System.out.println("Enter new information for pet " + id + ":");
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Age: ");
        int age = sc.nextInt();
        sc.nextLine();
        System.out.print("Weight: ");
        float weight = sc.nextFloat();
        sc.nextLine();
        System.out.print("Colour: ");
        String colour = sc.nextLine();
        System.out.print("Gender: ");
        String gender = sc.nextLine();
        System.out.print("Type: ");
        String type = sc.nextLine();
        System.out.print("Price: ");
        int price = sc.nextInt();
        sc.nextLine();

    // 4. Kiểm tra loại pet để thay đổi thông tin phù hợp

        if (pet instanceof Dog) {
            Dog.Builder builder = new Dog.Builder()
                    .id(id)
                    .name(name)
                    .age(age)
                    .weight(weight)
                    .colour(colour)
                    .gender(gender)
                    .type(type)
                    .price(price);
            System.out.print("Food: ");
            String food = sc.nextLine();
            builder = builder.food(food);
            Dog newPet = builder.build();
            pets.set(pets.indexOf(pet), newPet);
            System.out.println("Pet " + id + " has been updated.");
        } else if (pet instanceof Bird) {
            Bird.Builder builder = new Bird.Builder()
                    .id(id)
                    .name(name)
                    .age(age)
                    .weight(weight)
                    .colour(colour)
                    .gender(gender)
                    .type(type)
                    .price(price);
            System.out.print("Fly: ");
            boolean fly = sc.nextBoolean();
            sc.nextLine();
            builder = builder.fly(String.valueOf(fly));
            Bird newPet = builder.build();
            pets.set(pets.indexOf(pet), newPet);
            System.out.println("Pet " + id + " has been updated.");
        } else {
            System.out.println("Invalid pet type.");
        }
    }
    // 5. Hiển thị pet co gia tu cao den thap
    public static void sortPetByPrice(){
        Main.PetList.getInstance();
        List<Pet> pets = Main.PetList.getPets();
        Collections.sort(pets, (p1, p2) -> Double.compare(p2.getPrice(), p1.getPrice()));
        System.out.println("List of pets with prices from high to low:");
        for (Pet pet : pets) {
            System.out.println(pet);
        }
    }
}

