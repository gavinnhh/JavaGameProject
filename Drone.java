package planeProject;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

// this class may be put in a seperate package
public class Drone extends Position{
	
	private String playerImage = "/images/Picture2.png"; // the images folder can not be in planeProject, but parallel with it under src
	int velocityX = 1;
	int velocityY = 0;
	//private Bullet b;
	
	private Rectangle droneRect;
	
	public Drone(int x, int y) {
		super(x, y); // refer to the super class which is Position, probably like a interface
		// TODO Auto-generated constructor stub
		
	}
	
	public void update() {
		x += velocityX;
		y += velocityY; // we may also make the drone move right left 
		
		//check border line
		if(y < 0)
			y = 0;
		if(y > 432)
			y = 432;
		if(x < 0 )
			x = 0;
		if(x > 600)
			x = 600;
	}
	// all these keys functions wont work without keyListener
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		if(key == KeyEvent.VK_UP)
		{
			velocityY = -1;
			velocityX = 0;
			
		}else if(key == KeyEvent.VK_DOWN) {
			velocityY = 1;
			velocityX = 0;
		}else if(key == KeyEvent.VK_RIGHT) {
			velocityX = 2;
			velocityY = 0;
		}else if(key == KeyEvent.VK_LEFT) {
			velocityX = -1;
			velocityY = 0;
			
		}
	}
	public void keyReleased(KeyEvent e)
	{
		int key = e.getKeyCode();

		if(key == KeyEvent.VK_UP)
		{
			velocityX = 1;
			velocityY = 0;
		}else if(key == KeyEvent.VK_DOWN) {
			velocityX = 1;
			velocityY = 0;
		}else if(key == KeyEvent.VK_RIGHT) {
			velocityX = 1;
			velocityY = 0;
		}else if(key == KeyEvent.VK_LEFT) {
			velocityX = 1;
			velocityY = 0;
		}
	}
	
	
	public void draw(Graphics2D g2d) {
		g2d.drawImage(getPlayerImage(), x, y, null);
		droneRect = new Rectangle(x, y, 50, 25);

		//g2d.draw(droneRect);
	}

	public Rectangle getDroneRect(){
		return droneRect;
	}


	
	public Image getPlayerImage()
	{
		ImageIcon i = new ImageIcon(getClass().getResource(playerImage));
		return i.getImage();
		
	}
	
	public int getX() {	return this.x;}
	public int getY() {	return this.y;}
	
}
