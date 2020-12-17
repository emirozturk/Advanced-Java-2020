package com.emirozturk;

import com.emirozturk.entity.Artist;
import com.emirozturk.entity.Song;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.logging.Logger;


public class Main {
    public static void main(String[] args) {
        var sessionFactory = new Configuration()
                                    .configure("hibernate.cfg.xml")
                                    .addAnnotatedClass(Song.class)
                                    .addAnnotatedClass(Artist.class)
                                    .buildSessionFactory();
        //AddArtist(sessionFactory);
        //GetArtist(sessionFactory);
        //QueryArtist(sessionFactory);
        //UpdateArtist(sessionFactory);
        RemoveArtist(sessionFactory);
    }

    private static void RemoveArtist(SessionFactory session) {
        var currentSession = session.getCurrentSession();
        currentSession.beginTransaction();
        var result = QueryArtist(currentSession);
        currentSession.delete(result);
        currentSession.getTransaction().commit();
        currentSession.close();
    }

    private static void UpdateArtist(SessionFactory session) {
        var currentSession = session.getCurrentSession();
        currentSession.beginTransaction();
        var result = QueryArtist(currentSession);
        result.setName("artist5");
        currentSession.getTransaction().commit();
        currentSession.close();
    }

    private static Artist QueryArtist(Session currentSession) {
        var result = currentSession.createQuery("from Artist a where a.name = 'artist5'",Artist.class).getResultList();
        return result.get(0);
    }

    private static void GetArtist(SessionFactory session) {
        try(var currentSession = session.getCurrentSession()){
            currentSession.beginTransaction();
            Artist result = currentSession.get(Artist.class,1);
            System.out.println(result.toString());
            currentSession.getTransaction().commit();
        }catch(Exception ex){
            Logger.getLogger("AddArtist").info(ex.getMessage());
        }
    }

    private static void AddArtist(SessionFactory session) {
        try(var currentSession = session.getCurrentSession()){
            currentSession.beginTransaction();
            var newArtist = new Artist("artist2");
            currentSession.save(newArtist);
            currentSession.getTransaction().commit();
        }catch(Exception ex){
            Logger.getLogger("AddArtist").info(ex.getMessage());
        }
    }
}
