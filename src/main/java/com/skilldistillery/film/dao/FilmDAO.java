package com.skilldistillery.film.dao;

import com.skilldistillery.film.entities.Film;

public interface FilmDAO {
	
	public Film findFilmByID(int id);

}
