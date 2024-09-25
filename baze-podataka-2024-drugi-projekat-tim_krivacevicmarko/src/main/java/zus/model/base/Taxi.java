package zus.model.base;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
public class Taxi {

    private final int taxiId;

    private final String vehicleCode;

    private final LocalDate date;

    private final LocalTime time;

    private final int capacity;

    private final int objectId;

    public Taxi(int taxiId, String vehicleCode, LocalDate date, LocalTime time, int capacity, int objectId) {
        this.taxiId = taxiId;
        this.vehicleCode = vehicleCode;
        this.date = date;
        this.time = time;
        this.capacity = capacity;
        this.objectId = objectId;
    }
}

