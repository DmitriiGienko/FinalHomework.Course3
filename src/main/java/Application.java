import DaoImpl.EntityUtil;
import DaoImpl.RoleDaoImpl;
import DaoImpl.UserDaoImpl;
import pojo.Role;
import pojo.User;

import java.util.ArrayList;


public class Application {
    public static void main(String[] args) {

// создаю роли и таблицу с ролями в БД
        RoleDaoImpl roleDao = new RoleDaoImpl();

        roleDao.addRole(new Role("Разработчик"));
        roleDao.addRole(new Role("Аналитик"));
        roleDao.addRole(new Role("Тестировщик"));
        roleDao.addRole(new Role("Менеджер"));
        roleDao.addRole(new Role("Дизайнер"));
        roleDao.addRole(new Role("По умолчанию"));

// получаю список ролей
        System.out.println("Список ролей");
        roleDao.getAllRoles().forEach(System.out::println);

        UserDaoImpl userDao = new UserDaoImpl();

//создаю новых пользователей и каждому назначаю по 2 роли, заношу их в БД
        userDao.addUserWithRoles(new User("Дмитрий Гиенко", "dGienko", "123456"),
                new ArrayList<>(roleDao.getAllRoles().subList(0, 2)));
        userDao.addUserWithRoles(new User("Алена Кулемина", "Akylema", "qwerty"),
                new ArrayList<>(roleDao.getAllRoles().subList(2, 4)));
        userDao.addUserWithRoles(new User("Катя Хрюшкина", "Xryssha", "1111"),
                new ArrayList<>(roleDao.getAllRoles().subList(4, 6)));

//Получаю список пользователей из БД (без ролей)
        userDao.getAllUsers().forEach(System.out::println);

// получаю пользователя по id с ролью
        userDao.getUserByIdWithRoles(1);

// получаю список сотрудников по роли
        userDao.getUsersByRoles(1);

// удалил пользователя из базы данных
        userDao.deleteUser(userDao.getUserById(3));

// обновил пользователя
        userDao.updateUser(1, new User("Валера Вильгельмс", "Wila", "qazwsxedc"));


        EntityUtil.closeMF();


    }
}
