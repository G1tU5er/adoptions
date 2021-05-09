package com.p5.adoptions.exemple;

import com.p5.adoptions.model.Animal;
import com.p5.adoptions.model.Cat;

public class OopExemple {
public static void main(String[]args){

    Animal animal = new Animal();
    Animal animal2 = new Animal("Rex", "rex.jpg");
    Animal animal3 = new Animal()
            .setName("Miki")
            .setPhotoUrl("photo");

    //Polimorphism
    Cat cat = new  Cat("Muchi", "photo");
    Animal catAnimal = new Cat("Zoe", "photo");


        }


}
