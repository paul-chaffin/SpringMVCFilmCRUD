package com.skilldistillery.film.dao;

import java.sql.SQLException;

import com.skilldistillery.film.entities.Film;

public interface FilmDAO {
	
	public Film findFilmByID(int id) throws SQLException;

}
