import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;
import javax.swing.JFrame;
import javax.sound.sampled.FloatControl;

public class Sound {
	private FloatControl volumeControl = null;
	private boolean released = false;
	private boolean playing = false;
	private Clip clip;

    Sound() {
    	released();
		play();
    }

    public void released() {
   		File file = new File("sounds/Cloud.wav");
	try {
		clip = AudioSystem.getClip();
		clip.open(AudioSystem.getAudioInputStream(file));
		volumeControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
		released = true;
        } catch (Exception exc) {
		System.out.println("Error: " + exc);
		released = false;
        }
    }

    public void play(boolean breakOld) {
		if (released) {
			if (breakOld) {
				//clip.stop();
				clip.start();
				clip.loop(Clip.LOOP_CONTINUOUSLY);
				playing = true;
			} else if (playing = false) {
				clip.start();
				clip.loop(Clip.LOOP_CONTINUOUSLY);
				playing = true;
			}
		}
	}
	public void play() {
		play(true);
	}

	public void stop() {
		if (playing) {
			clip.stop();
		}
	}
	public void setVolume(float x) {
		if (x<0) x = 0;
		if (x>1) x = 1;
		float min = volumeControl.getMinimum();
		float max = volumeControl.getMaximum();
		volumeControl.setValue((max-min)*x+min);
	}
}