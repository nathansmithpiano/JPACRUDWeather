package com.skilldistillery.jpacrudweather.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Point {

	// Exists in initial database
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;
	private String category;
	private Double latitude;
	private Double longitude;
	private Integer elevation;

	@Column(name = "mountain_range")
	private String mountainRange;

	@Column(name = "id_url")
	private String idUrl;
	@Column(name = "cwa")
	private String cwa;
	@Column(name = "grid_id")
	private String gridId;

	@Column(name = "grid_x")
	private Integer gridX;

	@Column(name = "grid_y")
	private Integer gridY;

	@Column(name = "forecast_url")
	private String forecastUrl;

	@Column(name = "forecast_hourly")
	private String forecastHourly;

	@Column(name = "rloc_Latitude")
	private Double rLatitude;

	@Column(name = "rloc_longitude")
	private Double rLongitude;

	@Column(name = "rloc_city")
	private String rCity;

	@Column(name = "rloc_state")
	private String rState;

	@Column(name = "rloc_distance")
	private Double rDistance;

	@Column(name = "rloc_bearing")

	private Integer rBearing;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Integer getElevation() {
		return elevation;
	}

	public void setElevation(Integer elevation) {
		this.elevation = elevation;
	}

	public String getMountainRange() {
		return mountainRange;
	}

	public void setMountainRange(String mountainRange) {
		this.mountainRange = mountainRange;
	}

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
		return "Point [id=" + id + ", name=" + name + ", category=" + category + ", latitude=" + latitude
				+ ", longitude=" + longitude + ", elevation=" + elevation + ", mountainRange=" + mountainRange
				+ ", idUrl=" + idUrl + ", cwa=" + cwa + ", gridId=" + gridId + ", gridX=" + gridX + ", gridY=" + gridY
				+ ", forecastUrl=" + forecastUrl + ", forecastHourly=" + forecastHourly + ", rLatitude=" + rLatitude
				+ ", rLongitude=" + rLongitude + ", rCity=" + rCity + ", rState=" + rState + ", rDistance=" + rDistance
				+ ", rBearing=" + rBearing + "]";
	}

}
