/**.
 * package import
 */
import java.util.*;
/**.
 * FirstLast6.
 * Author harinath reddy
 * date 10/08/18
 */
public class FirstLast6 {
	/**.
	 * { this is a main funcyion }
	 *
	 * @param      args  The arguments
	 */
		
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int a = input.nextInt();
		int b = 6;
		int [] l = new int[a];
		for (int i = 0;i<l.length; i++ ) {
			l[i] = input.nextInt();
			
		}
		if (l[0] == b || l[(l.length)-1] == b){
			System.out.println("true");
		}
		else{
			System.out.println("false");
		}
		
	}

}