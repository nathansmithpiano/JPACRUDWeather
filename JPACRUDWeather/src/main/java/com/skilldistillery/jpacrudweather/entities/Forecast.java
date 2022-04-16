package com.skilldistillery.jpacrudweather.entities;

import java.time.OffsetDateTime;

public class Forecast {

	private OffsetDateTime updated;
	private OffsetDateTime generatedAt;
	private OffsetDateTime updateTime;
	private Double elevation;
	private int numPeriods;

	public OffsetDateTime getUpdated() {
		return updated;
	}

	public void setUpdated(OffsetDateTime updated) {
		this.updated = updated;
	}

	public OffsetDateTime getGeneratedAt() {
		return generatedAt;
	}

	public void setGeneratedAt(OffsetDateTime generatedAt) {
		this.generatedAt = generatedAt;
	}

	public OffsetDateTime getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(OffsetDateTime updateTime) {
		this.updateTime = updateTime;
	}

	public Double getElevation() {
		return elevation;
	}

	public void setElevation(Double elevation) {
		this.elevation = elevation;
	}

	public int getNumPeriods() {
		return numPeriods;
	}

	public void setNumPeriods(int numPeriods) {
		this.numPeriods = numPeriods;
	}

	@Override
	public String toString() {
		return "Forecast\nupdated=" + updated + "\ngeneratedAt=" + generatedAt + "\nupdateTime=" + updateTime
				+ "\nelevation=" + elevation + "\nnumPeriods=" + numPeriods;
	}

}
