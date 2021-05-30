package sample.gui;

import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sample.logic.entities.Report;
import sample.logic.services.IReportServices;
import sample.logic.services.impl.ReportServices;

import java.awt.*;
import java.util.Map;

public class ReportScene {
    // Visual Properties
    private Stage stage;
    private Label label;
    private Scene scene;
    //ERROR private TableView reportTable;
    private javafx.scene.control.TableView<Report> reportTable;

    // Logic properties
    private IReportServices
    reportServices;

    public ReportScene() {
        stage  = new Stage();

        setUp();
        behavior(stage);

        stage.setTitle("Report");
        stage.setScene(scene);
        stage.show();
    }

    private void setUp() {

        //javafx.scene.control.Label label = new javafx.scene.control.Label("im a label");
        setUpTableReport();
        VBox reportLayout = new VBox(10);
        reportLayout.getChildren().add(reportTable);//table or label
        scene = new Scene(reportLayout, 200, 200);
    }

    private void behavior(Stage stage) {

        this.reportServices = new ReportServices();
        Map<String, Report> reportPersonasByProfession = this.reportServices.getReportPersonasByProfession();
        Report victims = this.reportServices.getCountOfVictims();

        reportTable.setItems((ObservableList<Report>) reportPersonasByProfession.values());

        //reportTable.setItems((List<Report>) reportPersonasByProfession.values());//getValues

    }

    private void setUpTableReport() {

        // Profession Name
        //TableColumn<Report,String> professionNameColumn = new TableColumn<>();
        javafx.scene.control.TableColumn<Report, String> professionNameColumn = new javafx.scene.control.TableColumn<Report, String>();
        professionNameColumn.setMaxWidth(200);
        professionNameColumn.setCellValueFactory(new PropertyValueFactory("criteria"));

        // Count
        //TableColumn<Report, Integer> countColumn = new TableColumn<>();
        javafx.scene.control.TableColumn<Report, Integer> countColumn = new javafx.scene.control.TableColumn<Report, Integer>();
        countColumn.setMaxWidth(200);
        countColumn.setCellValueFactory(new PropertyValueFactory("count"));

        reportTable = new javafx.scene.control.TableView<>();
        reportTable.getColumns().addAll(professionNameColumn, countColumn);

       // reportTable = new TableView<>();
       // reportTable.getColumns().addAll(professionNameColumn, countColumn);

    }
}
