package Dao;

import pojo.Role;

import java.util.List;

public interface RoleDao {
    //    Создание (добавление) сущности Role в таблицу.
    void addRole(Role role);

    //    Получение списка всех объектов Role из базы.
    List<Role> getAllRoles();


}
