
/*Vector Math Equations
 * Brandon Kerber
 * Date Started: Feb 16th, 2017
*/
public class VectorMathEquations 
{
	public double CalcSlope(Vector vector)
	{
		double slope = vector.y / vector.x;
		System.out.println("Calculating the slope of vector " + vector + ".");
		System.out.println("Slope = " + vector.y + "/" + vector.x + " = " + slope +"\n\n\n");
		return slope;
	}
	
	public double CalcLength(Vector vector)
	{
		double x2 = Math.pow(vector.x, 2);
		double y2 = Math.pow(vector.y, 2);
		double total = x2 + y2;
		double length = Math.sqrt(total);
		
		System.out.println("Calculating the length of vector " + vector);
		System.out.println("Length = sqrt(" + vector.x + "^2 + " + vector.y + "^2)");
		System.out.println("Length = sqrt(" + x2 + " + " + y2 + ")");
		System.out.println("Length = sqrt(" + total + ")" );
		System.out.println("Length = " + Math.sqrt(total)+"\n\n\n");
		
		return length;
	}
	
	public void CalcUnitVector(Vector vector)
	{
		double length = CalcLength(vector);
		double unitX = vector.x / length;
		double unitY = vector.y / length;
		System.out.println("Calculating Unit Vector for " + vector);
		System.out.println("Unit Vector = v(" + vector.x + "/" + length + ", " + vector.y + "/" + length + ")");
		System.out.println("Unit Vector = v(" + unitX +", " + unitY + ")"+"\n\n\n");
	}
	
	public double CalcDotProduct(Vector vector1, Vector vector2)
	{
		double dx = vector1.x * vector2.x;
		double dy = vector1.y * vector2.y;
		double dot = dx + dy;
		
		
		System.out.println("Calculating dot product for " + vector1 + " and " + vector2);
		System.out.println("Dot Product = (" + vector1.x + " * " + vector2.x + ") + (" + vector1.y + " * " + vector2.y + ")"  );
		System.out.println("Dot Product = (" + dx + ") + (" + dy + ")");
		System.out.println("Dot Product = " + dot+"\n\n\n");
		return dot;
	}
	
	public double CalcCosineBetweenTwoAngles(Vector vector1, Vector vector2)
	{
		double v1Length = CalcLength(vector1);
		double v2Length = CalcLength(vector2);
		double lengthTimesLength = v1Length * v2Length;
		double dot = CalcDotProduct(vector1, vector2);
		double cosineOfAngle = dot / lengthTimesLength;
		
		
		System.out.println("Calculating the cosine of the angle between " + vector1 + " and " + vector2);
		System.out.println("Cosine(angle) = (" + vector1.vectorChar + " dot " + vector2.vectorChar + ") / (||" + vector1.vectorChar + "||" + " * ||" + vector2.vectorChar + "|| )");
		System.out.println("Cosine(angle) = (" + dot + ") / (" + v1Length + " * " + v2Length + ")");
		System.out.println("Cosine(angle) = " + dot + " / (" + lengthTimesLength + ")");
		System.out.println("Cosine(angle) = " + dot + " / " + lengthTimesLength);
		System.out.println("Cosine(angle) = " + cosineOfAngle+"\n\n\n");
		
		return cosineOfAngle;
	} 
	public double CalcAngleBetweenToVectorsInRadians(Vector vector1, Vector vector2)
	{
		double cosineOfAngle = CalcCosineBetweenTwoAngles(vector1, vector2);
		double ACosine = Math.acos(cosineOfAngle);
		System.out.println("Calculating the angle (in Radians) between the two vectors " + vector1 + " and " + vector2);
		System.out.println("angle(in rad) = ACosine(" + cosineOfAngle + ")");
		System.out.println("angle(in rad) = " + ACosine+"\n\n\n" );
		return ACosine;
	}
	public double CalcAngleBetweenToVectorsInDegrees(Vector vector1, Vector vector2)
	{
		double angleInRads = CalcAngleBetweenToVectorsInRadians(vector1, vector2);
		double degree = 180 / Math.PI;
		double angleInDegrees = degree * angleInRads;
		System.out.println("Calculating the angle (in Degrees) between the two vectors " + vector1 + "and" + vector2);
		System.out.println("angle(in deg) = (180 / PI) * " + angleInRads);
		System.out.println("angle(in deg) = " + degree + " * " + angleInRads);
		System.out.println("angle(in deg) = " + angleInDegrees+"\n\n\n");
		return angleInDegrees;
	}
	
	public double getDistanceFromPointToLine(Point linePoint, Vector vector, Point point )
	{
		Vector newVector = point.Subtract(linePoint);
		Vector normal = vector.GetNormal(); 
		double dot = CalcDotProduct(normal, newVector );
		double length = CalcLength(normal);
		double distance = dot / length;
		
		System.out.println("Calculating the distance from point " + point + " to point " + linePoint + " on a line parallel to the vector " + vector + ".");
		System.out.println("Distance = " + normal.vectorChar + " dot (" + point.varName + " - " + linePoint.varName + ") / " + "||" + normal.vectorChar + "||");
		System.out.println("Distance = " + normal.vectorChar + " dot (" + newVector + ") / " + length );
		System.out.println("Distance = " + dot + " / " + length);
		System.out.println("Distance = " + distance);
		System.out.println("|Distance| = " + Math.abs(distance)+"\n\n\n");
		return distance;
	}
	
	public Vector getPerpendicularProjection(Point p, Vector v, Point q)
	{
		Vector qp = q.Subtract(p);
		double dot = CalcDotProduct(v, qp);
		double vLength = CalcLength(v);
		double vLengthSquared = Math.pow(vLength, 2);
		double scalar = dot / vLengthSquared;
		Vector vTimesScalar = v.scalarMultiplication(scalar);
		Vector perp = new Vector(p.x + vTimesScalar.x, p.y + vTimesScalar.y, "p");
		
		System.out.println("Finding the perpendicular projection from point " + q + " on the line that passes through point " + p + " that is parallel to the vector " + v);
		System.out.println("Projection = " + p.varName + " + ((" + v.vectorChar + " dot (" + q.varName + " - " + p.varName + ")) / ||" + v.vectorChar + "||^2) * " + v.vectorChar);
		System.out.println("Projection = " + p + " + ((" + v + " dot (" + q + " - " + p + ")) / ||" + v + "||^2) * " + v);
		System.out.println("Projection = " + p + " + ((" + v + " dot (" + qp + ")) / " + vLength + "^2) * " + v);
		System.out.println("Projection = " + p + " + ((" + dot + " )/ " + vLengthSquared + ") * " + v);
		System.out.println("Projection = " + p + " + (" + scalar + ") * " + v);
		System.out.println("Projection = " + p + " + (" + scalar + " * " + v + ")");
		System.out.println("Projection = " + p + " + (" + vTimesScalar + ")");
		System.out.println("Projection = " + perp);
		return perp;
		
	}
	public Vector getReflectionVector(Vector a, Vector v)
	{
		Vector normal = v.GetNormal();
		double dot = CalcDotProduct(normal, a);
		double length = CalcLength(normal);
		double lengthSquared = Math.pow(length, 2);
		double dotTimes2 = 2 * dot;
		double scalar = dotTimes2 / lengthSquared;
		Vector nScalar = normal.scalarMultiplication(scalar);
		Vector reflection = a.subtract(nScalar);
		
		
		System.out.println("Finding the reflection of vector + " + a + " after colliding with vector " + v );
		System.out.println("Reflection = " + a.vectorChar + " - ( 2 * (" + normal.vectorChar + " dot " + a.vectorChar + ") / ||" + normal.vectorChar + "||^2) * " + normal.vectorChar);
		System.out.println("Reflection = " + a + " - ( 2 * (" + normal + " dot " + a + ") / ||" + normal + "||^2) * " + normal);
		System.out.println("Reflection = " + a + " - ( 2 * (" + dot + ") / " + length + "^2) * " + normal);
		System.out.println("Reflection = " + a + " - ( (2 * " + dot + ") / " + lengthSquared + ") * " + normal);
		System.out.println("Reflection = " + a + " - (" + dotTimes2 + ") / " + lengthSquared + ") * " + normal);
		System.out.println("Reflection = " + a + " - (" + scalar + ") * " + normal);
		System.out.println("Reflection = " + a + " - " + nScalar);
		System.out.println("Reflection = " + reflection);
		return reflection;
	}
	public boolean isPointInsideTriangle(Triangle t, Point m)
	{
		Vector bA = t.b.Subtract(t.a);
		Vector cB = t.c.Subtract(t.b);
		Vector aC = t.a.Subtract(t.c);
		
		
		
		Vector mA = m.Subtract(t.a);
		Vector mB = m.Subtract(t.b);
		Vector mC = m.Subtract(t.c);
		
		
		
		System.out.println("Calculating vectors along sides of triangle");
		System.out.println(t.b.varName + "-" +  t.a.varName + " = " + t.b + " - " + t.a);
		System.out.println(t.b.varName + "-" +  t.a.varName + " = " + bA);
		System.out.println("\n");
		System.out.println(t.c.varName + "-" +  t.b.varName + " = " + t.c + " - " + t.b);
		System.out.println(t.c.varName + "-" +  t.b.varName + " = " + cB);
		System.out.println("\n");
		System.out.println(t.a.varName + "-" +  t.c.varName + " = " + t.a + " - " + t.c);
		System.out.println(t.a.varName + "-" +  t.c.varName + " = " + aC);
		System.out.println("\n\n");
		
		System.out.println("Calculating normals to the triangles three sides");
		Vector nBA = bA.GetNormal();
		Vector nCB = cB.GetNormal();
		Vector nAC = aC.GetNormal();
		System.out.println("\n\n");
		
		System.out.println("Calculating vectors from vertices to point " + m.varName);
		System.out.println(m.varName + " - " + t.a.varName + " = " + m + " - " + t.a);
		System.out.println(m.varName + " - " + t.a.varName + " = " + mA);
		System.out.println("\n");
		System.out.println(m.varName + " - " + t.b.varName + " = " + m + " - " + t.b);
		System.out.println(m.varName + " - " + t.b.varName + " = " + mB);
		System.out.println("\n");
		System.out.println(m.varName + " - " + t.c.varName + " = " + m + " - " + t.c);
		System.out.println(m.varName + " - " + t.c.varName + " = " + mC);
		System.out.println("\n\n");
		
		double nBA_mA = CalcDotProduct(nBA, mA);
		double nCB_mB = CalcDotProduct(nCB, mB);
		double nAC_mC = CalcDotProduct(nAC, mC);
		
		System.out.println("inside = (" + nBA_mA + " <= 0 && " + nCB_mB + " <= 0 && " + nAC_mC +  " <= 0) || (" + nBA_mA  +" >= 0 && " + nCB_mB  +" >= 0 && " + nAC_mC +" >= 0)");
		System.out.println("inside = (" + (nBA_mA <= 0) + " && " + (nCB_mB <= 0) + " && " + (nAC_mC <= 0) + ") || (" + (nBA_mA >= 0) + " && " + (nCB_mB >= 0) + " && " + (nAC_mC >= 0) + ")");
		System.out.println("inside = (" + ((nBA_mA <= 0) && (nCB_mB <= 0) && (nAC_mC <= 0)) + " || " + ((nBA_mA >= 0) && (nCB_mB >= 0) && (nAC_mC >= 0)) + ")");
		System.out.println("inside = " + ((nBA_mA <= 0) && (nCB_mB <= 0) && (nAC_mC <= 0) || (nBA_mA >= 0) && (nCB_mB >= 0) && (nAC_mC >= 0)));
		boolean isInside = (nBA_mA <= 0 && nCB_mB <= 0 && nAC_mC <= 0) || (nBA_mA >= 0 && nCB_mB >= 0 && nAC_mC >= 0);
		
		return isInside;
		
		
		
		
	}
}
