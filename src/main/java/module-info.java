module com.example.tableview {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.scienceleadership.Phone to javafx.fxml;
    exports org.scienceleadership.Phone;
}