package edu.miu.ea.rs.service;


import edu.miu.ea.rs.model.Role;
import edu.miu.ea.rs.model.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);

    Role saveRole(Role role);

    void addRole(String username, String roleName);

    User getUser(String username);

    List<User> getUsers();

    User getLoggedInUser();

    User deleteUser(int id);
}
