package com.p5.adoptions.repository.shelter;

import com.p5.adoptions.repository.animals.Animal;
import org.apache.catalina.LifecycleState;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class AnimalShelter {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String name;
    private String address;

    //relatie unidirectionala
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "shelter_id")
    List<Animal> animals = new ArrayList<>();

//    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = false)
//    @JoinColumn(name = "animal_id")
//    private Animal animal;

//    //relatie bidirectionala
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "shelter")
//    List<Animal> animals = new ArrayList<>();


//    //relatie bidirectionala
//    @ManyToMany
//    @JoinTable(name = "animals_shelters")
//    List<Animal> animals = new ArrayList<>();


    public List<Animal> getAnimals() {
        return animals;
    }

    public AnimalShelter setAnimals(List<Animal> animals) {
        this.animals = animals;
        return this;
    }

    public AnimalShelter() {
    }

    public Integer getId() {
        return id;
    }

    public AnimalShelter setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public AnimalShelter setName(String name) {
        this.name = name;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public AnimalShelter setAddress(String address) {
        this.address = address;
        return this;
    }
}
