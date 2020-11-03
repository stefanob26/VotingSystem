package it.contrader.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.contrader.model.UtenteVotante;
import it.contrader.utils.ConnectionSingleton;

public class UtenteVotanteDAO implements DAO<UtenteVotante> {
	private final String QUERY_ALL = "SELECT * FROM utentevotante";
	private final String QUERY_CREATE = "INSERT INTO utentevotante (id_utente, id_scheda, voto) VALUES (?,?,?)";
	private final String QUERY_ANALYTICS = "SELECT COUNT(*) AS total FROM utentevotante WHERE  id_scheda = ? AND voto = ?";
	private final String QUERY_CONTROL = "SELECT * FROM utentevotante WHERE id_utente = ? AND id_scheda = ?";
	
	public UtenteVotanteDAO() {
		
	}
	
	public List<UtenteVotante> getAll() {
		List<UtenteVotante> listaUtentiVotanti = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			UtenteVotante utente;
			while (resultSet.next()) {
				int id_utente = resultSet.getInt("id_utente");
				int id_scheda = resultSet.getInt("id_scheda");
				int voto = resultSet.getInt("voto");
				utente = new UtenteVotante(id_utente, id_scheda, voto);
				listaUtentiVotanti.add(utente);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaUtentiVotanti;
	}
	
	public boolean insert(UtenteVotante utenteToInsert) {
		Connection connection = ConnectionSingleton.getInstance();
		try {	
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_CREATE);
			preparedStatement.setInt(1, utenteToInsert.getidutente());
			preparedStatement.setInt(2, utenteToInsert.getidscheda());
			preparedStatement.setInt(3, utenteToInsert.getvoto());
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			return false;
		}

	}
	
	public double[] statistica(int id) {
		double[] numeroRisposte = new double[3]; 
		
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_ANALYTICS);
			preparedStatement.setInt(1, id);
			preparedStatement.setInt(2, 1);
			ResultSet rs = preparedStatement.executeQuery();
			if (rs.next()) {
			     
				numeroRisposte[0] = (double)rs.getInt("Total");
			}
			PreparedStatement preparedStatement1 = connection.prepareStatement(QUERY_ANALYTICS);
			preparedStatement1.setInt(1, id);
			preparedStatement1.setInt(2, 2);
			ResultSet rs1 = preparedStatement1.executeQuery();
			if (rs1.next()) {
			     
				numeroRisposte[1] = (double)rs1.getInt("Total");
			}
			
			PreparedStatement preparedStatement2 = connection.prepareStatement(QUERY_ANALYTICS);
			preparedStatement2.setInt(1, id);
			preparedStatement2.setInt(2, 3);
			ResultSet rs2 = preparedStatement2.executeQuery();
			if (rs2.next()) {
			     
				numeroRisposte[2] = (double)rs2.getInt("Total");
			}
						
			
		
		} catch (SQLException e) {
			
		}
		return numeroRisposte;
	}
	
	
	public boolean checkUser(int id_scheda, int id_utente) {
		Connection connection = ConnectionSingleton.getInstance();
		ResultSet rs;
		int count = 0;
		try {	
			
			PreparedStatement ps = connection.prepareStatement(QUERY_CONTROL);
			ps.setInt(1, id_utente);
			ps.setInt(2, id_scheda);
			
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

	@Override
	public UtenteVotante read(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(UtenteVotante dto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}
}
