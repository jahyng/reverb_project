import javax.sound.sampled.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class ReverbApp {
    public static void main(String[] args) {
        String inputFile = "input.wav";
        String outputFile = "output_reverb.wav";


        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(inputFile));
            AudioFormat format = audioInputStream.getFormat();

            byte[] audioData = new byte[(int) (audioInputStream.getFrameLength() * format.getFrameSize())];

            audioInputStream.read(audioData);
            FileOutputStream clonedAudioInputStream = new FileOutputStream(outputFile);
            
    //         // Create a reverb effect with a delay line
    //         int delayMillis = 500; // Adjust the delay time as needed
    //         int delayBytes = (int) (format.getSampleRate() * format.getFrameSize() * delayMillis / 1000);
    //         byte[] buffer = new byte[delayBytes];
    //         int bytesRead;

    //         SourceDataLine sourceLine = AudioSystem.getSourceDataLine(format);
    //         sourceLine.open(format);
    //         sourceLine.start();

    //         while ((bytesRead = audioInputStream.read(buffer, 0, buffer.length)) != -1) {
    //             // Apply reverb effect by adding delayed audio data
    //             sourceLine.write(buffer, 0, bytesRead);
    //             sourceLine.write(buffer, 0, bytesRead);
    //         }

    //         sourceLine.drain();
    //         sourceLine.close();
            audioInputStream.close();

            System.out.println("Reverb applied successfully. Output saved to " + outputFile);
        } //catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            //e.printStackTrace();
        //}
        catch (UnsupportedAudioFileException | IOException e) {
            e.printStackTrace();
        }
    }
    

}
