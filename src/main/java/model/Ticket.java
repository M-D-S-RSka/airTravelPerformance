package model;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class Ticket {

    private String origin;

    @SerializedName("origin_name")
    private String originName;

    private String destination;

    @SerializedName("destination_name")
    private String destinationName;

    @SerializedName("departure_date")
    private LocalDate departureDate;

    @SerializedName("departure_time")
    private LocalTime departureTime;

    @SerializedName("arrival_date")
    private LocalDate arrivalDate;

    @SerializedName("arrival_time")
    private LocalTime arrivalTime;

    private String carrier;

    private int stops;

    private int price;
}