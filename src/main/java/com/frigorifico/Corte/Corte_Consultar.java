package com.frigorifico.Corte;

import java.io.IOException;
import java.util.ArrayList;

import com.frigorifico.App;
import com.frigorifico.utils.DatabaseUtils;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class Corte_Consultar {
    @FXML
    private TextField txtField_Cve;

    @FXML
    private ListView<String> ListView_Field;

    @FXML
    private void btn_OnSearch() throws IOException{
        ListView_Field.getItems().clear();
        String Id = txtField_Cve.getText();
        String SQL_Setencia="SELECT * FROM MFAA_Corte WHERE Cve_Corte = "+Id+";";
        ArrayList<String> resultados = DatabaseUtils.executeSelectQuery(SQL_Setencia);
        String Result = DatabaseUtils.arrayListToString(resultados, ", ");
        DatabaseUtils.executeSelectQuery(SQL_Setencia);
        ListView_Field.getItems().add(Result);
        DatabaseUtils.closeConnection(null);
    }

    @FXML
    private void btn_OnReturn() throws IOException{
        App.setRoot("Otras_Pantallas/Consulta");
    }
}
