package com.revature.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Embeddable
public class Artists {

	
	@Column(name="ARTIST_NAME")
	private String name; //artist name
	
	@Embedded
	private ExternalUrls spotify;
	
	
	public Artists() {
	}


	public Artists(String name, ExternalUrls spotify) {
		super();
		this.name = name;
		this.spotify = spotify;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public ExternalUrls getSpotify() {
		return spotify;
	}


	public void setSpotify(ExternalUrls spotify) {
		this.spotify = spotify;
	}


	@Override
	public String toString() {
		return "Artists [name=" + name + ", spotify=" + spotify + "]";
	}


	
	
	
	
	
}
