package com.frigorifico;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class PrimaryController {
    Connection cnx = null;
    String Base = "Frigorifico"; // Nombre de tu base de datos
    String srv = "localhost:1433"; // Nombre de tu servidor
    String usr;
    String pass;

    @FXML
    private TextField user;

    @FXML
    private PasswordField password; 

    @FXML
    private void btn_OnExit() throws IOException {
        System.out.println("EXIT");
        Platform.exit();
    }

    @FXML
    private void btn_OnLogin() throws IOException {
        usr = user.getText();
        pass = password.getText();
        if (usr.equals("DBA_AXEL") && pass.equals("ADMIN")) {
            usr = "DBA_AXEL";
            pass = "ADMIN";
            System.out.println("NICE");
            Connection();
            App.setRoot("Otras_Pantallas/Inicio2");
        } else {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Información");
            alert.setHeaderText(null);
            alert.setContentText("Usuario o contraseña incorrectos");
            alert.showAndWait();
        }
    }

    public void Connection() {
        String cxnString ="jdbc:sqlserver://"+srv+";"
                        + "database="+Base+";"
                        + "user="+usr+";"
                        + "password="+pass+";"
                        + "encrypt=false;"
                        + "trustServerCertificate=false;"
                        + "loginTimeout=30;";
        try (Connection connection = DriverManager.getConnection(cxnString);) {
            System.out.println("conexion exitosa");
            // Code here.
        }
        // Handle any errors that may have occurred.
        catch (SQLException e) {
            e.printStackTrace();
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Usuario o contraseña incorrecto");
            alert.showAndWait();
        }
    }
}
