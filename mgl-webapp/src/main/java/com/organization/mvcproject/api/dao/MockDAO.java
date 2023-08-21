package com.organization.mvcproject.api.dao;

import java.util.List;

import com.organization.mvcproject.model.GameImpl;

public interface MockDAO {
    
    List<GameImpl> getAllGames();
    
    GameImpl getGameById(Long id);
    
    boolean deleteGameById(Long id);
    
    GameImpl getGameByGenre(String genre);
    
    GameImpl saveGame(GameImpl game);

}
