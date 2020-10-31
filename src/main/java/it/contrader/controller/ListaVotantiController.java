package it.contrader.controller;

import java.util.List;

import it.contrader.dto.ListaVotantiDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.service.ListaVotantiService;



public class ListaVotantiController implements Controller {
	
	private static String sub_package = "user.";
	
	private ListaVotantiService listaService;
	/**
	 * Costruisce un oggetto di tipo UserService per poterne usare i metodi
	 */
	public ListaVotantiController() {
		this.listaService = new ListaVotantiService();
	}
	
	
	/**
	 * Metodo dell'interfaccia Controller. Estrae dalla request la mode
	 * (che riceve dalle view specifiche e può essere la richesta di una 
	 * scelta da parte dell'utente "GETCHOICE") e la scelta dell'utente.
	 * 
	 * Se la modalità corrisponde ad una CRUD il controller chiama i service,
	 * altrimenti rimanda alla View della CRUD per richiedere i parametri
	 */
	@Override
	public void doControl(Request request) {
		String mode = (String) request.get("mode");
		//String choice = (String) request.get("choice");
		int id_scheda;
		int id_utente;
		int voto;
		
		switch (mode) {
		case "STAT":
			id_scheda = Integer.parseInt(request.get("id_scheda").toString());
			double[] risultati = listaService.getStatistca(id_scheda);
			request.put("risultati", risultati);
			request.put("id_scheda", id_scheda);
			MainDispatcher.getInstance().callView(sub_package + "Statistica", request);
			break;
			
		case "CONTROL":
			id_scheda = Integer.parseInt(request.get("id_scheda").toString());
			id_utente = Integer.parseInt(request.get("id_utente").toString());
			boolean check = listaService.checkID(id_scheda, id_utente);
			request.put("id_scheda", id_scheda);
			request.put("id_utente", id_utente);
			request.put("check", check);
			request.put("mode", "CHECK");
			MainDispatcher.getInstance().callAction("SchedaVotazione", "doControl", request);
			break;
			
		case "VOTILIST":
			List<ListaVotantiDTO> lista1DTO = listaService.getAll();
			//Impacchetta la request con la lista degli user
			request.put("voti", lista1DTO);
			MainDispatcher.getInstance().callView("VotantiLista", request);
			break;
			
		case "SAVE":
			id_scheda = Integer.parseInt(request.get("id_scheda").toString());
			id_utente = Integer.parseInt(request.get("id_utente").toString());
			voto = Integer.parseInt(request.get("voto").toString());
			ListaVotantiDTO listaDTO = new ListaVotantiDTO(id_utente, id_scheda, voto);
			listaService.insert(listaDTO);
			request.put("id_utente", id_utente);
			MainDispatcher.getInstance().callView("HomeUser", request);
			break;
		}
		
	}
	
}