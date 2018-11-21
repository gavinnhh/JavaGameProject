package planeProject;
// to create a plane list = more planes
import java.awt.Graphics2D;
import java.util.LinkedList;
import java.util.Random;

public class PlanesControl {

	LinkedList<Plane>e = new LinkedList<Plane>();
	
	Plane temp; 
	static Drone d;
	public boolean hitted = false;
	public PlanesControl(Drone d)
	{
		
	    this.d = d;
	    Random rand2 = new Random(); 
	    int n2 = rand2.nextInt(15) + 5; // for random number of planes 
	    
	    for(int i = 0; i < n2; i++)  	
	    {	
	    		Random rand = new Random(); 
	    		int n = rand.nextInt(10); // for random y position
	    		Random rand3 = new Random(); 
	    		int n3 = 100 * rand3.nextInt(10) + 700;
	    		n *= 80;
	    		addEnemies(new Plane(n3, n));  
	    }
	    
	}
	public void draw(Graphics2D g2d) {
		for(int i = 0; i < e.size(); i++)
		{
			temp = e.get(i);
			temp.draw(g2d);
		}
	}
	
	public void update()
	{
		for(int i = 0; i < e.size(); i++) // check for collision
		{	
			if(e.get(i).hit)  
			{
				hitted = true;
				e.remove(i);
			//System.out.println("hit???");
			}
			//System.out.println("no hit");
		}
		
		for(int i = 0; i < e.size(); i++)
		{
			temp = e.get(i);
			temp.update(); // to make sure each enemy will be moving 
		}
	}
	
	public void addEnemies(Plane enemy)
	{
		e.add(enemy);
		
	}
	
}
