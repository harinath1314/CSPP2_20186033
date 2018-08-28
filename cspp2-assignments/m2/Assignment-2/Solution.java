import java.util.*;
import java.lang.*;

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
	static void rootsOfQuadraticEquation(int a, int b, int c) {
		double det = Math.sqrt((b*b) - 4*a*c);
		double root1 = (-b + det)/2*a;
		double root2 = (-b - det)/2*a;
		System.out.print(root1);
		System.out.print( root2);
	}
}
