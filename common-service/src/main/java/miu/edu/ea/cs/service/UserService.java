package miu.edu.ea.cs.service;


import miu.edu.ea.cs.model.Role;
import miu.edu.ea.cs.model.User;

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
