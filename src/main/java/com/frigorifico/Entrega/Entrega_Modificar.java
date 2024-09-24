package com.frigorifico.Entrega;

import java.io.IOException;
import java.util.ArrayList;

import com.frigorifico.App;
import com.frigorifico.utils.DatabaseUtils;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class Entrega_Modificar {
    
    @FXML
    private TextField txtField_Search;

    @FXML
    private TextField txtField_Date;

    @FXML
    private TextField txtField_Hr;

    @FXML
    private void btn_OnReturn() throws IOException{
        App.setRoot("Otras_Pantallas/Modificar");
    }

    @FXML
    private String btn_OnSearch() throws IOException{
        String Id = txtField_Search.getText();
        String SQL_Setencia="SELECT * FROM MFAA_Entrega WHERE No_Entrega = "+Id+";";
        ArrayList<String> resultados = DatabaseUtils.executeSelectQuery(SQL_Setencia);
        txtField_Date.setText(resultados.get(1));
        txtField_Hr.setText(resultados.get(2));
        DatabaseUtils.closeConnection(null);
        return resultados.get(0);
    }

    @FXML
    private void btn_OnUpdate() throws IOException{
        String Date = txtField_Date.getText();
        String Hr = txtField_Hr.getText();
        String No_Entrega = btn_OnSearch();
        String Query = "UPDATE MFAA_Entrega SET Fec_Entrega= '"+Date+"', Hr_Entrega='"+Hr+"' WHERE No_Entrega= "+No_Entrega+";";
        DatabaseUtils.executeUpdateQuery(Query);
        DatabaseUtils.closeConnection(null);
        txtField_Search.clear();
        txtField_Date.clear();
        txtField_Hr.clear();
    }

}
