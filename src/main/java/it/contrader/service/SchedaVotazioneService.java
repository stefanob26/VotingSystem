package it.contrader.service;

import it.contrader.dto.SchedaVotazioneDTO;
import it.contrader.model.SchedaVotazione;
import it.contrader.dao.SchedaVotazioneDAO;
import it.contrader.converter.SchedaVotazioneConverter;



public class SchedaVotazioneService extends AbstractService<SchedaVotazione, SchedaVotazioneDTO> {
	
	
	public SchedaVotazioneService() {
		this.dao = new SchedaVotazioneDAO();
		this.converter = new SchedaVotazioneConverter();
	}
	
}
