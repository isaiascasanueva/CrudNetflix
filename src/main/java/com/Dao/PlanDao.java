package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.conexion.conexion;
import com.model.Plan;
import com.model.Subscritor;

public class PlanDao {
	
	private Connection connection;
	private PreparedStatement statement;
	private boolean estadoOperacion;
	
	
	
	// guardar
	public boolean guardar(Plan plan) throws SQLException {
		String sql = null;
		estadoOperacion = false;
		connection = obtenerConexion();

		try {
			connection.setAutoCommit(false);
			sql = "INSERT INTO plan (idPlan, nombre,importe) VALUES(?,?,?) ";
			statement = connection.prepareStatement(sql);

			statement.setString(1, null);
			
			statement.setInt(1, plan.getIdPlan());
			statement.setString(2, plan.getNombre());
			statement.setFloat(3, plan.getImportef());
			

			estadoOperacion = statement.executeUpdate() > 0;
			connection.commit();
			statement.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			connection.rollback();
			e.printStackTrace();
		}

		return estadoOperacion;
	}
	
	
	

public Plan obtenerPlan(int idplan) throws SQLException {
		
		ResultSet resulset = null;
		Plan pl = new Plan();
		String sql = null;
		estadoOperacion = false;
		connection = obtenerConexion();

		try {

			sql = "SELECT * FROM plan WHERE idPlan=?";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, idplan);
			resulset = statement.executeQuery(sql);
			
			
			if(resulset.next()) {
		
			pl.setIdPlan(resulset.getInt(1));
			pl.setNombre(resulset.getString(2));
			pl.setImportef(Float.parseFloat(resulset.getString(3)));
				
				
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return pl;
	}

// obtener
private Connection obtenerConexion() throws SQLException {
	return conexion.getConnection();

}

	
	
}
