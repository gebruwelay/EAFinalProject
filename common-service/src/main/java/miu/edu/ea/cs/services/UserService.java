package miu.edu.ea.cs.services;

import edu.miu.ea.cm.Role;
import edu.miu.ea.cm.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    User saveUser(User user);

    Role saveRole(Role role);

    void addRole(String username, String roleName);

    User getUser(String username);

    List<User> getUsers();

    User getLoggedInUser();

    User deleteUser(int id);
}
