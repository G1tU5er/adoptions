package com.p5.adoptions.exemple;

import com.p5.adoptions.model.Animal;
import com.p5.adoptions.model.CatDTO;

public class OopExemple {
public static void main(String[]args){

    Animal animal = new Animal();
    Animal animal2 = new Animal("Rex", "rex.jpg", 1);
    Animal animal3 = new Animal()
            .setName("Miki")
            .setPhotoUrl("photo");

    //Polimorphism
    CatDTO catDTO = new CatDTO("Muchi", "photo", 1);
    Animal catAnimal = new CatDTO("Zoe", "photo", 2);


        }


}
