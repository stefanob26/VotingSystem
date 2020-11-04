package it.contrader.service;

import java.util.List;

import it.contrader.converter.UtenteVotanteConverter;
import it.contrader.dao.UtenteVotanteDAO;
import it.contrader.dto.UtenteVotanteDTO;

public class UtenteVotanteService {
	
	private UtenteVotanteDAO dao;
	private UtenteVotanteConverter converter;
	
	
	public UtenteVotanteService() {
		this.dao = new UtenteVotanteDAO();
		this.converter = new UtenteVotanteConverter();
	}

	public double[] getStatistca(int id) {
		return converter.getStatistica(dao.statistica(id));
	}
	
	public boolean checkUser(int id_scheda, int id_utente) {
		return dao.checkUser(id_scheda,id_utente);
	}
	
	public List<UtenteVotanteDTO> getAll() {
		// Ottiene una lista di entità e le restituisce convertendole in DTO
		return converter.toDTOList(dao.getAll());
	}
	
	public boolean insert(UtenteVotanteDTO dto) {
		// Converte un DTO in entità e lo passa al DAO per l'inserimento
		return dao.insert(converter.toEntity(dto));
	}
}
