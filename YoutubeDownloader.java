import com.github.axet.vget.VGet;
import java.io.File;
import java.net.URL;

public class YTDownloader {
    public static void main(String[] args) throws Exception {
        // Define la URL del vídeo de YouTube
        URL url = new URL("https://www.youtube.com/watch?v=dQw4w9WgXcQ");

        // Crea un objeto VGet
        VGet v = new VGet(url, new File("video.mp4"));

        // Inicia la descarga del vídeo
        v.download();
    }
}
