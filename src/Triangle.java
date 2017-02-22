/*Vector Math Equations
 * Brandon Kerber
 * Date Started: Feb 16th, 2017
*/
public class Triangle
{
	public Point a;
	public Point b;
	public Point c;
	
	String name;
	
	public Triangle(Point p1, Point p2, Point p3, String n)
	{
		a = p1;
		b = p2;
		c = p3;
		name = n;
	}
	
	public String toString()
	{
		return (name + "(" + a + ", " + b + ", " + c + ")");
	}
}
