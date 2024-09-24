package com.frigorifico.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DatabaseUtils {
    private static final String srv = "localhost:1433";
    private static final String Base = "Frigorifico";
    private static final String usr = "DBA_AXEL";
    private static final String pass = "ADMIN";
    private static final String cxnString ="jdbc:sqlserver://"+srv+";"
                        + "database="+Base+";"
                        + "user="+usr+";"
                        + "password="+pass+";"
                        + "encrypt=false;"
                        + "trustServerCertificate=false;"
                        + "loginTimeout=30;";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(cxnString);
    }

    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static ArrayList<String> executeSelectQuery(String query) {
        ArrayList<String> results = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();

            while (resultSet.next()) {
                List<String> row = new ArrayList<>();
                for (int i = 1; i <= columnCount; i++) {
                    row.add(resultSet.getString(i));
                }
                results.addAll(row);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return results;
    }

    public static String executeInsertQuery(String query) {
        String result = "";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            int affectedRows = preparedStatement.executeUpdate();
            result = "Se afectaron " + affectedRows + " filas";
        } catch (SQLException e) {
            result = "Error: " + e.getMessage();
            e.printStackTrace();
        }
        return result;
    }

    public static String executeUpdateQuery(String query){
        String result = "";
        try (Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query)){
            int affectedRows = preparedStatement.executeUpdate();
            result = "Se afectaron "+affectedRows+" filas";
            
        } catch (Exception e) {
            result = "Error: " + e.getMessage();
            e.printStackTrace();
        }
        return result;
    }

    public static String executeDeleteQuery(String query){
        String result="";
        try (Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query)){
                int affectedRows = preparedStatement.executeUpdate();
                result = "Se elimino "+affectedRows+" fila";
            
        } catch (Exception e) {
            // TODO: handle exception
        }
        return result;
    }

    public static String arrayListToString(ArrayList<String> list, String delimiter) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 1; i < list.size(); i++) {
            stringBuilder.append(list.get(i));
            if (i < list.size() - 1) {
                stringBuilder.append(delimiter);
            }
        }

        return stringBuilder.toString();
    }
}
