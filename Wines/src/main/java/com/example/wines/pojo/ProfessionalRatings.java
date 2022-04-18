package com.example.wines.pojo;

public class ProfessionalRatings {
	
	protected int professionalRaingId;
	protected Integer points;
	protected Tasters taster;
	protected Wines wine;
	public ProfessionalRatings(int professionalRaingId, int rating, Tasters taster, Wines wine) {

		this.professionalRaingId = professionalRaingId;
		this.points = rating;
		this.taster = taster;
		this.wine = wine;
	}

	public Integer getPoints() {
		return points;
	}

	public void setPoints(Integer points) {
		this.points = points;
	}

	public ProfessionalRatings(){}
	
	public ProfessionalRatings( int rating, Tasters taster, Wines wine) {

		this.points = rating;
		this.taster = taster;
		this.wine = wine;
	}

	public int getProfessionalRaingId() {
		return professionalRaingId;
	}

	public void setProfessionalRaingId(int professionalRaingId) {
		this.professionalRaingId = professionalRaingId;
	}

	public int getRating() {
		return points;
	}

	public void setRating(int rating) {
		this.points = rating;
	}

	public Tasters getTaster() {
		return taster;
	}

	public void setTaster(Tasters taster) {
		this.taster = taster;
	}

	public Wines getWine() {
		return wine;
	}

	public void setWine(Wines wine) {
		this.wine = wine;
	}
	
	
	
	

}
