package it.contrader.view.user;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class VotazioneView extends AbstractView {

	Request request1 = new Request();
	private int voto;
	private String choice;
	private String mode = "GETCHOICE";
	private String msg = "";
	
	@Override
	public void showResults(Request request) {
		request1 = request;
		msg = request.get("msg").toString();	
		if(!msg.equals("")) {
			System.out.println(request.get("msg")+"\nTorna indietro premendo [X]");
			
		}
		 
		 if(msg.equals("")) {
			 System.out.println(request.get("domanda"));
			 System.out.println("[1]-" + request.get("risposta1"));
			 System.out.println("[2]-" + request.get("risposta2"));
			 System.out.println("[3]-" + request.get("risposta3"));
			 System.out.println("Procedere con la votazione digitando 1, 2 o 3");
			
		 }
		
	}

	@Override
	public void showOptions() {
		
		if(!msg.equals("")) {
			
			choice = getInput();
			while(!choice.equals("X")) {
				System.out.println("Digitare [X] per uscire");
				choice = getInput();
			}
			
		}
		 
		 if(msg.equals("")) {
			 
			 voto = Integer.parseInt(getInput());
		 }
	}

	@Override
	public void submit() {
		if(!msg.equals("")) {
			Request req = new Request();
			req.put("mode", mode);
			req.put("choice", choice);
			req.put("id_utente", Integer.parseInt(request1.get("id_utente").toString()));
			MainDispatcher.getInstance().callAction("User", "doControl", req);
		}
		 
		 if(msg.equals("")) {
			 Request req = new Request();
			 req.put("voto", voto);
			 req.put("id_utente", Integer.parseInt(request1.get("id_utente").toString()));
			 req.put("id_scheda", Integer.parseInt(request1.get("id_scheda").toString()));
			 req.put("mode", "SAVE");
			 MainDispatcher.getInstance().callAction("ListaVotanti", "doControl", req);
		 }
		
	}

}
