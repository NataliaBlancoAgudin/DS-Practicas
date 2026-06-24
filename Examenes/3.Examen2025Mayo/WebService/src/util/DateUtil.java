package util;

public class DateUtil {
    private int counter;

    public boolean isWeekendToday() {
        counter++;
        return counter % 2 == 0;
    }
}
