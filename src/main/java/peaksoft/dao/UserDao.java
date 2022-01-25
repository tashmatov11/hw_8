package peaksoft.dao;

import peaksoft.Entity.User;

import java.util.List;

/**
 * Project: hw_8
 * Author: Tashmatov Bektur
 * Date: 25.01.2022 (19:54)
 */
public interface UserDao {

    void createUsersTable();

    void dropUsersTable();

    void saveUser(String name, String lastName, byte age);

    List<User> getAllUsers();

    void removeUserByName();

    void UpdateUsers();

    List<User> getAllUser();

    void cleanUsersTable();
}
