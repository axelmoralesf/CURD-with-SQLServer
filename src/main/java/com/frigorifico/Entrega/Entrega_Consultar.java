package com.frigorifico.Entrega;

import java.io.IOException;
import java.util.ArrayList;

import com.frigorifico.App;
import com.frigorifico.utils.DatabaseUtils;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class Entrega_Consultar{
    
    @FXML
    private TextField txtField_No;

    @FXML
    private ListView <String> ListView_Results;

    @FXML
    private void btn_OnSearch() throws IOException{
        ListView_Results.getItems().clear();
        String Id = txtField_No.getText();
        String SQL_Setencia="SELECT * FROM MFAA_Entrega WHERE No_Entrega = "+Id+";";
        ArrayList<String> resultados = DatabaseUtils.executeSelectQuery(SQL_Setencia);
        String Result = DatabaseUtils.arrayListToString(resultados, ", ");
        DatabaseUtils.executeSelectQuery(SQL_Setencia);
        ListView_Results.getItems().add(Result);
        DatabaseUtils.closeConnection(null);
    }

    @FXML
    private void btn_OnReturn() throws IOException{
        App.setRoot("Otras_Pantallas/Consulta");
    }
}
