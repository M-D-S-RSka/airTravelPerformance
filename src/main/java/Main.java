import fileReader.FileReader;
import model.Ticket;
import service.TicketService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String ORIGIN_NAME = "Владивосток";
    private static final String DESTINATION_NAME = "Тель-Авив";

    public static void main(String[] args) {

        ArrayList<Ticket> tickets = FileReader.readFileContents();
        Map<String, Integer> minTimeMap = new HashMap<>();
        List<Integer> prices = new ArrayList<>();
        int totalPrices = 0;

        for (Ticket ticket : tickets) {
            if (ticket.getOriginName().equals(ORIGIN_NAME) && ticket.getDestinationName().equals(DESTINATION_NAME)) {
                int price = ticket.getPrice();
                int time = TicketService.timeFinder(ticket);
                prices.add(price);
                totalPrices += price;
                minTimeMap.compute(ticket.getCarrier(), (t, existingTime) -> existingTime == null ?
                        time : Math.min(existingTime, time));
            }
        }

        TicketService.printMinFlightTimes(minTimeMap);
        System.out.println(" \n");
        prices.sort(Integer::compareTo);
        int median = TicketService.calculateDifferenceMedianAndAveragePrice(prices);
        int avg = totalPrices / prices.size();
        System.out.println("Difference between the average price and the median: " + (avg - median));
    }
}