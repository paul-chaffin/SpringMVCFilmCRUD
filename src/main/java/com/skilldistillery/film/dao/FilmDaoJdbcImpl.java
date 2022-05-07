package com.skilldistillery.film.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Component;

import com.skilldistillery.film.entities.Film;

@Component
public class FilmDaoJdbcImpl implements FilmDAO {

	private static final String URL = "jdbc:mysql://localhost:3306/sdvid?useSSL=false&useLegacyDatetimeCode=false&serverTimezone=US/Mountain";
	private final String user = "student";
	private final String pass = "student";

	@Override
	public Film findFilmByID(int id) {

		Film film = null;

		try {

			String sql = "SELECT film.id, film.title, film.description, film.release_year, film.language_id, language.name, film.rental_duration,"
					+ " film.rental_rate, film.length, film.replacement_cost, film.rating, film.special_features"
					+ "	FROM film JOIN film_actor ON film.id = film_actor.film_id "
					+ " JOIN language ON language.id=film.language_id where film.id = ?"; 

			Connection conn = DriverManager.getConnection(URL, user, pass);
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id); 

			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				film = new Film();

				film.setId(rs.getInt("film.id"));
				film.setTitle(rs.getString("film.title"));
				film.setDescription(rs.getString("film.description"));
				film.setReleaseYear(rs.getInt("film.release_year"));
				film.setLanguageID(rs.getInt("film.language_id"));
				film.setLanguage(rs.getString("language.name"));
				
				film.setRentalDuration(rs.getInt("film.rental_duration"));
				film.setRentalRate(rs.getDouble("film.rental_rate"));
				film.setLength(rs.getInt("film.length"));
				film.setReplacementCost(rs.getDouble("film.replacement_cost"));
				film.setRating(rs.getString("film.rating"));
				film.setSpecialFeatures(rs.getString("film.special_features"));
		//		film.setActors(findActorsByFilmId(filmId)); 

			}
			rs.close();
			stmt.close();
			conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return film;
	}

	
	
	
	
	
}
