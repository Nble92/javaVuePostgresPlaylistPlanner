package com.techelevator.model;

public class EventSongDTO {
    private int songID;
    private int eventID;
    private String status;

    public int getSongID() {
        return songID;
    }

    public void setSongID(int songID) {
        this.songID = songID;
    }

    public int getEventID() {
        return eventID;
    }

    public void setEventID(int eventID) {
        this.eventID = eventID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "EventSongDTO{" +
                "songID=" + songID +
                ", eventID=" + eventID +
                ", status='" + status + '\'' +
                '}';
    }


}
