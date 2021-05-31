package com.p5.adoptions.repository;

import com.p5.adoptions.model.AnimalDTO;
import com.p5.adoptions.model.CatDTO;
import com.p5.adoptions.model.DogDTO;

import java.util.ArrayList;
import java.util.List;

public class AnimalStore {
    public static final List<AnimalDTO> available = new ArrayList<AnimalDTO>() {
        {
            add(new DogDTO("Alfi", "http://www.pngall.com/wp-content/uploads/2016/03/Cat-PNG-9.png", 1));
            add(new DogDTO("Malaga", "http://www.pngall.com/wp-content/uploads/2016/03/Cat-PNG-9.png", 2));

            add(new CatDTO("Lica", "https://freepngimg.com/thumb/cat/22193-3-adorable-cat.png", 3));
            add(new CatDTO("Zoe", "https://freepngimg.com/thumb/cat/22193-3-adorable-cat.png", 4));

        }
    };
}






