package com.frigorifico.Empleado;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.frigorifico.App;
import com.frigorifico.utils.DatabaseUtils;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class Empleado_UP implements Initializable{

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        charge_cBox();
    }

    @FXML
    private TextField txtField_Name;

    @FXML
    private TextField txtField_Cargo;

    @FXML
    private TextField txtField_Type;

    @FXML
    private TextField txtField_Phone;

    @FXML
    private ComboBox<String> cBox_Cliente;

    @FXML
    private void btn_OnReturn() throws IOException{
        App.setRoot("Otras_Pantallas/Alta");
    }

    @FXML
    private void btn_OnRegister() throws IOException{
        ArrayList<String> resultados = charge_cBox();
        String name = txtField_Name.getText();
        String cargo = txtField_Cargo.getText();
        String type = txtField_Type.getText();
        String phone = txtField_Phone.getText();

        String Cliente = cBox_Cliente.getSelectionModel().getSelectedItem();
        String FK="";
        System.out.println(resultados);
        for(int i=0;i<resultados.size();i++){
            if(Cliente.equals(resultados.get(i))){
                FK=resultados.get(i-1);
            }
        }
        String Query = "INSERT INTO MFAA_Empleado VALUES ('"+name+"','"+cargo+"','"+type+"','"+phone+"',"+FK+");";
        DatabaseUtils.executeInsertQuery(Query);
        DatabaseUtils.closeConnection(null);
        resultados.clear();
        txtField_Name.clear();
        txtField_Cargo.clear();
        txtField_Type.clear();
        txtField_Phone.clear();
        cBox_Cliente.getItems().clear();
        charge_cBox();
    }

    private ArrayList<String> charge_cBox(){
        String Query = "SELECT Id_Cliente, Nom_Cliente FROM MFAA_Cliente";
        ArrayList<String> resultados = DatabaseUtils.executeSelectQuery(Query);
        for(int i=1;i<resultados.size();i++){
            if(i%2 != 0){
                cBox_Cliente.getItems().addAll(resultados.get(i));
            }
        }
        return resultados;
    }
}
