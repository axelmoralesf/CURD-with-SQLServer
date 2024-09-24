package com.frigorifico.Empleado;

import java.io.IOException;
import java.util.ArrayList;

import com.frigorifico.App;
import com.frigorifico.utils.DatabaseUtils;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class Empleado_Modificar {
    @FXML
    private TextField txtField_Search;

    @FXML
    private TextField txtField_Cargo;

    @FXML
    private TextField txtField_Type;

    @FXML
    private TextField txtField_Phone;

    @FXML
    private void btn_OnReturn() throws IOException{
        App.setRoot("Otras_Pantallas/Modificar");
    }

    @FXML
    private void btn_OnUpdate() throws IOException{
        String Cargo = txtField_Cargo.getText();
        String Type = txtField_Type.getText();
        String Phone = txtField_Phone.getText();
        String ID = btn_OnSearch();
        String Query = "UPDATE MFAA_Empleado SET Cargo = '"+Cargo+"', Tipo_Empleado = '"+Type+"', Tel_Empleado = '"+Phone+"' WHERE Id_Empleado= "+ID+";";
        DatabaseUtils.executeUpdateQuery(Query);
        DatabaseUtils.closeConnection(null);
        txtField_Cargo.clear();
        txtField_Type.clear();
        txtField_Phone.clear();
    }

    @FXML
    private String btn_OnSearch() throws IOException{
        String Id = txtField_Search.getText();
        String SQL_Setencia="SELECT * FROM MFAA_Empleado WHERE Id_Empleado = "+Id+";";
        ArrayList<String> resultados = DatabaseUtils.executeSelectQuery(SQL_Setencia);
        txtField_Cargo.setText(resultados.get(2));;
        txtField_Type.setText(resultados.get(3));;
        txtField_Phone.setText(resultados.get(4));;
        DatabaseUtils.closeConnection(null);
        return resultados.get(0);
    }
}
