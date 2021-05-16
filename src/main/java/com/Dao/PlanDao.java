package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.conexion.conexion;
import com.model.Subscritor;
import com.mysql.cj.xdevapi.PreparableStatement;

public class PlanDao {
	
	private Connection connection;
	private PreparedStatement statement;
	private boolean  estadoOperacion;
	
	//guardar
	public boolean guardar(Subscritor subs ) throws SQLException {
		String sql= null;
		estadoOperacion=false;
		connection= obtenerConexion();
		
		try {
			connection.setAutoCommit(false);
			sql="INSERT INT usuario (id, nombre, apellidoPaterno,apellidoMaterno,servicio, fechaNacimiento, plan, estatus) VALUES(?,?,?,?,?,?,?,?) ";
			statement=connection.prepareStatement(sql);
			
			statement.setString(1,null);
			statement.setString(2, subs.getNombre());
			statement.setString(3, subs.getApellidoPaterno());
			statement.setString(4, subs.getApellidoMaterno());
			statement.setString(5, subs.getServicio());
			statement.setString(6, subs.getFechaNacimiento());
			statement.setObject(7, subs.getPlan());
			statement.setString(8, subs.getEstatus());
			
			estadoOperacion=statement.executeUpdate()>0;
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

	//editar
	public boolean editar(Subscritor subs ) throws SQLException {
		String sql= null;
		estadoOperacion=false;
		connection= obtenerConexion();
		try {
			connection.setAutoCommit(false);
			sql="UPDATE usuario SET nombre=?, apellidoPaterno=?,apellidoMaterno=?,servicio=?, fechaNacimiento=?, plan=?, estatus=? WHERE id=?";
			statement=connection.prepareStatement(sql);
			
			statement.setString(1, subs.getNombre());
			statement.setString(2, subs.getApellidoPaterno());
			statement.setString(3, subs.getApellidoMaterno());
			statement.setString(4, subs.getServicio());
			statement.setString(5, subs.getFechaNacimiento());
			statement.setObject(6, subs.getPlan());
			statement.setString(7, subs.getEstatus());
			statement.setInt(8, subs.getId());
			
			estadoOperacion=statement.executeUpdate()>0;
			connection.commit();
			statement.close();
			connection.close();
			
			
			
		} catch (SQLException e) {
			connection.rollback();
			e.printStackTrace();
		}
		
		return estadoOperacion;
	}

	//eliminar
	public boolean eliminar(int idSubs ) {
		return true;
	}
	
	//lista de subs
	public List<Subscritor> obtenerSubs(int idSubs ) {
		return null; 
	}
	
	//obtener subs
	public Subscritor obtenerSub(int idSubs ) {
		return null; 
	}
	
	//obtener 
	private Connection  obtenerConexion() throws SQLException {
		return conexion.getConnection(); 
		
	}
	
	
}

