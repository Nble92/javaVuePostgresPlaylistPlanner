package com.techelevator.services;

import org.springframework.web.client.RestTemplate;

public class RestSpotifyService {

//    private static final String API_URL = "https://cat-data.netlify.app/api/pictures/random";
//    private RestTemplate restTemplate = new RestTemplate();
//
//    public CatPic getPic() throws RestClientResponseException {
//        CatPic catPic = restTemplate.getForObject(API_URL, CatPic.class);
//        return catPic;
//    }

    private static final String API_URL = "https://api.spotify.com/v1/";
    private RestTemplate restTemplate = new RestTemplate();

//    //@RequestMapping(value=)
//    public List<Song> searchSong() {
//        List<Song> songs = new ArrayList<>();
//        Song song = restTemplate.getForObject(API_URL, Song.class);
//        return songs;
//    }



}
