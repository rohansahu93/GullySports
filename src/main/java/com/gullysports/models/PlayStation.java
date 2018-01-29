package com.gullysports.models;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "playStations")
public class PlayStation extends EntityBase {

	@NotNull(message = "Name can't be null.")
	@Indexed
	private String name;

	@NotNull(message = "Address can't be null.")
	private String address;

	private String description;

	@NotNull(message = "Opening Time can't be null.")
	private String openingTime;

	@NotNull(message = "Closing Time can't be null.")
	private String closingTime;

	private boolean paid;

	private List<Charge> charges;

	@NotNull(message = "Latitude can't be null.")
	private double latitude;

	@NotNull(message = "Longitude can't be null.")
	private double longitude;

	@NotNull(message = "GameSlots can't be null.")
	private List<GameSlots> gameSlots;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getOpeningTime() {
		return openingTime;
	}

	public void setOpeningTime(String openingTime) {
		this.openingTime = openingTime;
	}

	public String getClosingTime() {
		return closingTime;
	}

	public void setClosingTime(String closingTime) {
		this.closingTime = closingTime;
	}

	public boolean isPaid() {
		return paid;
	}

	public void setPaid(boolean paid) {
		this.paid = paid;
	}

	public List<Charge> getCharges() {
		return charges;
	}

	public void setCharges(List<Charge> charges) {
		this.charges = charges;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public List<GameSlots> getGameSlots() {
		return gameSlots;
	}

	public void setGameSlots(List<GameSlots> gameSlots) {
		this.gameSlots = gameSlots;
	}

}
