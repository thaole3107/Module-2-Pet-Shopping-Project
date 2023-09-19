package com.codegym.pet;

public class Bird implements Pet {
    private String id;
    private String name;
    private int age;
    private float weight;
    private String colour;
    private String gender;
    private String type;
    private int price;
    private boolean fly;

    public Bird(Bird.Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.age = builder.age;
        this.weight = builder.weight;
        this.colour = builder.colour;
        this.gender = builder.gender;
        this.type = builder.type;
        this.price = builder.price;
        this.fly = builder.fly;
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
        private Boolean fly;

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
        public Builder fly(String fly){
            this.fly = Boolean.valueOf(fly);
            return this;
        }
        public Bird build() {
            return new Bird(this);
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
    public boolean isFly() {
        return fly;
    }
    @Override
    public void setFly(boolean fly) {
        this.fly = fly;
    }
    @Override
    public String getFood() {
        return "nothing";
    }
    @Override
    public void setFood(String food) {
        throw new IllegalArgumentException("This function is not for birds");
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
                ", " + fly;
    }
}
