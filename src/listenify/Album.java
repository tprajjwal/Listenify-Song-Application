package listenify;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Album {
    private String name;
    private String artist;
    private List<Song> songs; //here memory is not allocated,that why you allocate memory in constructor;
     //Whenever you are creating data structures ,always allocate memory in constructor
     //Initialize the songList
    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs=new ArrayList<>(); //Memory is allocated for song reference variable;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> song) {
        this.songs = song;
    }

    //Find Song
    public boolean findSong(String title){
        for(Song song:songs)
        {
            if(song.getTitle().equals(title))
                return true;

        }
        return false;

    }
    //add song to album
    //Check if the song is already present we will not add
    //otherwise we will create a new Song and add it to the songList
    public String addSongToAlbum(String title,double duration){
        if(findSong(title)==true)
        {
            return "Song is already present";
        }
        else{
            //I need to create a Song Object and then add it to songList because list is of song object
            Song s = new Song(title,duration);
            songs.add(s);
            return "New song is added successfully";
        }
    }
    public String addSongToPlaylistFromAlbum(String title, List<Song> playList){
        if(findSong(title)==true)
        {
            for(Song song:songs){
                if(song.getTitle().equals(title)) playList.add(song);
                return "Song has been added to playlist";
            }
        }
        return "Song not present in album";
    }
    public String addSongToPlaylistFromAlbum(int trackNo ,List<Song> playList){
        int idx = trackNo-1; // if song no. is 3 then in arraylist it is store at 2 index;
        if(idx>=0 && idx<this.songs.size())
        {
             playList.add(this.songs.get(idx));
             return "Song has been added to playlist";
        }
        return "Invalid Track number";
    }
}
