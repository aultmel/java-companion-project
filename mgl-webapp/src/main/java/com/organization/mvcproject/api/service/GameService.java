package com.organization.mvcproject.api.service;

import java.util.List;

import com.organization.mvcproject.model.GameImpl;

public interface GameService {

	List<GameImpl> retrieveAllGames();

	GameImpl saveGame(GameImpl game);
	
	GameImpl getGameById(Long id);
	
	boolean deleteGameById(Long id);

}
