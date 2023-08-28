package com.organization.mvcproject.api.dao;

import java.util.List;

import com.organization.mvcproject.api.model.Game;

public interface MockDAO {
    
    List<Game> getAllGames();
    
    Game getGameById(Long id);
    
    boolean deleteGameById(Long id);
    
    List<Game> getGameByGenre(String genre);
    
    Game saveGame(Game game);

}
