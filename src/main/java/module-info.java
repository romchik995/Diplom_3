module com.example.diplom_3 {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens com.example.diplom_3 to javafx.fxml;
    exports com.example.diplom_3;
}