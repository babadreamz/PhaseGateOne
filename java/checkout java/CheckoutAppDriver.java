import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CheckoutAppDriver{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("What is the customer's Name");
        String customerName = scan.nextLine();

        while (true) {
            System.out.println("What did the user buy?");
            String item = scan.nextLine();

            System.out.println("How many pieces?");
            int quantity = getIntInput(scan);

            System.out.println("How much per unit?");
            double price = getDoubleInput(scan);

            CheckoutApp.addItem(item, quantity, price);

            System.out.println("Add more Items? (yes/no)");
            String answer = scan.nextLine().toLowerCase();
            if (!answer.equals("yes")) {
                break;
            }
        }

        System.out.println("What is your name?");
        String cashierName = scan.nextLine();

        System.out.println("How much discount will they get?");
        double discountRate = getDoubleInput(scan);

        double subtotal = CheckoutApp.calculateTotal();
        double discount = CheckoutApp.calculateDiscount(subtotal, discountRate);
        double vat = CheckoutApp.calculateVAT(subtotal);
        double billTotal = CheckoutApp.getBillTotal(subtotal, discount, vat);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yy hh:mm:ss a");
        String dateTime = LocalDateTime.now().format(formatter);

        printReceiptHeader(cashierName, customerName, dateTime);
        printItems();
        System.out.printf("%nSub Total:\t\t%.2f%n", subtotal);
        System.out.printf("Discount:\t\t%.2f%n", discount);
        System.out.printf("VAT @ 17.50%%:\t\t%.2f%n%n", vat);
        System.out.printf("Bill Total:\t\t%.2f%n", billTotal);
        System.out.printf("%nTHIS IS NOT A RECEIPT. KINDLY PAY %.2f%n%n", billTotal);

        System.out.println("How much did the customer give to you?");
        double amountPaid = getDoubleInput(scan);

        double balance = amountPaid - billTotal;

        printReceiptHeader(cashierName, customerName, dateTime);
        printItems();
        System.out.printf("%nSub Total:\t\t%.2f%n", subtotal);
        System.out.printf("Discount:\t\t%.2f%n", discount);
        System.out.printf("VAT @ 17.50%%:\t\t%.2f%n", vat);
        System.out.printf("Bill Total:\t\t%.2f%n", billTotal);
        System.out.printf("Amount Paid:\t\t%.2f%n", amountPaid);
        System.out.printf("Balance:\t\t%.2f%n", balance);
        System.out.println("\nTHANK YOU FOR YOUR PATRONAGE");
    }

    private static int getIntInput(Scanner scan) {
        while (true) {
            try {
                return Integer.parseInt(scan.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Enter a valid number");
            }
        }
    }

    private static double getDoubleInput(Scanner scan) {
        while (true) {
            try {
                return Double.parseDouble(scan.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Enter a valid number");
            }
        }
    }

    private static void printReceiptHeader(String cashier, String customer, String dateTime) {
        System.out.println("\nSEMICOLON STORES");
        System.out.println("MAIN BRANCH");
        System.out.println("LOCATION: 312, HERBERT MACAULAY WAY, SABO YABA, LAGOS.");
        System.out.println("TEL: 03293828343");
        System.out.println("Date: " + dateTime);
        System.out.println("Cashier: " + cashier);
        System.out.println("Customer Name: " + customer);
        System.out.println();
        System.out.println("ITEM\tQTY\tPRICE\tTOTAL (NGN)");
    }

    private static void printItems() {
        for (int i = 0; i < CheckoutApp.items.size(); i++) {
            String item = CheckoutApp.items.get(i);
            int qty = CheckoutApp.quantityBought.get(i);
            double price = CheckoutApp.prices.get(i);
            double total = qty * price;
            System.out.printf("%s\t%d\t%.2f\t%.2f%n", item, qty, price, total);
        }
    }
}
