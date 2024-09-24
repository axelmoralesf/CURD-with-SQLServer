package com.frigorifico.Otras_Pantallas;

import java.io.IOException;

import com.frigorifico.App;

import javafx.fxml.FXML;

public class Modificar{
    
    @FXML
    private void btn_OnDistributtor() throws IOException{
        App.setRoot("Distribuidor/Dis_Modificar");
    }

    @FXML
    private void btn_OnDelivery() throws IOException{
        App.setRoot("Entrega/Entrega_Modificar");
    }

    @FXML
    private void btn_OnCourt() throws IOException{
        App.setRoot("Corte/Corte_Modificar");
    }

    @FXML
    private void btn_OnOrder() throws IOException{
        
    }

    @FXML
    private void btn_OnEmploye() throws IOException{
        App.setRoot("Empleado/Empleado_Modificar");
    }

    @FXML
    private void btn_OnClient() throws IOException{
        App.setRoot("Cliente/Cliente_Modificar");
    }

    @FXML
    private void btn_OnReturn() throws IOException{
        App.setRoot("Otras_Pantallas/Inicio2");
    }

}
