package com.p5.adoptions.exemple;

import com.p5.adoptions.model.AnimalDTO;
import com.p5.adoptions.model.CatDTO;

public class OopExemple {
public static void main(String[]args){

    AnimalDTO animal = new AnimalDTO();
    AnimalDTO animal2 = new AnimalDTO("Rex", "rex.jpg", 1);
    AnimalDTO animal3 = new AnimalDTO()
            .setName("Miki")
            .setPhotoUrl("photo");

    //Polimorphism
    CatDTO catDTO = new CatDTO("Muchi", "photo", 1);
    AnimalDTO catAnimal = new CatDTO("Zoe", "photo", 2);


        }


}
