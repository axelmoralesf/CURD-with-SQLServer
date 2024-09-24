package com.frigorifico.Entrega;

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

public class Entrega_Alta implements Initializable {

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        charge_cBox();
    }
    
    @FXML
    private TextField txtField_Fecha;

    @FXML
    private TextField txtField_Hour;

    @FXML
    private TextField txtField_NameC;

    @FXML
    private ComboBox<String>  cbox_Distributor;

    @FXML
    private void btn_OnReturn() throws IOException{
        App.setRoot("Otras_Pantallas/Alta");
    }

    @FXML
    private void btn_OnUp() throws IOException{
        ArrayList<String> resultados = charge_cBox();
        String Fecha = txtField_Fecha.getText();
        String Hour = txtField_Hour.getText();
        String Name = txtField_NameC.getText();
        String Distribuidor = cbox_Distributor.getSelectionModel().getSelectedItem();
        String FK="";
        System.out.println(resultados);
        for(int i=0;i<resultados.size();i++){
            if(Distribuidor.equals(resultados.get(i))){
                FK=resultados.get(i-1);
            }
        }
        String Query = "INSERT INTO MFAA_Entrega VALUES ('"+Fecha+"','"+Hour+"','"+Name+"',"+FK+");";
        DatabaseUtils.executeInsertQuery(Query);
        resultados.clear();
        cbox_Distributor.getItems().clear();
        charge_cBox();
    }

    private ArrayList<String> charge_cBox(){
        String Query = "SELECT Id_Distribuidor, Nom_Distribuidor FROM MFAA_Distribuidor";
        ArrayList<String> resultados = DatabaseUtils.executeSelectQuery(Query);
        for(int i=1;i<resultados.size();i++){
            if(i%2 != 0){
                cbox_Distributor.getItems().addAll(resultados.get(i));
            }
        }
        return resultados;
    }
}