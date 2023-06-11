package com.goal3.kuniokunnonekketsusoccerleague.teams;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@Table(name = "nekketsu_teams")
@JsonIgnoreProperties("team") //свойства, которые json будет игнорировать
public class NekketsuTeam {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short id;
    @NotNull
    @OneToOne
    @JoinColumn(name = "team_id")
    private Team team;

    public NekketsuTeam() {
    }

    public NekketsuTeam(short id, Team team) {
        this.id = id;
        this.team = team;
    }

    //создаем геттеры для всех полей, чтобы их видел json


    public short getId() {
        return id;
    }

    public Team getTeam() {
        return team;
    }

    //переопределяем equals() и hashCode(), чтобы равенство 2х объектов определялось не по ссылке, а по равенству полей

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NekketsuTeam that = (NekketsuTeam) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


    //переопределяем toString(), чтобы в виде строки выводились данные объекта, а не его внутренний код


    @Override
    public String toString() {
        return "NekketsuTeam{" +
                "id=" + id +
                ", team=" + team.getName() +
                '}';
    }
}
