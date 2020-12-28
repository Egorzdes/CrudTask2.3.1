package fedorov.app.service;

import fedorov.app.model.User;

import java.util.List;

public interface UserService {
    void save(User user);

    List<User> getAllUsers();

    void update(User user);

    void delete(long id);


    User findUserById(long id);


}
