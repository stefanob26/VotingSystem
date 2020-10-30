package it.contrader.service;

import java.util.List;
import it.contrader.converter.ListaVotantiConverter;
import it.contrader.dao.ListaVotantiDAO;
import it.contrader.dto.ListaVotantiDTO;



public class ListaVotantiService {
	private ListaVotantiDAO listaDAO;
	private ListaVotantiConverter listaConverter;
	
	public ListaVotantiService() {
		this.listaDAO = new ListaVotantiDAO();
		this.listaConverter = new ListaVotantiConverter();
	}
	
	public List<ListaVotantiDTO> getAll() {
		// Ottiene una lista di entità e le restituisce convertendole in DTO
		return listaConverter.toDTOList(listaDAO.getAll());
	}	


	public boolean insert(ListaVotantiDTO dto) {
		// Converte un DTO in entità e lo passa al DAO per l'inserimento
		return listaDAO.insert(listaConverter.toEntity(dto));
	}

	public double[] getStatistca(int id) {
		return listaConverter.getStatistica(listaDAO.statistica(id));
	}
	
	public boolean checkID(int id_scheda, int id_utente) {
		return listaDAO.checkUser(id_scheda, id_utente);
	}

}