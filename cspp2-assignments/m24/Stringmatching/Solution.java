import java.util.*;
import java.io.*;
import java.lang.*;
import java.nio.file.*;
import java.nio.charset.*;
public class Solution {
	public static void main(String[] args) {
		ArrayList<String> d = new ArrayList<>();
		ArrayList<Mytalent> jab = new ArrayList<>();
		Scanner input = new Scanner(System.in);
		File folder = new File(input.nextLine());
		File[] files = folder.listFiles();
		System.out.println(Arrays.toString(files));
		for (File file : files) {
			try {
				String examp = new String(Files.readAllBytes(Paths.get(file.getAbsolutePath())));
				System.out.println(examp);
				String refined_string = examp.replaceAll("[^a-zA-Z0-9_]", "").replaceAll("\n", " ");
				d.add(refined_string);
				System.out.println(d);
			} catch (Exception h) {
				System.out.println("file not found");
			}
		}
		for (String ans  : d) {
			for (String rash : d) {
				jab.add(new Mytalent(ans, rash));
			}
		}
		for (Mytalent etv : jab) {
			System.out.println(etv.lcs_caluation());
		}
	}
}
class Mytalent {
	private double result;
	private String file1;
	private String file2;
	Mytalent(String input1, String input2) {
		file1 = input1;
		file2 = input2;
	}
	public double lcs_caluation() {
		double l = 0;
		int initi;
		int j;
		String bruce="";
		for (initi = 0; initi < file1.length(); initi=j) {
			String s = "";
			for (j = 0; j < file1.length(); j++) {
				if (!file2.contains(file1.substring(initi, j + 1))) {
					s = file1.substring(initi, j);
					if (s.length() > l) {
						l = s.length();
						bruce = s;
					}
					break;
				}
			}
		}
		System.out.println("yo! its batman: " + bruce);
		return((Double)(l*2) / (file1.length() + file2.length())) * 100;
	}
	public double getresutls(){
		return result;
	}
}
