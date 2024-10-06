import org.example.Flight;
import org.example.FlightBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class FlightBuilderTest {

    private Flight flight1;
    private Flight flight2;
    private Flight flight3;
    private Flight flight4;
    private Flight flight5;
    private Flight flight6;
    private final List<Flight> flights = new ArrayList<>();

    @BeforeEach
    public void setUp() {

        flight1 = new Flight(TestConstants.SEGMENTS_1);
        flight2 = new Flight(TestConstants.SEGMENTS_2);
        flight3 = new Flight(TestConstants.SEGMENTS_3);
        flight4 = new Flight(TestConstants.SEGMENTS_4);
        flight5 = new Flight(TestConstants.SEGMENTS_5);
        flight6 = new Flight(TestConstants.SEGMENTS_6);
        Collections.addAll(flights, flight1, flight2, flight3, flight4, flight5, flight6);
    }

    @Test
    void testCreateFlights_CorrectParameters_Success() {

        List<Flight> actual = FlightBuilder.createFlights();
        Flight actual1 = actual.get(0);
        Flight actual2 = actual.get(1);
        Flight actual3 = actual.get(2);
        Flight actual4 = actual.get(3);
        Flight actual5 = actual.get(4);
        Flight actual6 = actual.get(5);

        assertEquals(flights.size(), actual.size());
        assertEquals(flight1.getSegments().size(), actual1.getSegments().size());
        assertEquals(flight2.getSegments().size(), actual2.getSegments().size());
        assertEquals(flight3.getSegments().size(), actual3.getSegments().size());
        assertEquals(flight4.getSegments().size(), actual4.getSegments().size());
        assertEquals(flight5.getSegments().size(), actual5.getSegments().size());
        assertEquals(flight6.getSegments().size(), actual6.getSegments().size());

//        assertAll("Сложный сценарий сравнения списка рейсов",
//                () -> assertEquals(flights.get(0), actual.get(0)),
//                () -> assertEquals(flights.get(1), actual.get(1)),
//                () -> assertEquals(flights.get(2), actual.get(2)),
//                () -> assertEquals(flights.get(3), actual.get(3)),
//                () -> assertEquals(flights.get(4), actual.get(4)),
//                () -> assertEquals(flights.get(5), actual.get(5))
//        );
    }

    @Test
    void testGetFlightsBeforeTimeNow_CorrectParameters_Success() {

        List<Flight> expected = new ArrayList<>();
        expected.add(flight3);

        List<Flight> actual = FlightBuilder.getFlightsBeforeTimeNow(FlightBuilder.createFlights());
        Flight actual3 = actual.get(0);

        assertEquals(expected.size(), actual.size());
        assertEquals(flight3.getSegments().size(), actual3.getSegments().size());
    }

    @Test
    void testFlightsArrivalBeforeDeparture_CorrectParameters_Success() {

        List<Flight> expected = new ArrayList<>();
        expected.add(flight4);

        List<Flight> actual = FlightBuilder.getFlightsArrivalBeforeDeparture(flights);
        Flight actual4 = actual.get(0);

        assertEquals(expected.size(), actual.size());
        assertEquals(expected, actual);
        assertEquals(flight4.getSegments().size(), actual4.getSegments().size());
        assertEquals(flight4.getSegments(), actual4.getSegments());
    }

    @Test
    void testFlightsMoreTwoHoursGrandTime_CorrectParameters_Success() {

        List<Flight> expected = new ArrayList<>();
        Collections.addAll(expected, flight5, flight6);

        List<Flight> actual = FlightBuilder.getFlightsMoreTwoHoursGrandTime(flights);
        Flight actual5 = actual.get(0);
        Flight actual6 = actual.get(1);

        assertEquals(expected.size(), actual.size());
        assertAll("Сложный сценарий сравнения списка рейсов",
                () -> assertEquals(expected.get(0), actual.get(0)),
                () -> assertEquals(expected.get(1), actual.get(1))

        );
        assertEquals(flight5.getSegments().size(), actual5.getSegments().size());
        assertAll("Сложный сценарий сравнения пятого рейса",
                () -> assertEquals(flight5.getSegments().get(0), actual5.getSegments().get(0)),
                () -> assertEquals(flight5.getSegments().get(1), actual5.getSegments().get(1))

        );
        assertEquals(flight6.getSegments().size(), actual6.getSegments().size());
        assertAll("Сложный сценарий сравнения шестого рейса",
                () -> assertEquals(flight6.getSegments().get(0), actual6.getSegments().get(0)),
                () -> assertEquals(flight6.getSegments().get(1), actual6.getSegments().get(1)),
                () -> assertEquals(flight6.getSegments().get(2), actual6.getSegments().get(2))
        );
    }
}
