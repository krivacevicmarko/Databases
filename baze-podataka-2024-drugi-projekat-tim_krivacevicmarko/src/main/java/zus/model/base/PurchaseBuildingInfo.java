package zus.model.base;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class PurchaseBuildingInfo {
    private final String buildingName;
    private final String objectType;
    private final int objectCapacity;
    private LocalDate purchaseDate;
    private final String objectName;

    public PurchaseBuildingInfo(String buildingName, String objectType, int objectCapacity, LocalDate purchaseDate,String objectName) {
        this.buildingName = buildingName;
        this.objectType = objectType;
        this.objectCapacity = objectCapacity;
        this.purchaseDate = purchaseDate;
        this.objectName = objectName;
    }
}

