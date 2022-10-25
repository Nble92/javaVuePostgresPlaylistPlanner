package com.techelevator.model;

public class Song {
    private int songID;
    private String title;
    private String artist;
    private String spotifySongURI;
    private String album;
    private String albumArt;
    private String genre;

    public Song() {
    }

    public int getSongID() {
        return songID;
    }

    public void setSongID(int songID) {
        this.songID = songID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getSpotifySongURI() {
        return spotifySongURI;
    }

    public void setSpotifySongURI(String spotifySongURI) {
        this.spotifySongURI = spotifySongURI;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getAlbumArt() {
        return albumArt;
    }

    public void setAlbumArt(String albumArt) {
        this.albumArt = albumArt;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
