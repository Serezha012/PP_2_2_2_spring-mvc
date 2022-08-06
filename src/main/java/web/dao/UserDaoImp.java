package web.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserDaoImp implements UserDao {
    private final SessionFactory sessionFactory;

    public UserDaoImp(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    public List<User> getUserList() {
        List<User> list = sessionFactory.getCurrentSession().createQuery("select u from User u", User.class).getResultList();
        return list;
    }

    @Transactional
    public User getUserById(int id) {
        User user = sessionFactory.getCurrentSession().get(User.class, id);
        System.out.println(user);
        return user;
    }

    @Transactional
    public void save(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Transactional
    public void update(int id, User user){
        User user1 = getUserById(id);
        user1.setName(user.getName());
        user1.setAge(user.getAge());
        user1.setSurname(user.getSurname());
    }

    @Transactional
    public void delete(int id){
        sessionFactory.getCurrentSession().delete(getUserById(id));
    }



    @Transactional
    public void deleteAll(){
        sessionFactory.getCurrentSession().createQuery("delete from User").executeUpdate();
    }
}
