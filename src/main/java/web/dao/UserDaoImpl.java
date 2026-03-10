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
    public void createUsersTable() {
        String sql = "CREATE TABLE IF NOT EXISTS users (" +
                "id BIGSERIAL PRIMARY KEY, " +
                "name VARCHAR(255) NOT NULL, " +
                "surName VARCHAR(255) NOT NULL, " + "department VARCHAR(255)," +
                "salary INT)";
        Query query = entityManager.createNativeQuery(sql);
        query.executeUpdate();
    }

    @Override
    public void dropUsersTable() {
        String sql = "DROP TABLE IF EXISTS users";
        Query query = entityManager.createNativeQuery(sql);
        query.executeUpdate();
    }

    @Override
    public void saveUser(String name, String surName, String department, int salary, String password) {
        Users users = new Users(name, surName, department, salary, password);
        entityManager.persist(users);
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
            String jpql = "SELECT u FROM Users u ORDER BY u.id";
        return entityManager.createQuery(jpql, Users.class).getResultList();
    }

    @Override
    public void cleanUsersTable() {
            String jpql = "DELETE FROM Users";
            Query query = entityManager.createQuery(jpql);
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
