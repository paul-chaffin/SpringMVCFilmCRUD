package com.skilldistillery.film.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.skilldistillery.film.dao.FilmDAO;
import com.skilldistillery.film.entities.Film;

@Controller
public class FilmController {
	
	@Autowired
	private FilmDAO filmDao; 
	
	@RequestMapping(path = {"/", "home.do"})
	public String home() {
		return "WEB-INF/views/home.jsp";
	} 
	 
	@RequestMapping(path = "FindFilmByID.do", params = "filmID", method = RequestMethod.GET) 
	public ModelAndView findFilmByID(int filmID) {
		ModelAndView mv = new ModelAndView();
		
		Film film = filmDao.findFilmByID(filmID);
		mv.addObject("film", film);
		mv.setViewName("WEB-INF/views/result.jsp"); 
		
		return mv;
//		return "WEB-INF/views/home.jsp"; 
	}

}
