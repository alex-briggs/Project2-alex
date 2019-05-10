package com.revature.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="URLS")
public class ExternalUrls {


	@Id
	@Column(name="URLS")
	private String spotify; //url to bring up spotify to play the songs

	public ExternalUrls() {
	}

	public ExternalUrls(String spotify) {
		super();
		this.spotify = spotify;
	}

	public String getSpotify() {
		return spotify;
	}

	public void setSpotify(String spotify) {
		this.spotify = spotify;
	}

	@Override
	public String toString() {
		return "ExternalUrls [spotify=" + spotify + "]";
	}
	
	
}
