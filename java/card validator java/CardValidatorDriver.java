import java.util.Scanner;
public class CardValidatorDriver{
public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.println("Hello, Kindly Enter Card details to verify");
            String cardNumber = scan.nextLine();

            String result = CardValidator.checkCard(cardNumber);
            System.out.println();
            System.out.println(result);

            System.out.println("Do you want to try again? yes or no");
            String userInput = scan.nextLine();

            if (userInput.equalsIgnoreCase("no")) {
                System.out.println("Thank you for using this service");
                break;
            } else {
                continue;
            }
        }
    }
}

