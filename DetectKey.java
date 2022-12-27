import org.jfugue.pattern.Pattern;
import org.jfugue.player.Player;
import org.jfugue.theory.Chord;
import org.jfugue.theory.ChordProgression;

public class KeyDetector {
    public static void main(String[] args) {
        // Load the song into a JFugue Pattern object
        Pattern song = new Pattern("C D E F G A B");

        // Use the JMusic KeyFinder class to detect the key of the song
        KeyFinder keyFinder = new KeyFinder();
        keyFinder.setKeyWeightings(KeyFinder.WEIGHTED_BY_DURATION);
        song.add(keyFinder);
        String key = keyFinder.getKey();

        // Print the detected key
        System.out.println("Detected key: " + key);
    }
}
