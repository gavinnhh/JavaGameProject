package planeProject;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Game extends JPanel implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String backGround = "/images/skyline.png";

	Timer runGame; 
	Drone d;
	Plane plane; 
	PlanesControl p;
	//BulletControl b;
	
	int hi=5;
	int score = 0;
	int round = 1;
	
	public Game() {
		
		
		Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hi -= 1;
                if (hi ==-1) {
                    
                    //((Timer)e.getSource()).stop();
                    round++;
                    score+=100;
                    hi = 5;
                    
                }
            }
        });
        timer.start();
		
		setFocusable(true);
		System.out.println("Plane Game");
		runGame = new Timer(8, this); // like a delay, if not 10, but 2, it will be way faster
		// time starts
		runGame.start();
		d = new Drone(50, 50); // initial position of the drone
		//e = new Enemies(640, 300); //
		
		p = new PlanesControl(d);
		//b = new BulletControl();
		addKeyListener(new KeyInput(d)); // once this runs, it will go into KeyInput and call the keyPressed and keyReleased functions
	}
	
	public Image getBackGroundImage()
	{
		ImageIcon i = new ImageIcon(getClass().getResource(backGround));
		return i.getImage();
	}

	public void paint(Graphics g)
	{
		super.paint(g);
		Graphics2D g2d = (Graphics2D)g;
		g2d.drawImage(getBackGroundImage(), 0, 0, this);
		d.draw(g2d); // draw the player . this function draw is inside Player
		//e.draw(g2d);
		p.draw(g2d);
		//System.out.println("Create bullet???");		
		//b.draw(g2d);
		
		g.drawString(""+hi, 280, 10);
		g.drawString(""+score, 600, 10);
		g.drawString("Your score:", 520, 10);
		g.drawString("Round:"+round, 10, 10);
		
		if(p.hitted) // for testing purpose, if drone hits x = 300, game over
		{	
			runGame.stop();
			g.setColor(Color.red);
			g.setFont(new Font("serif", Font.BOLD, 40));
			g.drawString("CRASHED! GAME OVER", 100,  240);
			
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		//System.out.println("running the game every 10 m-sec.");
		//System.out.println("x: " + d.getX() + " y: " + d.getY());
		repaint(); //this calls the public void paint() method
		d.update();
		//e.update();
		p.update();
		
		//System.out.println(d.x + d.y);
		//b.update();
	}
}
