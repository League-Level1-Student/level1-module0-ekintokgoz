package _01_methods._5_FlappyBird;

import processing.core.PApplet;

public class FlappyBird extends PApplet {
    static final int WIDTH = 800;
    static final int HEIGHT = 600;
    int x = 100;
    int y;
    int pipeX = WIDTH;
    int pipeY = 0;
    int birdYVelocity = -15;
    int birdGravity = 1;
    int upperPipeHeight = (int) random(100, 400);
    int pipeGap = 200;
    int pipeWidth = 75;
    int lowerPipeTop = upperPipeHeight+pipeGap;
    
    @Override
    public void settings() {
        size(WIDTH, HEIGHT);
    }

    @Override
    public void setup() {
       
    }

    @Override
    public void draw() {
    	if(intersectsPipes()) {
    		background(255,255,255);
    		textSize(30);
    		text("YOU LOST", 350, 300);
    	} else {
    background(255, 255, 255);
    fill(255, 0, 0);
    stroke(255, 0, 0);
    ellipse(x, y, 50, 50);
    fill(0, 255, 0);
    rect(pipeX, pipeY, pipeWidth, upperPipeHeight);
    rect(pipeX, lowerPipeTop, pipeWidth, HEIGHT-upperPipeHeight-pipeGap);
    pipeX -= 3;
    if(pipeX <= -75) {
    	teleportPipes();
    }
    y += birdYVelocity;
    birdYVelocity += birdGravity;
    	}
    }
    
    public void teleportPipes() {
    	pipeX = WIDTH;
    	upperPipeHeight = (int) random(100, 400);
    	lowerPipeTop = upperPipeHeight+pipeGap;
    }
    
    public void mousePressed() {
    	birdYVelocity = -15;
    }
    
    boolean intersectsPipes() { 
        if (y < upperPipeHeight && x > pipeX && x < (pipeX+pipeWidth)){
           return true; }
       else if (y>lowerPipeTop && x > pipeX && x < (pipeX+pipeWidth)) {
           return true; }
       else { return false; }
}

    static public void main(String[] args) {
        PApplet.main(FlappyBird.class.getName());
    }
}
