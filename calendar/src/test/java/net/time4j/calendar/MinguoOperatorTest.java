package net.time4j.calendar;

import net.time4j.CalendarUnit;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


@RunWith(JUnit4.class)
public class MinguoOperatorTest {

    @Test
    public void plusYears() {
        assertThat(
            MinguoCalendar.of(MinguoEra.ROC, 89, 2, 29).plus(2, CalendarUnit.YEARS),
            is(MinguoCalendar.of(MinguoEra.ROC, 91, 2, 28)));
        assertThat(
            MinguoCalendar.of(MinguoEra.ROC, 91, 1, 1).isLeapYear(),
            is(false));
    }

    @Test
    public void plusMonths() {
        assertThat(
            MinguoCalendar.of(MinguoEra.ROC, 89, 1, 31).plus(5, CalendarUnit.MONTHS),
            is(MinguoCalendar.of(MinguoEra.ROC, 89, 6, 30)));
    }

    @Test
    public void plusWeeks() {
        assertThat(
            MinguoCalendar.of(MinguoEra.ROC, 89, 1, 30).plus(5, CalendarUnit.WEEKS),
            is(MinguoCalendar.of(MinguoEra.ROC, 89, 3, 5)));
    }

    @Test
    public void plusDays() {
        assertThat(
            MinguoCalendar.of(MinguoEra.ROC, 89, 2, 28).plus(4, CalendarUnit.DAYS),
            is(MinguoCalendar.of(MinguoEra.ROC, 89, 3, 3)));
    }

    @Test
    public void nextMonth() {
        assertThat(
            MinguoCalendar.of(MinguoEra.ROC, 89, 1, 30).with(MinguoCalendar.MONTH_OF_YEAR.incremented()),
            is(MinguoCalendar.of(MinguoEra.ROC, 89, 2, 29)));
    }

    @Test
    public void previousMonth() {
        assertThat(
            MinguoCalendar.of(MinguoEra.ROC, 89, 3, 30).with(MinguoCalendar.MONTH_OF_YEAR.decremented()),
            is(MinguoCalendar.of(MinguoEra.ROC, 89, 2, 29)));
    }

    @Test
    public void nextYear() {
        assertThat(
            MinguoCalendar.of(MinguoEra.ROC, 89, 2, 29).with(MinguoCalendar.YEAR_OF_ERA.incremented()),
            is(MinguoCalendar.of(MinguoEra.ROC, 90, 2, 28)));
    }

    @Test
    public void previousYear() {
        assertThat(
            MinguoCalendar.of(MinguoEra.ROC, 89, 2, 29).with(MinguoCalendar.YEAR_OF_ERA.decremented()),
            is(MinguoCalendar.of(MinguoEra.ROC, 88, 2, 28)));
    }

    @Test
    public void nextDay() {
        assertThat(
            MinguoCalendar.of(MinguoEra.ROC, 89, 2, 28).with(MinguoCalendar.DAY_OF_YEAR.incremented()),
            is(MinguoCalendar.of(MinguoEra.ROC, 89, 2, 29)));
        assertThat(
            MinguoCalendar.of(MinguoEra.ROC, 89, 2, 29).with(MinguoCalendar.DAY_OF_MONTH.incremented()),
            is(MinguoCalendar.of(MinguoEra.ROC, 89, 3, 1)));
        assertThat(
            MinguoCalendar.of(MinguoEra.ROC, 89, 3, 1).with(MinguoCalendar.DAY_OF_WEEK.incremented()),
            is(MinguoCalendar.of(MinguoEra.ROC, 89, 3, 2)));
    }

    @Test
    public void previousDay() {
        assertThat(
            MinguoCalendar.of(MinguoEra.ROC, 89, 3, 2).with(MinguoCalendar.DAY_OF_YEAR.decremented()),
            is(MinguoCalendar.of(MinguoEra.ROC, 89, 3, 1)));
        assertThat(
            MinguoCalendar.of(MinguoEra.ROC, 89, 3, 1).with(MinguoCalendar.DAY_OF_MONTH.decremented()),
            is(MinguoCalendar.of(MinguoEra.ROC, 89, 2, 29)));
        assertThat(
            MinguoCalendar.of(MinguoEra.ROC, 89, 2, 29).with(MinguoCalendar.DAY_OF_WEEK.decremented()),
            is(MinguoCalendar.of(MinguoEra.ROC, 89, 2, 28)));
    }

    @Test
    public void maxDay() {
        assertThat(
            MinguoCalendar.of(MinguoEra.ROC, 89, 2, 21).with(MinguoCalendar.DAY_OF_MONTH.maximized()),
            is(MinguoCalendar.of(MinguoEra.ROC, 89, 2, 29)));
        assertThat(
            MinguoCalendar.of(MinguoEra.ROC, 90, 2, 21).with(MinguoCalendar.DAY_OF_MONTH.maximized()),
            is(MinguoCalendar.of(MinguoEra.ROC, 90, 2, 28)));
    }

    @Test
    public void minDay() {
        assertThat(
            MinguoCalendar.of(MinguoEra.ROC, 89, 2, 21).with(MinguoCalendar.DAY_OF_MONTH.minimized()),
            is(MinguoCalendar.of(MinguoEra.ROC, 89, 2, 1)));
    }

    @Test
    public void yearAtFloor() {
        assertThat(
            MinguoCalendar.of(MinguoEra.ROC, 89, 5, 2).with(MinguoCalendar.YEAR_OF_ERA.atFloor()),
            is(MinguoCalendar.of(MinguoEra.ROC, 89, 1, 1)));
    }

    @Test
    public void yearAtCeiling() {
        assertThat(
            MinguoCalendar.of(MinguoEra.ROC, 89, 5, 2).with(MinguoCalendar.YEAR_OF_ERA.atCeiling()),
            is(MinguoCalendar.of(MinguoEra.ROC, 89, 12, 31)));
    }

    @Test
    public void monthAtFloor() {
        assertThat(
            MinguoCalendar.of(MinguoEra.ROC, 89, 5, 2).with(MinguoCalendar.MONTH_OF_YEAR.atFloor()),
            is(MinguoCalendar.of(MinguoEra.ROC, 89, 5, 1)));
    }

    @Test
    public void monthAtCeiling() {
        assertThat(
            MinguoCalendar.of(MinguoEra.ROC, 89, 5, 2).with(MinguoCalendar.MONTH_OF_YEAR.atCeiling()),
            is(MinguoCalendar.of(MinguoEra.ROC, 89, 5, 31)));
    }

}