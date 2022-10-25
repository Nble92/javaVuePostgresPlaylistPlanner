package com.techelevator.controller;

import com.techelevator.dao.EventDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Event;
import com.techelevator.model.EventSongDTO;
import com.techelevator.model.Song;
import com.techelevator.model.User;

import com.techelevator.services.EventService;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@CrossOrigin
@RestController
public class EventController {


    private EventDao eventDAO;
    private EventService eventService;
    private UserDao userDAO;


    public EventController(EventDao eventDAO, EventService eventService, UserDao userDAO) {
        this.eventDAO = eventDAO;
        this.eventService = eventService;
        this.userDAO = userDAO;
    }

    @GetMapping("/events")
    public List<Event> getEvents() {
        return eventDAO.getAllEvents();
    }

    // make new event
    // requires authentication - can only be done by hosts
    // TODONE: logged in userID must be added to hostID
    @PostMapping("/events")
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("isAuthenticated()")
    public Event postEvent(@RequestBody Event event, Principal principal) {
        String thisUser = principal.getName();
        int thisID = userDAO.findIdByUsername(thisUser);
        event.setHostID(thisID);
        return eventDAO.createEvent(event);
    }

    // send song suggestion
    @PostMapping("/events/queue")
    @ResponseStatus(HttpStatus.CREATED)
    public Song addSong(@RequestBody Song song) {
        return eventDAO.addSongToDatabase(song);
    }
    //insert into song_event with status pending
    //used by suggest song form on guest event view -- allows guests to add songs to suggestion queue

    @PostMapping("/events/{id}/queue")
    @ResponseStatus(HttpStatus.CREATED)
    public void submitSongSuggestion(@PathVariable Integer id, @RequestBody Song song) {
        Song currentSong = eventDAO.addSongToDatabase(song);
        eventDAO.suggestSong(id,currentSong);
    }

    //insert into song_event with status approved
    //used by add song to playlist form in dj event view -- allows dj to add a song directly to the playlist
    @PostMapping("/events/{id}/playlist")
    @ResponseStatus(HttpStatus.CREATED)
    public void directlyAddSongToPlaylist(@PathVariable Integer id, @RequestBody Song song) {
        Song currentSong = eventDAO.addSongToDatabase(song);
        eventDAO.addSongDirectlyToPlaylist(id,currentSong);
    }



    //approve song and get back status
    @PutMapping("/events/{eventId}/songs/{songId}/approve")
    public String approveSong(@PathVariable Integer eventId, @PathVariable Integer songId) {
        eventDAO.approveSong(songId,eventId);
        return eventDAO.getSongStatus(songId,eventId);
    }

    //approve song and get back status
    @PutMapping("/events/{eventId}/songs/{songId}/reject")
    public String rejectSong(@PathVariable Integer eventId, @PathVariable Integer songId) {
        eventDAO.rejectSong(songId,eventId);
        return eventDAO.getSongStatus(songId,eventId);

    }

    // get event info
    // unsure about response status so did not include

    @GetMapping("/events/{id}")
    public Event getEvent(@PathVariable int id) {
        return eventDAO.getEventByID(id);
    }

    // join an event

    @PostMapping("/events/{id}/users")
    public boolean addUserToEvent(@RequestBody User user, Event event) {
        return eventDAO.addUserToEvent(user.getId(), event.getEventID());
    }

    // approve a song
    // used when a song is selected by a dj and played
//    @PostMapping("/events/{id}/playlist")
//    public boolean playSong(@RequestBody Song selectedSong, Event event) {
//        return eventService.playSong(selectedSong,event);
//    }

    // get playlist for an event
    @GetMapping("/events/{id}/playlist")
    public List<Song> getPlaylistByEventID(@PathVariable int id) {
        return eventDAO.getPlaylistByEventID(id);
    }

    @GetMapping("/events/{id}/suggested")
    public List<Song> getSuggestedSongsByEventID(@PathVariable int id) {
        return eventDAO.getDjQueueByEventID(id);
    }

}









