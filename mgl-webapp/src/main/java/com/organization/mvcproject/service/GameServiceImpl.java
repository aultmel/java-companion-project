package com.organization.mvcproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.organization.mvcproject.api.dao.MockDAO;
import com.organization.mvcproject.api.model.Game;
import com.organization.mvcproject.api.service.GameService;

@Service
public class GameServiceImpl implements GameService {

    @Autowired
	private MockDAO mockDao;

	public List<Game> retrieveAllGames() {
		return mockDao.getAllGames();
	}

	public Game saveGame(Game game) {
		return mockDao.saveGame(game);
	}
	
	public Game getGameById(Long id) {
	    return mockDao.getGameById(id);
	}
	
	public boolean deleteGameById(Long id) {
	    return mockDao.deleteGameById(id);
	    
	}
	
	public List<Game> getGameByGenre(String genre) {
	    return mockDao.getGameByGenre(genre);
	    
	}
	

}