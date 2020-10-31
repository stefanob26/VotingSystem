package it.contrader.view.user;



import java.util.List;

import it.contrader.controller.Request;
import it.contrader.dto.SchedaVotazioneDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class SchedeView extends AbstractView {
	private int id_scheda;
	private Request req;
	private final String mode = "STAT";
	private String choice = "";
	private String usertype;
	private int id_utente;
	public SchedeView() {
		
	}
	
	/**
	 * Se la request null (ovvero quando arriva dal controller con mode GETCHOICE e choice L 
	 * il metodo  vuoto.
	 * 
	 * Altrimenti se arriva con uno user nella request (ovvero quando arriva
	 * dal controller con mode READ) mostra lo user. In questo caso torna alla UserView senza eseguire
	 * gli altri due metodi
	 */
	public void showResults(Request request) {
		
		if (request != null) {
			
			this.usertype = request.get("usertype").toString();
			if(this.usertype.equals("USER"))
				id_utente = Integer.parseInt(request.get("id_utente").toString());
			System.out.println("\n------------------- Gestione schede votazioni ----------------\n");
			System.out.println("ID\tTitolo");
			System.out.println("----------------------------------------------------\n");
			@SuppressWarnings("unchecked")
			
			List<SchedaVotazioneDTO> scheda = (List<SchedaVotazioneDTO>) request.get("scheda");
			
			for (SchedaVotazioneDTO s: scheda) {
				System.out.println(s.getId() +"\t" +s.getTitolo());
			}
			System.out.println();
			
		}
	}

	
	/**
	 * chiede all'utente di inserire l'id dell'utente da leggere
	 */
	public void showOptions() {
		if(usertype.equals("ADMIN")) {
			String aus = "";
			System.out.println("Inserisci l'ID della scheda per statistica oppure digitare [B] per tornare alla home");
			aus = getInput();
			if(aus.equals("B")) {
				choice = aus;
			} else {
				id_scheda = Integer.parseInt(aus);
			}
		} 
		if(usertype.equals("USER")) {
			String aus = "";
			System.out.println("Inserisci l'ID della scheda per procedere alla votazione oppure premere [X] per tornare alla home");
			aus = getInput();
			if(aus.equals("X")) {
				choice = aus;
			} else {
				id_scheda = Integer.parseInt(aus);
				
			}
		}
	}
	
	/**
	 * impacchetta una request con l'id dell'utente da leggere e la manda al controller tramite il Dispatcher
	 */
	@Override
	public void submit() {
		req = new Request();
		
		if(usertype.equals("ADMIN")) {
			if(!choice.equals("")) {
				req.put("choice", choice);
				req.put("mode", "GETCHOICE");
				MainDispatcher.getInstance().callAction("User", "doControl", req);
			} else {
				req.put("id_scheda", id_scheda);
				req.put("mode", mode);
				MainDispatcher.getInstance().callAction("ListaVotanti", "doControl", req);
			}		
			
		}
		
		if(usertype.equals("USER")) {
			if(!choice.equals("")) {
				req.put("choice", choice);
				req.put("mode", "GETCHOICE");
				req.put("id_utente", id_utente);
				MainDispatcher.getInstance().callAction("User", "doControl", req);
			} else {				
				req.put("id_scheda", id_scheda);
				req.put("id_utente", id_utente);
				req.put("mode", "CONTROL");
				MainDispatcher.getInstance().callAction("ListaVotanti", "doControl", req);
			}
		}
		
	}
	
}
