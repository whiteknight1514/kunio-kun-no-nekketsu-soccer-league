package com.goal3.kuniokunnonekketsusoccerleague.nekketsu_team_starting_lineups;

import com.goal3.kuniokunnonekketsusoccerleague.players.Player;
import com.goal3.kuniokunnonekketsusoccerleague.teams.TeamFormation;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "nekketsu_team_starting_lineups")
public class NekketsuTeamStartingLineup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short id;
    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "team_formation")
    private TeamFormation teamFormation;
    @NotNull
    @ManyToOne
    @JoinColumn(name = "captain_id")
    private Player captain;
    @ManyToMany
    @JoinTable(
            name = "nekketsu_team_starting_lineups_players",
            joinColumns = @JoinColumn(name = "nekketsu_team_starting_lineup_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "player_id", referencedColumnName = "id")
    )
    private Set<Player> players;

    public NekketsuTeamStartingLineup() {
    }

    public NekketsuTeamStartingLineup(TeamFormation teamFormation, Player captain, Set<Player> players) {
        this.teamFormation = teamFormation;
        this.captain = captain;
        this.players = players;
    }

    public NekketsuTeamStartingLineup(short id, TeamFormation teamFormation, Player captain, Set<Player> players) {
        this.id = id;
        this.teamFormation = teamFormation;
        this.captain = captain;
        this.players = players;
    }

    //создаем геттеры для всех полей, чтобы их видел json

    public short getId() {
        return id;
    }

    public TeamFormation getTeamFormation() {
        return teamFormation;
    }

    public Player getCaptain() {
        return captain;
    }

    public Set<Player> getPlayers() {
        return players;
    }

    //переопределяем equals() и hashCode(), чтобы равенство 2х объектов определялось не по ссылке, а по равенству полей

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NekketsuTeamStartingLineup that = (NekketsuTeamStartingLineup) o;
        return id == that.id && teamFormation == that.teamFormation && Objects.equals(captain, that.captain) && Objects.equals(players, that.players);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, teamFormation, captain, players);
    }

    //переопределяем toString(), чтобы в виде строки выводились данные объекта, а не его внутренний код

    @Override
    public String toString() {
        return "NekketsuTeamStartingLineup{" +
                "id=" + id +
                ", teamFormation=" + teamFormation +
                ", captain=" + captain +
                ", players=" + players +
                '}';
    }
}
