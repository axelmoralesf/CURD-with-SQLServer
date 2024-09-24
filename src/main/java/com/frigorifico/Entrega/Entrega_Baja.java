package com.frigorifico.Entrega;

import java.io.IOException;
import java.util.ArrayList;

import com.frigorifico.App;
import com.frigorifico.utils.DatabaseUtils;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class Entrega_Baja {
    @FXML
    private TextField txtField_No;

    @FXML
    private ListView<String> ListView_Results;

    @FXML
    private String btn_OnSearch() throws IOException{
        ListView_Results.getItems().clear();
        String Id = txtField_No.getText();
        String SQL_Setencia="SELECT * FROM MFAA_Entrega WHERE No_Entrega = "+Id+";";
        ArrayList<String> resultados = DatabaseUtils.executeSelectQuery(SQL_Setencia);
        String Result = DatabaseUtils.arrayListToString(resultados, ", ");
        DatabaseUtils.executeSelectQuery(SQL_Setencia);
        ListView_Results.getItems().add(Result);
        DatabaseUtils.closeConnection(null);
        return resultados.get(0);
    }

    @FXML
    private void btn_OnDelete() throws IOException{
        String ID = btn_OnSearch();
        String Query = "DELETE FROM MFAA_Entrega WHERE No_Entrega = "+ID+";";
        String result = DatabaseUtils.executeDeleteQuery(Query);
        System.out.println(result);
        DatabaseUtils.closeConnection(null);
        ListView_Results.getItems().clear();
    }

    @FXML
    private void btn_OnReturn() throws IOException{  
        App.setRoot("Otras_Pantallas/Baja");
    }
}
