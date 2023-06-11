package com.goal3.kuniokunnonekketsusoccerleague.nekketsu_team_starting_lineups;

import com.goal3.kuniokunnonekketsusoccerleague.exceptions.ValidationException;
import com.goal3.kuniokunnonekketsusoccerleague.players.Player;
import com.goal3.kuniokunnonekketsusoccerleague.players.PlayerPosition;
import com.goal3.kuniokunnonekketsusoccerleague.players.PlayerService;
import com.goal3.kuniokunnonekketsusoccerleague.teams.Team;
import com.goal3.kuniokunnonekketsusoccerleague.teams.TeamFormation;
import com.goal3.kuniokunnonekketsusoccerleague.teams.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class NekketsuTeamStartingLineupService {

    @Autowired
    private NekketsuTeamStartingLineupRepository repository;

    @Autowired
    private TeamService teamService;

    @Autowired
    private PlayerService playerService;

    public void create(NekketsuTeamStartingLineup nekketsuTeamStartingLineup) {
        //TODO: нужны валидации: 1. id нет в базе, 2. игроки из команды Nekketsu, 3. капитан на позиции MF, 4. игроки соответствуют расположению, 1.5 в составе 6 игроков
        validate(nekketsuTeamStartingLineup, false);
        repository.save(nekketsuTeamStartingLineup);
    }

    public void edit(NekketsuTeamStartingLineup nekketsuTeamStartingLineup) {
        validate(nekketsuTeamStartingLineup, true);
        repository.save(nekketsuTeamStartingLineup);
    }

    private void validate(NekketsuTeamStartingLineup nekketsuTeamStartingLineup, boolean isEdit) {
        ValidationException validationException = new ValidationException();
        short nekketsuTeamStartingLineupId = nekketsuTeamStartingLineup.getId();
        Set<Player> nonNekketsuTeamPlayers = playerService.getNonNekketsuTeamPlayers(nekketsuTeamStartingLineup.getPlayers());

        //в случае редактирования проверяем есть ли id в базе данных
        if (isEdit && repository.existsById(nekketsuTeamStartingLineupId)) {
            validationException.put(
                    "Id",
                    "Nekketsu team starting lineup with id '" + nekketsuTeamStartingLineupId + "' not found.");
        }

        //проверяем все ли игроки из Nekketsu team
        if (nonNekketsuTeamPlayers.size() > 0) {
            validationException.put(
                    "Players",
                    "Players with id '" + String.join(", ", nonNekketsuTeamPlayers.stream()
                            .map(player -> String.valueOf(player.getId()))
                            .collect(Collectors.toSet())) + "' not on the Nekketsu team.");
        }

        //проверяем играет ли капитан на позиции MF
        if (Objects.equals(nekketsuTeamStartingLineup.getCaptain().getPlayerPosition(), PlayerPosition.MF)) {
            validationException.put(
                    "Captain",
                    "The captain must play in the MF player position.");
        }

        //проверяем соответсвуют ли позиции игроков построению команды


        validationException.throwExceptionIfIsNotEmpty();
    }

    public NekketsuTeamStartingLineup generate() {
        Random random = new Random();
        Team nekketsuTeam = teamService.getNekketsuTeam();
        TeamFormation teamFormation = TeamFormation.values()[random.nextInt(TeamFormation.values().length)];
        Set<Player> players = new HashSet<>(6);

        AddPlayersByPosition(players, nekketsuTeam, PlayerPosition.GK, (byte) 1);
        AddPlayersByPosition(players, nekketsuTeam, PlayerPosition.DF, teamFormation.getQuantityDF());
        AddPlayersByPosition(players, nekketsuTeam, PlayerPosition.MF, teamFormation.getQuantityMF());
        AddPlayersByPosition(players, nekketsuTeam, PlayerPosition.FW, teamFormation.getQuantityFW());

        Player captain = players.stream()
                .filter(player -> player.getPlayerPosition().equals(PlayerPosition.MF))
                .toList()
                .get(0); //первый полузащитник

        return new NekketsuTeamStartingLineup(teamFormation, captain, players);
    }

    private void AddPlayersByPosition(Set<Player> players, Team nekketsuTeam, PlayerPosition playerPosition, byte quantityPlayerPositions) {
        List<Player> playersByPosition = playerService.getAllByTeamAndPlayerPosition(nekketsuTeam, playerPosition);

        if (playersByPosition.size() < quantityPlayerPositions) {
            throw new ValidationException(
                    "Player positions",
                    "There are not enough " + playerPosition + " players in the Nekketsu team." +
                            "Have - " + playersByPosition.size() + ", need - " + quantityPlayerPositions + ".");
        }

        Random random = new Random();

        for (int i = 0; i < quantityPlayerPositions; i++) {
            List<Player> freePlayersByPosition = playersByPosition.stream()
                    .filter(player -> !players.contains(player))
                    .toList();
            players.add(freePlayersByPosition.get(random.nextInt(freePlayersByPosition.size())));
        }
    }
}
