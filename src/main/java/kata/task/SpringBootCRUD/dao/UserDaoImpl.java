package kata.task.SpringBootCRUD.dao;

import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import kata.task.SpringBootCRUD.model.User;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    private EntityManager manager;

    @Override
    public List<User> getAllUsers() {
        return manager.createQuery("SELECT user FROM User user").getResultList();
    }

    @Override
    public User getUser(int n) {
        User user = manager.find(User.class, n);
        return user;
    }

    @Override
    public void saveUser(User user) {
        manager.merge(user);
        System.out.println(user.getId());
    }

    @Override
    public void deleteUser(int id) {
        manager.remove(getUser(id));
    }
}
