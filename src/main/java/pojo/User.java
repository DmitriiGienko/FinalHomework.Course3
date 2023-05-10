package pojo;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "Users")
public class User {
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;
    @Column
    @NotNull
    private String name;
    @Column
    @NotNull
    private String login;
    @Column
    @NotNull
    private String password;
    @Column(name = "Time_and_date_of_creation")
    private LocalDateTime dateTimeOfCreation = LocalDateTime.now();
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "Users_Roles",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id")}
    )
    private List<Role> roleList;

    public User(String name, String login, String password) {
        this.name = name;
        this.login = login;
        this.password = password;
    }

    public User() {

    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getDateTimeOfCreation() {
        return dateTimeOfCreation;
    }

    public void setDateTimeOfCreation(LocalDateTime dateTimeOfCreation) {
        this.dateTimeOfCreation = dateTimeOfCreation;
    }

    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return userId == user.userId && Objects.equals(name, user.name) && Objects.equals(login, user.login) && Objects.equals(password, user.password) && Objects.equals(dateTimeOfCreation, user.dateTimeOfCreation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, name, login, password, dateTimeOfCreation);
    }

    @Override
    public String toString() {
        return "Пользователь: " +
                "id " + userId +
                ", имя " + name +
                ", логин " + login +
                ", пароль " + password +
                ", дата и время создания учетной записи " + dateTimeOfCreation
                .format(DateTimeFormatter.ofPattern("dd.MM.yyyy hh:mm"));
    }
}
