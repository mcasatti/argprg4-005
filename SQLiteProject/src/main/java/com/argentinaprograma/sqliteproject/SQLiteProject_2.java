/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.argentinaprograma.sqliteproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author mcasatti
 */
public class SQLiteProject_2 {

    public static void main(String[] args) {
        Connection conn = null;
        try {
            // Establecer una conexión
            conn = DriverManager.getConnection("jdbc:sqlite:database.db");
            // Crear la base de datos
            Statement stmt = conn.createStatement();

            System.out.println("Consultando datos...");
            String sql = "SELECT idEquipo, Nombre, Descripcion FROM equipos";
            ResultSet rs = stmt.executeQuery(sql); // loop through the result set
            System.out.println("Cargando los datos en ListaEquipos...");
            ListaEquipos lista = new ListaEquipos();
            while (rs.next()) {
                Equipo e = new Equipo(
                        rs.getInt("idEquipo"),
                        rs.getString("Nombre"),
                        rs.getString("Descripcion")
                );
                lista.addEquipo(e);
            }
            System.out.println("Mostrando los OBJETOS de ListaEquipos...");
            System.out.println(lista.listar());
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                // conn close failed.
                System.out.println(e.getMessage());
            }
        }
    }
}
