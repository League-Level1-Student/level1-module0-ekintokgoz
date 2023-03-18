package _04_gui_from_scratch._4_cuteness_tv;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URI;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Cuteness implements ActionListener {
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton butt1 = new JButton("ducks");
	JButton butt2 = new JButton("frogs");
	JButton butt3 = new JButton("unicorns");
	public void run() {
		frame.setVisible(true);
		panel.add(butt1);
		panel.add(butt2);
		panel.add(butt3);
		frame.add(panel);
		frame.pack();
		butt1.addActionListener(this);
		butt2.addActionListener(this);
		butt3.addActionListener(this);
	}
	
	void showDucks() {
	     playVideo("https://www.youtube.com/watch?v=MtN1YnoL46Q");
	}

	void showFrog() {
	     playVideo("https://www.youtube.com/watch?v=cBkWhkAZ9ds");
	}

	void showFluffyUnicorns() {
	     playVideo("https://www.youtube.com/watch?v=a-xWhG4UU_Y");
	}

	void playVideo(String videoID) {
	     
	     // Workaround for Linux because "Desktop.getDesktop().browse()" doesn't
	     //work on some Linux implementations
	     try {
	     if (System.getProperty("os.name").toLowerCase().contains("linux")) {
	     if (Runtime.getRuntime().exec(new String[] {
	      "which", "xdg- open" }).getInputStream().read() != -1) {
	     Runtime.getRuntime().exec(new String[] { "xdg-open", videoID });
	     }
	     } else {
	          URI uri = new URI(videoID);
	          java.awt.Desktop.getDesktop().browse(uri);
	     }      } catch (Exception e) {
	          e.printStackTrace();
	     }
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==butt1) {
			showDucks();
		}if(e.getSource()==butt2) {
			showFrog();
		}if(e.getSource()==butt3) {
			showFluffyUnicorns();
		}
	}
}
