import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
public class MenstrualApp{

    public static CycleDates cycleDatesCalculation(String startingDate, int cycleLength){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate startDate = LocalDate.parse(startingDate, formatter);
        LocalDate ovulationDay = startDate.plusDays(cycleLength - 14);
        LocalDate fertileWindowOpen = ovulationDay.minusDays(4);
        LocalDate fertileWindowClose = ovulationDay.plusDays(1);
        LocalDate nextPeriod = startDate.plusDays(cycleLength);
        return new CycleDates(startDate, ovulationDay, fertileWindowOpen, fertileWindowClose, nextPeriod);
    }
}
