module sumyitschool.thing_project {
    requires javafx.controls;
    requires javafx.fxml;


    opens sumyitschool.thing_project to javafx.fxml;
    exports sumyitschool.thing_project;
    exports sumyitschool.thing_project.controller;
    opens sumyitschool.thing_project.controller to javafx.fxml;
    exports sumyitschool.thing_project.model;
    opens sumyitschool.thing_project.model to javafx.fxml;
}