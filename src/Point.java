
public class Point 
{
	public int x;
	public int y;
	public String varName;
	
	public Point(int x, int y, String varName)
	{
		this.x = x;
		this.y = y;
		this.varName = varName;
	}
	
	public Vector Subtract(Point rightOperand)
	{
		return new Vector(x - rightOperand.x, y - rightOperand.y, varName + rightOperand.varName);
	}
	public String toString()
	{
		return (varName + "(" + x +", " + y + ")");
	}
}
