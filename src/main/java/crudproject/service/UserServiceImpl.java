package crudproject.service;

import crudproject.dao.UserDao;
import crudproject.dao.UserDaoImpl;
import crudproject.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserDao userDao;


    @Override
    @Transactional
    public List<User> index() {
        return userDao.index();
    }

    @Override
    @Transactional
    public User show(int id) {
        return userDao.show(id);
    }

    @Override
    @Transactional
    public void save(User user) {
      userDao.save(user);
    }

    @Override
    @Transactional
    public User update(int id, User updateUser) {
     return userDao.update(id, updateUser);

    }

    @Override
    @Transactional
    public void delete(int id) {
      userDao.delete(id);
    }
}
