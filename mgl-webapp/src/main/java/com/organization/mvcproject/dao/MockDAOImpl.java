package com.organization.mvcproject.dao;

import java.util.ArrayList;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.google.common.collect.ImmutableList;
import com.organization.mvcproject.api.dao.MockDAO;
import com.organization.mvcproject.api.model.Game;
import com.organization.mvcproject.model.GameImpl;


@Repository
public class MockDAOImpl implements MockDAO {
    
    private static Long gameId = new Long(0);
    private static List<GameImpl> gameImpls = new ArrayList<GameImpl>();

    static {
        gameImpls = populateGames();
    }

    private static List<GameImpl> populateGames() {

        GameImpl game1 = new GameImpl();
        game1.setId(++gameId);
        game1.setGenre("Sport");
        game1.setName("Rocket League");

        GameImpl game2 = new GameImpl();
        game2.setId(++gameId);
        game2.setGenre("Shooter");
        game2.setName("Halo 3");

        GameImpl game3 = new GameImpl();
        game3.setId(++gameId);
        game3.setGenre("MMORPG");
        game3.setName("Runescape");

        gameImpls.add(game1);
        gameImpls.add(game2);
        gameImpls.add(game3);

        return gameImpls;
    }
    
    public List<Game> getAllGames() {
        return ImmutableList.copyOf(gameImpls);
    }
    
    public Game getGameById(Long id) {
        for (Game game : gameImpls) {
            if (id == game.getId()) {
                return game;
            }
        }
        
        return null;
    }
    
    public Game saveGame(Game game) {
        if (game.getId() != null) {
            Game existingGame = getGameById(game.getId());
            if (existingGame != null) {
                for (int i = 0; i < gameImpls.size(); i++) {
                    if (game.getId() == gameImpls.get(i).getId()) {
                        gameImpls.set(i, (GameImpl) existingGame);
                    }
                }
            }
        }
        game.setId(gameId++);
        gameImpls.add((GameImpl)game);
        return game;
    }
    
    public boolean deleteGameById(Long id) {
        for (int i = 0; i < gameImpls.size(); i++) {
            if (id == gameImpls.get(i).getId()) {
                gameImpls.remove(gameImpls.get(i));
                return true;
            }
        }
        return false;
    }
    
    public List<Game> getGameByGenre(String genre) {
        List<Game> gamesByGenre = new ArrayList<>();
        for (int i = 0; i < gameImpls.size(); i++) {
            if (genre.equals(gameImpls.get(i).getGenre())) {
                gamesByGenre.add(gameImpls.get(i));
            }
        }
        
        return gamesByGenre.isEmpty() ? null : gamesByGenre;
        
    }

}
