package my.rinat.kata.datetime.calendarkata;

import org.assertj.core.api.Assertions;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.set.sorted.SortedSetIterable;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.threeten.extra.Interval;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.TimeZone;

class MyCalendarTest {

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
        Assertions.assertThat(
                this.calendar.hasOverlappingMeeting(
                        LocalDate.of(2017, 7, 7),
                        LocalTime.NOON,
                        Duration.ofHours(1)
                )).isTrue();
    }

    @Test
    void getMeetingsForDate() {
        SortedSetIterable<Meeting> meetingsForJuly6 = this.calendar.getMeetingsForDate(LocalDate.of(2017, 7, 6));
        Assertions.assertThat((Iterable<Meeting>) meetingsForJuly6).hasSize(1);
        System.out.println(meetingsForJuly6);
    }

    @Test
    void getMeetingsForWorkWeekOf() {
        final WorkWeek week = this.calendar.getMeetingsForWorkWeekOf(LocalDate.of(2017, 7, 6));
        Assertions.assertThat(week.getNumberOfMeetings()).isEqualTo(4);
        System.out.println(week);
    }

    @Test
    void getMeetingsForFullWeekOf() {
        final FullWeek week = this.calendar.getMeetingsForFullWeekOf(LocalDate.of(2017, 7, 6));
        Assertions.assertThat(week.getNumberOfMeetings()).isEqualTo(6);
        System.out.println(week);
    }

    @Test
    void getMeetingsForMonthOf() {
        FullMonth month = this.calendar.getMeetingsForYearMonth(2017, Month.JULY);
        Assertions.assertThat(month.getNumberOfMeetings()).isEqualTo(6);
        System.out.println(month);
    }

    @Test
    void getAvailableTimeslots() {
        MutableList<Interval> availableTimeslots1 = this.calendar.getAvailableTimeslots(LocalDate.of(2017, 7, 6));
        Assertions.assertThat(availableTimeslots1).hasSize(2);
        System.out.println(availableTimeslots1);
        MutableList<Interval> availableTimeslots2 = this.calendar.getAvailableTimeslots(LocalDate.of(2017, 7, 1));
        Assertions.assertThat(availableTimeslots2).hasSize(1);
        System.out.println(availableTimeslots2);
    }
}
