package _04_gui_from_scratch._1_fortune_cookie;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class FortuneCookie implements ActionListener {
	public void showButton() {
		System.out.println("Button clicked");
		JFrame frame = new JFrame();
		frame.setVisible(true);
		JButton button = new JButton();
		frame.add(button);
		frame.pack();
		button.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//JOptionPane.showMessageDialog(null, "Woohoo!");
		int ran = new Random().nextInt(5);
		if(ran == 0) {
			JOptionPane.showMessageDialog(null, "you will become rich");
		}if(ran == 1) {
			JOptionPane.showMessageDialog(null, "you will be poor for the rest of your life");
		}if(ran == 2) {
			JOptionPane.showMessageDialog(null, "you will get hired into your dream job");
		}if(ran == 3) {
			JOptionPane.showMessageDialog(null, "you will meet your favorite celebrity/athlete");
		}if(ran == 4) {
			JOptionPane.showMessageDialog(null, "you will become a dumster guy");
		}
	}
}
