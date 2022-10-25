package com.techelevator.dao;

import com.techelevator.model.Event;
import com.techelevator.model.EventSongDTO;
import com.techelevator.model.Song;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcEventDao implements EventDao {
    private JdbcTemplate jdbcTemplate;
    private EventDao eventDAO;


    public JdbcEventDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public Event createEvent(Event event) {
        String sql = "INSERT INTO events (event_name, event_begin, event_end, host_id) VALUES (?,?,?,?) RETURNING event_id;";

        int eventID = jdbcTemplate.queryForObject(sql, Integer.class, event.getEventName(), event.getEventBegin(), event.getEventEnd(),event.getHostID());
        event.setEventID(eventID);

        return event;
    }

    @Override
    public boolean addUserToEvent(int userId, int eventId) {
        String sql = "INSERT INTO user_event (user_id, event_id) " +
                "VALUES (?, ?)";
        int count = jdbcTemplate.update(sql, userId, eventId);

        return count == 1;
    }

//    @Override
//    public boolean addSongToDatabase(Song song) {
//
//        String sql = "INSERT INTO songs (title, artist,genre,album,spotify_song_uri, album_art) " +
//                "VALUES (?,?,?,?,?,?) RETURNING id";
//
//        try {
//            Integer newID = jdbcTemplate.update(sql, Integer.class, song.getTitle(), song.getArtist(),
//                    song.getGenre(), song.getAlbum(), song.getSpotifySongURI(), song.getAlbumArt());
//            return true;
//        } catch (DataAccessException ex) {
//            return false;
//        }
//
//    }



    @Override
    public Song addSongToDatabase(Song song) {

        String sql = "INSERT INTO songs (title, artist,genre,album,spotify_song_uri, album_art) " +
                "VALUES (?,?,?,?,?,?) RETURNING song_id";
            Integer newID = jdbcTemplate.queryForObject(sql, Integer.class, song.getTitle(), song.getArtist(),
                    song.getGenre(), song.getAlbum(), song.getSpotifySongURI(), song.getAlbumArt());
            song.setSongID(newID);

            return song ;
      }



    @Override
    public boolean suggestSong(int eventID, Song song) {
        String sql = "INSERT INTO event_song (song_id, event_id, status) " +
                "VALUES (?,?, 'pending');";
        int count = jdbcTemplate.update(sql, song.getSongID(), eventID);

        return count == 1;
    }

    @Override
    public boolean addSongDirectlyToPlaylist(int eventID, Song song) {
        String sql = "INSERT INTO event_song (song_id, event_id, status) " +
                "VALUES (?,?, 'approved');";
        int count = jdbcTemplate.update(sql, song.getSongID(), eventID);

        return count == 1;
    }

    // approve song
    @Override
    public boolean approveSong(int songId, int eventId) {
        String sql = "UPDATE event_song SET status = 'approved' WHERE song_id = ? AND event_id = ?;";
        int count = jdbcTemplate.update(sql, songId, eventId);
        return count == 1;
    }
    // reject song
    @Override
    public boolean rejectSong(int songId, int eventId) {
        String sql = "UPDATE event_song SET status = 'rejected' WHERE song_id = ? AND event_id = ?;";
        int count = jdbcTemplate.update(sql, songId, eventId);
        return count == 1;
    }

    @Override
    public Event getEventByID(int eventID) {
        String sql = "SELECT * FROM events WHERE event_id = ?;";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, eventID);
        if (rowSet.next()) {
            Event event = mapRowToEvent(rowSet);
            return event;
        } else {
            return null;
        }
    }

    @Override
    public boolean isSongInDB(String spotifyURI) {
        String sql = "SELECT * FROM songs WHERE spotify_song_uri = ?";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, spotifyURI);
        return rowSet.next();
    }

    @Override
    public List<Song> getPlaylistByEventID(int eventID) {
        List<Song> songs = new ArrayList<>();
        String sql = "SELECT * FROM songs s JOIN event_song es ON s.song_id = es.song_id WHERE es.event_id = ? AND status = 'approved'";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, eventID);
        while (rowSet.next()) {
            Song song = mapRowToSong(rowSet);
            songs.add(song);
        }
        return songs;
    }

    @Override
    public List<Song> getDjQueueByEventID(int eventID) {
        List<Song> songs = new ArrayList<>();
        String sql = "SELECT * FROM songs s JOIN event_song es ON s.song_id = es.song_id WHERE es.event_id = ? AND status = 'pending'";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, eventID);
        while (rowSet.next()) {
            Song song = mapRowToSong(rowSet);
            songs.add(song);
        }
        return songs;
    }

    @Override
    public String getSongStatus(int eventId, int songId) {
        String sql = "SELECT status FROM event_song WHERE event_id = ? AND song_id = ?;";
        String status = jdbcTemplate.queryForObject(sql,String.class, eventId, songId);

            return status;
    }




    public Event mapRowToEvent(SqlRowSet rowSet) {
        Event output = new Event();
        output.setEventName(rowSet.getString("event_name"));
        output.setEventBegin(rowSet.getString("event_begin")); //come back to
        output.setEventEnd(rowSet.getString("event_end"));
        output.setHostID(rowSet.getInt("host_id"));
        output.setDjID(rowSet.getInt("dj_id"));
        output.setSpotifyPlaylistURI(rowSet.getString("spotify_playlist_URI"));
        return output;
    }

    public Song mapRowToSong(SqlRowSet rowSet) {
        Song output = new Song();
        output.setSongID(rowSet.getInt("song_id"));
        output.setArtist(rowSet.getString("artist"));
        output.setTitle(rowSet.getString("title"));
        output.setSpotifySongURI(rowSet.getString("spotify_song_uri"));
        output.setAlbum(rowSet.getString("album"));
        output.setAlbumArt(rowSet.getString("album_art"));
        output.setGenre(rowSet.getString("genre"));
        return output;
    }

    @Override
    public List<Event> getAllEvents() {
        List<Event> events = new ArrayList<>();
        String sql = "SELECT * FROM events;";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql);
        while (rowSet.next()) {
            Event event = mapRowToEvent(rowSet);
            events.add(event);
        }
        return events;
    }



}
