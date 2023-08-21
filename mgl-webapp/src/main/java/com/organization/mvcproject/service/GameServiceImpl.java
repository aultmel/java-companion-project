package com.organization.mvcproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.organization.mvcproject.api.service.GameService;
import com.organization.mvcproject.dao.MockDAOImpl;
import com.organization.mvcproject.model.GameImpl;

@Service
public class GameServiceImpl implements GameService {

    @Autowired
	private MockDAOImpl mockDao;

	public List<GameImpl> retrieveAllGames() {
		return mockDao.getAllGames();
	}

	public GameImpl saveGame(GameImpl game) {
		return mockDao.saveGame(game);
	}
	
	public GameImpl getGameById(Long id) {
	    return mockDao.getGameById(id);
	}
	
	public boolean deleteGameById(Long id) {
	    return mockDao.deleteGameById(id);
	    
	}
	

}