package com.p5.adoptions.repository;

import com.p5.adoptions.model.Animal;
import com.p5.adoptions.model.Cat;
import com.p5.adoptions.model.Dog;

import java.util.ArrayList;
import java.util.List;

public class AnimalStore {
    public static final List<Animal> available = new ArrayList<Animal>() {
        {
            add(new Dog("Alfi", "http://www.pngall.com/wp-content/uploads/2016/03/Cat-PNG-9.png"));
            add(new Dog("Alfi", "http://www.pngall.com/wp-content/uploads/2016/03/Cat-PNG-9.png"));
            add(new Cat("Alfi", "http://www.pngall.com/wp-content/uploads/2016/03/Cat-PNG-9.png"));
            add(new Cat("Alfi", "http://www.pngall.com/wp-content/uploads/2016/03/Cat-PNG-6.png"));

        }
    };
}






