package com.p5.adoptions.repository;

import com.p5.adoptions.model.AnimalDTO;
import com.p5.adoptions.model.DogDTO;
import com.p5.adoptions.model.UserDTO;

import java.util.ArrayList;
import java.util.List;

public class UserStore {
    public static final List<UserDTO> available = new ArrayList<UserDTO>() {
        {
            add(new UserDTO(1, "parola1", "ion@email.com"));
            add(new UserDTO(2,"parola2", "maria@email.com"));
            add(new UserDTO(3,"parola3", "mircea@email.com"));
            add(new UserDTO(4,"parola4", "mioara@email.com"));
        }

    };
}
