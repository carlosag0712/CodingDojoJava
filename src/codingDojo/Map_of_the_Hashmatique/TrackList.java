package codingDojo.Map_of_the_Hashmatique;

import java.util.HashMap;
import java.util.Map;

public class TrackList {
    private String SongName;
    private String Lyrics;
    private HashMap<String,String> trackList;

    public TrackList() {
        this.trackList = new HashMap<>();
    }

    public void addTrack(String SongName, String Lyrics){
        trackList.put(SongName,Lyrics);
    }

    public void searchTrack(String SongName){
        String song = trackList.get(SongName);

        System.out.println("You searched for: "+ song);
    }

    public void getList(){
        for (String key : trackList.keySet()){
            System.out.println(key+" : "+trackList.get(key));
        }
    }





}
