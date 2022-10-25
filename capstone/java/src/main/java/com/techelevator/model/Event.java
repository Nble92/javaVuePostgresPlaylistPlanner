package com.techelevator.model;

import java.util.List;

public class Event {
    private int eventID;
    private String eventName;
    private int hostID;
    private int djID;
    private List <Song> playlist;
    private String spotifyPlaylistURI;
    private String eventBegin;
    private String eventEnd;

    public Event () {

    }

    public int getEventID() {
        return eventID;
    }

    public void setEventID(int eventID) {
        this.eventID = eventID;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public int getHostID() {
        return hostID;
    }

    public void setHostID(int hostID) {
        this.hostID = hostID;
    }

    public int getDjID() {
        return djID;
    }

    public void setDjID(int djID) {
        this.djID = djID;
    }

    public List <Song> getPlaylist(){
        return playlist;
    }

    public void setPlaylist(List <Song> playlist) {
        this.playlist = playlist;
    }

    public String getSpotifyPlaylistURI() {
        return spotifyPlaylistURI;
    }

    public void setSpotifyPlaylistURI(String spotifyPlaylistURI) {
        this.spotifyPlaylistURI = spotifyPlaylistURI;
    }

    public void setEventBegin(String eventBegin) {
        this.eventBegin = eventBegin;
    }

    public void setEventEnd(String eventEnd) {
        this.eventEnd = eventEnd;
    }

    public String getEventBegin() {
        return eventBegin;
    }

    public String getEventEnd() {
        return eventEnd;
    }
}
