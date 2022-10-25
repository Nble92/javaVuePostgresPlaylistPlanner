import axios from 'axios';

//this is talking to the java backend on localhost 9000



export default {


  addEvent(newEvent) {
    return axios.post('/events', newEvent)
  },

  getEvent(eventID) {
    return axios.get(`/events/${eventID}`, eventID)
  },

  addSong(newSong) {
    return axios.post(`/events/queue`, newSong)
  },

  //V1: need an event page that links to a specific event object
  suggestSong(newSong, eventID) {
    console.log("!!!" + newSong);
    return axios.post(`/events/${eventID}/queue`, newSong)
  },

  addSongDirectlyToPlaylist(newSong, eventID) {
    return axios.post(`/events/${eventID}/playlist`, newSong)
  },

  approveSong(eventId, songId) {
    return axios.put(`/events/${eventId}/songs/${songId}/approve`)
  },

  rejectSong(eventId, songId) {
    return axios.put(`/events/${eventId}/songs/${songId}/reject`)
  },

  getEventPlaylist(eventId) {
    return axios.get(`/events/${eventId}/playlist`)
  },

  getSuggestedQueue(eventId){
    return axios.get(`/events/${eventId}/suggested`)
  }





}