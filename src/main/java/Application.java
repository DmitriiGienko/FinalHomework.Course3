import DaoImpl.EntityUtil;
import DaoImpl.RoleDaoImpl;
import DaoImpl.UserDaoImpl;
import pojo.Role;
import pojo.User;

public class Application {
    public static void main(String[] args) {

        UserDaoImpl userDao = new UserDaoImpl();
//        userDao.addUser(new User("Дмитрий Гиенко", "dGienko", "123456"));
//        userDao.addUser(new User("Алена Кулемина", "Akylema", "qwerty"));
//        userDao.addUser(new User("Катя Хрюшкина", "Xryssha", "1111"));

        //Получаю список пользователей из БД (без ролей)
        userDao.getAllUsers().forEach(System.out::println);

        RoleDaoImpl roleDao = new RoleDaoImpl();
//        roleDao.addRole(new Role("Разработчик"));
//        roleDao.addRole(new Role("Аналитик"));
//        roleDao.addRole(new Role("Тестировщик"));
//        roleDao.addRole(new Role("Менеджер"));
//        roleDao.addRole(new Role("Дизайнер"));
//        roleDao.addRole(new Role("По умолчанию"));

        roleDao.getAllRoles().forEach(System.out::println);

        EntityUtil.closeMF();

    }
}
