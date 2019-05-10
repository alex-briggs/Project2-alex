package com.revature.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.SecondaryTables;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "MUSIC")
@SecondaryTables({
	@SecondaryTable(name="URLS", pkJoinColumns= {
			@PrimaryKeyJoinColumn(name="spotify")}),//,
	@SecondaryTable(name="SEEDS", pkJoinColumns= {
			@PrimaryKeyJoinColumn(name="id")})
})
public class Music {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "musicSequence")
	@SequenceGenerator(name = "musicSequence", sequenceName = "MUSIC_SEQ", allocationSize = 1)
	@Column(name = "M_ID")
	private int id;

	@Column(name = "TRACK_ID")
	private String track;

	@Column(name = "ARTIST_ID")
	private String artist;

	@Column(name = "GENRE_ID")
	private String genre;

	@Column(name = "ALBUM_ID")
	private String album;
	
	@Column(name = "SEED_ID")
	private String seed;
	
	@Column(name = "ITEM_ID")
	private String item;
	
	@Column(name = "URL_ID")
	private String url;
	
	public Music() {
	}

	public Music(int id, String track, String artist, String genre, String album) {
		this.id = id;
		this.track = track;
		this.artist = artist;
		this.genre = genre;
		this.album = album;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTrack() {
		return track;
	}

	public void setTrack(String track) {
		this.track = track;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getAlbum() {
		return album;
	}

	public void setAlbum(String album) {
		this.album = album;
	}

	@Override
	public String toString() {
		return "Music [id=" + id + ", track=" + track + ", artist=" + artist + ", genre=" + genre + ", album=" + album
				+ "]";
	}

}
