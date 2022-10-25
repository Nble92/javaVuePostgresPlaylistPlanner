import axios from 'axios';
import qs from 'qs'

export default {



  token: "",
  refreshtoken: "",

  async authorize() {
    const data = {
      response_type: 'code',
      client_id: "YOUR CLIENT ID",
      redirect_uri: 'http://localhost:8080/callback',
      scope: [
        'user-read-playback-state',
        'user-modify-playback-state',
        'user-read-currently-playing',
        'streaming',
        'app-remote-control',
        'playlist-read-collaborative',
        'playlist-modify-public',
        'playlist-read-private',
        'playlist-modify-private',
        'user-library-modify',
        'user-library-read',
        'user-top-read',
        'user-read-playback-position',
        'user-read-recently-played',

      ].join(",")
    },
      headers = {

        Accept: 'application/json',
        Content_Type: 'application/x-www-form-urlencoded',
      }
    try {
      const response = await axios.get('https://accounts.spotify.com/authorize?client_id=6a349475303f406d83af30cd90999cb7&redirect_uri=http://localhost:8080/&response_type=code&scope=user-modify-playback-state+user-read-currently-playing',
        data,
        headers
      )
       console.log(response)
// console.log(window.location(this.redirectURI))
// console.log(URL(response))
    }
    catch (error) {
      console.log(error);
    }
  },
  async getAuth() {
    const clientId = this.client_id
    const clientSecret = this.clientSecret;
    const redirectURI = 'http://localhost:8080/'
    alert("I'm in get auth")

    const headers = {
      headers: {
        Accept: 'application/json',
        'Content-Type': 'application/x-www-form-urlencoded',
      },
      auth: {
        username: clientId,
        password: clientSecret,
      },
    };
    const data = {
      grant_type: 'authorization_code',
      redirect_uri: redirectURI,
      code: "",

    };
    try {
      const response = await axios.post(
        'https://accounts.spotify.com/api/token',
        qs.stringify(data),
        headers
      );
      console.log(response.data.access_token);
      this.token = response.data.access_token
      this.refreshtoken = response.data.refresh_token
      return response.data.access_token;

    } catch (error) {
      console.log(error);
    }

  },


  // DA HTTP REQUESTS!!!!!!!

  async getSong() {

    try {
      const response = await axios.get('https://api.spotify.com/v1/tracks/2ncLdwTd8qzkxiJjlbiOgC', {
        headers: {

          Authorization: "Bearer " + this.token,
        }

      })

      console.log(response);

    }
    catch (error) {
      console.log(error);
    }

  },
  playSong(uri) {
    alert('PLAYING')
    try {
      let body = {
        device_id: this.device_id,
        uris: [uri]
        }
      axios.defaults.headers.common['Authorization'] = `Bearer ${this.token}`
      const response = axios.put('https://api.spotify.com/v1/me/player/play', body)


      console.log(response);

    }
    catch (error) {
      console.log(error);
    }
  },

  queueSong(uri) {
    alert('PLAYING')
    try {
      let body = {
        uri: uri
        }
      axios.defaults.headers.common['Authorization'] = `Bearer ${this.token}`
      const response = axios.post('https://api.spotify.com/v1/me/player/queue?uri='+ uri, body)


      console.log(response);
      alert("Added")

    }
    catch (error) {
      console.log(error);
    }
  },

   async nextSong(){
      try {
        let body = {
          device_id: this.device_id,
          }
         axios.defaults.headers.common['Authorization'] = `Bearer ${this.token}`
        const response = await axios.post('https://api.spotify.com/v1/me/player/next', body)
  
  
        console.log(response);
        this.currentSong()
      }
      catch (error) {
        console.log(error);
      }
  },
  async currentSong(){
    try {
      let body = {
        device_id: this.device_id,
        }
      axios.defaults.headers.common['Authorization'] = `Bearer ${this.token}`
      const response = await axios.get('https://api.spotify.com/v1/me/player/currently-playing', body)


      alert(response.data.item.name +
        ' by ' + response.data.item.artists[0].name
        );
      // alert(
      //   response.data.item.artists[0].name,
      //   response.data.item.name

      //   )
console.log(response)
    }
    catch (error) {
      console.log(error);
    }
},
  async searchSong(search) {

    try {
      const response = await axios.get(`https://api.spotify.com/v1/search?q=${search}&type=track,artist`, {
        headers: {

          Authorization: "Bearer " + this.token
        }

      })
      // for(let i = 0; i < 10; i++){
        return(response)
          // response.data.tracks.items[i].album.artists[0].name,
          // response.data.tracks.items[i].name,
          // response.data.tracks.items[i].uri,
          // response.data.tracks.items[i].album.name
          // )
        }
    // }
    catch (error) {
      console.log(error);
    }

  },


}