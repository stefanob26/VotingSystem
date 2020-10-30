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
	//private final String QUERY_READ = "SELECT * FROM listavotanti WHERE id_scheda=? AND voto=?";
	private final String QUERY_ANALYTICS = "SELECT COUNT(voto) AS total FROM listavotanti WHERE id_scheda=? AND voto=?";
	private final String QUERY_CONTROL = "SELECT COUNT(voto) AS total FROM listavotanti WHERE id_scheda=? AND id_utente=?";
	
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
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_ANALYTICS);
			preparedStatement.setInt(1, id);
			preparedStatement.setInt(2, 1);
			ResultSet rs = preparedStatement.executeQuery();
			if (rs.next()) {
			     
				percentuali[0] = (double)rs.getInt("Total");
			}
			PreparedStatement preparedStatement1 = connection.prepareStatement(QUERY_ANALYTICS);
			preparedStatement.setInt(1, id);
			preparedStatement.setInt(2, 2);
			ResultSet rs1 = preparedStatement1.executeQuery();
			if (rs1.next()) {
			     
				percentuali[1] = (double)rs1.getInt("Total");
			}
			
			PreparedStatement preparedStatement2 = connection.prepareStatement(QUERY_ANALYTICS);
			preparedStatement.setInt(1, id);
			preparedStatement.setInt(2, 3);
			ResultSet rs2 = preparedStatement2.executeQuery();
			if (rs2.next()) {
			     
				percentuali[2] = (double)rs2.getInt("Total");
			}
			double totale = percentuali[0] + percentuali[1] + percentuali[2];
			percentuali[0] = (percentuali[0]/totale)*100;
			percentuali[1] = (percentuali[1]/totale)*100;
			percentuali[2] = (percentuali[2]/totale)*100;
			
		} catch (SQLException e) {
		}
		return percentuali;
	}
	
	
	public boolean checkUser(int id_scheda, int id_utente) {
		Connection connection = ConnectionSingleton.getInstance();
		int count = 100;
		ResultSet rs;
		try {	
			
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_CONTROL);
			preparedStatement.setInt(1, id_scheda);
			preparedStatement.setInt(2, id_utente);
			System.out.println("t");
			rs = preparedStatement.executeQuery();
			rs.next();
			count = rs.getInt("total");
		} catch (SQLException e) {
			
		}
		
		if(count == 0)
			return true;
		return false;
		
	}
}






