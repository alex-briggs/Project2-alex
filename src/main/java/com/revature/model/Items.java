package com.revature.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Embeddable
public class Items {
	
	@Embedded
	private Album album;
	@Embedded
	private Artists artists;
	
	@Column(name="S_NAME")
	private String name; //song name
	
	public Items() {
	}
	
	public Items(Album album, Artists artists, String name) {
		super();
		this.album = album;
		this.artists = artists;
		this.name = name;
	}
	
	public Album getAlbum() {
		return album;
	}
	public void setAlbum(Album album) {
		this.album = album;
	}
	public Artists getArtists() {
		return artists;
	}
	public void setArtists(Artists artists) {
		this.artists = artists;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Items [album=" + album + ", artists=" + artists + ", name=" + name + "]";
	}
	
	
}
