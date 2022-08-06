package web.service;

import org.springframework.stereotype.Service;
import web.dao.UserDao;
import web.model.User;

import java.util.List;

@Service
public class UserServiceImp implements UserService {


    private final UserDao userDao;

    public UserServiceImp(UserDao userDao) {
        this.userDao = userDao;
    }

    public List<User> getUserList() {
        return userDao.getUserList();
    }


    public User getUserById(int id){
        return userDao.getUserById(id);
    }

    public void save(User user){
        userDao.save(user);
    }
    public void update(int id, User user){
        userDao.update(id,user);
    }

    public void delete(int id){
        userDao.delete(id);
    }


    public void deleteAll(){
        userDao.deleteAll();
    }
}
