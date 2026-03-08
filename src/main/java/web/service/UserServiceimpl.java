package web.service;

import org.springframework.stereotype.Service;
import web.dao.UserDao;
import web.model.Users;
import java.util.List;

@Service
public class UserServiceimpl implements UserService {
    private final UserDao dao;

    public UserServiceimpl(UserDao dao) {
        this.dao = dao;
    }

    public void createUsersTable() {
        dao.createUsersTable();
    }

    public void dropUsersTable() {
        dao.dropUsersTable();
    }

    public void saveUser(String name, String surName, String department, int salary) {
        dao.saveUser(name, surName, department, salary);
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

    public void updateUser(long id, String name, String surName, String department, int salary) {
        Users user = new Users(name, surName, department, salary);
        user.setId(id);
        dao.updateUser(user);
    }
}
