package com.revature.rest;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.revature.model.Playlist;
import com.revature.model.Tracks;

public interface PlaylistController {

	ResponseEntity<List<Playlist>> getAllPlaylists();
	ResponseEntity<Playlist> createPlaylist(String name);
	ResponseEntity<Playlist> updatePlaylist(Tracks track);
}
