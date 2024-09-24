package com.frigorifico.Distribuidor;

import java.io.IOException;
import java.util.ArrayList;

import com.frigorifico.App;
import com.frigorifico.utils.DatabaseUtils;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class Dis_Modificar{
    
    @FXML
    private TextField txtField_Id;

    @FXML
    private TextField txtField_Phone;

    @FXML
    private void btn_OnReturn() throws IOException{
        App.setRoot("Otras_Pantallas/Modificar");
    }

    @FXML
    private void btn_OnUpdate() throws IOException{
        String Phone = txtField_Phone.getText();
        String ID = btn_OnSearch();
        String Query = "UPDATE MFAA_Distribuidor SET Tel_Distribuidor= '"+Phone+"' WHERE Id_Distribuidor= "+ID+";";
        DatabaseUtils.executeUpdateQuery(Query);
        DatabaseUtils.closeConnection(null);
        txtField_Phone.clear();
    }

    @FXML
    private String btn_OnSearch() throws IOException{
        String Id = txtField_Id.getText();
        String SQL_Setencia="SELECT * FROM MFAA_Distribuidor WHERE Id_Distribuidor = "+Id+";";
        ArrayList<String> resultados = DatabaseUtils.executeSelectQuery(SQL_Setencia);
        txtField_Phone.setText(resultados.get(3));
        DatabaseUtils.closeConnection(null);
        return resultados.get(0);
    }

}
