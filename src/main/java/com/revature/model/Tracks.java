package com.revature.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Embeddable
public class Tracks {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "trackSequence")
	@SequenceGenerator(name = "trackSequence", sequenceName = "TRACK_SEQ", allocationSize = 1)
	@Column(name = "TRACK_ID")
	private int id;
	
	@Embedded
	private Items items;
	
	
	public Tracks() {
	}



	public Tracks(Items items) {
		super();
		this.items = items;
	}



	public Items getItems() {
		return items;
	}



	public void setItems(Items items) {
		this.items = items;
	}



	@Override
	public String toString() {
		return "Tracks [items=" + items + "]";
	}
	
	
	
}
