import java.time.LocalDate;
public class CycleDates {
    public LocalDate startDate;
    public LocalDate ovulationDay;
    public LocalDate fertileWindowOpen;
    public LocalDate fertileWindowClose;
    public LocalDate nextPeriod;

    public CycleDates(LocalDate startDate, LocalDate ovulationDay, LocalDate fertileWindowOpen,LocalDate fertileWindowClose, LocalDate nextPeriod){
        this.startDate = startDate;
        this.ovulationDay = ovulationDay;
        this.fertileWindowOpen = fertileWindowOpen;
        this.fertileWindowClose = fertileWindowClose;
        this.nextPeriod = nextPeriod;
    }
}
