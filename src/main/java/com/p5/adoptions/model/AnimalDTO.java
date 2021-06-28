package com.p5.adoptions.model;

public class AnimalDTO {
    protected Integer id;
    private String name;
    private String photoUrl;

    public AnimalDTO() {
    }

    public AnimalDTO(String name, String photoUrl, Integer id) {
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

    public AnimalDTO setName(String name) {

        this.name = name;
        return this;
    }

    public String getPhotoUrl() {

        return photoUrl;
    }

    public AnimalDTO setPhotoUrl(String photoUrl) {

        this.photoUrl = photoUrl;
        return this;
    }

    public Integer getId() {
        return id;
    }

    public AnimalDTO setId(Integer id) {
        this.id = id;
        return this;
    }
}
