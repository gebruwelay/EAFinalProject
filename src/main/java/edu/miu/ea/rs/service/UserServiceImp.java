package edu.miu.ea.rs.service;


import edu.miu.ea.rs.model.Role;
import edu.miu.ea.rs.model.User;
import edu.miu.ea.rs.repository.RoleRepository;
import edu.miu.ea.rs.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserServiceImp implements UserService, UserDetailsService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private User loggedInUser;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
         User user = userRepository.getUserByUsername(username).get(0);
        if (user == null) {
            log.error("User not found in database");
            throw new UsernameNotFoundException("User not found in database");
        } else {
            loggedInUser = user;
            log.info("User found in database: {}", username);
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        user.getRoles().forEach(role -> authorities.add(new SimpleGrantedAuthority(role.getName())));
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
    }

    @Override
    public User saveUser(User user) {
        log.info("Saving user to database");
        User oldUser = userRepository.findByUsername(user.getUsername());
        if (oldUser != null) throw new RuntimeException("user exists");
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public Role saveRole(Role role) {
        log.info("Saving role to database");
        return roleRepository.save(role);
    }

    @Override
    public void addRole(String username, String roleName) {
        log.info("Adding role to  user to database");
        User user = userRepository.findByUsername(username);
        Role role = roleRepository.findByName(roleName);
        user.getRoles().add(role);
    }

    @Override
    public User getUser(String username) {
        log.info("Getting one user from database");
        return userRepository.findByUsername(username);
    }

    @Override
    public List<User> getUsers() {
        log.info("Getting all user from database");
        return userRepository.findAll();
    }

    @Override
    public User getLoggedInUser() {
        return loggedInUser;
    }

    @Override
    public User deleteUser(int id) {
        User user = userRepository.getById(id);
        if (user != null) {
            user.setActive(false);
            return saveUser(user);
        }
        return  null;
    }
}



