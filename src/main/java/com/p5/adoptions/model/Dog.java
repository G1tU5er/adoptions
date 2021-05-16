package com.p5.adoptions.model;

public class Dog extends Animal {
    public Dog(String name, String photoUrl) {
        super(name, photoUrl);
    }
    public void iAmADog() {

        System.out.println("Dogs are special!");
    }

    @Override
    public void speak() {

        System.out.println("Dogs can speaks.");
    }

}
