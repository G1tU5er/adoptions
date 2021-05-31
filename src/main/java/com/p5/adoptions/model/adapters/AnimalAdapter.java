package com.p5.adoptions.model.adapters;

import com.p5.adoptions.model.AnimalDTO;
import com.p5.adoptions.model.CatDTO;
import com.p5.adoptions.repository.animals.Animal;
import com.p5.adoptions.repository.cats.Cat;

import java.util.ArrayList;
import java.util.List;

public class AnimalAdapter {
    public static Animal fromDto(AnimalDTO animalDTO){
        if (animalDTO.getName().equals("")) {
            animalDTO.setName("Generic animal");
        }
        return new Animal().setName(animalDTO.getName()).setPhotoUrl(animalDTO.getPhotoUrl());
    }
    public static List<Animal> fromDto(List<AnimalDTO>dtos){
        List<Animal> animals = new ArrayList<>();
        for (AnimalDTO animal : dtos){
            animals.add(fromDto(animal));
        }
        return animals;
    }

    public static AnimalDTO toDto(Animal animal){
        return new AnimalDTO(animal.getName(), animal.getPhotoUrl(), animal.getId());

    }

    public static List<AnimalDTO> toListDto(List<Animal>animalList){
        List<AnimalDTO> dtoList = new ArrayList<>();
        animalList.forEach(animal -> dtoList.add(toDto(animal)));
        return dtoList;

    }
}
