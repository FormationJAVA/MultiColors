package winColors;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;

public class panColor extends JPanel implements MouseMotionListener{
	
	Point P1,P2;
	private boolean isChanged,isFirst;
	int n ;
	Color cr;
	
	panColor()
	{
		P1 = new Point(300,300);
		P2 = new Point(500,300);
		isChanged = false;
		n = 360;
		cr = Color.WHITE;
		isFirst = true;
		this.addMouseMotionListener(this);
	}

	protected void paintComponent(Graphics g)
	{
		/*g.setColor(Color.WHITE);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());*/
		
		g.setColor(cr);
		g.fillRect(30, 30, 50, 20);
		paintColorComp(g);

		

		
	}
	private void paintColorComp(Graphics g)
	{
		for (int i = 0; i<n;i++ )
		{
			g.setColor(getColor( (double) (i+1)/n ) );
			g.drawLine((int)P1.x, (int)P1.y,(int)P2.x , (int)P2.y);
			P2.sub(P1);
			P2.transform((2*Math.PI)/n, new Point(0,0));
			P2.add(P1);
		}
	}
	private Color getColor(double r)
	{
		
		Color result = new Color(0,0,0) ;
		/*A Programmer*/
		
		return result;
	}

	@Override
	public void mouseDragged(MouseEvent ev) {
		// TODO Auto-generated method stub
		Point pMouse = new Point (ev.getX(), ev.getY());
		double d1 = Point.getDistance(pMouse, P2);
		double d2 = Point.getDistance(P1, P2);
		Point temp = new Point(P2);
		if(d1<=d2)
		{
			isChanged = true;
			pMouse.sub(P1);
			temp.sub(P1);
			double angle = pMouse.getAngle(temp);
			double sign = (pMouse.x*temp.y)- (pMouse.y*temp.x);
			if (sign >0)
				angle *=-1;
			System.out.println(angle);
			double i = angle / (Math.PI/n);
			if (i<0)
			{
				i+=n;
				i%=n;
			}
			cr = getColor(i/n);
			repaint();
		}
		
		
	}

	@Override
	public void mouseMoved(MouseEvent ev) {
		// TODO Auto-generated method stub
		Point pMouse = new Point (ev.getX(), ev.getY());
		double d1 = Point.getDistance(pMouse, P1);
		double d2 = Point.getDistance(P1, P2);
		Point temp = new Point(P2);
		if(d1<=d2)
		{
			isChanged = true;
			pMouse.sub(P1);
			temp.sub(P1);
			double angle = pMouse.getAngle(temp);
			double sign = (pMouse.x*temp.y)- (pMouse.y*temp.x);

			if (sign>0) {

				angle = (2.0 * Math.PI) - angle;

			}
			angle+= (2.0*Math.PI);
			angle =angle% (2.0*Math.PI);
			double i = angle / ((2.0*Math.PI)/n);
			cr = getColor(Math.min(Math.max(0,i+1),n-1)/n);
			repaint();
		}
	}
	
}
