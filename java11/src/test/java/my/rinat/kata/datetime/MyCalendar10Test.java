package my.rinat.kata.datetime;

import my.rinat.kata.datetime.calendarkata10.MyCalendar;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.TimeZone;

class MyCalendar10Test {
    private MyCalendar calendar;

    /**
     * Do not change this method!  The tests will fail due to overlapping meetings.  Implement the logic in
     * MyCalendar to check for overlapping meetings.
     *
     * @see MyCalendar#hasOverlappingMeeting(LocalDate, LocalTime, Duration) )
     */
    @BeforeEach
    void setUp() {
        this.calendar = new MyCalendar(TimeZone.getTimeZone("UTC"));
        this.setupWeekendMeetings();
        this.setupOverlappingWeekendMeetings();
        this.setupWeekdayMeetings();
        this.setupOverlappingWeekdayMeetings();
    }

    /**
     * Do not change this method!
     */
    private void setupWeekendMeetings() {
        this.calendar.addMeeting("Soccer Match",
                LocalDate.of(2017, 7, 2),
                LocalTime.of(13, 0),
                Duration.ofHours(2));
        this.calendar.addMeeting("Swimming Championship",
                LocalDate.of(2017, 7, 8),
                LocalTime.of(13, 0),
                Duration.ofHours(2));
    }

    /**
     * Do not change this method!
     */
    private void setupOverlappingWeekendMeetings() {
        this.calendar.addMeeting("Soccer Match",
                LocalDate.of(2017, 7, 2),
                LocalTime.of(12, 30),
                Duration.ofHours(1));
        this.calendar.addMeeting("Swimming Championship",
                LocalDate.of(2017, 7, 8),
                LocalTime.of(12, 30),
                Duration.ofHours(1));
    }

    /**
     * Do not change this method!
     */
    private void setupWeekdayMeetings() {
        this.calendar.addMeeting("Lunch",
                LocalDate.of(2017, 7, 3),
                LocalTime.NOON,
                Duration.ofHours(1));
        this.calendar.addMeeting("Lunch",
                LocalDate.of(2017, 7, 5),
                LocalTime.NOON,
                Duration.ofHours(1));
        this.calendar.addMeeting("Lunch",
                LocalDate.of(2017, 7, 6),
                LocalTime.NOON,
                Duration.ofHours(1));
        this.calendar.addMeeting("Lunch",
                LocalDate.of(2017, 7, 7),
                LocalTime.NOON,
                Duration.ofHours(1));
    }

    /**
     * Do not change this method!
     */
    private void setupOverlappingWeekdayMeetings() {
        this.calendar.addMeeting("Lunch",
                LocalDate.of(2017, 7, 3),
                LocalTime.NOON.plusMinutes(30),
                Duration.ofHours(1));
        this.calendar.addMeeting("Lunch",
                LocalDate.of(2017, 7, 5),
                LocalTime.NOON.plusMinutes(30),
                Duration.ofHours(1));
        this.calendar.addMeeting("Lunch",
                LocalDate.of(2017, 7, 6),
                LocalTime.NOON.plusMinutes(30),
                Duration.ofHours(1));
        this.calendar.addMeeting("Lunch",
                LocalDate.of(2017, 7, 7),
                LocalTime.NOON.plusMinutes(30),
                Duration.ofHours(1));
    }

    @Test
    void printCalendar() {
        System.out.println(this.calendar);
    }

    /**
     * Implement the {@link MyCalendar#hasOverlappingMeeting(LocalDate, LocalTime, Duration)} method.
     */
    @Test
    void hasOverlappingMeeting() {
        /*
        fixme:
        Assert.assertTrue(this.calendar.hasOverlappingMeeting(
                LocalDate.of(2017, 7, 7),
                LocalTime.NOON,
                Duration.ofHours(1)));*/
    }

    @Test
    void getMeetingsForDate() {
        /*
        fixme:
        var meetingsForJuly6 = this.calendar.getMeetingsForDate(LocalDate.of(2017, 7, 6));
        Verify.assertSize(1, meetingsForJuly6);
        System.out.println(meetingsForJuly6);*/
    }

    @Test
    void getMeetingsForWorkWeekOf() {
        /*
        fixme:
        var workWeek = this.calendar.getMeetingsForWorkWeekOf(LocalDate.of(2017, 7, 6));
        Assert.assertEquals(4, workWeek.getNumberOfMeetings());
        System.out.println(workWeek);*/
    }

    @Test
    void getMeetingsForFullWeekOf() {
        /*
        fixme:
        var fullWeek = this.calendar.getMeetingsForFullWeekOf(LocalDate.of(2017, 7, 6));
        Assert.assertEquals(6, fullWeek.getNumberOfMeetings());
        System.out.println(fullWeek);*/
    }

    @Test
    void getMeetingsForMonthOf() {
        /*
        fixme:
        var fullMonth = this.calendar.getMeetingsForYearMonth(2017, Month.JULY);
        Assert.assertEquals(6, fullMonth.getNumberOfMeetings());
        System.out.println(fullMonth);*/
    }

    @Test
    void getAvailableTimeslots() {
        /*
        fixme:
        var availableTimeslots1 = this.calendar.getAvailableTimeslots(LocalDate.of(2017, 7, 6));
        Assert.assertEquals(2, availableTimeslots1.size());
        System.out.println(availableTimeslots1);
        var availableTimeslots2 = this.calendar.getAvailableTimeslots(LocalDate.of(2017, 7, 1));
        Assert.assertEquals(1, availableTimeslots2.size());
        System.out.println(availableTimeslots2);*/
    }
}
