package zus.model.base;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class Purchase {

    private final int purchaseId;
    private final int personId;
    private final int buildingId;
    private LocalDate purchaseDate;

    public Purchase(int purchaseId, int personId, int buildingId, LocalDate purchaseDate) {
        this.purchaseId = purchaseId;
        this.personId = personId;
        this.buildingId = buildingId;
        this.purchaseDate = purchaseDate;
    }
}
