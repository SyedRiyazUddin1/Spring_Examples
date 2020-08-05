package com.myspringboot.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myspringboot.model.Player;
import com.myspringboot.model.Team;
import com.myspringboot.repository.PlayerRepository;
import com.myspringboot.repository.TeamRepository;

@Service
public class SoccerServiceImpl implements SoccerService {

	@Autowired
	private PlayerRepository playerRepository;

	@Autowired
	private TeamRepository teamRepository;

	/**
	 * This method fetches the list of players for the given team id
	 * 
	 * @param teamId Id of the Team
	 * @return it fetches the list of player names of the team id
	 */
	public List<String> getAllTeamPlayers(long teamId) {
		List<String> result = new ArrayList<String>();
		List<Player> players = playerRepository.findByTeamId(teamId);
		for (Player player : players) {
			result.add(player.getName());
		}

		return result;
	}

	public void addBarcelonaPlayer(String name, String position, int number) {

		Optional<Team> barcelona = teamRepository.findById(1l);

		Player newPlayer = new Player();
		newPlayer.setName(name);
		newPlayer.setPosition(position);
		newPlayer.setNum(number);
		newPlayer.setTeam(barcelona);
		playerRepository.save(newPlayer);
	}

}