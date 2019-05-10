package com.revature.repository;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.model.Music;

@Repository("musicRepository")
@Transactional
public class MusicRepositoryHibernate implements MusicRepository{

	private static Logger logger=Logger.getLogger(MusicRepositoryHibernate.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public MusicRepositoryHibernate() {
		logger.trace("Inject Session Factory Bean. ");
	}
	
	@Override
	public Music findByTitle(String title) {
		try {
			return (Music) sessionFactory.getCurrentSession().createCriteria(Music.class)
					.add(Restrictions.like("name", title)).list().get(0);
		} catch (IndexOutOfBoundsException e) {
			return null;
		}
	}

	@Override
	public Music findByArtist(String artist) {
		try {
			return (Music) sessionFactory.getCurrentSession().createCriteria(Music.class)
					.add(Restrictions.like("name", artist)).list().get(0);
		} catch (IndexOutOfBoundsException e) {
			return null;
		}
	}

	@Override
	public Music findByAlbum(String album) {
		try {
			return (Music) sessionFactory.getCurrentSession().createCriteria(Music.class)
					.add(Restrictions.like("name", album)).list().get(0);
		} catch (IndexOutOfBoundsException e) {
			return null;
		}
	}

}
