package it.contrader.service;

import it.contrader.converter.UtenteVotanteConverter;
import it.contrader.dao.UtenteVotanteDAO;
import it.contrader.dto.UtenteVotanteDTO;
import it.contrader.model.UtenteVotante;

public class UtenteVotanteService extends AbstractService<UtenteVotante, UtenteVotanteDTO>{
	
	public UtenteVotanteService() {
		this.dao = new UtenteVotanteDAO();
		this.converter = new UtenteVotanteConverter();
	}
}
