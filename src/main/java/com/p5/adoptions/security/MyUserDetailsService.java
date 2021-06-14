package com.p5.adoptions.security;

import com.p5.adoptions.model.UserDTO;
import com.p5.adoptions.model.adapters.UserAdapter;
import com.p5.adoptions.users.User;
import com.p5.adoptions.users.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public MyUserDetailsService(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<User> userOptional = userRepository.findByEmail(username);
        if (!userOptional.isPresent()){
            throw new UsernameNotFoundException(username);
        }
        return new UserPrincipal(userOptional.get());
    }
    //Initialise DB with a default user
//    @Bean
//    private CommandLineRunner setUpDefaultUser(){
//        return args -> {
//            final String defaultEmail = "animalshelter@pentastagiu.io";
//            final String defaultPassword = "password";
//
//            Optional<User> defaultUser = userRepository.findByEmail(defaultEmail);
//
//            if (!defaultUser.isPresent()){
//                userRepository.save(new User()
//                                                 .setEmail(defaultEmail)
//                        .setPassword(passwordEncoder.encode(defaultPassword)));
//            }
//
//        };
//    }
    public void addUser(UserDTO userDto){
        if (userDto.getEmail() == null && userDto.getPassword() == null){
            throw new RuntimeException("User must have a email and a password!");
        }

        UserAdapter userAdapter = new UserAdapter(passwordEncoder);

        userRepository.save(userAdapter.fromDto(userDto));
    }
}
