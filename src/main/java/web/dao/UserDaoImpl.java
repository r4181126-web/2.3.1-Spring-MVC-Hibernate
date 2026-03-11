package web.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.model.Users;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;


@Repository
@Transactional
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void saveUser(String name, String surName, String department, int salary, String password) {
        Users user = new Users(name, surName, department, salary, password);
        entityManager.persist(user);
    }

    @Override
    public void removeUserById(long id) {
        Users users = entityManager.find(Users.class, id);
        if (users != null) {
            entityManager.remove(users);
        }
    }

    @Override
    public List<Users> getAllUsers() {
        return entityManager.createQuery("SELECT u FROM Users u ORDER BY u.id", Users.class).getResultList();
    }

    @Override
    public void cleanUsersTable() {
            Query query = entityManager.createQuery("DELETE FROM Users");
            query.executeUpdate();
    }

    @Override
    public void updateUser(Users user) {
        entityManager.merge(user);
    }

    @Override
    public Users getUserById(long id) {
        return entityManager.find(Users.class, id);
    }
}
