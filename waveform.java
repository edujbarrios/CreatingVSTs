import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class AudioWaveform {
    public static void main(String[] args) throws UnsupportedAudioFileException, IOException {
        // Lee el archivo de audio
        File audioFile = new File("audio.wav");
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
        AudioFormat format = audioStream.getFormat();
        int numChannels = format.getChannels();
        int frameSize = format.getFrameSize();
        float frameRate = format.getFrameRate();
        int numFrames = (int) audioStream.getFrameLength();
        byte[] audioData = new byte[numFrames * frameSize];
        audioStream.read(audioData);

        // Selecciona un canal para mostrar la onda
        int[] channelData = new int[numFrames];
        for (int i = 0; i < numFrames; i++) {
            channelData[i] = audioData[i * frameSize];
        }

        // Dibuja la onda del archivo de audio
        JFrame frame = new JFrame("Onda del archivo de audio");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(Color.BLACK);
                int width = getWidth();
                int height = getHeight();
                int xScale = width / numFrames;
                int yScale = height / 256;
                for (int i = 1; i < numFrames; i++) {
                    g.drawLine(xScale * (i - 1), height - channelData[i - 1] * yScale, xScale * i, height - channelData[i] * yScale);
                }
            }
        };
        frame.add(panel);
        frame.setVisible(true);
    }
}
