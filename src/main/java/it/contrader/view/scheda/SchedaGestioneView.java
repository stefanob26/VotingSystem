package it.contrader.view.scheda;

import java.util.List;

import it.contrader.controller.Request;
import it.contrader.dto.SchedaVotazioneDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class SchedaGestioneView extends AbstractView{
	
	private Request request;
	private String choice;

	@Override
	public void showResults(Request request) {
		if (request != null) {
			System.out.println("\n------------------- Gestione Schede ----------------\n");
			System.out.println("ID\tTitolo\tScheda");
			System.out.println("----------------------------------------------------\n");
			
			@SuppressWarnings("unchecked")
			List<SchedaVotazioneDTO> schede = (List<SchedaVotazioneDTO>) request.get("schede");
			for (SchedaVotazioneDTO s: schede)
				System.out.println(s.getId()+"\t"+s.getTitolo());
			System.out.println();
		}
		
	}

	@Override
	public void showOptions() {
		System.out.println("          Scegli l'operazione da effettuare:");
		System.out.println("[L]eggi [I]nserisci [C]cancella [B]ack [E]sci");

		this.choice = getInput();
		
	}

	@Override
	public void submit() {
		
		request = new Request();
		request.put("choice", choice);
		request.put("mode", "GETCHOICE");
		MainDispatcher.getInstance().callAction("SchedaVotazione", "doControl", this.request);
	}

}
