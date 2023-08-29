package sumyitschool.thing_project.controller;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import sumyitschool.thing_project.model.Thing;
import sumyitschool.thing_project.model.ThingIO;

import java.io.File;
import java.util.ArrayList;
import java.util.IdentityHashMap;

public class ThingController {
    @FXML
    private TableView<Thing> thingTable;
    @FXML
    private TableColumn<Thing, Boolean> isActiveColumn;
    @FXML
    private TableColumn<Thing, String> nameColumn;
    @FXML
    private TableColumn<Thing, String> placeColumn;
    @FXML
    private TableColumn<Thing, Double> timeColumn;
    @FXML
    private TableColumn<Thing, String> commentsColumn;
    @FXML
    private RadioButton activeTrue;
    @FXML
    private RadioButton activeFalse;
    @FXML
    private ToggleGroup activeGroup;
    @FXML
    private TextField thingName;
    @FXML
    private TextField thingPlace;
    @FXML
    private TextField thingTime;
    @FXML
    private TextArea thingComments;

    public void serThingsTable(ArrayList<Thing> things) {
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        isActiveColumn.setCellValueFactory(new PropertyValueFactory<>("isActive"));
        placeColumn.setCellValueFactory(new PropertyValueFactory<>("place"));
        timeColumn.setCellValueFactory(new PropertyValueFactory<>("time"));
        commentsColumn.setCellValueFactory(new PropertyValueFactory<>("comments"));
        thingTable.setItems(FXCollections.observableArrayList(things));
    }

    public void addThing() {
        Thing thing = new Thing(Boolean.valueOf(((RadioButton)activeGroup.getSelectedToggle()).getText()), thingName.getText(), thingPlace.getText(), thingTime.getText(), thingComments.getText());
    }

    public void editThing() {
        Thing selectedThing = thingTable.getSelectionModel().getSelectedItem();
        if(selectedThing != null) {
            selectedThing.setName(thingName.getText());
            selectedThing.setIsActive(Boolean.valueOf(((RadioButton)activeGroup.getSelectedToggle()).getText()));
            selectedThing.setPlace(thingPlace.getText());
            selectedThing.setTime(thingTime.getText());
            selectedThing.setComments(thingComments.getText());
            thingTable.refresh();
        }
    }

    public void getSelectedThing() {
        Thing selectedThing = thingTable.getSelectionModel().getSelectedItem();
        if(selectedThing != null) {
            thingName.setText(selectedThing.getName());
            if(selectedThing.getIsActive()) {
                activeTrue.setSelected(true);
            } else {
                activeFalse.setSelected(true);
            }
            thingPlace.setText(selectedThing.getPlace());
            thingTime.setText(selectedThing.getTime());
            thingComments.setText(selectedThing.getComments());
        }
    }
}