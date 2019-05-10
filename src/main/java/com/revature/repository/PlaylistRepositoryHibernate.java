package com.revature.repository;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.model.Playlist;
import com.revature.model.Tracks;

@Repository("playlistRepository")
@Transactional
public class PlaylistRepositoryHibernate implements PlaylistRepository {
	
	private static Logger logger=Logger.getLogger(PlaylistRepositoryHibernate.class);
	
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public PlaylistRepositoryHibernate() {
		logger.trace("Inject Session Factory Bean. ");
	}

	@Override
	public void save(Playlist playlist) {
		
		sessionFactory.getCurrentSession().save(playlist);
		
	}

	@Override
	public Playlist findbyName(String name) {
		try {
			return (Playlist) sessionFactory.getCurrentSession().createCriteria(Playlist.class)
					.add(Restrictions.like("name", name)).list().get(0);
		} catch (IndexOutOfBoundsException e) {
			return null;
		}
	}

	@Override
	public Playlist createPlaylist(String name) {
		return new Playlist();
	}

	@Override
	public Playlist findbyUserId(int userId) {
		
		return null;
	}

	@Override
	public List<Playlist> findAllPlaylists() {
		List<Playlist> playlists = sessionFactory.getCurrentSession().createQuery("from PLAYLIST").list();
		return playlists;
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
