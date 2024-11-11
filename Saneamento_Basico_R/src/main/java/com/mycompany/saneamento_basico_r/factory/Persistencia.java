/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.saneamento_basico_r.factory;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author JonathasOliveira
 */

public class Persistencia {
    private static Persistencia instance = null;
    private Connection connection = null;
    private static final String DB_URL = "//nome do banco de dados";

    private Persistencia() {
        try {
            Class.forName("org.sqlite.JDBC");
            this.connection = DriverManager.getConnection(DB_URL);
        } catch (ClassNotFoundException | SQLException ex) {
            System.err.println("Error - Ao abrir conexão." + ex.toString());
        }
    }

    public static Connection getConnection() {
        if (instance == null) {
            instance = new Persistencia();
        }
        return instance.connection;
    }

    // Método para fechar a conexão (se necessário)
    public static void closeConnection() {
        if (instance != null && instance.connection != null) {
            try {
                instance.connection.close();
                instance = null;
            } catch (SQLException ex) {
                Logger.getLogger(Persistencia.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}