package com.goal3.kuniokunnonekketsusoccerleague.teams;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@Table(name = "computer_teams")
@JsonIgnoreProperties("team") //свойства, которые json будет игнорировать
public class ComputerTeam {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short id;
    @NotNull
    @Min(1)
    @Max(6)
    private short power;
    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "team_formation")
    private TeamFormation teamFormation;
    @NotNull
    @OneToOne
    @JoinColumn(name = "team_id")
    private Team team;

    public ComputerTeam() {
    }

    public ComputerTeam(short id, short power, TeamFormation teamFormation, Team team) {
        this.id = id;
        this.power = power;
        this.teamFormation = teamFormation;
        this.team = team;
    }

    //создаем геттеры для всех полей, чтобы их видел json

    public short getId() {
        return id;
    }

    public short getPower() {
        return power;
    }

    public TeamFormation getTeamFormation() {
        return teamFormation;
    }

    public Team getTeam() {
        return team;
    }

    //переопределяем equals() и hashCode(), чтобы равенство 2х объектов определялось не по ссылке, а по равенству полей

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ComputerTeam that = (ComputerTeam) o;
        return id == that.id && power == that.power && teamFormation == that.teamFormation;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, power, teamFormation);
    }


    //переопределяем toString(), чтобы в виде строки выводились данные объекта, а не его внутренний код


    @Override
    public String toString() {
        return "ComputerTeam{" +
                "id=" + id +
                ", power=" + power +
                ", teamFormation=" + teamFormation +
                ", team=" + team.getName() +
                '}';
    }
}
