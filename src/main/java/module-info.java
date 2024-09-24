module com.frigorifico {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires javafx.base;
    
    opens com.frigorifico to javafx.fxml;
    opens com.frigorifico.Otras_Pantallas to javafx.fxml;
    opens com.frigorifico.Distribuidor to javafx.fxml;
    opens com.frigorifico.Entrega to javafx.fxml;
    opens com.frigorifico.Cliente to javafx.fxml;
    opens com.frigorifico.Corte to javafx.fxml;
    opens com.frigorifico.Empleado to javafx.fxml;
    opens com.frigorifico.Pedido to javafx.fxml;

    exports com.frigorifico;
    exports com.frigorifico.Otras_Pantallas;
    exports com.frigorifico.Distribuidor;
    exports com.frigorifico.Entrega;
    exports com.frigorifico.Cliente;
    exports com.frigorifico.Corte;
    exports com.frigorifico.Empleado;
    exports com.frigorifico.Pedido;
}
