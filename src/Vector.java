/*Vector Math Equations
 * Brandon Kerber
 * Date Started: Feb 16th, 2017
*/
public class Vector 
{
	public double x;
	public double y;
	public String vectorChar;
	public double length;
	public double slope;
	
	public Vector(double d, double e, String vC)
	{
		this.x = d;
		this.y = e;
		this.vectorChar = vC;
	}
	
	public Vector GetNormal()
	{
		return new Vector(-y, x, "n" + vectorChar);
	}
	
	public String toString()
	{
		return (vectorChar + "(" + x + ", " + y + ")");
	}
	
	public Vector scalarMultiplication(double scalar)
	{
		return new Vector(x * scalar, y * scalar, vectorChar + "s");
	}
	public Vector subtract(Vector right)
	{
		return new Vector(x - right.x, y - right.y, vectorChar + right.vectorChar);
	}
}
