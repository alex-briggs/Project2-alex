package com.revature.service;

import com.revature.model.Music;

public interface MusicService {

	public Music getTitle (String title);
	public Music getAlbum (String album);
	public Music getArtist (String artist);
}
