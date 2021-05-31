package com.p5.adoptions.repository.animals;

import com.p5.adoptions.repository.shelter.AnimalShelter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

////Optiunea 1
//@MappedSuperclass
//
////Optiunea 2
//@Entity
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn(name = "discriminator", discriminatorType = DiscriminatorType.STRING)

//Optiunea 3 (un singur tabel pentru fiecare entitate, va alatura tabelele pentru a compune entitatea)
//@Entity
//@Inheritance(strategy = InheritanceType.JOINED)

//Optiunea 4
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)

public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Integer id;
    private String name;
    private String photoUrl;

//    @OneToOne(mappedBy = "animal")
//    private AnimalShelter shelter;

//    //relatie bidirectionala
//    @ManyToOne
//    @JoinColumn(name = "shelter_id")
//    AnimalShelter shelter;

//    //relatie bidirectionala
//    @ManyToMany(mappedBy = "animals")
//    List<AnimalShelter> shelters = new ArrayList<>();


    public Animal() {
    }

    public Integer getId() {
        return id;
    }

    public Animal setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Animal setName(String name) {
        this.name = name;
        return this;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public Animal setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
        return this;
    }
}
