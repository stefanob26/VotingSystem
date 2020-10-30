package it.contrader.converter;
import it.contrader.dto.ListaVotantiDTO;
import it.contrader.model.ListaVotanti;
import java.util.List; 
import java.util.ArrayList;

public class ListaVotantiConverter {
	
	/*
	 * Da modello a DTO
	 */
	
	public ListaVotantiDTO toDTO(ListaVotanti lista) {
		ListaVotantiDTO ListaVotantiDTO = new ListaVotantiDTO(lista.getidscheda(), lista.getidutente(), lista.getvoto());
		return ListaVotantiDTO;
	}
	
	/*
	 * Da DTO a modello
	 */
	
	public ListaVotanti toEntity(ListaVotantiDTO listaDTO) {
		ListaVotanti lista = new ListaVotanti(listaDTO.getidscheda(), listaDTO.getidutente(), listaDTO.getvoto());
		return lista;
	}
	
	/**
	 * Metodo per convertire le liste di ListaVotanti.
	 */
	public List<ListaVotantiDTO> toDTOList(List<ListaVotanti> votList) {
		//Crea una lista vuota.
		List<ListaVotantiDTO> votDTOList = new ArrayList<ListaVotantiDTO>();
		
		//Cicla tutti gli elementi della lista e li converte uno a uno
		for(ListaVotanti lista : votList) {
			//Utilizza il metodo toDTO per convertire ogni singolo elemento della lista
			//e lo aggiunge adda lista di DTO
			votDTOList.add(toDTO(lista));
		}
		return votDTOList;
	}
	
	/*
	 * Metodo per recuperare la statistica
	 */
	
	public double[] getStatistica(double[] aperc) {
		double[] perc = new double[3];
		perc = aperc;
		return perc;
	}
	
		
}