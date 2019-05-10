package com.revature.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="SEEDS")
public class Seeds {

	@Id
	@Column(name="SEED_ID")
	private String id; //genre name 

	public Seeds() {
	}

	public Seeds(String id) {
		super();
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Seeds [id=" + id + "]";
	}
	
	
}
