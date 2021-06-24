package com.p5.adoptions.repository;

import com.p5.adoptions.model.AnimalDTO;
import com.p5.adoptions.model.DogDTO;
import com.p5.adoptions.model.UserDTO;
import com.p5.adoptions.model.roles.RolesEnum;
import com.p5.adoptions.repository.roles.Role;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserStore {
    public static final List<UserDTO> available = new ArrayList<UserDTO>() {
        {
            Set<Role> collectionRole = new HashSet<Role>();
            collectionRole.add(new Role().setRole(RolesEnum.ROLE_MOD));
            add(new UserDTO(1, "parola1", "ion@email.com",  collectionRole));
            add(new UserDTO(2,"parola2", "maria@email.com", collectionRole));
            add(new UserDTO(3,"parola3", "mircea@email.com", collectionRole));
            add(new UserDTO(4,"parola4", "mioara@email.com", collectionRole));
        }

    };
}
