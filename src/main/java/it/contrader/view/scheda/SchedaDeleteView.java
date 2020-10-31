package it.contrader.view.scheda;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class SchedaDeleteView extends AbstractView {

	
	private Request request;
	private final String sub_package = "scheda.";
	private int id;
	private final String mode = "DELETE";
	
	public SchedaDeleteView() {
		
	}
	
	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("Cancellazione andata a buon fine.\n");
			MainDispatcher.getInstance().callView(sub_package + "SchedaGestione", null);
		}
		
	}

	@Override
	public void showOptions() {
		
		System.out.println("Inserisci id della scheda da eliminare:");
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
