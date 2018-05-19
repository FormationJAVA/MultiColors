package winColors;

public class Point {
		public double x;
		public double y;

		public Point ()
		{
			this.x =0;
			this.y =0;
		}
		public Point (int a, int b )
		{
			this.x =a;
			this.y =b;
		}
		
		public Point(Point P) {
			this.x= P.x;
			this.y= P.y;
		}
		public void add (Point P)
		{
			this.x+= P.x;
			this.y+= P.y;

		}
		public double getAngle(Point P)
		{
			/*A Programmer*/
			
			
			return 0.0;
		}
		public double norme ()
		{
			double result = 0.0;
			result +=Math.pow(this.x,2);
			result +=Math.pow(this.y,2);
			return Math.sqrt(result);
		}
		public static double dot(Point P1,Point P2)
		{
			double result = 0.0;
			result +=P1.x * P2.x;
			result +=P1.y * P2.y;
			return result;
		}
		public void sub (Point P)
		{
			this.x-= P.x;
			this.y-= P.y;

		}
		public void transform (double theta, Point T)
		
		{
			double ct = Math.cos(theta), st = Math.sin(theta);
			
			double xTemp = (ct * this.x) - (st * this.y) ;
			double yTemp = (st * this.x) + (ct * this.y) ;
			xTemp += T.x;
			yTemp += T.y;
			this.x= xTemp;
			this.y= yTemp;
		}
		public static Point add (Point P1,Point P2)
		{
			Point resultat = new Point();
			resultat.x= P1.x+P2.x;
			resultat.y= P1.y+P2.y;
			return resultat;
		}
		public void mul (double a)
		{
			this.x*= a;
			this.y*= a;

		}
		public static Point mul (Point P,double a)
		{
			Point resultat = new Point();
			resultat.x= Math.round(P.x*a);
			resultat.y= Math.round(P.y*a);
			return resultat;
		}
		public static double getDistance(Point P1,Point P2 )
		{
			double D;
			D= Math.pow( P1.x-P2.x,2);
			D+=Math.pow( P1.y-P2.y,2);
			D= Math.sqrt(D);
			return D;
		}
		public void setPoint (Point P)
		{
			this.x= P.x;
			this.y= P.y;
		}
		public String toString()
		{
			return "("+this.x+", "+this.y+")";
		}
}
