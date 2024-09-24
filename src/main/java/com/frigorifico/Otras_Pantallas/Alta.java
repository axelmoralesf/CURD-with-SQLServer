package com.frigorifico.Otras_Pantallas;

import java.io.IOException;
import com.frigorifico.App;
import javafx.fxml.FXML;

public class Alta {
    
    @FXML
    private void btn_OnDistributtor() throws IOException{
        App.setRoot("Distribuidor/Dis_UP");
    }

    @FXML
    private void btn_OnDelivery() throws IOException{
        App.setRoot("Entrega/Entrega_Alta");
    }

    @FXML
    private void btn_OnCourt() throws IOException{
        App.setRoot("Corte/Corte_Alta");
    }

    @FXML
    private void btn_OnOrder() throws IOException{
        App.setRoot("Pedido/Pedido_UP");
    }

    @FXML
    private void btn_OnEmploye() throws IOException{
        App.setRoot("Empleado/Empleado_UP");
    }

    @FXML
    private void btn_OnClient() throws IOException{
        App.setRoot("Cliente/Cliente_UP");
    }

    @FXML
    private void btn_OnReturn() throws IOException{
        App.setRoot("Otras_Pantallas/Inicio2");
    }

}
