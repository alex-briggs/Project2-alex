package com.revature.repository;

import com.revature.model.Music;

public interface MusicRepository {

	Music findByTitle(String title);
	Music findByArtist(String artist);
	Music findByAlbum(String album);
}
