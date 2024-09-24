package com.frigorifico.Cliente;
import com.frigorifico.utils.DatabaseUtils;
import java.io.IOException;
import com.frigorifico.App;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;

public class Cliente_UP {
    @FXML
    private TextField txtField_Name;

    @FXML
    private TextField txtField_Type;

    @FXML
    private TextField txtField_Address;

    @FXML
    private TextField txtField_Phone;

    @FXML
    private TextField txtField_RUC;

    @FXML
    private void btn_OnReturn() throws IOException{
        App.setRoot("Otras_Pantallas/Alta");
    }

    @FXML
    private void btn_OnRegister() throws IOException{
        String name=txtField_Name.getText();
        String type=txtField_Type.getText();
        String address=txtField_Address.getText();
        String phone=txtField_Phone.getText();
        String RUC=txtField_RUC.getText();
        if(name.equals("")|| address.equals("") || phone.equals("") || type.equals("") || RUC.equals("")){
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Hay campos vacios");
            alert.showAndWait();
        }else{
            String Query="INSERT INTO MFAA_Cliente VALUES ('"+name+"','"+type+"','"+address+"','"+phone+"','"+RUC+"');";
            String result = DatabaseUtils.executeInsertQuery(Query);
            System.out.println(result);
            DatabaseUtils.closeConnection(null);
        }
    }
}
