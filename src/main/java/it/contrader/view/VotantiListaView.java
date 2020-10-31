package it.contrader.view;

import java.util.List;

import it.contrader.controller.Request;
import it.contrader.dto.ListaVotantiDTO;
import it.contrader.dto.UserDTO;
import it.contrader.main.MainDispatcher;

public class VotantiListaView extends AbstractView{
	
	private Request request;
	private String choice;
	
	public VotantiListaView() {
		
	}
	@Override
	public void showResults(Request request) {
		if (request != null) {
			System.out.println("\n------------------- Lista Voti ----------------\n");
			System.out.println("tIdUtente\tIdScheda\tVoto");
			System.out.println("----------------------------------------------------\n");
			
			@SuppressWarnings("unchecked")
			List<ListaVotantiDTO> voti = (List<ListaVotantiDTO>) request.get("voti");
			for (ListaVotantiDTO v: voti)
				System.out.println(v.getidutente()+"\t"+
						v.getidscheda()+"\t"+
						v.getvoto()+"\t");
			System.out.println();
		}
		
	}

	@Override
	public void showOptions() {
		System.out.println("Premi [E] per uscire");
		choice = getInput();
		
	}

	@Override
	public void submit() {
		switch(choice) {
		case "e" :
			MainDispatcher.getInstance().callView("Login", null);
			break;
			
			default:
				MainDispatcher.getInstance().callView("Login", null);
		}
		
	}

}
