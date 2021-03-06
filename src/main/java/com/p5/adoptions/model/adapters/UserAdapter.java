package com.p5.adoptions.model.adapters;

import com.p5.adoptions.model.UserDTO;
import com.p5.adoptions.security.BCryptPasswordEncoder;
import com.p5.adoptions.users.User;

import java.util.ArrayList;
import java.util.List;

public class UserAdapter {

    public static User fromDto(UserDTO userDTO){
        if(userDTO.getEmail().equals("")){
            userDTO.setEmail("Generic@email.com");
        }
        return new User().setEmail(userDTO.getEmail()).setPassword(userDTO.getPassword()).setUserRoles(userDTO.getUserRoles());
    }

    public static UserDTO toDto(User user){
        return new UserDTO(user.getId(), user.getPassword(),user.getEmail(), user.getUserRoles());
    }

    public static List<UserDTO> toListDto (List<User> userList){
        List<UserDTO> dtoList = new ArrayList<>();
        userList.forEach(user -> dtoList.add(toDto(user)));

        return dtoList;

    }
}
