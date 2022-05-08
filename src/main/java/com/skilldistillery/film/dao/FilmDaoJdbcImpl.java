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

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Film findFilmByID(int id) throws SQLException {

		Film film = null;

		try {

//			String sql = "SELECT film.id, film.title, film.description, film.release_year, film.language_id, language.name, film.rental_duration,"
//					+ " film.rental_rate, film.length, film.replacement_cost, film.rating, film.special_features"
//					+ "	FROM film JOIN film_actor ON film.id = film_actor.film_id "
//					+ " JOIN language ON language.id=film.language_id where film.id = ?";

			String sql = "SELECT * FROM film join language on film.language_id = language.id where film.id = ?";

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
				// film.setActors(findActorsByFilmId(filmId));

			}
			rs.close();
			stmt.close();
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return film;
	}

	@Override
	public Film createFilm(Film film) {

		Connection conn = null;
		try {
			conn = DriverManager.getConnection(URL, user, pass);
			conn.setAutoCommit(false); // START TRANSACTION
			String sql = "INSERT INTO film (title, description, release_year, language_id, rental_duration, rental_rate,"
					+ " length, replacement_cost, rating)" + " VALUES (?,?,?,?,?,?,?,?,?)";
			PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, film.getTitle());
			stmt.setString(2, film.getDescription());
			stmt.setInt(3, film.getReleaseYear());
			stmt.setInt(4, film.getLanguageID());
			stmt.setInt(5, film.getRentalDuration());
			stmt.setDouble(6, film.getRentalRate());
			stmt.setInt(7, film.getLength());
			stmt.setDouble(8, film.getReplacementCost());
			stmt.setString(9, film.getRating());
			// EXECUTE
			int updateCount = stmt.executeUpdate();
			// CHECK PROPER INSERT
			if (updateCount == 1) {
				ResultSet keys = stmt.getGeneratedKeys();
				if (keys.next()) {
					int newFilmId = keys.getInt(1);
					film.setId(newFilmId);
				}
			} else {
				film = null;
			}
			conn.commit(); // COMMIT TRANSACTION
//			System.out.println(film.toString()); // for testing only 
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			if (conn != null) {
				try {
					conn.rollback();
				} catch (SQLException sqle2) {
					System.err.println("Error trying to rollback");
				}
			}
			throw new RuntimeException("Error inserting film " + film);
		}
		return film;
	}

	@Override
	public boolean deleteFilm(Integer deleteFilmID) {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(URL, user, pass);
			conn.setAutoCommit(false); // START TRANSACTION
			String sql = "DELETE FROM film WHERE film.id = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, deleteFilmID);
			int updateCount = stmt.executeUpdate();
			if (updateCount == 1) {
				System.out.println("Film ID" + deleteFilmID + "removed from database.");
			} else {
				System.out.println("Something went wrong.");
			}
			conn.commit(); // COMMIT TRANSACTION
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			if (conn != null) {
				try {
					conn.rollback();
				} catch (SQLException sqle2) {
					System.err.println("Error trying to rollback");
				}
			}
			return false;
		}
		return true;
	}

	@Override
	public Film updateFilm(Film film) {
//		stmt.executeUpdate();

		Connection conn = null;
		try {
			conn = DriverManager.getConnection(URL, user, pass);
			conn.setAutoCommit(false); // START TRANSACTION
//			String sql = "INSERT INTO film (title, language_id, rental_duration, rental_rate, replacement_cost) "
//					+ " VALUES (?,?,?,?,?)"; // sql will need updating 
			String sql = "UPDATE film" + " SET title = ?," + " description = ?," + " release_year = ?,"
					+ " language_id = ?," + " rental_duration = ?," + " rental_rate = ?," + " length = ?,"
					+ " replacement_cost = ?," + " rating = ?"
//					+ " special_features = ?"
					+ " WHERE id = ?";

			PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			stmt.setString(1, film.getTitle());
			stmt.setString(2, film.getDescription());
			stmt.setInt(3, film.getReleaseYear());
			stmt.setInt(4, film.getLanguageID());
			stmt.setInt(5, film.getRentalDuration());
			stmt.setDouble(6, film.getRentalRate());
			stmt.setInt(7, film.getLength());
			stmt.setDouble(8, film.getReplacementCost());
			stmt.setString(9, film.getRating());
//			stmt.setString(10, film.getSpecialFeatures()); 
			stmt.setInt(10, film.getId());

			// EXECUTE
			int updateCount = stmt.executeUpdate();
			int updatedFilmId = film.getId();
			// CHECK PROPER INSERT
			if (updateCount == 1) {
				ResultSet keys = stmt.getGeneratedKeys();
				if (keys.next()) {
					film = findFilmByID(updatedFilmId);
				}
			} else {
				film = null;
			}
			conn.commit(); // COMMIT TRANSACTION
//			System.out.println(film.toString()); // for testing only 
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			if (conn != null) {
				try {
					conn.rollback();
				} catch (SQLException sqle2) {
					System.err.println("Error trying to rollback");
				}
			}
			throw new RuntimeException("Error updating film " + film);
		}
		return film;
	}

}
