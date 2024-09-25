package zus.model.base;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
public class TaxiTrip {

    private final int taxiId;
    private final String code;
    private final LocalDate date;
    private final LocalTime time;
    private final int numOfPassengers;
    private final String passengerNames;
    private final String name;

    public TaxiTrip(int taxiId, String code, LocalDate date, LocalTime time, int numOfPassengers, String passengerNames, String name) {
        this.taxiId = taxiId;
        this.code = code;
        this.date = date;
        this.time = time;
        this.numOfPassengers = numOfPassengers;
        this.passengerNames = passengerNames;
        this.name = name;
    }
}

