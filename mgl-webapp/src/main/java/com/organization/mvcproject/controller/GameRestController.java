package com.organization.mvcproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.organization.mvcproject.model.Game;
import com.organization.mvcproject.service.GameService;

@RestController
public class GameRestController {
    
    @Autowired
    private GameService gameService;
    
    @GetMapping("game")
    public ResponseEntity<List<Game>> fetchAllGames() {
        return new ResponseEntity<List<Game>>(gameService.retrieveAllGames(), HttpStatus.OK);
    }

    @PostMapping(value = "/game", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createGame(@RequestBody Game game) {
        gameService.saveGame(game);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

}
