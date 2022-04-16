package com.skilldistillery.jpacrudweather.entities;

public class WeatherPoint {

	private String idUrl;
	private String cwa;
	private String gridId;
	private Integer gridX;
	private Integer gridY;
	private String forecastUrl;
	private String forecastHourly;
	private Double rLatitude;
	private Double rLongitude;
	private String rCity;
	private String rState;
	private Double rDistance;
	private Integer rBearing;

	public String getIdUrl() {
		return idUrl;
	}

	public void setIdUrl(String idUrl) {
		this.idUrl = idUrl;
	}

	public String getCwa() {
		return cwa;
	}

	public void setCwa(String cwa) {
		this.cwa = cwa;
	}

	public String getGridId() {
		return gridId;
	}

	public void setGridId(String gridId) {
		this.gridId = gridId;
	}

	public Integer getGridX() {
		return gridX;
	}

	public void setGridX(Integer gridX) {
		this.gridX = gridX;
	}

	public Integer getGridY() {
		return gridY;
	}

	public void setGridY(Integer gridY) {
		this.gridY = gridY;
	}

	public String getForecastUrl() {
		return forecastUrl;
	}

	public void setForecastUrl(String forecastUrl) {
		this.forecastUrl = forecastUrl;
	}

	public String getForecastHourly() {
		return forecastHourly;
	}

	public void setForecastHourly(String forecastHourly) {
		this.forecastHourly = forecastHourly;
	}

	public Double getrLatitude() {
		return rLatitude;
	}

	public void setrLatitude(Double rLatitude) {
		this.rLatitude = rLatitude;
	}

	public Double getrLongitude() {
		return rLongitude;
	}

	public void setrLongitude(Double rLongitude) {
		this.rLongitude = rLongitude;
	}

	public String getrCity() {
		return rCity;
	}

	public void setrCity(String rCity) {
		this.rCity = rCity;
	}

	public String getrState() {
		return rState;
	}

	public void setrState(String rState) {
		this.rState = rState;
	}

	public Double getrDistance() {
		return rDistance;
	}

	public void setrDistance(Double rDistance) {
		this.rDistance = rDistance;
	}

	public Integer getrBearing() {
		return rBearing;
	}

	public void setrBearing(Integer rBearing) {
		this.rBearing = rBearing;
	}

	@Override
	public String toString() {
		return "WeatherPoint\nidUrl=" + idUrl + "\ncwa=" + cwa + "\ngridId=" + gridId + "\ngridX=" + gridX + "\ngridY="
				+ gridY + "\nforecastUrl=" + forecastUrl + "\nforecastHourly=" + forecastHourly + "\nrLatitude="
				+ rLatitude + "\nrLongitude=" + rLongitude + "\nrCity=" + rCity + "\nrState=" + rState + "\nrDistance="
				+ rDistance + "\nrBearing=" + rBearing;
	}

}
