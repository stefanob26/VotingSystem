package it.contrader.view.scheda;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class SchedaInsertView extends AbstractView{
	
	private final String mode = "INSERT";
	private final String sub_package = "scheda.";
	private Request request;
	
	private String titolo;
	private String domanda;
	private String Risposta1;
	private String Risposta2;
	private String Risposta3 = "NON VALIDA";
	
	
	public SchedaInsertView() {
		
	}
	
	
	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("Inserimento andato a buon fine.\n");
			MainDispatcher.getInstance().callView(sub_package + "SchedaGestione", null);
		}
		
	}

	@Override
	public void showOptions() {
		
		System.out.println("Immettere il titolo della scheda");
		this.titolo = getInput();
		System.out.println("Immettere la domanda della scheda");
		this.domanda = getInput();
		System.out.println("Immettere la prima risposta della scheda");
		this.Risposta1 = getInput();
		System.out.println("Immettere la seconda risposta della scheda");
		this.Risposta2 = getInput();
	}

	@Override
	public void submit() {
		request = new Request();
		request.put("titolo", this.titolo);
		request.put("domanda", this.domanda);
		request.put("risposta1", this.Risposta1);
		request.put("risposta2", this.Risposta2);
		request.put("risposta3", this.Risposta3);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("SchedaVotazione", "doControl", request);
		
	}

}
