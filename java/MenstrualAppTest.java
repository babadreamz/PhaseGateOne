import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;

public class MenstrualAppTest {

	@Test
	public void testCycleDatesCalculation() {
	String startDateStr = "2025-01-22"; 
	int cycleLength = 28;

        CycleDates result = MenstrualApp.cycleDatesCalculation(startDateStr, cycleLength);

        // actions
	LocalDate expectedStart = LocalDate.of(2025, 1, 22);
        LocalDate expectedOvulation = expectedStart.plusDays(14);
        LocalDate expectedFertileStart = expectedOvulation.minusDays(4);
        LocalDate expectedFertileEnd = expectedOvulation.plusDays(1);
        LocalDate expectedNextPeriod = expectedStart.plusDays(cycleLength);

        // checks
	assertEquals(expectedStart, result.startDate);
	assertEquals(expectedOvulation, result.ovulationDay);
	assertEquals(expectedFertileStart, result.fertileWindowOpen);
	assertEquals(expectedFertileEnd, result.fertileWindowClose);
	assertEquals(expectedNextPeriod, result.nextPeriod);
    }
}
