package org.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Flight> flightsBeforeTimeNow = FlightBuilder.getFlightsBeforeTimeNow(FlightBuilder.createFlights());
        System.out.println("Список рейсов с датой и временем вылета до текущего момента времени");
        System.out.println(flightsBeforeTimeNow);

        List<Flight> flightsArrivalBeforeDeparture = FlightBuilder
                .getFlightsArrivalBeforeDeparture(FlightBuilder.createFlights());
        System.out.println("Список рейсов с датой прилёта более ранней, чем дата вылета");
        System.out.println(flightsArrivalBeforeDeparture);

        List<Flight> flightsMoreTwoHoursGrandTime = FlightBuilder
                .getFlightsMoreTwoHoursGrandTime(FlightBuilder.createFlights());
        System.out.println("Список рейсов, в которых общее время, проведённое на земле, превышает два часа");
        System.out.println(flightsMoreTwoHoursGrandTime);
    }
}