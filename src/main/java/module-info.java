module sio.tp6 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens sio.suivimedical.Entities;


    opens sio.suivimedical to javafx.fxml;
    exports sio.suivimedical;
}