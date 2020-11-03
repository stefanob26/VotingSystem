package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;
import it.contrader.dto.SchedaVotazioneDTO;
import it.contrader.model.SchedaVotazione;

public class SchedaVotazioneConverter implements Converter<SchedaVotazione, SchedaVotazioneDTO> {
	/**
	 * Crea un oggetto di tipo SchedaVotazioneDTO e lo riempie con i campi del parametro schedav di tipo SchedaVotazione.
	 */
	
	public SchedaVotazioneDTO toDTO(SchedaVotazione schedav) {
		SchedaVotazioneDTO schedaDTO = new SchedaVotazioneDTO(schedav.getId(), schedav.getTitolo(), schedav.getDomanda(), 
				schedav.getRisposta1(), schedav.getRisposta2(), schedav.getRisposta3());
		return schedaDTO;
		
	}
	
	
	/**
	 * Crea un oggetto di tipo SchedaVotazione e lo riempie con i campi del parametro schedaDTO di tipo SchedaVotazioneDTO.
	 */
	public SchedaVotazione toEntity(SchedaVotazioneDTO schedaDTO) {
		SchedaVotazione schedav = new SchedaVotazione(schedaDTO.getId(), schedaDTO.getTitolo(), schedaDTO.getDomanda(), 
				schedaDTO.getRisposta1(), schedaDTO.getRisposta2(), schedaDTO.getRisposta3());
		return schedav;
	}
	
	
	/**
	 * Metodo per convertire le liste di SchedaVotazione.
	 */
	public List<SchedaVotazioneDTO> toDTOList(List<SchedaVotazione> schedaList) {
		//Crea una lista vuota.
		List<SchedaVotazioneDTO> schedaDTOList = new ArrayList<SchedaVotazioneDTO>();
		
		//Cicla tutti gli elementi della lista e li converte uno a uno
		for(SchedaVotazione scheda : schedaList) {
			//Utilizza il metodo toDTO per convertire ogni singolo elemento della lista
			//e lo aggiunge adda lista di DTO
			schedaDTOList.add(toDTO(scheda));
		}
		return schedaDTOList;
	}
	
}
