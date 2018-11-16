package planeProject;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter{

	Drone d;
	//BulletControl b;
	public KeyInput(Drone d) {
		this.d = d;
		//this.b = b;
	}
	public void keyPressed(KeyEvent e) {
		d.keyPressed(e); // this will call the function keyPressed in class Player
		//b.keyPressed(e);
	}
	public void keyReleased(KeyEvent e)
	{
		d.keyReleased(e);// this will call the function keyPressed in class Player
		//b.keyReleased(e);
	}
	
}
