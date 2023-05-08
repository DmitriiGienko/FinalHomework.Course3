package Dao;

import pojo.User;

import java.util.List;

public interface UserDao {

    //    Создание (добавление) сущности User в таблицу.
    void addUser(User user);

    //    Получение списка всех объектов User из базы.
    List<User> getAllUsers();

    //    Изменение конкретного объекта User в базе по id.
    void updateUser(int id, User user);

    //    Удаление конкретного объекта User .
    void deleteUser(User user);

    // выбор user по id
    User getUserById(int id);

}
