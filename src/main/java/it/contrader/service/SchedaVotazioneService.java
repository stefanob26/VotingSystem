package it.contrader.service;

import it.contrader.dao.SchedaVotazioneDAO;
import it.contrader.dto.SchedaVotazioneDTO;


import java.util.List;

import it.contrader.converter.SchedaVotazioneConverter;

public class SchedaVotazioneService{
	private SchedaVotazioneDAO schedaDAO;
	private SchedaVotazioneConverter schedaConverter;
	
	public SchedaVotazioneService() {
		this.schedaDAO = new SchedaVotazioneDAO();
		this.schedaConverter = new SchedaVotazioneConverter();
	}
	
	public List<SchedaVotazioneDTO> getAll() {
		// Ottiene una lista di entità e le restituisce convertendole in DTO
		return schedaConverter.toDTOList(schedaDAO.getAll());
	}


	public SchedaVotazioneDTO read(int id) {
		// Ottiene un'entità e la restituisce convertendola in DTO
		return schedaConverter.toDTO(schedaDAO.read(id));
	}


	public boolean insert(SchedaVotazioneDTO dto) {
		// Converte un DTO in entità e lo passa al DAO per l'inserimento
		return schedaDAO.insert(schedaConverter.toEntity(dto));
	}


	public boolean update(SchedaVotazioneDTO dto) {
		// Converte un userDTO in entità e lo passa allo userDAO per la modifica
		return schedaDAO.update(schedaConverter.toEntity(dto));
	}


	public boolean delete(int id) {
		// Questo mtodo chiama direttamente il DAO
		return schedaDAO.delete(id);
	}
	
}