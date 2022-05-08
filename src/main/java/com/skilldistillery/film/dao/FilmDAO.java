package com.skilldistillery.film.dao;

import java.sql.SQLException;
import java.util.List;

import com.skilldistillery.film.entities.Actor;
import com.skilldistillery.film.entities.Film;

public interface FilmDAO {
	
	public Film findFilmByID(int id) throws SQLException;
	public Film createFilm(Film film);
	public boolean deleteFilm(Integer filmID);
	public Film updateFilm(Film film);
	public List<Film> findFilmsBySearchKeyword(String keyword); 
	public List<Actor> findActors(int filmId);
	public String findCategories(int filmId);

}
