import com.github.axet.vget.VGet;
import java.io.File;
import java.net.URL;

public class SDownloader {
    public static void main(String[] args) throws Exception {
        // Define la URL del archivo de audio de SoundCloud
        URL url = new URL("https://soundcloud.com/user/song");

        // Crea un objeto VGet y establece el formato de salida en WAV
        VGet v = new VGet(url, new File("song.wav"));
        v.setFormat("[ext=wav]");

        // Inicia la descarga del archivo de audio
        v.download();
    }
}
