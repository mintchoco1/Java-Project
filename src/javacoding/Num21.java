package javacoding;

class Song{
    String title;
    String artist;
    int year;
    String country;

    public Song(){

    }
    public Song(String title, String artist, int year, String country){
        this.title = title;
        this.artist = artist;
        this.year = year;
        this.country = country;
    }
    public void show(){
        System.out.println(title + " by " + artist + " from " + country + " , " + year);
    }
}

public class Num21 {
    public static void main(String[] args) {
        String title = "Dynamite";
        String artist = "BTS";
        int year = 2021;
        String country = "Korea";

        Song song = new Song(title, artist, year, country);
        song.show();
    }
}
