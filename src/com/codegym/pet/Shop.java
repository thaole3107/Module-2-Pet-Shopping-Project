package com.codegym.pet;

public class Shop {
  static  String name;
    static int wallet;

    public String getName() {
        return name;
    }

    public static void setName(String name) {
        Shop.name = name;
    }

    public static int getWallet() {
        return wallet;
    }

    public static void setWallet(int wallet) {
        Shop.wallet = wallet;
    }

    public static void addMoney(double money){
        Shop.wallet += money;
    }
    public Shop(String name, int wallet) {
        Shop.name = name;
        Shop.wallet = wallet;
    }
}
