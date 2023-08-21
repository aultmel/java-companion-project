package com.organization.mvcproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.organization.mvcproject.model.GameImpl;

@Controller
public class GameController {

	@GetMapping("games")
	public ModelAndView game() {
		return new ModelAndView("gamesPage", "command", new GameImpl());
	}

}