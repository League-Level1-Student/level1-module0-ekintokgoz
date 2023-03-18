package _04_gui_from_scratch._3_sound_effects_machine;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class SoundEffectsMachine implements ActionListener {
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton butt1 = new JButton("Sawing wood");
	JButton  butt2 = new JButton("seashells");
	public void run() {
		frame.setVisible(true);
		panel.add(butt1);
		panel.add(butt2);
		frame.add(panel);
		frame.pack();
		butt1.addActionListener(this);
		butt2.addActionListener(this);
	}
	
	private void playSound(String soundFile) {
		String path = "src/_04_gui_from_scratch/_3_sound_effects_machine/";
			File sound = new File(path+soundFile);
			if (sound.exists()) {
				new Thread(() -> {
				try {
					Clip clip = AudioSystem.getClip();
					clip.open(AudioSystem.getAudioInputStream(sound));
					clip.start();
					Thread.sleep(clip.getMicrosecondLength()/1000);
				}
				catch (Exception e) {
					System.out.println("Could not play this sound");
				}}).start();
	 		}
			else {
				System.out.println("File does not exist");
			}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==butt1) {
			playSound("sawing-wood-daniel_simon.wav");
		}if(e.getSource()==butt2) {
			playSound("seashells.wav");
		}
	}
}
