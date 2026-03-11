package web.service;

import web.model.Users;
import java.util.List;

    public interface UserService {

        void saveUser(String name, String SurName, String department, int salary, String password);

        void removeUserById(long id);

        List<Users> getAllUsers();

        void cleanUsersTable();
        void updateUser(long id, String name, String surName, String department, int salary, String password);

        Users getUserById(long id);
    }