package com.skilldistillery.jpacrudweather.entities;

import java.time.OffsetDateTime;

public class Period {
	private int number;
	private String name;
	private OffsetDateTime startTime;
	private OffsetDateTime endTime;
	private boolean isDaytime;
	private Integer temp;
	private String tempUnit;
	private String windSpeed;
	private Integer windMin;
	private Integer windMax;
	private String windDirection;
	private String iconUrl;
	private String shortForecast;
	private String detailedForecast;
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public OffsetDateTime getStartTime() {
		return startTime;
	}
	public void setStartTime(OffsetDateTime startTime) {
		this.startTime = startTime;
	}
	public OffsetDateTime getEndTime() {
		return endTime;
	}
	public void setEndTime(OffsetDateTime endTime) {
		this.endTime = endTime;
	}
	public boolean isDaytime() {
		return isDaytime;
	}
	public void setDaytime(boolean isDaytime) {
		this.isDaytime = isDaytime;
	}
	public Integer getTemp() {
		return temp;
	}
	public void setTemp(Integer temp) {
		this.temp = temp;
	}
	public String getTempUnit() {
		return tempUnit;
	}
	public void setTempUnit(String tempUnit) {
		this.tempUnit = tempUnit;
	}
	public String getWindSpeed() {
		return windSpeed;
	}
	public void setWindSpeed(String windSpeed) {
		this.windSpeed = windSpeed;
	}
	public Integer getWindMin() {
		return windMin;
	}
	public void setWindMin(Integer windMin) {
		this.windMin = windMin;
	}
	public Integer getWindMax() {
		return windMax;
	}
	public void setWindMax(Integer windMax) {
		this.windMax = windMax;
	}
	public String getWindDirection() {
		return windDirection;
	}
	public void setWindDirection(String windDirection) {
		this.windDirection = windDirection;
	}
	public String getIconUrl() {
		return iconUrl;
	}
	public void setIconUrl(String iconUrl) {
		this.iconUrl = iconUrl;
	}
	public String getShortForecast() {
		return shortForecast;
	}
	public void setShortForecast(String shortForecast) {
		this.shortForecast = shortForecast;
	}
	public String getDetailedForecast() {
		return detailedForecast;
	}
	public void setDetailedForecast(String detailedForecast) {
		this.detailedForecast = detailedForecast;
	}
	@Override
	public String toString() {
		return "Period\nnumber=" + number + "\nname=" + name + "\nstartTime=" + startTime + "\nendTime=" + endTime
				+ "\nisDaytime=" + isDaytime + "\ntemp=" + temp + "\ntempUnit=" + tempUnit + "\nwindSpeed=" + windSpeed
				+ "\nwindMin=" + windMin + "\nwindMax=" + windMax + "\nwindDirection=" + windDirection + "\niconUrl="
				+ iconUrl + "\nshortForecast=" + shortForecast + "\ndetailedForecast=" + detailedForecast;
	}

}
