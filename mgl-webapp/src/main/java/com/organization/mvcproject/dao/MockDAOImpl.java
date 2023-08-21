package com.organization.mvcproject.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.organization.mvcproject.api.dao.MockDAO;
import com.organization.mvcproject.model.GameImpl;


@Repository
public class MockDAOImpl implements MockDAO {
    
    private static Long gameId = new Long(0);
    private static List<GameImpl> games = new ArrayList<GameImpl>();

    static {
        games = populateGames();
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

        games.add(game1);
        games.add(game2);
        games.add(game3);

        return games;
    }
    
    public List<GameImpl> getAllGames() {
        return games;
    }
    
    public GameImpl getGameById(Long id) {
        for (GameImpl game : games) {
            if (id == game.getId()) {
                return game;
            }
        }
        
        return null;
    }
    
    public GameImpl saveGame(GameImpl game) {
        if (game.getId() != null) {
            GameImpl existingGame = getGameById(game.getId());
            if (existingGame != null) {
                for (int i = 0; i < games.size(); i++) {
                    if (game.getId() == games.get(i).getId()) {
                        games.set(i, existingGame);
                    }
                }
            }
        }
        game.setId(gameId++);
        games.add(game);
        return game;
    }
    
    public boolean deleteGameById(Long id) {
        for (int i = 0; i < games.size(); i++) {
            if (id == games.get(i).getId()) {
                games.remove(games.get(i));
                return true;
            }
        }
        return false;
    }
    
    public GameImpl getGameByGenre(String genre) {
        for (int i = 0; i < games.size(); i++) {
            if (genre.equals(games.get(i).getGenre())) {
                return games.get(i);
            }
        }
        return null;
    }

}
