package com.goal3.kuniokunnonekketsusoccerleague.championships;

import com.goal3.kuniokunnonekketsusoccerleague.nekketsu_team_starting_lineups.NekketsuTeamStartingLineup;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
@Table(name = "championships")
public class Championship {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short id;
    @NotEmpty
    @Size(max = 100)
    private String name;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "nekketsu_team_starting_lineup_id")
    private NekketsuTeamStartingLineup nekketsuTeamStartingLineup; //может быть null

    public Championship() {
    }

    public Championship(short id, String name, NekketsuTeamStartingLineup nekketsuTeamStartingLineup) {
        this.id = id;
        this.name = name;
        this.nekketsuTeamStartingLineup = nekketsuTeamStartingLineup;
    }

    //создаем геттеры для всех полей, чтобы их видел json

    public short getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public NekketsuTeamStartingLineup getNekketsuTeamStartingLineup() {
        return nekketsuTeamStartingLineup;
    }

    //переопределяем equals() и hashCode(), чтобы равенство 2х объектов определялось не по ссылке, а по равенству полей

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Championship that = (Championship) o;
        return id == that.id && Objects.equals(name, that.name) && Objects.equals(nekketsuTeamStartingLineup, that.nekketsuTeamStartingLineup);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, nekketsuTeamStartingLineup);
    }

    //переопределяем toString(), чтобы в виде строки выводились данные объекта, а не его внутренний код

    @Override
    public String toString() {
        return "Championship{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nekketsuTeamStartingLineup=" + nekketsuTeamStartingLineup +
                '}';
    }
}
