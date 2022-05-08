package com.skilldistillery.film.entities;

import java.util.List;


public class Film {
	private int id; // task 4 from collaboration exercise 
	private String title;
	private String description;
	private Integer releaseYear; 
	private int languageID; // will map to foreign key of another table
	private String language;
	private int rentalDuration;
	private double rentalRate;
	private Integer length;
	private double replacementCost;
	private String rating; // enum in film table DESC, use String here 
	private String specialFeatures; // set in film table DESC, use String here
	private List<Actor> actors;
	
	
	public Film() {
		
	}
	
	public Film(int id, String title, String description, Integer releaseYear, int languageID, int rentalDuration,
			double rentalRate, Integer length, double replacementCost, String rating, String specialFeatures,
			List<Actor> actors) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.releaseYear = releaseYear;
		this.languageID = languageID;
		this.rentalDuration = rentalDuration;
		this.rentalRate = rentalRate;
		this.length = length;
		this.replacementCost = replacementCost;
		this.rating = rating;
		this.specialFeatures = specialFeatures;
		this.actors = actors;
	}

	
	public Film(int filmId, String filmTitle, Integer releaseYear, String rating, String description, String language) {
		this.id = filmId;
		this.title = filmTitle;
		this.description = description;
		this.releaseYear = releaseYear;
		this.rating = rating;
		this.language = language;
	}

	public Film(int filmId, String filmTitle, Integer releaseYear, String rating, 
			String description, String language, List<Actor> actors) {
		this.id = filmId;
		this.title = filmTitle;
		this.description = description;
		this.releaseYear = releaseYear;
		this.rating = rating;
		this.language = language;
		this.actors = actors;
	}

	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(Integer releaseYear) {
		this.releaseYear = releaseYear;
	}

	public int getLanguageID() {
		return languageID;
	}

	public void setLanguageID(int languageID) {
		this.languageID = languageID;
	}

	public int getRentalDuration() {
		return rentalDuration;
	}

	public void setRentalDuration(int rentalDuration) {
		this.rentalDuration = rentalDuration;
	}

	public double getRentalRate() {
		return rentalRate;
	}

	public void setRentalRate(double rentalRate) {
		this.rentalRate = rentalRate;
	}

	public Integer getLength() {
		return length;
	}

	public void setLength(Integer length) {
		this.length = length;
	}

	public double getReplacementCost() {
		return replacementCost;
	}

	public void setReplacementCost(double replacementCost) {
		this.replacementCost = replacementCost;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getSpecialFeatures() {
		return specialFeatures;
	}

	public void setSpecialFeatures(String specialFeatures) {
		this.specialFeatures = specialFeatures;
	}

	public List<Actor> getActors() {
		return actors;
	}

	public void setActors(List<Actor> actors) {
		this.actors = actors;
	}
	
	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	
	@Override
	public String toString() {
		String filmS = "";
		
		filmS += "Title: " + title  + " | Release Year: " + releaseYear 
				+ " | Language: " + language + " | Rating: " + rating 
				+ " | Description: " + description 
				+ "\n" + "Cast of actors: \n";
		
//		for (Actor actor : actors) {
//			film += "\t" + actor;
//		}
		return filmS;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Film))
			return false;
		Film other = (Film) obj;
		if (id != other.id)
			return false;
		return true;
	} 
	

}