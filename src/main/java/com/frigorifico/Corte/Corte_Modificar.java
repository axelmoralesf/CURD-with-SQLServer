package com.frigorifico.Corte;

import java.io.IOException;
import java.util.ArrayList;

import com.frigorifico.App;
import com.frigorifico.utils.DatabaseUtils;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class Corte_Modificar {
    @FXML
    private TextField txtField_Search;

    @FXML
    private TextField txtField_Count;

    @FXML
    private TextField txtField_Price;

    @FXML
    private void btn_OnReturn() throws IOException{
        App.setRoot("Otras_Pantallas/Modificar");
    }

    @FXML
    private void btn_OnUpdate() throws IOException{
        String Count = txtField_Count.getText();
        String Price = txtField_Price.getText();
        String ID = btn_OnSearch();
        String Query = "UPDATE MFAA_Corte SET Existencia= "+Count+", Prec_Corte = "+Price+" WHERE Cve_Corte= "+ID+";";
        DatabaseUtils.executeUpdateQuery(Query);
        DatabaseUtils.closeConnection(null);
        txtField_Count.clear();
        txtField_Price.clear();
    }

    @FXML
    private String btn_OnSearch() throws IOException{
        String Id = txtField_Search.getText();
        String SQL_Setencia="SELECT * FROM MFAA_Corte WHERE Cve_Corte = "+Id+";";
        ArrayList<String> resultados = DatabaseUtils.executeSelectQuery(SQL_Setencia);
        txtField_Count.setText(resultados.get(2));
        txtField_Price.setText(resultados.get(3));
        DatabaseUtils.closeConnection(null);
        return resultados.get(0);
    }
}
