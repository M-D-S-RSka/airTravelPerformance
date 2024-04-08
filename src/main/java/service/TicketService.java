package service;

import model.Ticket;

import java.time.Duration;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.List;
import java.util.Map;

public class TicketService {

    public static int calculateDifferenceMedianAndAveragePrice(List<Integer> prices) {
        List<Integer> sortedList = prices
                .stream()
                .sorted()
                .toList();

        int sortedSize = sortedList.size();
        if (sortedSize % 2 == 0) {
            return (sortedList.get(sortedSize / 2) + sortedList.get(sortedSize / 2 - 1)) / 2;
        } else {
            return sortedList.get((sortedSize - 1) / 2);
        }
    }

    public static void printMinFlightTimes(Map<String, Integer> minTimeMap) {
        for (Map.Entry<String, Integer> entry : minTimeMap.entrySet()) {
            String ticket = entry.getKey();
            Integer timeInMinutes = entry.getValue();
            int hours = timeInMinutes / 60;
            int minutes = timeInMinutes % 60;
            String formattedTime = String.format("Minimum flight time for airline %s: %02d:%02d", ticket, hours, minutes);
            System.out.println(formattedTime);
        }
    }

    public static int timeFinder(Ticket ticket) {
        OffsetDateTime departureDateTime = OffsetDateTime.of(ticket.getDepartureDate(), ticket.getDepartureTime(),
                ZoneOffset.of("+10:00"));
        OffsetDateTime arrivalDateTime = OffsetDateTime.of(ticket.getArrivalDate(), ticket.getArrivalTime(),
                ZoneOffset.of("+03:00"));
        Duration timeDifference = Duration.between(departureDateTime, arrivalDateTime);
        return (int) timeDifference.toMinutes();
    }
}