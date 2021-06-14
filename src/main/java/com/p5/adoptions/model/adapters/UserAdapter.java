package com.p5.adoptions.model.adapters;

import com.p5.adoptions.model.UserDTO;
import com.p5.adoptions.security.BCryptPasswordEncoder;
import com.p5.adoptions.users.User;

import java.util.ArrayList;
import java.util.List;

public class UserAdapter {
    private final BCryptPasswordEncoder passwordEncoder;

    public UserAdapter(BCryptPasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public User fromDto(UserDTO userDTO){
        if(userDTO.getEmail().equals("")){
            userDTO.setEmail("Generic user");
        }
        return new User().setEmail(userDTO.getEmail()).setPassword(passwordEncoder.encode(userDTO.getPassword()));
    }

    public static UserDTO toDto(User user){
        return new UserDTO(user.getId(), user.getPassword(),user.getEmail());
    }

    public static List<UserDTO> toListDto (List<User> userList){
        List<UserDTO> dtoList = new ArrayList<>();
        userList.forEach(user -> dtoList.add(toDto(user)));

        return dtoList;

    }
}
