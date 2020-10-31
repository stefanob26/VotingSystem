package it.contrader.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.contrader.main.ConnectionSingleton;
import it.contrader.model.ListaVotanti;


public class ListaVotantiDAO {
	private final String QUERY_ALL = "SELECT * FROM listavotanti";
	private final String QUERY_CREATE = "INSERT INTO listavotanti (id_utente, id_scheda, voto) VALUES (?,?,?)";
	private final String QUERY_ANALYTICS = "SELEC COUNT(*) AS total FROM listavotanti WHERE  id_scheda = ?";
	private final String QUERY_CONTROL = "SELECT * FROM listavotanti WHERE id_utente = ? AND id_scheda = ?";
	
	
	public ListaVotantiDAO() {
		
	}
	
	public List<ListaVotanti> getAll() {
		List<ListaVotanti> schedeList = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			ListaVotanti listavotanti;
			while (resultSet.next()) {
				int id_utente = resultSet.getInt("id_utente");
				int id_scheda = resultSet.getInt("id_scheda");
				int voto = resultSet.getInt("voto");
				listavotanti = new ListaVotanti(id_utente, id_scheda, voto);
				schedeList.add(listavotanti);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return schedeList;
	}
	
	public boolean insert(ListaVotanti listaToInsert) {
		Connection connection = ConnectionSingleton.getInstance();
		try {	
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_CREATE);
			preparedStatement.setInt(1, listaToInsert.getidutente());
			preparedStatement.setInt(2, listaToInsert.getidscheda());
			preparedStatement.setInt(3, listaToInsert.getvoto());
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			return false;
		}

	}
	
	public double[] statistica(int id) {
		double[] percentuali = new double[3]; 
		
		Connection conn1 = ConnectionSingleton.getInstance();
		Connection conn2 = ConnectionSingleton.getInstance();
		Connection conn3 = ConnectionSingleton.getInstance();
		PreparedStatement ps1;
		PreparedStatement ps2;
		PreparedStatement ps3;
		
		ResultSet rs1;
		ResultSet rs2;
		ResultSet rs3;
		try {
			ps1 = conn1.prepareStatement(QUERY_ANALYTICS);
			ps1.setInt(1, id);
			//ps1.setInt(2, 1);
			rs1 = ps1.executeQuery();
			
			if(rs1.next())
				percentuali[0] = 1.0;
			
			ps2 = conn2.prepareStatement(QUERY_ANALYTICS);
			ps2.setInt(1, id);
			//ps2.setInt(2, 2);
			rs2 = ps2.executeQuery();
			
			if(rs2.next())
				percentuali[1] = 1.0;
			
			ps3 = conn3.prepareStatement(QUERY_ANALYTICS);
			ps3.setInt(1, id);
			//ps3.setInt(2, 3);
			rs3 = ps3.executeQuery();
			
			if(rs3.next())
				percentuali[2] = 1.0;
			
			
			
		
		} catch (SQLException e) {
		}
		return percentuali;
	}
	
	
	public boolean checkUser(int id_scheda, int id_utente) {
		Connection connection = ConnectionSingleton.getInstance();
		ResultSet rs;
		int count = 0;
		try {	
			
			PreparedStatement ps = connection.prepareStatement(QUERY_CONTROL);
			ps.setInt(1, id_scheda);
			ps.setInt(2, id_utente);
			
			rs = ps.executeQuery();
			if(rs.next())
				count++;
			
		
		} catch (SQLException e) {
			return false;
		}
		
		if(count == 0)
			return true;
		return false;
		
	}
}






