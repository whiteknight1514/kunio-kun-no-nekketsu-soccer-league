package com.goal3.kuniokunnonekketsusoccerleague.teams;

import com.goal3.kuniokunnonekketsusoccerleague.players.Player;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "teams")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short id;
    @NotEmpty
    @Size(max = 11)
    private String name;
    @OneToOne(mappedBy = "team", fetch = FetchType.EAGER)
    private ComputerTeam computerTeam; //может быть null
    @OneToOne(mappedBy = "team", fetch = FetchType.EAGER)
    private NekketsuTeam nekketsuTeam; //может быть null
    @OneToMany(mappedBy = "team", fetch = FetchType.EAGER)
    private Set<Player> players;

    public Team() {
    }

    public Team(short id, String name, ComputerTeam computerTeam, NekketsuTeam nekketsuTeam, Set<Player> players) {
        this.id = id;
        this.name = name;
        this.computerTeam = computerTeam;
        this.nekketsuTeam = nekketsuTeam;
        this.players = players;
    }

    //создаем геттеры для всех полей, чтобы их видел json

    public short getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ComputerTeam getComputerTeam() {
        return computerTeam;
    }

    public NekketsuTeam getNekketsuTeam() {
        return nekketsuTeam;
    }

    public Set<Player> getPlayers() {
        return players;
    }

    //переопределяем equals() и hashCode(), чтобы равенство 2х объектов определялось не по ссылке, а по равенству полей

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Team team = (Team) o;
        return id == team.id && Objects.equals(name, team.name) && Objects.equals(computerTeam, team.computerTeam) && Objects.equals(nekketsuTeam, team.nekketsuTeam) && Objects.equals(players, team.players);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, computerTeam, nekketsuTeam, players);
    }

    //переопределяем toString(), чтобы в виде строки выводились данные объекта, а не его внутренний код

    @Override
    public String toString() {
        return "Team{" +
                "id=" + id +
                ", name='" + name + '\'' +
                (computerTeam == null ? "" : ", computerTeam=" + computerTeam) +
                (nekketsuTeam == null ? "" : ", nekketsuTeam=" + nekketsuTeam) +
                '}';
    }
}
