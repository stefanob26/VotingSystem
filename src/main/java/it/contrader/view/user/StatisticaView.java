package it.contrader.view.user;

import java.util.List;

import it.contrader.controller.Request;
import it.contrader.dto.SchedaVotazioneDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class StatisticaView extends AbstractView {
	double[] risultati;
	private Request req;
	private final String mode = "GETCHOICE";
	private String choice = "";
	
	
	public StatisticaView() {
		
	}
	/**
	 * Se la request  null (ovvero quando arriva dal controller con mode GETCHOICE e choice L 
	 * il metodo  vuoto.
	 * 
	 * Altrimenti se arriva con uno user nella request (ovvero quando arriva
	 * dal controller con mode READ) mostra lo user. In questo caso torna alla UserView senza eseguire
	 * gli altri due metodi
	 */
	public void showResults(Request request) {
		if (request != null) {
			System.out.println("\n------------------- Risultato votazioni\t" +request.get("id_scheda") +"----------------\n");
			@SuppressWarnings("unchecked")
			double[] risultati = (double[]) request.get("risultati");
			int x = 0;
			String s = null;
			for (double r: risultati) {	
				if(x == 0) {
					s = "si";
				} if(x == 1) {
					s = "no";	
				}
				if(x == 2) {
					s = "nulla";
				}
				
				System.out.println("percentuale\t" +s +"\t" +r);
				x++;
			}
			System.out.println();
			
		}
	}

	
	/**
	 * chiede all'utente di inserire l'id dell'utente da leggere
	 */
	public void showOptions() {
		
		System.out.println("Premi [B] per tornare indietro");
		String s = getInput();
		while(!s.equals("b")) {
			System.out.println("opzione errata digitare b per tornare indietro");
			s = getInput();
		}
		this.choice = s;
	}
	
	/**
	 * impacchetta una request con l'id dell'utente da leggere e la manda al controller tramite il Dispatcher
	 */
	@Override
	public void submit() {
		req = new Request();
		req.put("choice", this.choice);
		req.put("mode", this.mode);
		req.put("usertype", "ADMIN");
		MainDispatcher.getInstance().callAction("User", "doControl", req);
	}
	
}
