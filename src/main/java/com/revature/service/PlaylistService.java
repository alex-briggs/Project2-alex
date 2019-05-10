package com.revature.service;

import java.util.List;

import com.revature.model.Playlist;

public interface PlaylistService {

	void save (Playlist playlist);
	Playlist getbyUserId(int userId);
	Playlist getbyName (String name);
	List<Playlist> getAllPlaylists();
	Playlist createPlaylist(String name);
	void updatePlaylist(int id, Playlist playlist);
	void deletePlaylist(int id);
}
