package com.goal3.kuniokunnonekketsusoccerleague.players;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.goal3.kuniokunnonekketsusoccerleague.teams.Team;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
@Table(name = "players")
@JsonIgnoreProperties("team") //свойства, которые json будет игнорировать
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short id;
    @NotEmpty
    @Size(max = 9)
    private String name;
    @NotNull
    @Min(1)
    @Max(12)
    private short number;
    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "player_position")
    private PlayerPosition playerPosition;
    @NotNull
    @ManyToOne//(cascade = CascadeType.ALL)
    @JoinColumn(name = "team_id")
    private Team team;

    public Player() {
    }

    public Player(short id, String name, short number, PlayerPosition playerPosition, Team team) {
        this.id = id;
        this.name = name;
        this.number = number;
        this.playerPosition = playerPosition;
        this.team = team;
    }

    //создаем геттеры для всех полей, чтобы их видел json

    public short getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public short getNumber() {
        return number;
    }

    public PlayerPosition getPlayerPosition() {
        return playerPosition;
    }

    public Team getTeam() {
        return team;
    }

    //переопределяем equals() и hashCode(), чтобы равенство 2х объектов определялось не по ссылке, а по равенству полей

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return id == player.id && number == player.number && Objects.equals(name, player.name) && playerPosition == player.playerPosition;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, number, playerPosition);
    }


    //переопределяем toString(), чтобы в виде строки выводились данные объекта, а не его внутренний код

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", number=" + number +
                ", playerPosition=" + playerPosition +
                ", team=" + team.getName() +
                '}';
    }
}
