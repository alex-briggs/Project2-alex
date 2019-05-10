package com.revature.service;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.model.Playlist;
import com.revature.repository.PlaylistRepository;

@Service("playlistService")
public class PlaylistServiceAlpha implements PlaylistService {

	private static Logger logger = Logger.getLogger(PlaylistServiceAlpha.class);
	
	@Autowired
	private PlaylistRepository playlistRepository;
	
	public PlaylistServiceAlpha() {
		
	}

	@Override
	public void save(Playlist playlist) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Playlist getbyUserId(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Playlist getbyName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public List<Playlist> getAllPlaylists() {
		return playlistRepository.findAllPlaylists();
	}

	@Override
	public Playlist createPlaylist(String name) {
		return playlistRepository.createPlaylist(name);
	}

	@Override
	public void updatePlaylist(int id, Playlist playlist) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletePlaylist(int id) {
		// TODO Auto-generated method stub
		
	}
	
	
}
