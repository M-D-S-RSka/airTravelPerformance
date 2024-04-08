package fileReader;

import model.Ticket;

import java.util.ArrayList;
import java.util.List;

public class TicketWrapper {
    private List<Ticket> tickets;

    public ArrayList<Ticket> getTickets() {
        return (ArrayList<Ticket>) tickets;
    }
}