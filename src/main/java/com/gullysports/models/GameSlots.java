package com.gullysports.models;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.data.mongodb.core.mapping.DBRef;

public class GameSlots {
	@DBRef
	private Sport sport;
	
	@NotNull(message = "Slots can't be null.")
	private List<Slot> slots;

	public Sport getSport() {
		return sport;
	}

	public void setSport(Sport sport) {
		this.sport = sport;
	}

	public List<Slot> getSlots() {
		return slots;
	}

	public void setSlots(List<Slot> slots) {
		this.slots = slots;
	}
	
}
