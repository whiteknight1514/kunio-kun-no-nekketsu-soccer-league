package com.goal3.kuniokunnonekketsusoccerleague.users;

import com.goal3.kuniokunnonekketsusoccerleague.security.Role;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short id;
    @NotEmpty
    @Size(min = 3, max = 20)
    private String login;
    @NotNull
    @Enumerated(EnumType.STRING)
    private Role role;
    @NotEmpty
    @Size(max = 255)
    private String password;

    public User() {
    }

    public User(short id, String login, Role role, String password) {
        this.id = id;
        this.login = login;
        this.role = role;
        this.password = password;
    }

    //создаем геттеры для всех полей, чтобы их видел json


    public short getId() {
        return id;
    }

    public void setId(short id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    //переопределяем equals() и hashCode(), чтобы равенство 2х объектов определялось не по ссылке, а по равенству полей

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && Objects.equals(login, user.login) && Objects.equals(role, user.role) && Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, login, role, password);
    }

    //переопределяем toString(), чтобы в виде строки выводились данные объекта, а не его внутренний код

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", role='" + role + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
