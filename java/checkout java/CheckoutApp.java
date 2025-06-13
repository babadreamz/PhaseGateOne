import java.util.ArrayList;

public class CheckoutApp{
public static ArrayList<String> items = new ArrayList<>();
public static ArrayList<Integer> quantityBought = new ArrayList<>();
public static ArrayList<Double> prices = new ArrayList<>();

public static void addItem(String name, int quantity, double price){
	items.add(name);
	quantityBought.add(quantity);
	prices.add(price);
    }

    public static double calculateTotal(){
        double total = 0;
        for (int item = 0; item < items.size(); item++){
            total += quantityBought.get(item) * prices.get(item);
        }
        return total;
    }

    public static double calculateDiscount(double total, double discountRate) {
        return (discountRate / 100.0) * total;
    }

    public static double calculateVAT(double total){
        return 0.175 * total;
    }

    public static double getBillTotal(double total, double discount, double vat) {
        return total - discount + vat;
    }
}
