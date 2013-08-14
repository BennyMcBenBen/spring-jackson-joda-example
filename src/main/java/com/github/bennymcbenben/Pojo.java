package com.github.bennymcbenben;

import org.joda.time.DateTime;

import com.fasterxml.jackson.core.JsonProcessingException;

public class Pojo {
	private DateTime dateTime;
	
	public void setDateTime(DateTime dateTime) {
		this.dateTime = dateTime;
	}
	
	public DateTime getDateTime() {
		return dateTime;
	}
	
	@Override
	public String toString() {
		try {
			return new MyObjectMapper().writeValueAsString(this);
		} catch (JsonProcessingException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((dateTime == null) ? 0 : dateTime.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pojo other = (Pojo) obj;
		if (dateTime == null) {
			if (other.dateTime != null)
				return false;
		} else if (!dateTime.equals(other.dateTime))
			return false;
		return true;
	}
}
