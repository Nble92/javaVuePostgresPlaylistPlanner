BEGIN TRANSACTION;
DROP TABLE IF EXISTS users CASCADE;
DROP TABLE IF EXISTS events CASCADE;
DROP TABLE IF EXISTS songs CASCADE;
DROP TABLE IF EXISTS user_event;
DROP TABLE IF EXISTS event_song;
CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);
CREATE TABLE events (
	event_id SERIAL,
	event_name VARCHAR(200) NOT NULL,
	host_id INT NOT NULL,
	dj_id INT,
	event_begin VARCHAR(50) NOT NULL,
	event_end VARCHAR(50) NOT NULL,
	spotify_playlist_uri VARCHAR(250),
	CONSTRAINT PK_event PRIMARY KEY (event_id),
	FOREIGN KEY (host_id) REFERENCES users(user_id),
	FOREIGN KEY (dj_id) REFERENCES users(user_id)
);
CREATE TABLE songs (
	song_id SERIAL,
	title VARCHAR(200) NOT NULL,
	artist VARCHAR(200) NOT NULL,
	spotify_song_uri VARCHAR(250),
	genre VARCHAR(100),
	album VARCHAR(200),
	album_art VARCHAR(400),
	CONSTRAINT PK_song PRIMARY KEY (song_id)
);
CREATE TABLE user_event (
	event_id INT NOT NULL,
	user_id INT NOT NULL,
	FOREIGN KEY (event_id) REFERENCES events(event_id),
	FOREIGN KEY (user_id) REFERENCES users(user_id)
);
CREATE TABLE event_song (
	event_id INT NOT NULL,
	song_id INT NOT NULL,
	status VARCHAR(50),
	FOREIGN KEY (event_id) REFERENCES events(event_id),
	FOREIGN KEY (song_id) REFERENCES songs(song_id),
	CONSTRAINT PK_event_song PRIMARY KEY (event_id, song_id)
);
COMMIT TRANSACTION;