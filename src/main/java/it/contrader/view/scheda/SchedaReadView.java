package it.contrader.view.scheda;

import it.contrader.controller.Request;
import it.contrader.dto.SchedaVotazioneDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class SchedaReadView extends AbstractView{

	private int id;
	private Request request;
	private final String mode = "READ";
	private final String sub_package = "scheda.";

	@Override
	public void showResults(Request request) {
		if (request != null) {
			SchedaVotazioneDTO scheda = (SchedaVotazioneDTO) request.get("scheda");
			System.out.println(scheda.getTitolo()+"\t"+
					scheda.getDomanda()+"\t"+
					scheda.getRisposta1()+"\t"+
					scheda.getRisposta2()+"\t"+
					scheda.getRisposta3()+"\t");
			MainDispatcher.getInstance().callView(sub_package + "SchedaGestione", null);
		}
		
	}

	@Override
	public void showOptions() {
		System.out.println("Inserisci l'ID della scheda:");
		id = Integer.parseInt(getInput());
		
	}

	@Override
	public void submit() {
		request = new Request();
		request.put("id", id);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("SchedaVotazione", "doControl", request);
		
	}

}
