package kata.task.SpringBootCRUD.dao;

import kata.task.SpringBootCRUD.model.User;
import java.util.List;

public interface UserDao {

    public List<User> getAllUsers();

    public User getUser(int n);

    public void saveUser(User user);

    public void deleteUser(int id);
}
