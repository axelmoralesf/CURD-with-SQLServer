package com.frigorifico.Distribuidor;

import java.io.IOException;
import java.util.ArrayList;

import com.frigorifico.App;
import com.frigorifico.utils.DatabaseUtils;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class Dis_Baja {
    @FXML
    private TextField txtField_Id;

    @FXML
    private ListView<String> ListView_Field;

    @FXML
    private String btn_OnSearch() throws IOException{
        ListView_Field.getItems().clear();
        String Id = txtField_Id.getText();
        String SQL_Setencia="SELECT * FROM MFAA_Distribuidor WHERE Id_Distribuidor = "+Id+";";
        ArrayList<String> resultados = DatabaseUtils.executeSelectQuery(SQL_Setencia);
        String Result = DatabaseUtils.arrayListToString(resultados, ", ");
        DatabaseUtils.executeSelectQuery(SQL_Setencia);
        ListView_Field.getItems().add(Result);
        DatabaseUtils.closeConnection(null);
        return resultados.get(0);
    }

    @FXML
    private void btn_OnDelete() throws IOException{
        String ID = btn_OnSearch();
        String Query = "DELETE FROM MFAA_Distribuidor WHERE Id_Distribuidor = "+ID+";";
        String result = DatabaseUtils.executeDeleteQuery(Query);
        System.out.println(result);
        DatabaseUtils.closeConnection(null);
        ListView_Field.getItems().clear();
    }

    @FXML
    private void btn_OnReturn() throws IOException{  
        App.setRoot("Otras_Pantallas/Baja");
    }

}
