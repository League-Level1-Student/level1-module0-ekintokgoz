package _01_methods._1_houses;

import java.awt.Color;

import org.jointheleague.graphical.robot.Robot;

/*
 *    Copyright (c) The League of Amazing Programmers 2013-2021
 *    Level 1
 */
public class Houses {
	Robot bob = new Robot();
	public void run() {
		// Check the recipe to find out what code to put here

		bob.moveTo(40,500);
		bob.penDown();
		bob.setSpeed(50);
		house("small", Color.ORANGE);
		house("large", Color.CYAN);
		house("medium", Color.BLUE);
		house("small", Color.MAGENTA);
		house("medium", Color.YELLOW);
		house("large", Color.BLUE);
		house("large", Color.RED);
		house("small", Color.ORANGE);
		house("medium", Color.PINK);

	}

	void house(String height, Color color){
		int size = 0;
		bob.setPenColor(color);
		if(height.equalsIgnoreCase("small")) {
			size = 60;
		}else if(height.equalsIgnoreCase("medium")) {
			size = 120;
		}else if(height.equalsIgnoreCase("large")) {
			size = 250;
		}
		bob.move(size);
		if(height.equalsIgnoreCase("large")) {
			flatRoof();
		}else {
			pointedRoof();
		}
		bob.move(size);
		bob.turn(-90);
		bob.setPenColor(0,255,0);
		bob.move(30);
		bob.turn(-90);
		bob.setPenColor(0,0,0);
	}
	void flatRoof() {
		bob.turn(90);
		bob.move(25);
		bob.turn(90);
	}
	void pointedRoof() {
		bob.turn(50);
		bob.move(20);
		bob.turn(75);
		bob.move(20);
		bob.setAngle(180);
	}
}
