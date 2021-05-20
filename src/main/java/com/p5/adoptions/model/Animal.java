package com.p5.adoptions.model;

import javax.persistence.criteria.CriteriaBuilder;

public class Animal {
    protected Integer id;
    private String name;
    private String photoUrl;

    public Animal() {
    }

    public Animal(String name, String photoUrl, Integer id) {
        this.name = name;
        this.photoUrl = photoUrl;
        this.id = id;
    }

    public void speak() {
        System.out.println("Animal speaks!");
    }

    protected void walk() {
        System.out.println("Animal walk!");

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
