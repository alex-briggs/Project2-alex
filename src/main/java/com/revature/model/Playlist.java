package com.revature.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "PLAYLIST")
public class Playlist {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="playlistSequence")
	@SequenceGenerator(name="playlistSequence", sequenceName="PLAYLIST_SEQ", allocationSize=1)
	@Column(name="P_ID")
	private int id;
	
	@Column(name="P_NAME")
	private String name;
	
	// foreign key for User Table
	//private User userId
	
	public Playlist() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Playlist [id=" + id + ", name=" + name + "]";
	}
	
	
}
