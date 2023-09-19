package com.codegym.customer;

public class RegularCustomer implements Customer {
        private String id;
        private String name;
        private double wallet;

        public RegularCustomer(String id, String name, double wallet) {
            this.id = String.valueOf(id);
            this.name = name;
            this.wallet = wallet;
            }

        @Override
        public String getId() {
            return id;
        }

        @Override
        public String getName() {
            return name;
        }

        @Override
        public double getWallet() {
            return wallet;
        }
        @Override
        public void setWallet(double money){
            this.wallet = money;
        }

        @Override
        public String toString() {
            return "Regular customer: " + id
                    + ", " + name
                    + ", " + wallet;
        }
    }

