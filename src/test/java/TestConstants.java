import org.example.Segment;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TestConstants {

    public static final LocalDateTime THREE_DAYS_FROM_NOW = LocalDateTime.now().plusDays(3);

    public static final LocalDateTime DEPARTURE_DATE_1 = THREE_DAYS_FROM_NOW;
    public static final LocalDateTime ARRIVAL_DATE_1 = THREE_DAYS_FROM_NOW.plusHours(2);
    public static final Segment SEGMENT_1 = new Segment(DEPARTURE_DATE_1, ARRIVAL_DATE_1);

    public static final LocalDateTime DEPARTURE_DATE_2 = THREE_DAYS_FROM_NOW.plusHours(3);
    public static final LocalDateTime ARRIVAL_DATE_2 = THREE_DAYS_FROM_NOW.plusHours(5);
    public static final Segment SEGMENT_2 = new Segment(DEPARTURE_DATE_2, ARRIVAL_DATE_2);

    public static final LocalDateTime DEPARTURE_DATE_3 = THREE_DAYS_FROM_NOW.minusDays(6);
    public static final LocalDateTime ARRIVAL_DATE_3 = THREE_DAYS_FROM_NOW;
    public static final Segment SEGMENT_3 = new Segment(DEPARTURE_DATE_3, ARRIVAL_DATE_3);

    public static final LocalDateTime DEPARTURE_DATE_4 = THREE_DAYS_FROM_NOW;
    public static final LocalDateTime ARRIVAL_DATE_4 = THREE_DAYS_FROM_NOW.minusHours(6);
    public static final Segment SEGMENT_4 = new Segment(DEPARTURE_DATE_4, ARRIVAL_DATE_4);

    public static final LocalDateTime DEPARTURE_DATE_5 = THREE_DAYS_FROM_NOW.plusHours(5);
    public static final LocalDateTime ARRIVAL_DATE_5 = THREE_DAYS_FROM_NOW.plusHours(6);
    public static final Segment SEGMENT_5 = new Segment(DEPARTURE_DATE_5, ARRIVAL_DATE_5);

    public static final LocalDateTime DEPARTURE_DATE_6 = THREE_DAYS_FROM_NOW.plusHours(3);
    public static final LocalDateTime ARRIVAL_DATE_6 = THREE_DAYS_FROM_NOW.plusHours(4);
    public static final Segment SEGMENT_6 = new Segment(DEPARTURE_DATE_6, ARRIVAL_DATE_6);

    public static final LocalDateTime DEPARTURE_DATE_7 = THREE_DAYS_FROM_NOW.plusHours(6);
    public static final LocalDateTime ARRIVAL_DATE_7 = THREE_DAYS_FROM_NOW.plusHours(7);
    public static final Segment SEGMENT_7 = new Segment(DEPARTURE_DATE_7, ARRIVAL_DATE_7);

    public static final List<Segment> SEGMENTS_1 = new ArrayList<>() {{
        add(SEGMENT_1);
    }};

    public static final List<Segment> SEGMENTS_2 = new ArrayList<>() {{
        add(SEGMENT_1);
        add(SEGMENT_2);
    }};

    public static final List<Segment> SEGMENTS_3 = new ArrayList<>() {{
        add(SEGMENT_3);
    }};

    public static final List<Segment> SEGMENTS_4 = new ArrayList<>() {{
        add(SEGMENT_4);
    }};

    public static final List<Segment> SEGMENTS_5 = new ArrayList<>() {{
        add(SEGMENT_1);
        add(SEGMENT_5);
    }};

    public static final List<Segment> SEGMENTS_6 = new ArrayList<>() {{
        add(SEGMENT_1);
        add(SEGMENT_6);
        add(SEGMENT_7);
    }};

}
