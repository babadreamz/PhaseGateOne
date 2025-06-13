import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
public class MenstrualAppDriver {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        System.out.println("MENSTRUAL TRACKER APP");
	String startDate = "";
        int cycleLength = 0;

       while (true) {
            System.out.print("Enter the first day of your last period (YYYY-MM-DD): ");
            startDate = scan.nextLine();

            try {
                LocalDate.parse(startDate, formatter);
                break;
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date format. Please enter date like YYYY-MM-DD.");
            }
        }

       while (true) {
            System.out.print("Enter your cycle length in days (e.g. 28): ");
            String cycleLengthInput = scan.nextLine();

            try {
                cycleLength = Integer.parseInt(cycleLengthInput);
                if (cycleLength < 20 || cycleLength > 45) {
                    System.out.println("Cycle length should be between 20 and 45 days.");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid number of days. Please enter a whole number (e.g. 28).");
            }
        }
       CycleDates result = MenstrualApp.cycleDatesCalculation(startDate, cycleLength);

       System.out.println("Menstrual Cycle Details:");
       System.out.println("Start Date: " + result.startDate);
       System.out.println("Ovulation Day: " + result.ovulationDay);
       System.out.println("Fertile Window: " + result.fertileWindowOpen + " to " + result.fertileWindowClose);
       System.out.println("Next Period: " + result.nextPeriod);

    }
}
