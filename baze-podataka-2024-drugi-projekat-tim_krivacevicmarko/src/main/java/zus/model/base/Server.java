package zus.model.base;

import zus.model.jdbc.JDBCUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Server {
    public static final Server SERVER = new Server();

    private final List<Person> people = new ArrayList<>();
    private final List<Mission> mission = new ArrayList<>();

    private final List<Object> objects = new ArrayList<>();
    private final List<Building> buildings = new ArrayList<>();

    private Server() {
        this.setPeople(JDBCUtils.selectAllFromPerson());
        this.setPlanet(JDBCUtils.selectAllFromMissions());
        this.setObjects(JDBCUtils.selectAllFromObject());
        this.setBuildings(JDBCUtils.selectAllFromBuilding());
    }

    public List<Building> getBuildings() {
        return buildings;
    }

    public List<Mission> getMission() {
        return mission;
    }

    public List<Object> getObjects() {
        return objects;
    }

    public List<Person> getPeople() {
        return people;
    }


    public void setPeople(Collection<Person> people) {
        this.people.clear();
        this.people.addAll(people);
    }

    public void setPlanet(Collection<Mission> mission){
        this.mission.clear();
        this.mission.addAll(mission);
    }

    public void setObjects(Collection<Object> objects){
        this.objects.clear();
        this.objects.addAll(objects);
    }
    public void setBuildings(Collection<Building> buildings){
        this.buildings.clear();
        this.buildings.addAll(buildings);
    }

}

