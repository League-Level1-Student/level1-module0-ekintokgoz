package _03_gui_with_help._2_photo_quiz;
/*
 *    Copyright (c) The League of Amazing Programmers 2013-2021
 *    Level 1
 */

import java.awt.Component;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class PhotoQuiz {

	public void run() {

		JFrame quizWindow = new JFrame();
		quizWindow.setVisible(true);
		// This will make sure the program exits when you close the window
		quizWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// 1. find an image on the internet, and put its URL in a String
		// variable (from your browser, right click on the image, and select
		// “Copy Image Address” )
		String photo = "https://m.media-amazon.com/images/M/MV5BODY1MjMzNTk5Nl5BMl5BanBnXkFtZTgwNjUzMjU3MTE@._V1_.jpg";
		// 2. create a variable of type "Component" that will hold your image
		Component image;
		// 3. use the "createImage()" method below to initialize your Component
		image = createImage(photo);
		// 4. add the image to the quiz window
		quizWindow.add(image);
		// 5. call the pack() method on the quiz window
		quizWindow.pack();
		// 6. ask a question that relates to the image
		String q1 = JOptionPane.showInputDialog("What color is the fence in the back?");
		// 7. print "CORRECT" if the user gave the right answer
		if(q1.equalsIgnoreCase("blue")) {
			System.out.println("CORRECT");
		}else {
			System.out.println("INCORRECT");
		}
		// 8. print "INCORRECT" if the answer is wrong
		// 9. remove the component from the quiz window (you may not see the
		// effect of this until step 12)
		quizWindow.remove(image);
		// 10. find another image and create it (might take more than one line
		// of code)
		String photo2 = "https://www.southernliving.com/thmb/M0PCmPR2EhL_T5CeVcnvlOqSkEI=/1500x0/filters:no_upscale():max_bytes(150000):strip_icc()/TCDITTH_EC001-2000-8de71c7169d44fd9a91e68a19ff73f83.jpg";
		// 11. add the second image to the quiz window
		Component image2;
		image2 = createImage(photo2);
		quizWindow.add(image2);
		// 12. pack the quiz window
		quizWindow.pack();
		// 13. ask another question
		String q2 = JOptionPane.showInputDialog("How many pumpkins are in the patch?");
		// 14+ check answer, say if correct or incorrect, etc.
		if(q2.equalsIgnoreCase("10")) {
			System.out.println("CORRECT");
		}else if(q2.equalsIgnoreCase("ten")) {
			System.out.println("CORRECT");
		}else {
			System.out.println("INCORRECT");
		}
	}

	private Component createImage(String imageUrl) {
		JLabel imageLabel = new JLabel();
		URL url;
		try {
			url = new URL(imageUrl);
			Icon icon = new ImageIcon(url);
			imageLabel.setIcon(icon);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "I can't find your image!!");
		}
		
		return imageLabel;
	}

	/* OPTIONAL */
	// *14. add scoring to your quiz
	// *15. make something happen when mouse enters image
	// (imageComponent.addMouseMotionListener())
}
