package it.contrader.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import it.contrader.utils.ConnectionSingleton;
import it.contrader.model.SchedaVotazione;

public class SchedaVotazioneDAO implements DAO<SchedaVotazione> {
	private final String QUERY_ALL = "SELECT * FROM schedavotazione";
	private final String QUERY_CREATE = "INSERT INTO schedavotazione (Titolo, Domanda, Risposta1, Risposta2, Risposta3) VALUES (?,?,?,?,?)";
	private final String QUERY_READ = "SELECT * FROM schedavotazione WHERE id=?";
	private final String QUERY_UPDATE = "UPDATE schedavotazione SET Titolo=?, Domanda=?, Risposta1=?, Risposta2=?, Risposta3=? WHERE id=?";
	private final String QUERY_DELETE = "DELETE FROM schedavotazione WHERE id=?";
	
	public SchedaVotazioneDAO() {
		
	}
	
	public List<SchedaVotazione> getAll() {
		List<SchedaVotazione> schedeList = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			SchedaVotazione schedavotazione;
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String Titolo = resultSet.getString("Titolo");
				String Domanda = resultSet.getString("Domanda");
				String Risposta1 = resultSet.getString("Risposta1");
				String Risposta2 = resultSet.getString("Risposta2");
				String Risposta3 = resultSet.getString("Risposta3");
				
				
				schedavotazione = new SchedaVotazione(id, Titolo, Domanda, Risposta1, Risposta2, Risposta3);
				schedeList.add(schedavotazione);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return schedeList;
	}
	
	public boolean insert(SchedaVotazione schedaToInsert) {
		Connection connection = ConnectionSingleton.getInstance();
		try {	
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_CREATE);
			preparedStatement.setString(1, schedaToInsert.getTitolo());
			preparedStatement.setString(2, schedaToInsert.getDomanda());
			preparedStatement.setString(3, schedaToInsert.getRisposta1());
			preparedStatement.setString(4, schedaToInsert.getRisposta2());
			preparedStatement.setString(5, schedaToInsert.getRisposta3());
			
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			return false;
		}

	}
	
	public SchedaVotazione read(int schedaId) {
		Connection connection = ConnectionSingleton.getInstance();
		try {


			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1, schedaId);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			String Titolo, Domanda;
			String Risposta1 = resultSet.getString("Risposta1");
			String Risposta2 = resultSet.getString("Risposta2");
			String Risposta3 = resultSet.getString("Risposta3");
			Titolo = resultSet.getString("Titolo");
			Domanda = resultSet.getString("Domanda");
			
			
			SchedaVotazione schedavotazione = new SchedaVotazione(Titolo, Domanda, Risposta1, Risposta2, Risposta3);
			schedavotazione.setId(resultSet.getInt("id"));

			return schedavotazione;
		} catch (SQLException e) {
			return null;
		}

	}
	
	public boolean update(SchedaVotazione schedaToUpdate) {
		Connection connection = ConnectionSingleton.getInstance();

		// Check if id is present
		if (schedaToUpdate.getId() == 0)
			return false;

		SchedaVotazione schedaRead = read(schedaToUpdate.getId());
		if (!schedaRead.equals(schedaToUpdate)) {
			try {
				// Fill the userToUpdate object
				if (schedaToUpdate.getTitolo() == null || schedaToUpdate.getTitolo().equals("")) {
					schedaToUpdate.setTitolo(schedaRead.getTitolo());
				}

				if (schedaToUpdate.getDomanda() == null || schedaToUpdate.getDomanda().equals("")) {
					schedaToUpdate.setDomanda(schedaRead.getDomanda());
				}

				if (schedaToUpdate.getRisposta1() == null || schedaToUpdate.getRisposta1().equals("")) {
					schedaToUpdate.setRisposta1(schedaRead.getRisposta1());
				}
				
				if (schedaToUpdate.getRisposta2() == null || schedaToUpdate.getRisposta2().equals("")) {
					schedaToUpdate.setRisposta2(schedaRead.getRisposta2());
				}
				
				if (schedaToUpdate.getRisposta3() == null || schedaToUpdate.getRisposta3().equals("")) {
					schedaToUpdate.setRisposta3(schedaRead.getRisposta3());
				}

				// Update the user
				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
				preparedStatement.setString(1, schedaToUpdate.getTitolo());
				preparedStatement.setString(2, schedaToUpdate.getDomanda());
				preparedStatement.setString(3, schedaToUpdate.getRisposta1());
				preparedStatement.setString(4, schedaToUpdate.getRisposta2());
				preparedStatement.setString(5, schedaToUpdate.getRisposta3());
				preparedStatement.setInt(6, schedaToUpdate.getId());
				int a = preparedStatement.executeUpdate();
				if (a > 0)
					return true;
				else
					return false;

			} catch (SQLException e) {
				return false;
			}
		}

		return false;

	}
	
	public boolean delete(int id) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);
			preparedStatement.setInt(1, id);
			int n = preparedStatement.executeUpdate();
			if (n != 0)
				return true;

		} catch (SQLException e) {
		}
		return false;
	}

}
