package zus.model.base;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Object {

    private final int objectId;
    private String name;
    private String type;
    private int nummOfMissions;


    public Object(int objectId, String name, String type, int nummOfMissions) {
        this.objectId = objectId;
        this.name = name;
        this.type = type;
        this.nummOfMissions = nummOfMissions;
    }
}
