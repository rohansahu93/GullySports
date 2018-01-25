package com.gullysports.models;

import org.bson.types.ObjectId;

public class Charge {
	private ObjectId sportId;
	private Long amount;
	private String rate;
	private String currency;

	public ObjectId getSportId() {
		return sportId;
	}

	public void setSportId(ObjectId sportId) {
		this.sportId = sportId;
	}

	public Long getAmount() {
		return amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}

	public String getRate() {
		return rate;
	}

	public void setRate(String rate) {
		this.rate = rate;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

}
