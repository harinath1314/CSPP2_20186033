/**
 * this is the solution for social network problem
 * author : harinatha reddy
 * date : 19/9/18
 */
// importing all thepackages necessary.
import java.util.Scanner;
import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.Arrays;
/**
 * Class for social network.
 */
class SocialNetwork{
	/**
	 * getconnection method is here.
	 */
	public static void getconnections(HashMap<String, ArrayList<String>> map, String user){
		if(map.keySet().contains(user)){
			System.out.println(map.get(user));
		}
		else{
			System.out.println("Not a user in Network");
		}
	}
	/**
	 * add connection method.
	 */
	public static void addconnection(HashMap<String, ArrayList<String>> map, String account, String friends){
		(map.get(account)).add(friends);
	}
	/**
	 * add new user method.
	 */
	public static void addnewuser(HashMap<String, ArrayList<String>> map, String newuser){
		map.put(newuser, new ArrayList<String>());
	}
	/**
	 * get common friends method.
	 */
	public static ArrayList<String> getcommonconnections(HashMap<String, ArrayList<String>> map, String user1, String user2){
		ArrayList<String> common = new ArrayList<>();
		for(String each : map.get(user1)){
			if(map.get(user2).contains(each)){
				common.add(each);
			}
		}
		return common;
	}
	/**
	 * this is the main function.
	 *
	 * @param      args  The arguments
	 */
	public static void main(String[] args){
		HashMap<String, ArrayList<String>> map = new HashMap<>();
		Scanner sc = new Scanner(new BufferedInputStream(System.in));
		String lineinput;
		while (sc.hasNext()){
			lineinput = sc.nextLine();
			String[] line1 = lineinput.split(" is connected to ");
			if(line1.length == 2){
				line1[1] = line1[1].replace(".", "");
				String[] tokens = line1[1].split(", ");
				map.put(line1[0], new ArrayList<String>(Arrays.asList(tokens)));
			
			}
			else {
				String[] line = lineinput.split(" ");
				switch(line[0]){
					case "getConnections":
						getconnections(map, line[1]);
						break;
					case "addConnections":
						addconnection(map, line[1], line[2]);
						break;
					case "addNewUser":
						addnewuser(map, line[1]);
						break;
					case "CommonConnections":
						System.out.println(getcommonconnections(map, line[1], line[2]));
						break;
					case "Network":
						String s ="";
						TreeMap<String, ArrayList<String>> sortedmap = new TreeMap<String, ArrayList<String>>(map);
						for(String each: sortedmap.keySet()){
							s += each + ": " + sortedmap.get(each) + ", ";
						}
						System.out.println(s.substring(0, s.length()-2));
					default:
						break;

			}
			}
						
		}
	}
}