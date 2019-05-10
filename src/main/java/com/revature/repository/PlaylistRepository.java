package com.revature.repository;

import java.util.List;

import com.revature.model.Playlist;
import com.revature.model.Tracks;

public interface PlaylistRepository {

	void save (Playlist playlist);
	Playlist findbyUserId(int userId);
	Playlist findbyName (String name);
	List<Playlist> findAllPlaylists();
	Playlist createPlaylist(String name);
	void updatePlaylist(int id, Playlist playlist);
	void deletePlaylist(int id);
	
}
