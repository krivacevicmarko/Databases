package zus.model.jdbc;

import javafx.scene.control.Alert;
import zus.model.base.*;
import zus.model.base.Object;

import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class JDBCUtils {
    public static Connection connection = null;

    public static void connect() {
        Properties properties = new Properties();
        properties.put("user", "root");
        properties.put("password", "");
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/zzuuss", properties);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    ///Method for getting all data from Person
    public static List<Person> selectAllFromPerson() {
        List<Person> people = new ArrayList<>();
        String query = "select * from person";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            // iterator za kretanje po podacima
            while (resultSet.next()) {
                int personId = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String surname = resultSet.getString(3);
                String username = resultSet.getString(4);
                String password = resultSet.getString(5);
                Person person = new Person(personId, name, surname, username,password);
                people.add(person);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return people;
    }

    //Method for login
    public static Person login(String username, String password) {
        String query = "select * from person where username = ? and password = ?";
        Person person = null;
        try {
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setString(1, username);
            statement.setString(2, password);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int personId = resultSet.getInt("personId");
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                String user = resultSet.getString("username");
                String pass = resultSet.getString("password");
                person = new Person(personId, name, surname, user, pass);
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Login Failed");
                alert.setHeaderText(null);
                alert.setContentText("No person found with the given credentials.");
                alert.showAndWait();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return person;
    }

    //method for registration
    public static void insertIntoPerson(String name, String surname, String username,String password) {
        String query = "insert into person (name, surname, username, password)" +
                "values (?, ?, ?, ?)";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            connection.setAutoCommit(false);
            statement.setString(1, name);
            statement.setString(2, surname);
            statement.setString(3, username);
            statement.setString(4, password);
            statement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    //method for getting all data from missions
    public static List<Mission> selectAllFromMissions() {
        List<Mission> missions = new ArrayList<>();
        String query = "select * from mission";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int missionId = resultSet.getInt(1);
                String missionName = resultSet.getString(2);
                LocalDate endOfMission = resultSet.getDate(3).toLocalDate();
                int planetId = resultSet.getInt(4);
                int averageDistanceToStarKm = resultSet.getInt(5);
                int lowestTemperatureKelvin = resultSet.getInt(6);
                int highestTemperatureKelvin = resultSet.getInt(7);
                double oxygenPercentage = resultSet.getDouble(8);
                String otherGasName = resultSet.getString(9);
                double otherGasPercentage = resultSet.getDouble(10);
                int maxGravityHeightKm = resultSet.getInt(11);
                double orbitalSpeedKms = resultSet.getDouble(12);
                int deathsUnder40LastYear = resultSet.getInt(13);
                boolean isHabitable = resultSet.getBoolean(14);
                Mission mission = new Mission(missionId,missionName,endOfMission,planetId, averageDistanceToStarKm, lowestTemperatureKelvin, highestTemperatureKelvin, oxygenPercentage, otherGasName, otherGasPercentage, maxGravityHeightKm, orbitalSpeedKms, deathsUnder40LastYear, isHabitable);
                missions.add(mission);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return missions;
    }

    //method for getting all data from object
    public static List<Object> selectAllFromObject(){
        List<Object> allObjects = new ArrayList<>();
        String querry = "select * from object";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(querry);
            while (resultSet.next()){
                int objectId = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String type = resultSet.getString(3);
                int numoffMissions = resultSet.getInt(4);
                Object object = new Object(objectId,name,type,numoffMissions);
                allObjects.add(object);
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return allObjects;
    }

    //method for getting all data from mission with objectId
    public static List<Mission> selectFromMissionViaId(int objectId){
        String qurry = "select * from mission where objectId = ?";
        List<Mission> missions = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(qurry);
            statement.setInt(1,objectId);

            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                int missionId = resultSet.getInt(1);
                String missionName = resultSet.getString(2);
                LocalDate endOfMission = resultSet.getDate(3).toLocalDate();
                int planetId = resultSet.getInt(4);
                int averageDistanceToStarKm = resultSet.getInt(5);
                int lowestTemperatureKelvin = resultSet.getInt(6);
                int highestTemperatureKelvin = resultSet.getInt(7);
                double oxygenPercentage = resultSet.getDouble(8);
                String otherGasName = resultSet.getString(9);
                double otherGasPercentage = resultSet.getDouble(10);
                int maxGravityHeightKm = resultSet.getInt(11);
                double orbitalSpeedKms = resultSet.getDouble(12);
                int deathsUnder40LastYear = resultSet.getInt(13);
                boolean isHabitable = resultSet.getBoolean(14);
                Mission mission = new Mission(missionId,missionName,endOfMission,planetId, averageDistanceToStarKm, lowestTemperatureKelvin, highestTemperatureKelvin, oxygenPercentage, otherGasName, otherGasPercentage, maxGravityHeightKm, orbitalSpeedKms, deathsUnder40LastYear, isHabitable);
                missions.add(mission);
            }

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return missions;
    }

    //method for getting all data from buildings
    public static List<Building> selectAllFromBuilding(){
        List<Building> allBuildings = new ArrayList<>();
        String querry = "select * from building";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(querry);
            while (resultSet.next()){
                int buildingId = resultSet.getInt(1);
                String name = resultSet.getString(2);
                int objectId = resultSet.getInt(3);
                String type = resultSet.getString(4);
                int numoffMissions = resultSet.getInt(5);
                Building building = new Building(buildingId,name,objectId,type,numoffMissions);
                allBuildings.add(building);
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return allBuildings;
    }

    //method for getting all data from buildings with objectId
    public static List<Building> selectFromBuildingViaObjectId(int objectId){
        List<Building> buildings = new ArrayList<>();
        String qurry = "select * from building where objectID = ?";
        try{
            PreparedStatement statement = connection.prepareStatement(qurry);
            statement.setInt(1,objectId);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                int buildingId = resultSet.getInt(1);
                String name = resultSet.getString(2);
                int objtId = resultSet.getInt(3);
                String type = resultSet.getString(4);
                int capacity = resultSet.getInt(5);
                Building building = new Building(buildingId,name,objtId,type,capacity);
                buildings.add(building);
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return buildings;
    }

    //method for getting all data from purchases
    public static List<Purchase> selectAllFromPurchase(){
        List<Purchase> purchases = new ArrayList<>();
        String qurry = "select * from purchase";
        try{
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(qurry);
            while(resultSet.next()){
                int purchaseID = resultSet.getInt(1);
                int personID = resultSet.getInt(2);
                int buildingID = resultSet.getInt(3);
                LocalDate date = resultSet.getDate(4).toLocalDate();
                Purchase purchase = new Purchase(purchaseID,personID,buildingID,date);
                purchases.add(purchase);
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return purchases;
    }

    //method for inserting all data to purchase
    public static void insertIntoPurchase(int personId,int buildingId,LocalDate date){
        String querry = "insert into purchase (personID, buildingID, purchaseDate)" +
                "values(?, ?, str_to_date(?,'%m/%d/%Y'))";
        try {
            PreparedStatement statement = connection.prepareStatement(querry);
            connection.setAutoCommit(false);
            statement.setInt(1,personId);
            statement.setInt(2,buildingId);
            statement.setString(3,
                    date.getMonthValue() + "/" +
                            date.getDayOfMonth() + "/" + date.getYear());
            statement.executeUpdate();
            connection.commit();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    //method for getting data for PurchaseBuildingTable data using join with personId on buildingId and objectId
    public static List<PurchaseBuildingInfo> selectFromBuildingAndPurchase(int personId){
        String query = "select b.buildingName, b.objectType, b.objectCapacity, p.purchaseDate, o.name " +
                "from purchase p " +
                "join building b on p.buildingId = b.buildingId " +
                "join object o on b.objectId = o.objectId " +
                "where p.personId = ?";
        List<PurchaseBuildingInfo> purchaseBuildingInfos = new ArrayList<>();
        try{
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1,personId);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                String buildingName = resultSet.getString(1);
                String objectType = resultSet.getString(2);
                int capacity = resultSet.getInt(3);
                LocalDate date = resultSet.getDate(4).toLocalDate();
                String objectName = resultSet.getString(5);
                PurchaseBuildingInfo purchase = new PurchaseBuildingInfo(buildingName,objectType,capacity,date,objectName);
                purchaseBuildingInfos.add(purchase);
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return purchaseBuildingInfos;
    }

    public static List<Taxi> selectAllFromTaxi(){
        List<Taxi> taxis = new ArrayList<>();
        String querry = "select * from taxi";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(querry);
            while (resultSet.next()){
                int taxiId = resultSet.getInt(1);
                String code = resultSet.getString(2);
                LocalDate date = resultSet.getDate(3).toLocalDate();
                LocalTime time = resultSet.getTime(4).toLocalTime();
                int capacity = resultSet.getInt(5);
                int objectId = resultSet.getInt(6);
                Taxi taxi = new Taxi(taxiId,code,date,time,capacity,objectId);
                taxis.add(taxi);
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return taxis;
    }

    //method for getting data for TaxiObjectTable data using join on object.id
    public static List<TaxiObject> selectAllFromTaxiAndObject(){
        List<TaxiObject> taxis = new ArrayList<>();
        String querry = "select t.taxiID, t.vehicleCode, t.travelDate, t.travelTime, t.capacity, o.name" +
                " from taxi t" +
                " join object o on t.objectID = o.objectID";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(querry);
            while (resultSet.next()){
                int taxiId = resultSet.getInt(1);
                String code = resultSet.getString(2);
                LocalDate date = resultSet.getDate(3).toLocalDate();
                LocalTime time = resultSet.getTime(4).toLocalTime();
                int capacity = resultSet.getInt(5);
                String name = resultSet.getString(6);
                TaxiObject taxi = new TaxiObject(taxiId,code,date,time,capacity,name);
                taxis.add(taxi);
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return taxis;
    }

    public static List<TaxiObject> selectAllFromTaxiAndObjectViaDate(LocalDate localDate){
        List<TaxiObject> taxis = new ArrayList<>();
        String querry = "select t.taxiID, t.vehicleCode, t.travelDate, t.travelTime, t.capacity, o.name" +
                " from taxi t" +
                " join object o on t.objectID = o.objectID where t.travelDate = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(querry);
            statement.setDate(1,java.sql.Date.valueOf(localDate));
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                int taxiId = resultSet.getInt(1);
                String code = resultSet.getString(2);
                LocalDate date = resultSet.getDate(3).toLocalDate();
                LocalTime time = resultSet.getTime(4).toLocalTime();
                int capacity = resultSet.getInt(5);
                String name = resultSet.getString(6);
                TaxiObject taxi = new TaxiObject(taxiId,code,date,time,capacity,name);
                taxis.add(taxi);
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return taxis;
    }

    //method for getting data for TaxiObjectTable data using join on buildingId,objectId with personId

    public static List<TaxiObject> selectFromTaxiAndObjectAndPurchase(int personId){
        String query = "select distinct t.taxiID, t.vehicleCode, t.travelDate, t.travelTime, t.capacity, o.name" +
                " from purchase p" +
                " join building b on p.buildingID = b.buildingID" +
                " join taxi t on b.objectID = t.objectID" +
                " join object o on t.objectID = o.objectID" +
                " where p.personID = ?";
        List<TaxiObject> taxiObjects = new ArrayList<>();
        try{
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1,personId);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                int taxiId = resultSet.getInt(1);
                String code = resultSet.getString(2);
                LocalDate date = resultSet.getDate(3).toLocalDate();
                LocalTime time = resultSet.getTime(4).toLocalTime();
                int capacity = resultSet.getInt(5);
                String name = resultSet.getString(6);
                TaxiObject taxi = new TaxiObject(taxiId,code,date,time,capacity,name);
                taxiObjects.add(taxi);
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return taxiObjects;
    }

    //method for inserting data into Trip
    public static void insertIntoTrip(int personId,int taxiId,int numOfPassengers,String passengersNames){
        String querry = "insert into trip (personID, taxiID, numOfPassengers, passengerNames)" +
                "values(?, ?, ?, ?)";
        try {
            PreparedStatement statement = connection.prepareStatement(querry);
            connection.setAutoCommit(false);
            statement.setInt(1,personId);
            statement.setInt(2,taxiId);
            statement.setInt(3,numOfPassengers);
            statement.setString(4,passengersNames);
            statement.executeUpdate();
            connection.commit();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    //method for getting data for TaxiTripTable using join on taciId,objectId with personId
    public static List<TaxiTrip> selectFromTaxiAndTripViaPerson(int personId){
        List<TaxiTrip> trips = new ArrayList<>();
        String querry = "select t.taxiID, t.vehicleCode, t.travelDate, t.travelTime, p.numOfPassengers, p.passengerNames, o.name"
        + " from taxi t inner join trip p on t.taxiID = p.taxiID inner join object o on t.objectID = o.objectId where p.personID = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(querry);
            statement.setInt(1,personId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                int taxiId = resultSet.getInt(1);
                String code = resultSet.getString(2);
                LocalDate date = resultSet.getDate(3).toLocalDate();
                LocalTime time = resultSet.getTime(4).toLocalTime();
                int numOfPassengers = resultSet.getInt(5);
                String names = resultSet.getString(6);
                String name = resultSet.getString(7);
                TaxiTrip taxi = new TaxiTrip(taxiId,code,date,time,numOfPassengers,names,name);
                trips.add(taxi);
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return trips;
    }

}

