package zus.model.base;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Building {

    private final int buildingId;

    private String buildingName;

    private final int objectId;

    private String objectType;

    private int objectCapacity;

    public Building(int buildingId, String buildingName, int objectId, String objectType, int objectCapacity) {
        this.buildingId = buildingId;
        this.buildingName = buildingName;
        this.objectId = objectId;
        this.objectType = objectType;
        this.objectCapacity = objectCapacity;
    }
}
