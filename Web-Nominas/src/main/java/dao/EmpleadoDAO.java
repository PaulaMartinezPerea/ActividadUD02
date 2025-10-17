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
				empleados.add(new Empleado(rs.getString("nombre"), rs.getString("dni"), rs.getString("sexo"),
						rs.getInt("categoria"), rs.getInt("anyos")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return empleados;
	}
}