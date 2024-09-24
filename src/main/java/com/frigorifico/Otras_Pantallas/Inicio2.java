package com.frigorifico.Otras_Pantallas;

import java.io.IOException;
import com.frigorifico.App;
import javafx.fxml.FXML;

public class Inicio2 {

    @FXML
    private void btn_OnUp() throws IOException {
        App.setRoot("Otras_Pantallas/Alta");
    }

    @FXML
    private void btn_OnConsult() throws IOException {
        App.setRoot("Otras_Pantallas/Consulta");
    }

    @FXML
    private void btn_OnUpdate() throws IOException {
        App.setRoot("Otras_Pantallas/Modificar");
    }

    @FXML
    private void btn_OnDelete() throws IOException {
        App.setRoot("Otras_Pantallas/Baja");
    }
}
