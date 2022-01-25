package peaksoft.service;

import peaksoft.Entity.User;
import peaksoft.dao.UserDao;
import peaksoft.dao.UserDaoImpl;

import java.util.List;

/**
 * Project: hw_8
 * Author: Tashmatov Bektur
 * Date: 25.01.2022 (20:00)
 */
public class UserServiceImpl implements UserService {

    UserDao userDao = new UserDaoImpl();

    public void createUsersTable() {
        userDao.createUsersTable();
    }

    public void dropUsersTable() {
        userDao.dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) {
        userDao.saveUser(name, lastName, age);
    }

    public List<User> getAllUsers(){
        return userDao.getAllUsers();
    }


    public void removeUserByName() {
        userDao.removeUserByName();
    }

    public void UpdateUsers() {
        userDao.UpdateUsers();
    }

    public List<User> getAllUser() {
        return userDao.getAllUser();
    }

    public void cleanUsersTable() {
        userDao.cleanUsersTable();
    }
}
