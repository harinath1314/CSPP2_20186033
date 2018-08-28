/**
 * Class for area of circle.
 */
import java.util.Scanner;

public class Area_of_circle {
	double Area_of_circle(double radius ) {
		double r = radius;
		double pi = 3.14;
		return(pi*(r*r));

	}
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("input radius of circle -");
		double radius = input.nextDouble();
		Area_of_circle area = new Area_of_circle();
		System.out.println("area of circle = " + area.Area_of_circle(radius));
		
	}
}