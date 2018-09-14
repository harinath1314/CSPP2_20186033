import java.util.Scanner;
/**
 * Class for solution.
 * author : harinatha reddy
 * date : 14/09/18
 */
final class Solution {
    /**
     * constructor.
     */
    private Solution() {

    }
    /**
     * main function.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        ShoppingCart shop = new ShoppingCart();
        Scanner sc = new Scanner(System.in);
        int rekhalu = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < rekhalu; i++) {
            String[] input = sc.nextLine().split(" ");
            switch (input[0]) {
            case "Item":
                String[] tokens = input[1].split(",");
                shop.addToCatalog(new Item(tokens[0],
                                           tokens[1], tokens[2]));
                break;
            case "catalog":
                shop.showCatalog();
                break;
            case "add":
                String[] tokens1 = input[1].split(",");
                shop.addToCart(new Item(tokens1[0], tokens1[1]));
                break;
            case "show":
                shop.showCart();
                break;
            case "totalAmount":
                System.out.println("totalAmount: "
                                   + shop.getTotalAmount());
                break;
            case "payableAmount":
                System.out.println("Payable amount: "
                                   + shop.getPayableAmount());
                break;
            case "remove":
                String[] tokens2 = input[1].split(",");
                shop.removeFromCart(new Item(tokens2[0], tokens2[1]));
                break;
            case "coupon":
                shop.applyCoupon(input[1]);
                break;
            case "print":
                shop.printInVoice();
                break;
            default:
                break;
            }
        }
    }
}

