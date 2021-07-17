package crudproject.dao;

import crudproject.models.User;

import java.util.List;

public interface UserDao {
    public List<User> index();
    public User show(int id);
    public void save(User user);
    public User update(int id, User updateUser);
    public void delete(int id);
}
