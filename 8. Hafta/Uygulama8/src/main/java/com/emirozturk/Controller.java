package com.emirozturk;

import com.emirozturk.entity.Artist;
import com.emirozturk.entity.Lyric;
import com.emirozturk.entity.Song;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.logging.Logger;

public class Controller {
    SessionFactory sessionFactory;
    public Controller(){
        sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Song.class)
                .addAnnotatedClass(Artist.class)
                .addAnnotatedClass(Lyric.class)
                .buildSessionFactory();
    }
    public void removeArtist(String name) {
        try(var currentSession = sessionFactory.getCurrentSession()) {
            currentSession.beginTransaction();
            var result = queryArtist(currentSession,name);
            currentSession.delete(result);
            currentSession.getTransaction().commit();
        }
        catch(Exception ex){
            Logger.getLogger("removeArtist").info(ex.getMessage());
        }
    }

    public void updateArtist(String oldName,String newName) {
        try(var currentSession = sessionFactory.getCurrentSession()){
            currentSession.beginTransaction();
            var result = queryArtist(currentSession,oldName);
            result.setName(newName);
            currentSession.getTransaction().commit();
        }
        catch(Exception ex){
            Logger.getLogger("updateArtist").info(ex.getMessage());
        }

    }

    public void addArtist(String name) {
        try(var currentSession = sessionFactory.getCurrentSession()){
            currentSession.beginTransaction();
            var newArtist = new Artist(name);
            currentSession.save(newArtist);
            currentSession.getTransaction().commit();
        }catch(Exception ex){
            Logger.getLogger("addArtist").info(ex.getMessage());
        }
    }

    private Artist queryArtist(Session currentSession,String name) {
        String query = "from Artist a where a.name like :name";
        var result = currentSession.createQuery(query,Artist.class)
                                .setParameter("name","%"+name+"%")
                                .getResultList();
        if(result.size()>0)
            return result.get(0);
        else
            return null;
    }

    public void addSong(String songName, int releaseYear) {
        try(var currentSession = sessionFactory.getCurrentSession()){
            currentSession.beginTransaction();
            Song newSong = new Song(songName,releaseYear);
            currentSession.save(newSong);
            currentSession.getTransaction().commit();
        }catch(Exception ex){
            Logger.getLogger("addSong").info(ex.getMessage());
        }
    }

    public Song getSong(String songName) {
        try(var currentSession = sessionFactory.getCurrentSession()){
            currentSession.beginTransaction();
            List<Song> songs = currentSession.createQuery("from Song s where s.name like :name",Song.class)
                            .setParameter("name","%" + songName + "%")
                            .getResultList();
            if(songs.size()>0)
                return songs.get(0);
            else
                return null;
        }catch(Exception ex){
            Logger.getLogger("getSong").info(ex.getMessage());
            return null;
        }
    }

    public void addLyric(Song song, String content) {
        try(var currentSession = sessionFactory.getCurrentSession()){
            currentSession.beginTransaction();
            Lyric newLyric = new Lyric(content);
            currentSession.get(Song.class,song.getId()).getLyrics().add(newLyric);
            newLyric.setSong(song);
            currentSession.save(newLyric);
            currentSession.getTransaction().commit();
        }catch(Exception ex){
            Logger.getLogger("addLyric").info(ex.getMessage());
        }
    }
}
