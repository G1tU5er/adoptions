package com.p5.adoptions.model;

import com.p5.adoptions.model.validations.OnCreate;
import com.p5.adoptions.model.validations.OnUpdate;
import com.p5.adoptions.repository.animals.Animal;

import javax.persistence.CascadeType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

import java.util.ArrayList;
import java.util.List;

public class AnimalShelterDTO {

    @Null(message = "Id-ul trebuia sa fie null la creare", groups = OnCreate.class)
    @NotNull(message = "Id-ul nu trebuie sa fie null pentru update", groups = OnUpdate.class)
    private Integer id;

    @NotNull(message = "Name is mandatory!!!!")
    @NotBlank(message = "Numele trebuie sa aiba cel putin 3 caractere")
    @NotBlank
    private String name;

    @NotNull
    @NotBlank
    private String address;

    List<AnimalDTO> animals = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public AnimalShelterDTO setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public AnimalShelterDTO setName(String name) {
        this.name = name;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public AnimalShelterDTO setAddress(String address) {
        this.address = address;
        return this;
    }

    public List<AnimalDTO> getAnimals() {
        return animals;
    }

    public AnimalShelterDTO setAnimals(List<AnimalDTO> animals) {
        this.animals = animals;
        return this;
    }
}
