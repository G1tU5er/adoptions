package com.p5.adoptions.security;

import com.p5.adoptions.model.roles.RoleRepository;
import com.p5.adoptions.model.roles.RolesEnum;
import com.p5.adoptions.repository.roles.Role;
import com.p5.adoptions.users.User;
import com.p5.adoptions.users.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class MyUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;

    public MyUserDetailsService(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<User> userOptional = userRepository.findByEmail(username);
        if (!userOptional.isPresent()) {
            throw new UsernameNotFoundException(username);
        }
        return new UserPrincipal(userOptional.get());
    }

    // Initialise DB with a default user
    @Bean
    private CommandLineRunner setUpDefaultUser() {
        return args -> {
            final String defaultEmail = "animalshelter@pentastagiu.io";
            final String defaultPassword = "password";

            Role moderatorRole = roleRepository.findByRole(RolesEnum.ROLE_MOD).orElseGet(() -> {
                Role newRole = new Role().setRole(RolesEnum.ROLE_MOD);
                return roleRepository.save(newRole);
            });

            Optional<User> defaultUser = userRepository.findByEmail(defaultEmail);

            if (!defaultUser.isPresent()) {
                Set<Role> collectionRole = new HashSet<Role>();
                collectionRole.add(moderatorRole);
                userRepository.save(new User()
                        .setEmail(defaultEmail)
                        .setPassword(passwordEncoder.encode(defaultPassword))
                     //   .setUserRoles(Collections.singleton(moderatorRole)))
                           .setUserRoles(collectionRole));
            }

        };
    }

//    public UserDTO addUser(UserDTO userDto) {
//        if (userDto.getEmail() == null && userDto.getPassword() == null) {
//            throw new RuntimeException("User must have a email and a password!");
//        }
//        userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
//        Optional<User> defaultUser = userRepository.findByEmail(userDto.getEmail());
//        if (!defaultUser.isPresent()) {
//            return UserAdapter.toDto(userRepository.save(UserAdapter.fromDto(userDto)));
//        }
//else
//    return null;
//    }
}
