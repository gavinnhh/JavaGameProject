package planeProject;

import javax.swing.JFrame;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		JFrame frame = new JFrame("Drone vs Planes");
		frame.pack();
		frame.setSize(640, 480);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//for(int i = 0; i < 4; i++)
			frame.add(new Game());
		frame.setVisible(true);
	}

}
