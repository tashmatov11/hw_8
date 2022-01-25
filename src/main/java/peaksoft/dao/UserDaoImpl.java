package peaksoft.dao;

import org.hibernate.Session;
import org.hibernate.query.Query;
import peaksoft.Entity.User;
import peaksoft.Util.Util;

import java.util.List;

/**
 * Project: hw_8
 * Author: Tashmatov Bektur
 * Date: 25.01.2022 (19:54)
 */
public class UserDaoImpl implements UserDao {
    public static final String ANSI_VIOLET = "\u001B[35m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_RESET = "\u001B[0m";

    public UserDaoImpl() {

    }

    @Override
    public void createUsersTable() {
        try {
            Session session = Util.getSessionFactory().openSession();
            session.beginTransaction();
            session.getTransaction().commit();
            session.close();
            System.out.println(ANSI_BLUE + "Таблица users создана" + ANSI_RESET);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void dropUsersTable() {
        try {
            Session session = Util.getSessionFactory().openSession();
            session.beginTransaction();
            session.createSQLQuery("DROP TABLE IF EXISTS users").executeUpdate();
            session.getTransaction().commit();
            session.close();
            System.out.println(ANSI_BLUE + "Таблица users удалена" + ANSI_RESET);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        try {
            Session session = Util.getSessionFactory().openSession();
            session.beginTransaction();

            User user = new User(name, lastName, age);
            session.save(user);

            session.getTransaction().commit();
            session.close();
            System.out.println(ANSI_VIOLET + "Пользователь " + name + " добавлен" + ANSI_RESET);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<User> getAllUsers() {
        Session session = Util.getSessionFactory().openSession();
        session.beginTransaction();
        List<User> users= session.createQuery("FROM User").getResultList();
        session.getTransaction().commit();
        session.close();
        return users;
    }

    @Override
    public void removeUserByName() {
        try {
            Session session = Util.getSessionFactory().openSession();
            session.beginTransaction();

            Query query = session.createQuery("DELETE FROM User where name = 'Aza'");
            query.executeUpdate();

            session.getTransaction().commit();
            session.close();
            System.out.println("Successfully update ");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void UpdateUsers() {
        Session session = Util.getSessionFactory().openSession();
        session.beginTransaction();
        String SQL = "update User set age = 18 where name = 'Aza'";
        int a = session.createQuery(SQL).executeUpdate();

        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully update ");
    }

    @Override
    public List<User> getAllUser() {
        Session session = Util.getSessionFactory().openSession();
        session.beginTransaction();
        List<User> user = session.createQuery("FROM User where age > 20 and name like 'Aza'").getResultList();
        session.getTransaction().commit();
        session.close();
        System.out.println(user.size());
        return user;
    }

    @Override
    public void cleanUsersTable() {
        try {
            Session session = Util.getSessionFactory().openSession();
            session.beginTransaction();
            session.createSQLQuery("TRUNCATE users").executeUpdate();
            session.getTransaction().commit();
            System.out.println(ANSI_BLUE + "Таблица очищена" + ANSI_RESET);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
