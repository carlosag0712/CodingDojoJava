package codingDojo.Map_of_the_Hashmatique;

public class Ipod {
    public static void main(String[] args) {
        TrackList Hashmatique = new TrackList();

        Hashmatique.addTrack("Tornado of Souls", "Now I'm safe in the eye of the tornado");
        Hashmatique.addTrack("Abolish government", "forget about XXX he's not innocent");
        Hashmatique.addTrack("Dig up her bones", "Anything is what she is");
        Hashmatique.addTrack("I'll stick around", "I thought I knew all it took to bother you");

        Hashmatique.searchTrack("I'll stick around");
        Hashmatique.getList();

    }
}
