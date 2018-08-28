/**
 * main program of finding root sof equations.
 */
import java.util.Scanner;
import java.lang.*;
/**
 * Class for solution.
 */
public class Solution {
	/*
	Do not modify this main function.
	*/
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		int b = scan.nextInt();
		int c = scan.nextInt();


		rootsOfQuadraticEquation(a, b, c);
	}
	/* 
	*
	*/
	static void rootsOfQuadraticEquation(final int a,final  int b,final int c) {
		/**
		 * roots
		 */
		int f = 4;
		double det = Math.sqrt((b * b) - f * a * c);
		double root1 = (-b + det) / 2 * a;
		double root2 = (-b - det) / 2 * a;
		System.out.print(root1 + " ");
		System.out.print(root2);
	}
}
