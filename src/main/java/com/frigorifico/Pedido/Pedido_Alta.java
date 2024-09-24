package com.frigorifico.Pedido;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.frigorifico.App;
import com.frigorifico.utils.DatabaseUtils;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class Pedido_Alta implements Initializable {
    ArrayList<String> FK_Cortes = new ArrayList<>();
    

    @Override
    public void initialize(URL location, ResourceBundle resources){
        cbox_Entrega();
        cbox_Empleado();
        cbox_Corte();
    }

    @FXML
    private TextField txtField_Date;

    @FXML
    private TextField txtField_Hr;

    @FXML
    private TextField txtField_Count;

    @FXML
    private ComboBox<String> cbox_Entrega;

    @FXML
    private ComboBox<String> cbox_Empleado;

    @FXML
    private ComboBox<String> cbox_Corte;
    
    @FXML
    public ArrayList<String> btn_OnAdd() throws IOException{
        ArrayList<String> CorteArray = cbox_Corte();
        String Corte = cbox_Corte.getSelectionModel().getSelectedItem();
        String CantidadCorte = txtField_Count.getText();

        for (int i = 0; i < CorteArray.size(); i++) {
            if (Corte.equals(CorteArray.get(i))) {
                FK_Cortes.add(CorteArray.get(i-1));
                FK_Cortes.add(CantidadCorte);
            }
        }
        cbox_Corte.getItems().clear();
        cbox_Corte();
        return this.FK_Cortes;
    }

    @FXML
    private void btn_OnRegister() throws IOException{
        ArrayList<String> EntregaArray = cbox_Entrega();
        ArrayList<String> EmpleadoArray = cbox_Empleado();
        String Date = txtField_Date.getText();
        String Hr = txtField_Hr.getText();
        String Entrega = cbox_Entrega.getSelectionModel().getSelectedItem();
        String Empleado = cbox_Empleado.getSelectionModel().getSelectedItem();
        String FK_Entrega="";
        String FK_Empleado="";
        ArrayList<String> FKcorte = new ArrayList<>();
        ArrayList<String> FKCountCorete = new ArrayList<>();
        

        for(int i=0;i<EntregaArray.size();i++){
            if(Entrega.equals(EntregaArray.get(i))){
                FK_Entrega=EntregaArray.get(i-1);
            }
        }
        for(int i=0;i<EmpleadoArray.size();i++){
            if(Empleado.equals(EmpleadoArray.get(i))){
                FK_Empleado=EmpleadoArray.get(i-1);
            }
        }
        String Query = "INSERT INTO MFAA_Pedido VALUES ('"+Date+"','"+Hr+"',"+FK_Entrega+","+FK_Empleado+");";
        DatabaseUtils.executeInsertQuery(Query);
        DatabaseUtils.closeConnection(null);
        String FK_Pedido=clavePedido();
        for(int i=0;i<FK_Cortes.size();i++){
            if(i%2==0){
                FKcorte.add(FK_Cortes.get(i));
                Query = "INSERT INTO MFAA_Corte_Pedido VALUES ("+FK_Cortes.get(i)+","+FK_Pedido+")";
                DatabaseUtils.executeInsertQuery(Query);
                DatabaseUtils.closeConnection(null);
            }
            if(i%2!=0){
                FKCountCorete.add(FK_Cortes.get(i));
            }
        }
        for(int i=0;i<FKcorte.size();i++){
            Query = "UPDATE MFAA_Corte SET Existencia = Existencia - "+FKCountCorete.get(i)+" WHERE Cve_Corte = "+FKcorte.get(i)+"";
            DatabaseUtils.executeUpdateQuery(Query); 
        }
        //Argregar la PK de lo añadido y Quitar con UPDATE el Counte de Carnes
    }

    private String clavePedido() {
        String Query = "SELECT TOP 1 Cve_Pedido FROM MFAA_Pedido ORDER BY Cve_Pedido DESC";
        ArrayList<String> FK_Pedido = DatabaseUtils.executeSelectQuery(Query);
        return FK_Pedido.get(0);
    }

    @FXML
    private void btn_OnReturn() throws IOException{
        App.setRoot("Otras_Pantallas/Alta");
    }

    private ArrayList<String> cbox_Entrega(){
        String Query = "SELECT No_Entrega, Fec_Entrega FROM MFAA_Entrega";
        ArrayList<String> resultados = DatabaseUtils.executeSelectQuery(Query);
        for(int i=1;i<resultados.size();i++){
            if(i%2 != 0){
                cbox_Entrega.getItems().addAll(resultados.get(i));
            }
        }
        return resultados;
    }

    private ArrayList<String> cbox_Empleado(){
        String Query = "SELECT Id_Empleado, Nom_Empleado FROM MFAA_Empleado";
        ArrayList<String> resultados = DatabaseUtils.executeSelectQuery(Query);
        for(int i=1;i<resultados.size();i++){
            if(i%2 != 0){
                cbox_Empleado.getItems().addAll(resultados.get(i));
            }
        }
        return resultados;
    }

    private ArrayList<String> cbox_Corte(){
        String Query = "SELECT Cve_Corte, Nom_Corte FROM MFAA_Corte";
        ArrayList<String> resultados = DatabaseUtils.executeSelectQuery(Query);
        for(int i=1;i<resultados.size();i++){
            if(i%2 != 0){
                cbox_Corte.getItems().addAll(resultados.get(i));
            }
        }
        return resultados;
    }
}
