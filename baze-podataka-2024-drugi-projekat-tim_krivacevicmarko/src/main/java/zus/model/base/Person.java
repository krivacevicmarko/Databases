package zus.model.base;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Person {

    private final int personId;
    private String name;
    private String surname;
    private String username;
    private String password;

    public Person(int personId, String name, String surname, String username, String password) {
        this.personId = personId;
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.password = password;
    }
}
