import java.util.Scanner;



public class Main
{
	public static VectorMathEquations vme = new VectorMathEquations();
	public static Scanner scanner = new Scanner(System.in);
	public static boolean running = true;
	public static void main(String args[])
	{
		
		while(running)
		{
			 parseInput(getStartInput());
		}
		
	}
	
	public static int getStartInput()
	{
		System.out.println("*********Vector Math Solver*********");
		System.out.println(" 1). Slope of a Vector");
		System.out.println(" 2). Vector Length");
		System.out.println(" 3). Unit Vector");
		System.out.println(" 4). Normal vector");
		System.out.println(" 5). Dot Product");
		System.out.println(" 6). Cosine of Angle between Vectors");
		System.out.println(" 7). Angle between Vectors(radians)");
		System.out.println(" 8). Angle between Vectors(degrees)");
		System.out.println(" 9). Distance from a Point to a Line");
		System.out.println("10). Projection of a Point on a Line");
		System.out.println("11). Reflection of a Vector from Another Vector");
		System.out.println("12). Point Inside a Triangle");
		System.out.println("************************************");
	
		
		
		System.out.println("Please input a number between 1 and 12:");
		String input = scanner.nextLine();
		return getInputAsInt(input);
		
	}
	
	
	public static Vector createVector()
	{
		System.out.println("New Vector");
		System.out.println("Please input a X for the vector:");
		int xInput = scanner.nextInt();
		System.out.println("Please input a Y for the vector:");
		int yInput = scanner.nextInt();
		System.out.println("Please input a character to name the vector:");
		String nameInput = scanner.next();
		System.out.println("**********\n\n");
		scanner.nextLine();
		return new Vector(xInput, yInput, nameInput);	
	}
	
	public static Point createPoint()
	{
		System.out.println("New Point:");
		System.out.println("Please input a X for the point:");
		int xInput = scanner.nextInt();
		System.out.println("Please input a Y for the point:");
		int yInput = scanner.nextInt();
		System.out.println("Please input a char for the point:");
		String nameInput = scanner.next();
		scanner.nextLine();
		System.out.println("**********\n\n");
		return new Point(xInput, yInput, nameInput);
	}
	
	public static Triangle createTriangle()
	{
		System.out.println("New Triangle:");
		System.out.println("Please create three points: ");
		Point p1 = createPoint();
		Point p2 = createPoint();
		Point p3 = createPoint();
		System.out.println("Please input a character to name the triangle: ");
		String nameInput = scanner.next();
		scanner.nextLine();
		System.out.println("**********\n\n");
		return new Triangle(p1, p2, p3, nameInput);
	}
	
	public static int getInputAsInt(String input)
	{
		int inputNumber = -1;
		try
		{
			inputNumber = Integer.parseInt(input);
		}
		catch (Exception ex)
		{
			return -1;
		}
		return inputNumber;
	}
	
	public static void enterToContinue()
	{
		System.out.println("Press 'Enter' or 'return' to continue...");
		scanner.nextLine();
	}
	
	public static void parseInput(int input)
	{
		Vector vector1, vector2;
		Point point1, point2;
		switch(input)
		{
		case 1:
			System.out.println("---SLOPE OF A VECTOR---");
			vector1 = createVector();
			vme.CalcSlope(vector1);
			enterToContinue();
			break;
		case 2:
			System.out.println("---LENGTH OF A VECTOR---");
			vector1 = createVector();
			vme.CalcLength(vector1);
			enterToContinue();
			break;
		case 3:
			System.out.println("---UNIT VECTOR OF A VECTOR---");
			vector1 = createVector();
			vme.CalcUnitVector(vector1);
			enterToContinue();
			break;
		case 4:
			System.out.println("---NORMAL OF A VECTOR---");
			vector1 = createVector();
			System.out.println("Normal of vector " + vector1 + " is " + vector1.GetNormal() + ".");
			enterToContinue();
			break;
		case 5:
			System.out.println("---DOT PRODUCT OF TWO VECTORS---");
			vector1 = createVector();
			vector2 = createVector();
			vme.CalcDotProduct(vector1, vector2);
			enterToContinue();
			break;
		case 6:
			System.out.println("---COSINE OF ANGLE BETWEEN TWO VECTORS---");
			vector1 = createVector();
			vector2 = createVector();
			vme.CalcCosineBetweenTwoAngles(vector1, vector2);
			enterToContinue();
			break;
		case 7:
			System.out.println("---ANGLE BETWEEN TWO VECTORS (RADIANS)---");
			vector1 = createVector();
			vector2 = createVector();
			vme.CalcAngleBetweenToVectorsInRadians(vector1, vector2);
			enterToContinue();
			break;
		case 8:
			System.out.println("---ANGLE BETWEEN TWO VECTORS (DEGREES)---");
			vector1 = createVector();
			vector2 = createVector();
			vme.CalcAngleBetweenToVectorsInDegrees(vector1, vector2);
			enterToContinue();
			break;
		case 9:
			System.out.println("---DISTANCE FROM A POINT TO A LINE---");
			System.out.println("(First point is the point on the line.)");
			
			point1 = createPoint();
			point2 = createPoint();
			vector1 = createVector();
			vme.getDistanceFromPointToLine(point1, vector1, point2);
			enterToContinue();
			break;
		case 10:
			System.out.println("---PROJECTION OF A POINT ON A LINE---");
			System.out.println("(First point is the point on the line.)");
			
			point1 = createPoint();
			vector1 = createVector();
			point2 = createPoint();
			vme.getPerpendicularProjection(point1, vector1, point2);
			enterToContinue();
			break;
		case 11:
			System.out.println("---Relfection of a Vector from Another Vector---");
			vector1 = createVector();
			vector2 = createVector();
			vme.getReflectionVector(vector1, vector2);
			enterToContinue();
			break;
		case 12:
			System.out.println("Is a Point inside a triangle?");
			Triangle t = createTriangle();
			point1 = createPoint();
			vme.isPointInsideTriangle(t, point1);
			enterToContinue();
			break;
		default:
			running = false;
			break;
		
		}
	}
	
}
