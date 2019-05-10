package com.revature.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.model.Music;
import com.revature.repository.MusicRepository;

@Service("musicService")
public class MusicServiceAlpha implements MusicService{

	private static Logger logger = Logger.getLogger(MusicServiceAlpha.class);
	
	@Autowired 
	private MusicRepository musicRepository;
	
	public MusicServiceAlpha() {
		
	}
	
	@Override
	public Music getTitle(String title) {
		return musicRepository.findByTitle(title);
	}

	@Override
	public Music getAlbum(String album) {
		return musicRepository.findByAlbum(album);
	}

	@Override
	public Music getArtist(String artist) {
		return musicRepository.findByArtist(artist);
	}


}
