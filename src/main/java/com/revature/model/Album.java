package com.revature.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Album {
	
//	@Embedded
//	private Artists artists;
	
	@Column(name="ALBUM_NAME")
	private String name; //album name
	
	public Album() {
	}
	public Album(Artists artists, String name) {
		super();
		//this.artists = artists;
		this.name = name;
	}

	/*
	 * public Artists getArtists() { return artists; } public void
	 * setArtists(Artists artists) { this.artists = artists; }
	 */
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		//return "Album [artists=" + artists + ", name=" + name + "]";
		return "Album [name=" + name + "]";
	}
	
	
}
