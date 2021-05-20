package com.p5.adoptions.repository;

import com.p5.adoptions.model.Animal;
import com.p5.adoptions.model.CatDTO;
import com.p5.adoptions.model.Dog;

import java.util.ArrayList;
import java.util.List;

public class AnimalStore {
    public static final List<Animal> available = new ArrayList<Animal>() {
        {
            add(new Dog("Alfi", "http://www.pngall.com/wp-content/uploads/2016/03/Cat-PNG-9.png", 1));
            add(new Dog("Malaga", "http://www.pngall.com/wp-content/uploads/2016/03/Cat-PNG-9.png", 2));

            add(new CatDTO("Lica", "https://freepngimg.com/thumb/cat/22193-3-adorable-cat.png", 1));
            add(new CatDTO("Zoe", "https://freepngimg.com/thumb/cat/22193-3-adorable-cat.png", 2));

        }
    };
}






