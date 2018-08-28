import java.util.Scanner;

public class Solution {
	/*
	Do not modify this main function.
	*/
	double calculateFromDegreesToFarenheit(double degreesCelsius) {
		final double v = 9/5;
		final double d = degreesCelsius;
		final int a = 32;
		return ((v*d)+a);
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		double degreesCelsius = scan.nextDouble();
		Solution temp = new Solution();
		System.out.println(temp.calculateFromDegreesToFarenheit(degreesCelsius));
	}
	/*
	Need to fill the calculateFromDegreesToFarenheit function and print the output
	of fahrenheit.
	*/
}