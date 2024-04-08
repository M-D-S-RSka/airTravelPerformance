package fileReader;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.Ticket;
import typeAdapter.LocalDateTypeAdapter;
import typeAdapter.LocalTimeTypeAdapter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class FileReader {
    static String PATH = "src/main/resources/tickets.json";

    static Gson gson = new GsonBuilder()
            .registerTypeAdapter(LocalDate.class, new LocalDateTypeAdapter())
            .registerTypeAdapter(LocalTime.class, new LocalTimeTypeAdapter())
            .create();

    public static ArrayList<Ticket> readFileContents() {
        String json;
        try {
            json = new String(Files.readAllBytes(Paths.get(PATH)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        TicketWrapper ticketWrapper;
        ticketWrapper = gson.fromJson(json, TicketWrapper.class);
        return ticketWrapper.getTickets();
    }
}