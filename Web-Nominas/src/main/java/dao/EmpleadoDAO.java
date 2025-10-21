package dao;

//Imports necesarios:
import model.Empleado;
import conexion.Conexion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoDAO {

	public static List<Empleado> obtenerTodos() {
		List<Empleado> empleados = new ArrayList<>();
		String sql = "SELECT * FROM empleados";
		try (Connection con = Conexion.getConnection();
				PreparedStatement ps = con.prepareStatement(sql);
				ResultSet rs = ps.executeQuery()) {
			while (rs.next()) {
				empleados.add(new Empleado(
						rs.getString("nombre"), 
						rs.getString("dni"), 
						rs.getString("sexo"),
						rs.getInt("categoria"), 
						rs.getInt("anyos_trabajados")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return empleados;
	}
	
	public static Empleado buscarPorDNI(String dni) {
        Empleado emp = null;
        String sql = "SELECT * FROM empleados WHERE dni = ?";
        try (Connection con = Conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, dni);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                emp = new Empleado(
                        rs.getString("nombre"),
                        rs.getString("dni"),
                        rs.getString("sexo"),
                        rs.getInt("categoria"),
                        rs.getInt("anyos_trabajados")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return emp;
    }
	
	public static double obtenerSueldoPorDNI(String dni) {
        double sueldo = -1;
        String sql = "SELECT sueldo FROM nominas WHERE dni = ?";
        try (Connection con = Conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, dni);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
            	sueldo = rs.getDouble("sueldo");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sueldo;
    }
}
