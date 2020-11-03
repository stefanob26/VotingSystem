package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.UserDTO;
import it.contrader.dto.UtenteVotanteDTO;
import it.contrader.model.User;
import it.contrader.model.UtenteVotante;

public class UtenteVotanteConverter implements Converter<UtenteVotante, UtenteVotanteDTO>{

	@Override
	public UtenteVotanteDTO toDTO(UtenteVotante entity) {
		UtenteVotanteDTO utentev = new UtenteVotanteDTO(entity.getidutente(), entity.getidscheda(), entity.getvoto());
		return utentev;
	}

	@Override
	public UtenteVotante toEntity(UtenteVotanteDTO dto) {
		UtenteVotante utente = new UtenteVotante(dto.getidutente(), dto.getidscheda(), dto.getvoto());
		return utente;
	}

	@Override
	public List<UtenteVotanteDTO> toDTOList(List<UtenteVotante> entityList) {
		//Crea una lista vuota.
		List<UtenteVotanteDTO> utenteDTOList = new ArrayList<UtenteVotanteDTO>();
				
		//Cicla tutti gli elementi della lista e li converte uno a uno
		for(UtenteVotante utente : entityList) {
			//Utilizza il metodo toDTO per convertire ogni singolo elemento della lista
			//e lo aggiunge adda lista di DTO
			utenteDTOList.add(toDTO(utente));
		}
		return utenteDTOList;
	}

}
