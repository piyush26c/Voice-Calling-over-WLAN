
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.zip.GZIPOutputStream;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.TargetDataLine;

/**
 * reads data from microphone and sends it to the server
 *
 * @author Piyush Chaudhari, Mayuresh Dindorkar, Rohit Bangar, Rohit Rajbhoj.
 */
public class MicThread extends Thread {

    public static double amplification = 1.0;
    private ObjectOutputStream toServer;
    private TargetDataLine mic;

    public MicThread(ObjectOutputStream toServer) throws LineUnavailableException {
        this.toServer = toServer;
        //open microphone line, an exception is thrown in case of error
        AudioFormat af = SoundPacket.defaultFormat;       //specifies a particular arrangement of data in a sound stream
        DataLine.Info info = new DataLine.Info(TargetDataLine.class, null);      //additional information specific to data lines
        mic = (TargetDataLine) (AudioSystem.getLine(info));     //A target data line is a type of DataLine from which audio data can be read.
        mic.open(af);
        mic.start();
    }

    @Override
    public void run() {
        for (;;) {
            if (mic.available() >= SoundPacket.defaultDataLenght) { //we got enough data to send
                byte[] buff = new byte[SoundPacket.defaultDataLenght];  //benchmark to input the bytes from buffer

                //Obtains the number of bytes of data currently available to the application for processing in the data line's internal buffer
                while (mic.available() >= SoundPacket.defaultDataLenght) { //flush old data from mic to reduce lag, and read most recent data
                    mic.read(buff, 0, buff.length); //read from microphone
                }
                try {
                    /*
                    this part is used to decide whether to send or not the packet. if volume is too low,
                    an empty packet will be sent and the remote client will play some comfort noise                    
                     */
                    long tot = 0;
                    for (int i = 0; i < buff.length; i++) {
                        buff[i] *= amplification;
                        tot += Math.abs(buff[i]);
                    }
                    tot *= 2.5;
                    tot /= buff.length;
                    //create and send packet
                    Message m = null;
                    if (tot == 0) {//send empty packet
                        m = new Message(-1, -1, new SoundPacket(null));
                    } else {                         
                        //send data, compress the sound packet with GZIP
                        ByteArrayOutputStream baos = new ByteArrayOutputStream();
                        /*
                        Creates a new output stream with a default buffer size.
                        invokes the 2-argument constructor GZIPOutputStream(out, false).
                        */
                        GZIPOutputStream go = new GZIPOutputStream(baos);
                        go.write(buff);
                        go.flush();
                        go.close();
                        baos.flush();
                        baos.close();
                        //create message for server, will generate chId and timestamp from this computer's IP and this socket's port 
                        m = new Message(-1, -1, new SoundPacket(baos.toByteArray()));  
                    }
                    toServer.writeObject(m); //writes the specified object to the ObjectOutputStream.
                } catch (IOException ex) { //connection error
                    stop();
                }
            } else {
                Utils.sleep(10); //sleep to avoid busy wait
            }
        }
    }
}
