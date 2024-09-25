package zus.model.base;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
public class TaxiObject {

    private final int taxiId;
    private final String code;
    private final LocalDate date;
    private final LocalTime time;
    private final int capacity;
    private final String name;

    public TaxiObject(int taxiId, String code, LocalDate date, LocalTime time,int capacity, String name) {
        this.taxiId = taxiId;
        this.code = code;
        this.date = date;
        this.time = time;
        this.capacity = capacity;
        this.name = name;
    }
}
