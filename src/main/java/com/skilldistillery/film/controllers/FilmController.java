package com.skilldistillery.film.controllers;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	public ModelAndView findFilmByID(@RequestParam("filmID") int filmID) {
		ModelAndView mv = new ModelAndView();
		
		Film film = null;
		try {
			film = filmDao.findFilmByID(filmID);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		mv.addObject("film", film);
		mv.setViewName("WEB-INF/views/result.jsp"); 
		
		return mv; 
//		return "WEB-INF/views/home.jsp"; 
	}
	
	@RequestMapping(path = "CreateNewFilm.do", params = {"title", "rentalDuration", "rentalRate", "replacementCost"} , method=RequestMethod.POST)
	public ModelAndView createFilm(String title, int rentalDuration, double rentalRate, double replacementCost) {
		ModelAndView mv = new ModelAndView();
		
		Film newFilm = new Film();
		
		newFilm.setTitle(title); 
		newFilm.setRentalDuration(rentalDuration);
		newFilm.setRentalRate(rentalRate);
		newFilm.setReplacementCost(replacementCost); 
		
		try {
			newFilm = filmDao.createFilm(newFilm);
		} catch (Exception e) {
			
			e.printStackTrace(); 
		}
		
		mv.addObject("film", newFilm);
		mv.setViewName("WEB-INF/views/result.jsp"); 
		return mv;
	}
	
	@RequestMapping(path = "deleteFilm.do", params = "filmID", method = RequestMethod.GET) 
	public ModelAndView deleteFilm(int filmID) {
		ModelAndView mv = new ModelAndView();
		
		
		
		return mv;
		
	}
	
	
}
