package com.revature.rest;

import java.net.URI;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import com.revature.model.Playlist;
import com.revature.model.Tracks;
import com.revature.service.PlaylistService;

@Controller("playlistController")
@CrossOrigin(origins = "http://localhost:4200")
public class PlaylistControllerAlpha implements PlaylistController {
	
	
	
	
	private static Logger logger = Logger.getLogger(PlaylistControllerAlpha.class);
	private static final String authorizationToken = "BQD8a6D--AhKRY9NQXsmxyGuQGJ23Fcreo8jRJdzMTl6CMY9p4oG8waqZ0StK9oCHBpMS5EtTE3iX-swWcu2YOOR9yIi77fD4QjWR3bY7R8daqjAFXrCwNF-y3ywqtiOba0dshW1jc2oY2sudtgxm_0";
	private RestTemplate restTemplate = new RestTemplate();
	private static final HttpHeaders headers = new HttpHeaders();

	
	@Autowired
	private PlaylistService playlistService;

	@GetMapping()
	public List<Playlist> findAllPlaylistsByUsername(String username) {
		
		  return playlistService.getAllPlaylists();
		
	}

	@PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Playlist> createPlaylist(@RequestBody String name) {
		Playlist newPlaylist = playlistService.createPlaylist(name);
		if (newPlaylist != null) {
			return ResponseEntity.created(URI.create("/playlists?name=" + newPlaylist.getName())).build();
		} else {
			return ResponseEntity.unprocessableEntity().build();
		}
	}

	@GetMapping(value="/playlists")
	public ResponseEntity<List<Playlist>> getAllPlaylists() {
		List<Playlist> playlists = playlistService.getAllPlaylists();
		return ResponseEntity.ok().body(playlists);
	}

	
	//https://api.spotify.com/v1/search?q=roadhouse%20blues&type=track
	
	//private static final String authorizationToken = "BQD8a6D--AhKRY9NQXsmxyGuQGJ23Fcreo8jRJdzMTl6CMY9p4oG8waqZ0StK9oCHBpMS5EtTE3iX-swWcu2YOOR9yIi77fD4QjWR3bY7R8daqjAFXrCwNF-y3ywqtiOba0dshW1jc2oY2sudtgxm_0";
	//private RestTemplate restTemplate = new RestTemplate();
	//private static final HttpHeaders headers = new HttpHeaders();
	

	@Override
	@PutMapping(value="/create", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Playlist> updatePlaylist(Tracks track) {
		headers.set("Authorization", "Bearer " + authorizationToken);
		HttpEntity<?> entity = new HttpEntity<Object>(headers);
		ResponseEntity<Playlist> response = restTemplate.exchange("https://api.spotify.com/v1/search?q=" + track.getItems().getName()+"&type=track", HttpMethod.GET, entity, Playlist.class);
		Playlist newPlaylist = response.getBody();
		//return newPlaylist;
		return response;
	}

	//sessionFactory.persist();
	
}
