package zus.view.tables;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.collections.FXCollections;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import zus.model.base.Mission;

import java.time.LocalDate;
import java.util.List;

public class MissionTable extends TableView<Mission> {
    public MissionTable(List<Mission> values) {
        super(FXCollections.observableArrayList(values));

        TableColumn<Mission, Integer> tcMissionId = new TableColumn<>("MissionId");
        TableColumn<Mission, String> tcName = new TableColumn<>("MissionName");
        TableColumn<Mission, LocalDate> tcDate = new TableColumn<>("EndOfMission");
        TableColumn<Mission, Integer> tcPlanetId = new TableColumn<>("ObjectId");
        TableColumn<Mission, Integer> tcAverageDistanceToStarKm = new TableColumn<>("AvgDistToStar(km)");
        TableColumn<Mission, Integer> tcLowestTemperatureKelvin = new TableColumn<>("LowTemp(K)");
        TableColumn<Mission, Integer> tcHighestTemperatureKelvin = new TableColumn<>("HighTemp(K)");
        TableColumn<Mission, Double> tcOxygenPercentage = new TableColumn<>("OxygPerc(%)");
        TableColumn<Mission, String> tcOtherGasName = new TableColumn<>("OtherGasName");
        TableColumn<Mission, Double> tcOtherGasPercentage = new TableColumn<>("OGPer(%)");
        TableColumn<Mission, Integer> tcMaxGravityHeightKm = new TableColumn<>("MaxGravHei(km)");
        TableColumn<Mission, Double> tcOrbitalSpeedKms = new TableColumn<>("OrbiSp(km/s)");
        TableColumn<Mission, Integer> tcDeathsUnder40LastYear = new TableColumn<>("DeathsU40LY");
        TableColumn<Mission, Boolean> tcIsHabitable = new TableColumn<>("IsHabitable");

        tcMissionId.setCellValueFactory(new PropertyValueFactory<>("missionId"));
        tcName.setCellValueFactory(new PropertyValueFactory<>("missionName"));
        tcDate.setCellValueFactory(new PropertyValueFactory<>("missionEndDatel"));
        tcPlanetId.setCellValueFactory(new PropertyValueFactory<>("planetId"));
        tcAverageDistanceToStarKm.setCellValueFactory(new PropertyValueFactory<>("averageDistanceToStarKm"));
        tcLowestTemperatureKelvin.setCellValueFactory(new PropertyValueFactory<>("lowestTemperatureKelvin"));
        tcHighestTemperatureKelvin.setCellValueFactory(new PropertyValueFactory<>("highestTemperatureKelvin"));
        tcOxygenPercentage.setCellValueFactory(new PropertyValueFactory<>("oxygenPercentage"));
        tcOtherGasName.setCellValueFactory(new PropertyValueFactory<>("otherGasName"));
        tcOtherGasPercentage.setCellValueFactory(new PropertyValueFactory<>("otherGasPercentage"));
        tcMaxGravityHeightKm.setCellValueFactory(new PropertyValueFactory<>("maxGravityHeightKm"));
        tcOrbitalSpeedKms.setCellValueFactory(new PropertyValueFactory<>("orbitalSpeedKms"));
        tcDeathsUnder40LastYear.setCellValueFactory(new PropertyValueFactory<>("deathsUnder40LastYear"));
        tcIsHabitable.setCellValueFactory(cellData -> new SimpleBooleanProperty(cellData.getValue().isHabitable()));


        //super.getColumns().add(tcMissionId);
        super.getColumns().add(tcName);
        super.getColumns().add(tcDate);
        super.getColumns().add(tcPlanetId);
        super.getColumns().add(tcAverageDistanceToStarKm);
        super.getColumns().add(tcLowestTemperatureKelvin);
        super.getColumns().add(tcHighestTemperatureKelvin);
        super.getColumns().add(tcOxygenPercentage);
        super.getColumns().add(tcOtherGasName);
        super.getColumns().add(tcOtherGasPercentage);
        super.getColumns().add(tcMaxGravityHeightKm);
        super.getColumns().add(tcOrbitalSpeedKms);
        super.getColumns().add(tcDeathsUnder40LastYear);
        super.getColumns().add(tcIsHabitable);
    }
}

