package org.example;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Factory class to get sample list of flights.
 */
public class FlightBuilder {

    public static final LocalDateTime THREE_DAYS_FROM_NOW = LocalDateTime.now().plusDays(3);

    public static List<Flight> createFlights() {
        return Arrays.asList(

                // A normal flight with two hour duration
                // Обычный рейс продолжительностью два часа
                createFlight(THREE_DAYS_FROM_NOW, THREE_DAYS_FROM_NOW.plusHours(2)),

                // A normal multi segment flight
                // Обычный много сегментный рейс
                createFlight(THREE_DAYS_FROM_NOW, THREE_DAYS_FROM_NOW.plusHours(2),
                        THREE_DAYS_FROM_NOW.plusHours(3), THREE_DAYS_FROM_NOW.plusHours(5)),

                // A flight departing in the past
                // Рейс с прошедшей датой вылета
                createFlight(THREE_DAYS_FROM_NOW.minusDays(6), THREE_DAYS_FROM_NOW),

                // A flight that departs before it arrives
                // Рейс с датой прилета более ранней, чем дата вылета
                createFlight(THREE_DAYS_FROM_NOW, THREE_DAYS_FROM_NOW.minusHours(6)),

                // A flight with more than two hours ground time
                // Рейс с нахождением на земле более двух часов
                createFlight(THREE_DAYS_FROM_NOW, THREE_DAYS_FROM_NOW.plusHours(2),
                        THREE_DAYS_FROM_NOW.plusHours(5), THREE_DAYS_FROM_NOW.plusHours(6)),

                // Another flight with more than two hours ground time
                // Еще один рейс с нахождением на земле более двух часов
                createFlight(THREE_DAYS_FROM_NOW, THREE_DAYS_FROM_NOW.plusHours(2),
                        THREE_DAYS_FROM_NOW.plusHours(3), THREE_DAYS_FROM_NOW.plusHours(4),
                        THREE_DAYS_FROM_NOW.plusHours(6), THREE_DAYS_FROM_NOW.plusHours(7)));
    }

    private static Flight createFlight(final LocalDateTime... dates) {
        if ((dates.length % 2) != 0) {
            throw new IllegalArgumentException(
                    "you must pass an even number of dates");
            // Вы должны передать четное количество дат
        }
        List<Segment> segments = new ArrayList<>(dates.length / 2);
        for (int i = 0; i < (dates.length - 1); i += 2) {
            segments.add(new Segment(dates[i], dates[i + 1]));
        }
        return new Flight(segments);
    }

    /**
     * Получение списка рейсов с датой и временем вылета до текущего момента времени.
     */
    public static List<Flight> getFlightsBeforeTimeNow(List<Flight> flights) {

        List<Flight> newFlights = new ArrayList<>();
        for (Flight flight : flights) {
            for (Segment segment : flight.getSegments()) {
                if (segment.getDepartureDate().isBefore(THREE_DAYS_FROM_NOW)) {
                    newFlights.add(flight);
                }
            }
        }
        return newFlights;
    }

    /**
     * Получение списка рейсов с датой прилёта более ранней, чем дата вылета.
     */
    public static List<Flight> getFlightsArrivalBeforeDeparture(List<Flight> flights) {

        List<Flight> newFlights = new ArrayList<>();
        for (Flight flight : flights) {
            for (Segment segment : flight.getSegments()) {
                if (segment.getDepartureDate().isAfter(segment.getArrivalDate())) {
                    newFlights.add(flight);
                }
            }
        }
        return newFlights;
    }

    /**
     * Получение списка рейсов, в которых общее время, проведённое на земле, превышает два часа
     * (время на земле — это интервал между прилётом одного сегмента и вылетом следующего за ним).
     */
    public static List<Flight> getFlightsMoreTwoHoursGrandTime(List<Flight> flights) {

        List<Flight> newFlights = new ArrayList<>();
        long totalGrandTime = 0;
        for (Flight flight : flights) {
            List<Segment> segments = flight.getSegments();
            int size = segments.size();
            if (size > 1) {
                for (int i = 0; i < size - 1; i++) {
                    long minutesBetween = getGrandTime(segments.get(i).getArrivalDate(),
                            segments.get(i + 1).getDepartureDate());
                    totalGrandTime += minutesBetween;
                }
                if (totalGrandTime > 120) {
                    newFlights.add(flight);
                }
            }
        }
        return newFlights;
    }

    /**
     * Получение времени в минутах между временем прилета одного сегмента и временем вылета из другого сегмента.
     */
    private static long getGrandTime(LocalDateTime startDateTime, LocalDateTime endDateTime) {
        return ChronoUnit.MINUTES.between(startDateTime, endDateTime);
    }
}
