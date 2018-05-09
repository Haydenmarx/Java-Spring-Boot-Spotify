create table SONGS (
  ID serial,
  SONG_TITLE varchar(100) NOT NULL,
  SONG_ARTIST varchar(100) NOT NULL,
  SONG_LENGTH decimal(3, 2) NOT NULL
);