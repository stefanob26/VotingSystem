package it.contrader.view;


import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;

public class HomeUserView extends AbstractView{
	Request req = new Request();
	String choice;
	private String usertype = "USER"; 
	int id_utente;
	
	@Override
	public void showResults(Request request) {
		id_utente = Integer.parseInt(request.get("id_utente").toString());
		if(request != null) {
			System.out.println("HOME UTENTE " + request.get("id_utente") );
		}
		
	}

	@Override
	public void showOptions() {
		System.out.println("-------------MENU------------\n");
		System.out.println("Premi [v] per votare oppure [e] per uscire");
		
		choice = this.getInput();

	}

	@Override
	public void submit() {
		
		switch (choice) {
		
		case "v":
			
			req.put("usertype", usertype);
			req.put("mode", "SCHEDELIST");
			req.put("id_utente", id_utente);
			MainDispatcher.getInstance().callAction("User", "doControl", req);
			break;

		case "e":
			MainDispatcher.getInstance().callAction("Login", "doControl", null);
			break;

		default:
			MainDispatcher.getInstance().callAction("Login", "doControl", null);
		}
	}

}
