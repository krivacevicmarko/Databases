package zus.model.base;

import lombok.Setter;

import java.time.LocalDate;


@Setter
public class Mission {
    private final int missionId;

    private String missionName;

    private LocalDate missionEndDatel;

    private final int planetId;

    private String name;

    private int averageDistanceToStarKm;

    private int lowestTemperatureKelvin;

    private int highestTemperatureKelvin;

    private double oxygenPercentage;

    private String otherGasName;
    private double otherGasPercentage;

    private int maxGravityHeightKm;

    private double orbitalSpeedKms;

    private int deathsUnder40LastYear;

    private boolean isHabitable;


    public Mission(int missionId, String missionName, LocalDate missionEndDatel, int planetId, int averageDistanceToStarKm, int lowestTemperatureKelvin, int highestTemperatureKelvin, double oxygenPercentage, String otherGasName, double otherGasPercentage, int maxGravityHeightKm, double orbitalSpeedKms, int deathsUnder40LastYear, boolean isHabitable) {
        this.missionId = missionId;
        this.missionName = missionName;
        this.missionEndDatel = missionEndDatel;
        this.planetId = planetId;
        this.averageDistanceToStarKm = averageDistanceToStarKm;
        this.lowestTemperatureKelvin = lowestTemperatureKelvin;
        this.highestTemperatureKelvin = highestTemperatureKelvin;
        this.oxygenPercentage = oxygenPercentage;
        this.otherGasName = otherGasName;
        this.otherGasPercentage = otherGasPercentage;
        this.maxGravityHeightKm = maxGravityHeightKm;
        this.orbitalSpeedKms = orbitalSpeedKms;
        this.deathsUnder40LastYear = deathsUnder40LastYear;
        this.isHabitable = isHabitable;
    }

    public int getMissionId() {
        return missionId;
    }

    public String getMissionName() {
        return missionName;
    }

    public LocalDate getMissionEndDatel() {
        return missionEndDatel;
    }

    public int getPlanetId() {
        return planetId;
    }

    public String getName() {
        return name;
    }

    public int getAverageDistanceToStarKm() {
        return averageDistanceToStarKm;
    }

    public int getLowestTemperatureKelvin() {
        return lowestTemperatureKelvin;
    }

    public int getHighestTemperatureKelvin() {
        return highestTemperatureKelvin;
    }

    public double getOxygenPercentage() {
        return oxygenPercentage;
    }

    public String getOtherGasName() {
        return otherGasName;
    }

    public double getOtherGasPercentage() {
        return otherGasPercentage;
    }

    public int getMaxGravityHeightKm() {
        return maxGravityHeightKm;
    }

    public double getOrbitalSpeedKms() {
        return orbitalSpeedKms;
    }

    public int getDeathsUnder40LastYear() {
        return deathsUnder40LastYear;
    }

    public boolean isHabitable() {
        return isHabitable;
    }
}