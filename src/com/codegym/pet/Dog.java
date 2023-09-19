package com.codegym.pet;

public class Dog implements Pet {
    private String id;
    private String name;
    private int age;
    private float weight;
    private String colour;
    private String gender;
    private String type;
    private int price;
    private String food;

    public Dog(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.age = builder.age;
        this.weight = builder.weight;
        this.colour = builder.colour;
        this.gender = builder.gender;
        this.type = builder.type;
        this.price = builder.price;
        this.food = builder.food;
    }

      public static class Builder{
        private String id;
        private String name;
        private int age;
        private float weight;
        private String colour;
        private String gender;
        private String type;
        private int price;
        private String food;

        public Builder id(String id){
            this.id = id;
            return this;
        }
        public Builder name(String name){
            this.name = name;
            return this;
        }
        public Builder age(int age){
            this.age = age;
            return this;
        }

        public Builder weight(float weight){
            this.weight = weight;
            return this;
        }
        public Builder colour(String colour){
            this.colour = colour;
            return this;
        }
        public Builder gender(String gender){
            this.gender = gender;
            return this;
        }
        public Builder type(String type){
            this.type = type;
            return this;
        }
        public Builder price(int price){
            this.price = price;
            return this;
        }
        public Builder food(String food){
            this.food = food;
            return this;
        }
        public Dog build() {
            return new Dog(this);
        }

    }
    @Override
    public String getId() {
        return id;
    }
    @Override
    public void setId(String id) {
        this.id = id;
    }
    @Override
    public String getName() {
        return name;
    }
    @Override
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public int getAge() {
        return age;
    }
    @Override
    public void setAge(int age) {
        this.age = age;
    }
    @Override
    public float getWeight() {
        return weight;
    }
    @Override
    public void setWeight(float weight) {
        this.weight = weight;
    }
    @Override
    public String getColour() {
        return colour;
    }
    @Override
    public void setColour(String colour) {
        this.colour = colour;
    }
    @Override
    public String getGender() {
        return gender;
    }
    @Override
    public void setGender(String gender) {
        this.gender = gender;
    }
    @Override
    public String getType() {
        return type;
    }
    @Override
    public void setType(String type) {
        this.type = type;
    }
    @Override
    public int getPrice() {
        return price;
    }
    @Override
    public void setPrice(int price) {
        this.price = price;
    }
    @Override
    public String getFood() {
        return food;
    }
    @Override
    public void setFood(String food) {
        this.food = food;
    }

    @Override
    public boolean isFly() {
        return false;
    }

    @Override
    public void setFly(boolean fly) {
        throw new IllegalArgumentException("This function is not for dogs");
    }

    @Override
    public String toString() {
        return  id +
                ", " + name +
                ", " + age +
                ", " + weight +
                ", " + colour +
                ", " + gender +
                ", " + type +
                ", " + price +
                ", " + food;
    }
}
