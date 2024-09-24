package com.frigorifico.Corte;

import java.io.IOException;

import com.frigorifico.App;
import com.frigorifico.utils.DatabaseUtils;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;

public class Corte_UP {
    @FXML
    private TextField txtField_Name;

    @FXML
    private TextField txtField_Count;

    @FXML
    private TextField txtField_Price;

    @FXML
    private void btn_OnReturn() throws IOException{
        App.setRoot("Otras_Pantallas/Alta");
    }

    @FXML
    private void btn_OnRegister() throws IOException{
        String name=txtField_Name.getText();
        String count=txtField_Count.getText();
        String Price=txtField_Price.getText();
        if(name.equals("")|| count.equals("") || Price.equals("")){
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Hay campos vacios");
            alert.showAndWait();
        }else{
            String Query="INSERT INTO MFAA_Corte VALUES ('"+name+"',"+count+","+Price+");";
            DatabaseUtils.executeInsertQuery(Query);
            DatabaseUtils.closeConnection(null);
        }
    }
}
