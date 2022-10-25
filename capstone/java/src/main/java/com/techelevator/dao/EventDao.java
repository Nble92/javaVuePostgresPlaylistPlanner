package com.techelevator.dao;

import com.techelevator.model.Event;
import com.techelevator.model.EventSongDTO;
import com.techelevator.model.Song;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.util.List;

public interface EventDao {

    public String getSongStatus(int eventId, int songId);

    public Event createEvent(Event event);

    public boolean addUserToEvent(int userId, int eventId);

    public Song addSongToDatabase(Song song);

    public boolean suggestSong(int eventId, Song song);

    public boolean addSongDirectlyToPlaylist(int eventID, Song song);

    public boolean approveSong(int songId, int eventId);

    public boolean rejectSong(int songId, int eventId);

    public Event getEventByID(int eventID);

    public Event mapRowToEvent(SqlRowSet rowSet);

    public List<Song> getPlaylistByEventID(int eventID);

    public List<Song> getDjQueueByEventID(int eventID);

    public boolean isSongInDB(String spotifyURI);

    public List<Event> getAllEvents();

}
