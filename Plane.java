package planeProject;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.Random;

import javax.swing.ImageIcon;

public class Plane extends Position{
	private String planeImage = "/images/Picture1.png"; // pass the image in
	int speed = 2;
	private Rectangle pRect;
	Drone da;
	public boolean hit = false;

	public Plane(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}

	/*public void draw(Graphics2D g2d)
	{
		g2d.drawImage(getPlaneImage(), x, y, null);
	}*/
	
	public void draw(Graphics2D g2d) {
		g2d.drawImage(getPlaneImage(), x, y, null);
		Rectangle rect = new Rectangle(x, y, 100, 50);
		//g2d.draw(rect);
		Rectangle dRect = PlanesControl.d.getDroneRect();
		checkCollision(rect, dRect);
	}

	public Rectangle getPlaneRect(){
		return pRect;
	}

public void checkCollision(Rectangle plane, Rectangle drone){
		
		if(drone.intersects(plane))		
			hit = true;
	}

	
	public void update()
	{
		//x+=speed;
		 Random rand1 = new Random(); 
		    int n2 = 150 * rand1.nextInt(10) + 600;
		  //Random rand2 = new Random();
		  	//int speed = rand2.nextInt(6) + 1;
		x -= speed;
		if(x == -150) // to make plane come out from the right again 
			x = n2;
		
	}
	public Image getPlaneImage()
	{
		ImageIcon i = new ImageIcon(getClass().getResource(planeImage));
		return i.getImage();
	}
	
	
}
