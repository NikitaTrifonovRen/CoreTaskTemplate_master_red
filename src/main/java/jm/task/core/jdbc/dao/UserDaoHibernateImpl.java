package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class UserDaoHibernateImpl implements UserDao {
    public UserDaoHibernateImpl() {

    }


    @Override
    public void createUsersTable() {
        Session session = Util.getSession();
        String sql = "CREATE TABLE IF NOT Exists testHiber(id BIGINT NOT NULL AUTO_INCREMENT, name VARCHAR(45), lastName VARCHAR(45), age INT, PRIMARY KEY (`id`));";
        session.createSQLQuery(sql).executeUpdate();
        session.close();
    }

    @Override
    public void dropUsersTable() {
        Session session = Util.getSession();
        String sql = "DROP TABLE IF Exists testHiber";
        session.createSQLQuery(sql).executeUpdate();
        session.close();
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        Session session = Util.getSession();
        Transaction tr = session.beginTransaction();
        session.save(new User(name,lastName,age));
        tr.commit();
        session.close();

    }

    @Override
    public void removeUserById(long id) {
        Session session = Util.getSession();
        User user = (User)session.get(User.class,id);
        Transaction tr = session.beginTransaction();
        session.delete(user);
        tr.commit();
        session.close();

    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = (List<User>) Util.getSession().createQuery("From User").list();
        System.out.println(users.toString());
        return users;
    }

    @Override
    public void cleanUsersTable() {
        Session session = Util.getSession();
        Transaction tr = session.beginTransaction();
        String hql = "DELETE FROM User";
        session.createQuery(hql).executeUpdate();
        tr.commit();
        session.close();
    }
}
