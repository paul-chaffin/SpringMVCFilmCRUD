package com.skilldistillery.film.controllers;

import java.sql.SQLException;
import java.util.List;

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

	@RequestMapping(path = { "/", "home.do" })
	public String home() {
		return "WEB-INF/views/home.jsp";
	}

	@RequestMapping(path = "findFilmsBySearchKeyword.do", params = "keyword", method = RequestMethod.GET)
	public ModelAndView findFilmByTerm(@RequestParam("keyword") String keyword) {
		List<Film> films;
		ModelAndView mv = new ModelAndView();
		films = filmDao.findFilmsBySearchKeyword(keyword);

		mv.addObject("films", films);
		mv.setViewName("WEB-INF/views/searchResults.jsp");
		return mv;
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

	@RequestMapping(path = "CreateNewFilm.do", params = { "title", "releaseYear", "rating", "rentalDuration",
			"rentalRate", "replacementCost", "length", "languageID", "description" }, method = RequestMethod.POST)
	public ModelAndView createFilm(String title, Integer releaseYear, String rating, int rentalDuration,
			double rentalRate, double replacementCost, Integer length, int languageID, String description) {
		ModelAndView mv = new ModelAndView();

		Film newFilm = new Film();

//		newFilm.setId(id);
		newFilm.setTitle(title);
		newFilm.setReleaseYear(releaseYear);
		newFilm.setRating(rating);
		newFilm.setRentalDuration(rentalDuration);
		newFilm.setRentalRate(rentalRate);
		newFilm.setReplacementCost(replacementCost);
		newFilm.setLength(length);
		newFilm.setLanguageID(languageID);
//		updateFilm.setSpecialFeatures(specialFeatures);
		newFilm.setDescription(description);

		try {
			newFilm = filmDao.createFilm(newFilm);
		} catch (Exception e) {

			e.printStackTrace();
		}

		mv.addObject("film", newFilm);
		mv.setViewName("WEB-INF/views/result.jsp");
		return mv;
	}

	@RequestMapping(path = "deleteFilm.do", params = "deleteFilmID", method = RequestMethod.GET)
	public ModelAndView deleteFilm(Integer deleteFilmID) {
		ModelAndView mv = new ModelAndView();
		boolean success = filmDao.deleteFilm(deleteFilmID);
		if (success) {
			mv.setViewName("WEB-INF/views/deleted.jsp");
		} else {
			mv.setViewName("WEB-INF/views/deletedFailed.jsp");
		}

		return mv;

	}

	@RequestMapping(path = "updateFilm.do",
//			params = {"id", "title", "releaseYear", "rating", "rentalDuration", "rentalRate", "replacementCost", "length", "languageID", "specialFeatures", "description"}, 
			params = { "id", "title", "releaseYear", "rating", "rentalDuration", "rentalRate", "replacementCost",
					"length", "languageID", "description" }, method = RequestMethod.POST)
	public ModelAndView updateFilm(int id, String title, Integer releaseYear, String rating, int rentalDuration,
			double rentalRate, double replacementCost, Integer length, int languageID, String description) {
		ModelAndView mv = new ModelAndView();

		Film updateFilm = new Film();

		updateFilm.setId(id);
		updateFilm.setTitle(title);
		updateFilm.setReleaseYear(releaseYear);
		updateFilm.setRating(rating);
		updateFilm.setRentalDuration(rentalDuration);
		updateFilm.setRentalRate(rentalRate);
		updateFilm.setReplacementCost(replacementCost);
		updateFilm.setLength(length);
		updateFilm.setLanguageID(languageID);
//		updateFilm.setSpecialFeatures(specialFeatures);
		updateFilm.setDescription(description);

		mv.addObject("film", filmDao.updateFilm(updateFilm));
		mv.setViewName("WEB-INF/views/result.jsp");

		return mv;
	}

}
