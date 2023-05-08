import DaoImpl.EntityUtil;
import DaoImpl.UserDaoImpl;
import pojo.User;

public class Application {
    public static void main(String[] args) {

        UserDaoImpl userDao = new UserDaoImpl();
//        userDao.addUser(new User("Дмитрий Гиенко", "dGienko", "123456"));
//        userDao.addUser(new User("Алена Кулемина", "Akylema", "qwerty"));
//        userDao.addUser(new User("Катя Хрюшкина", "Xryssha", "1111"));

        //Получаю список пользователей из БД (без ролей)
        userDao.getAllUsers().forEach(System.out::println);

        EntityUtil.closeMF();

    }
}
