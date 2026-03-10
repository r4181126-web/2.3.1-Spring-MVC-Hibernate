package web.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import web.dao.UserDao;
import web.model.Users;
import java.util.List;

@Service
public class UserServiceimpl implements UserService {
    private final UserDao dao;
    private final PasswordEncoder passwordEncoder;

    public UserServiceimpl(UserDao dao, PasswordEncoder passwordEncoder) {
        this.dao = dao;
        this.passwordEncoder = passwordEncoder;
    }

    public void createUsersTable() {
        dao.createUsersTable();
    }

    public void dropUsersTable() {
        dao.dropUsersTable();
    }

    public void saveUser(String name, String surName, String department, int salary, String password) {
        String encodedPassword = passwordEncoder.encode(password);
        dao.saveUser(name, surName, department, salary, encodedPassword);
    }

    public void removeUserById(long id) {
        dao.removeUserById(id);
    }

    public List<Users> getAllUsers() {
        return dao.getAllUsers();
    }
    public void cleanUsersTable() {
        dao.cleanUsersTable();
    }

    public void updateUser(long id, String name, String surName, String department, int salary, String password) {
        Users user = new Users(name, surName, department, salary, password);
        user.setId(id);
        user.setPassword(passwordEncoder.encode(password));
        dao.updateUser(user);
    }

    @Override
    public Users getUserById(long id) {
        return dao.getUserById(id);
    }
}
