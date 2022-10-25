package com.techelevator.services;

import com.techelevator.dao.EventDao;
import com.techelevator.model.Event;
import com.techelevator.model.Song;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Service
public class EventService {


//    private EventDao eventDAO;
//
//    public EventService (EventDao eventDAO) {
//        this.eventDAO = eventDAO;
//    }
//
//    public boolean playSong (Song song, Event event) {
//        if (eventDAO.isSongInDB(song.getSpotifySongURI())) {
//            eventDAO.addSongToDatabase(song);
//            eventDAO.addSongToPlaylist(song.getSongID(), event.getEventID());
//            return true;
//        } else {
//            eventDAO.addSongToPlaylist(song.getSongID(), event.getEventID());
//            return true;
//        }
//    }





}
