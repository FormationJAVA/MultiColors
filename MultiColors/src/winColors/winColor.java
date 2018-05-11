package winColors;

import javax.swing.JFrame;

public class winColor extends JFrame {
	
	winColor()
	{
		panColor pan = new panColor();
		
		this.setResizable(false);
		this.setTitle("MultiColors");
		this.setSize(600, 600);
		this.setContentPane(pan);
		this.setVisible(true);
	
	}
	
	public static void main(String[] args) {
		
		winColor wc = new winColor();
	}

}
