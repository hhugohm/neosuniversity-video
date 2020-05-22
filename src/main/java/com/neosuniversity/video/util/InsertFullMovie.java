package com.neosuniversity.video.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;

import com.neosuniversity.video.entities.Actor;
import com.neosuniversity.video.entities.Chapter;
import com.neosuniversity.video.entities.Country;
import com.neosuniversity.video.entities.Movie;
import com.neosuniversity.video.entities.Season;
import com.neosuniversity.video.entities.TypeMovie;

public class InsertFullMovie {
	
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.getTransaction().begin();
		
		Movie movie = new Movie();
		movie.setTitle("DOCTOR HOUSE");
		
		TypeMovie typeMovie = (TypeMovie) session.get(TypeMovie.class, new Long(2));
		
		movie.setTypemovie(typeMovie);
		
		movie.setDuration(new Date());
		
		Season season1 = new Season();
		season1.setTitle("TEMPORADA 1");
		season1.setSynopsis("E");
		
		Season season2 = new Season();
		season2.setTitle("TEMPORADA 2");
		season2.setSynopsis("E");
		
		
		Chapter chapter1 = new Chapter();
		chapter1.setTitle("PILOTO");
		chapter1.setDuration(new Date());
		
		Chapter chapter2 = new Chapter();
		chapter2.setTitle("LOCURA");
		chapter2.setDuration(new Date());
		
		Chapter chapter3 = new Chapter();
		chapter3.setTitle("SAVE ME");
		chapter3.setDuration(new Date());
		
		List<Chapter> chapters1= new ArrayList<>();
		chapters1.add(chapter1);
		chapters1.add(chapter2);
		
		
		season1.setChapters(chapters1);
		
		List<Chapter> chapters2= new ArrayList<>();
		chapters2.add(chapter3);
		
		season2.setChapters(chapters2);
		
		List<Season> seasons = new ArrayList<>();
		seasons.add(season1);
		seasons.add(season2);
		
		movie.setSeason(seasons);
		
		
		
		
		Actor actor= new Actor();
		actor.setName("BRAT");
		actor.setLasname("PIT");
		
		Country country = Country.builder().description("MEXICO").build();
		
		
		
		Actor actor2= new Actor();
		actor2.setName("BRAT");
		actor2.setLasname("PIT");
		
		Country country2 = Country.builder().description("CANADA").build();
		
		
		Set<Actor> actors = new HashSet<>();
		actors.add(actor);
		actors.add(actor2);
		
		movie.setActors(actors);
		
		
		session.save(movie);
		session.getTransaction().commit();
		HibernateUtil.shutdown();

	}

}
