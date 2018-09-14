import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;
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
                shop.addToCatalog(new Item(tokens[0], tokens[1], tokens[2]));
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
                System.out.println("totalAmount: " + shop.getTotalAmount());
                break;
            case "payableAmount":
                System.out.println("Payable amount: " + shop.getPayableAmount());
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
/**
 * Class for item.
 */
class Item {
    String vastu;
    int quantity;
    double fees;
    public Item(final String vastu, final String quantity, final String fees) {
        this.vastu = vastu;
        this.quantity = Integer.parseInt(quantity);
        this.fees = Double.parseDouble(fees);
    }
    public Item(final String vastu, final String quantity) {
        this.vastu = vastu;
        this.quantity = Integer.parseInt(quantity);
    }
    public String toString() {
        return this.vastu + " " + this.quantity + " " + this.fees;
    }
    public boolean equals(final Item other) {
        if (!this.vastu.equals(other.vastu)) {
            return false;
        }
        return true;
    }
}
/**
 * Class for shopping cartesian.
 */
class ShoppingCart {
    int catsize, cartsize;
    int k = 1;

    Item[] catalog, cart;
    String[] validCoupons = {"IND10", "IND20", "IND30", "IND50"};
    static double discount = 0.0;
    static boolean couponApplied = false;
    /**
     * Constructs the object.
     */
    ShoppingCart() {
        catalog = new Item[20];
        cart = new Item[20];
        catsize = 0;
        cartsize = 0;

    }
    /**
     * Adds to catalog.
     *
     * @param      item  The item
     */
    public void addToCatalog(final Item item) {
        catalog[catsize++] = item;
    }
    /**
     * Adds to cartesian.
     *
     * @param      item  The item
     */
    public void addToCart(final Item item) {
        if (!inCart(item)) {
            if (checkCatalog(item)) {
                cart[cartsize++] = item;
            }
        }
    }
    
    /**
     * { function_description }
     *
     * @param      item  The item
     *
     * @return     { description_of_the_return_value }
     */
    boolean inCart (final Item item) {
        for (Item s : cart) {
            if (s != null) {
                if (s.equals(item)) {
                    s.quantity = s.quantity + item.quantity;
                    return true;
                }
            }
        }
        return false;
    }
    /**
     * { function_description }
     *
     * @param      item  The item
     *
     * @return     { description_of_the_return_value }
     */
    public boolean checkCatalog(final Item item) {
        for (Item i : catalog) {
            if (i != null) {
                if (i.equals(item)) {
                    if (item.quantity <= i.quantity) {
                        i.quantity = i.quantity - item.quantity;
                        return true;
                    }
                }
            }
        }
        return false;
    }
    /**
     * Removes a from cartesian.
     *
     * @param      item  The item
     */
    public void removeFromCart(final Item item) {
        for (int i = 0; i < cartsize; i++) {
            if (item.equals(cart[i])) {
                cart[i].quantity = cart[i].quantity - item.quantity;
            }
        }
    }
    /**
     * Shows the cartesian.
     */
    public void showCart() {
        for (Item i : cart) {
            if (i != null) {
                if (i.quantity != 0) {
                    System.out.println(i.vastu + " " + i.quantity);
                }
            }
        }
    }
    /**
     * Shows the catalog.
     */
    public void showCatalog() {
        for (Item i : catalog) {
            if (i != null) {
                System.out.println(i);
            }
        }
    }
    /**
     * Gets the total amount.
     *
     * @return     The total amount.
     */
    double getTotalAmount() {
        double total = 0;
        for (int i = 0; i < cartsize; i++) {
            total += cart[i].quantity * getPrice(cart[i]);
        }
        return total;
    }
    /**
     * Gets the price.
     *
     * @param      item  The item
     *
     * @return     The price.
     */
    double getPrice(final Item item) {
        for (Item i : catalog) {
            if (i != null) {
                if (i.equals(item)) {
                    return i.fees;
                }
            }
        }
        return 0.0;
    }
    /**
     * Gets the payable amount.
     *
     * @return     The payable amount.
     */
    public double getPayableAmount() {
        double total = getTotalAmount();
        double newTotal = total - discount;
        double tax = newTotal * 15 / 100;
        return newTotal + tax;
    }

    /**.
     * { function_description }.
     *
     * @param      coupon  The coupon
     */
    public void applyCoupon(final String coupon) {


        if (couponApplied) {
            // System.out.println("Invalid coupon");
            return;
        }
        boolean valid = false;
        if (k == 1) {
            for (String s : validCoupons) {
                if (s.equals(coupon)) {
                    int num = Integer.parseInt(coupon.substring(3));
                    discount = getTotalAmount() * num / 100;
                    valid = true;
                    couponApplied = true;
                    k++;
                }
            }
        }
        if (!valid) {
            System.out.println("Invalid coupon");
            return;
        }
    }
    /**.
     * { function_description }.
     */
    void printInVoice() {
        System.out.println("Name   quantity   Price");
        for (Item i : cart) {
            if (i != null) {
                if (i.quantity != 0) {
                    System.out.println(i.vastu + " " + i.quantity + " " + getPrice(i));
                }
            }
        }


        double total = getTotalAmount();
        double total2 = total - discount;
        double tax = total2 * 15 / 100;
        System.out.println("Total:" + getTotalAmount());
        System.out.println("Disc%:" + discount);
        System.out.println("Tax:" + tax);
        System.out.println("Payable amount: " + getPayableAmount());
    }
}
