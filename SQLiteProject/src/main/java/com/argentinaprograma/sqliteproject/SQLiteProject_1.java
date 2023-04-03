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
public class SQLiteProject_1 {

    public static void main(String[] args) {
        Connection conn = null;
        try {
            // Establecer una conexión
            conn = DriverManager.getConnection("jdbc:sqlite:database.db");
            // Crear la base de datos
            Statement stmt = conn.createStatement();
            String insert;
            // Crear la tabla de equipos
            System.out.println("Creando y cargando la base de datos...");
            stmt.executeUpdate("drop table if exists equipos");
            stmt.executeUpdate("create table equipos (idEquipo integer, Nombre string, Descripcion string)");
            // Cargar la tabla de equipos
            insert = "insert into equipos (idEquipo,Nombre,Descripcion) values (?,?,?)";
            PreparedStatement pInsert = conn.prepareStatement(insert);
            for (int i = 1; i < 11; i++) {
                pInsert.setInt(1, i);
                pInsert.setString(2, "Equipo " + i);
                pInsert.setString(3, "Descripción del equipo " + i);
                pInsert.executeUpdate();
            }
            System.out.println("Base de datos creada y cargada exitosamente.");

            System.out.println("Consultando datos...");
            String sql = "SELECT idEquipo, Nombre, Descripcion FROM equipos";
            ResultSet rs = stmt.executeQuery(sql); // loop through the result set
            while (rs.next()) {
                System.out.println(rs.getInt("idEquipo") + "\t"
                        + rs.getString("Nombre") + "\t"
                        + rs.getString("Descripcion") + "\t");
            }
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
