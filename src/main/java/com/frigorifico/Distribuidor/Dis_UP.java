package com.frigorifico.Distribuidor;

import com.frigorifico.utils.DatabaseUtils;
import java.io.IOException;
import com.frigorifico.App;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;

public class Dis_UP {
    @FXML
    private TextField txtField_Name;

    @FXML
    private TextField txtField_Address;

    @FXML
    private TextField txtField_Phone;

    @FXML
    private void btn_OnReturn() throws IOException{
        App.setRoot("Otras_Pantallas/Alta");
    }

    @FXML
    private void btn_OnRegister() throws IOException{
        String name=txtField_Name.getText();
        String address=txtField_Address.getText();
        String phone=txtField_Phone.getText();
        if(name.equals("")|| address.equals("") || phone.equals("")){
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Hay campos vacios");
            alert.showAndWait();
        }else{
            String Query="INSERT INTO MFAA_Distribuidor VALUES ('"+name+"','"+address+"','"+phone+"');";
            String result = DatabaseUtils.executeInsertQuery(Query);
            System.out.println(result);
            DatabaseUtils.closeConnection(null);
        }
    }
}
