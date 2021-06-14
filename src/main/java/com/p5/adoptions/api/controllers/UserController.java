package com.p5.adoptions.api.controllers;

import com.p5.adoptions.model.AnimalDTO;
import com.p5.adoptions.model.DogDTO;
import com.p5.adoptions.model.UserDTO;
import com.p5.adoptions.repository.AnimalStore;
import com.p5.adoptions.repository.UserStore;
import com.p5.adoptions.security.MyUserDetailsService;
import com.p5.adoptions.service.DogService;
import com.p5.adoptions.users.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    private final MyUserDetailsService userDetailsService;

    public UserController(MyUserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @GetMapping("/Hello")
    public ResponseEntity<String> greetUser(@RequestParam(name = "email", required = false) String userName) {
        String name = userName == null ? "world" : userName;

        return ResponseEntity.ok("Hello  " + name);
    }

    //    @GetMapping()
//    public ResponseEntity<List<UserDTO>> getAvailableUsers() {
//        return ResponseEntity.ok(UserStore.available);
//
//    }
    @PostMapping
    public void addUser(@RequestBody UserDTO userDto){

         userDetailsService.addUser(userDto);
      //  userDetailsService.setUpDefaultUser(userDto);
    }
//    public ResponseEntity<UserDTO> addUser(@RequestBody UserDTO user) {
//        if (user == null && user.getName() == null && user.getPassword() == null && user.getEmail() == null) {
//            return ResponseEntity.badRequest().body(user);
//        }
//        UserStore.available.add(user);
//        return ResponseEntity.ok(user);
//    }

    @PutMapping("/{email}")
    public void updateUser(@PathVariable(name = "email") String email, @RequestBody UserDTO updateUser) {

        List<UserDTO> available = UserStore.available;

        for (int i = 0; i < available.size(); i++) {

            UserDTO user = available.get(i);
            if (user.getEmail().equals("email")) {
                available.remove(i);
                available.add(updateUser);
                break;
            }
        }
    }
    @DeleteMapping({"/email"})
    public void deleteUser(@PathVariable(name = "email") String email){

        List<UserDTO>available = UserStore.available;
        for (int i=0; i<available.size(); i++){

            UserDTO user = available.get(i);
            if (user.getEmail().equals("email")){
                available.remove(i);
                break;
            }
        }

    }
}
