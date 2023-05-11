package Dao;

import pojo.Role;
import pojo.User;

import java.util.List;

public interface UserDao {

    //    Создание (добавление) сущности User в таблицу c ролями.
    void addUserWithRoles(User user, List<Role> roleList);

    //    Получение списка всех объектов User из базы.
    List<User> getAllUsers();

    //    Изменение конкретного объекта User в базе по id.
    void updateUser(int id, User user);

    //    Удаление конкретного объекта User .
    void deleteUser(User user);

    // выбор user по id c ролью
    void getUserByIdWithRoles(int id);

    // выбор user по id
    User getUserById(int id);

    //получение списка пользователей по id роли
    void getUsersByRoles(int roleId);

}
