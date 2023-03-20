package listenify;

import java.sql.SQLOutput;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {
    public static void play(List<Song> playList) {
        ListIterator<Song> itr = playList.listIterator();

        if (playList.size() == 0) {
            System.out.println("Playlist is empty");
            return;
        }
        System.out.println("Currently playing" + " " + itr.next());

        Scanner sc = new Scanner(System.in);
        boolean isNext=true;

        printMenu();


        while (true) {
            System.out.println("Enter your choice");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    if(!isNext) {
                        System.out.println(itr.next());
                    }
                    if(itr.hasNext()) {
                        System.out.println("Now playing"+" "+itr.next());
                        isNext=true;
                    }
                    else System.out.println("You have reached to the end of playlist");
                     break;

                case 2:
                    if(isNext) {
                        System.out.println(itr.previous());
                    }
                    if(itr.hasPrevious()) {
                        System.out.println("Now playing" + " " + itr.previous());
                        isNext=false;
                    }
                    else System.out.println("You are on first song");
                    break;
                case 3:
                    if(isNext){
                        if(itr.hasPrevious()) {
                            System.out.println(itr.previous());
                            isNext = false;
                        }
                    }
                    else{
                        if(itr.hasNext()){
                            System.out.println(itr.next());
                            isNext = true;
                        }
                    }
                    break;
                case 4:
                    if (playList.size() > 0)
                    {
                        System.out.println(itr.previous().toString() + " has been removed from the playlist.");
                        itr.remove();
                        if (playList.size()>0 && itr.hasPrevious())
                        {
                            System.out.println("Now playing " + itr.next().toString());
                        }
                        else if (playList.size()>0 && itr.hasNext())
                        {
                            System.out.println("Now playing " + itr.previous().toString());
                        }
                    } else
                    {
                        System.out.println("The playlist is already empty.");
                    }
                    break;
                case 5:printAllSong(playList);
                    break;
                case 6:printMenu();
                    break;
                case 7://Exit
                    return;
            }
        }
    }
    public static void printMenu() {
        System.out.println("1. Play next song");
        System.out.println("2. Play previous song");
        System.out.println("3.Play current song");
        System.out.println("4. Delete current song");
        System.out.println("5. Show all song");
        System.out.println("6. Show menu again");
    }
    public static void printAllSong(List<Song> playList) {
        for (Song song : playList)
            System.out.println(song);
    }

    public static void main(String[] args) {
        Album album1 = new Album("Romantic Songs", "Arijit Singh");
        album1.addSongToAlbum("Song1", 5.3);
        album1.addSongToAlbum("Song2", 4.3);
        album1.addSongToAlbum("Song3", 3.3);

        Album album2 = new Album("HeartBreak", "Dino James");
        album2.addSongToAlbum("Song11", 5.35);
        album2.addSongToAlbum("Song22", 4.34);
        album2.addSongToAlbum("Song33", 3.33);

        List<Song> myPlaylist = new LinkedList<>();
        System.out.println(album2.addSongToPlaylistFromAlbum("Song11", myPlaylist));
        System.out.println(album1.addSongToPlaylistFromAlbum(1, myPlaylist));
        System.out.println(album2.addSongToPlaylistFromAlbum("Song22", myPlaylist));
        System.out.println(album1.addSongToPlaylistFromAlbum(2, myPlaylist));
        System.out.println(album2.addSongToPlaylistFromAlbum("Song33", myPlaylist));
        System.out.println(album1.addSongToPlaylistFromAlbum(3, myPlaylist));

        play(myPlaylist);
    }
}








