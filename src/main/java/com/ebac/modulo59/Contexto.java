package com.ebac.modulo59;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Contexto {
    public void guardarDireccion(DireccionModel direccion) {
        String query = "INSERT INTO direcciones (usuario_id, calle, ciudad, estado, codigo_postal) VALUES ('"
                + direccion.getUsuarioId() + "', '"
                + direccion.getCalle() + "', '"
                + direccion.getCiudad() + "', '"
                + direccion.getEstado() + "', '"
                + direccion.getCodigoPostal() + "')";

        ejecutarActualizacion(query);
    }

    public void actualizarDireccion(DireccionModel direccion) {
        String query = "UPDATE direcciones SET calle = '" + direccion.getCalle() +
                "', ciudad = '" + direccion.getCiudad() +
                "', estado = '" + direccion.getEstado() +
                "', codigo_postal = '" + direccion.getCodigoPostal() +
                "' WHERE id = " + direccion.getId();

        ejecutarActualizacion(query);
    }

    public void eliminarDireccion(int id) {
        String query = "DELETE FROM direcciones WHERE id = " + id;
        ejecutarActualizacion(query);
    }

    public void obtenerDirecciones() {
        String query = "SELECT * FROM direcciones";
        try (Connection conn = MysqlConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") +
                        ", Usuario ID: " + rs.getInt("usuario_id") +
                        ", Calle: " + rs.getString("calle") +
                        ", Ciudad: " + rs.getString("ciudad") +
                        ", Estado: " + rs.getString("estado") +
                        ", Código Postal: " + rs.getString("codigo_postal"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void ejecutarActualizacion(String query) {
        try (Connection conn = MysqlConnection.getConnection();
             Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
