package com.revature.rest;

import com.revature.model.Music;

public interface MusicController {

	Music getTitle (String title);
	Music getAlbum (Music music);
	Music getArtist (Music music);
}
