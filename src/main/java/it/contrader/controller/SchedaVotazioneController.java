package it.contrader.controller;


import it.contrader.dto.SchedaVotazioneDTO;
import it.contrader.dto.UserDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.service.SchedaVotazioneService;



public class SchedaVotazioneController implements Controller{
	
	private SchedaVotazioneService schedaService;
	private String sub_package = "scheda.";
	private String sub_package1 ="user.";
	private SchedaVotazioneDTO scheda = new SchedaVotazioneDTO();
	private int id;
	Request req;
	
	private String titolo;
	private String domanda;
	private String Risposta1;
	private String Risposta2;
	private String Risposta3;
	
	public SchedaVotazioneController() {
		this.schedaService = new SchedaVotazioneService();
	}


	public void doControl(Request request) {
		String choice = "";
		String mode = (String) request.get("mode");
		if(request.get("choice") !=null)
			choice = (String) request.get("choice");
		
		
		switch (mode) {
		
		// Arriva qui dalla UserReadView. Invoca il Service con il parametro id e invia alla UserReadView uno user da mostrare 
		case "READ":
			id = Integer.parseInt(request.get("id").toString());
			SchedaVotazioneDTO schedaDTO = this.schedaService.read(id);
			request.put("scheda", schedaDTO);
			MainDispatcher.getInstance().callView(sub_package + "SchedaRead", request);
			break;
			
			
		case "INSERT":
			this.titolo = request.get("titolo").toString();
			this.domanda = request.get("domanda").toString();
			this.Risposta1 = request.get("risposta1").toString();
			this.Risposta2 = request.get("risposta2").toString();
			this.Risposta3 = request.get("risposta3").toString();
			
			//costruisce l'oggetto user da inserire
			SchedaVotazioneDTO schedatoinsert = new SchedaVotazioneDTO(this.titolo, this.domanda, this.Risposta1, this.Risposta2, this.Risposta3);
			//invoca il service
			schedaService.insert(schedatoinsert);
			Request req1 = new Request();
			req1.put("mode", "mode");
			//Rimanda alla view con la risposta
			MainDispatcher.getInstance().callView(sub_package + "SchedaInsert", req1);
			break;
			
		case "DELETE":
			id = Integer.parseInt(request.get("id").toString());
			//Qui chiama il service
			schedaService.delete(id);
			request = new Request();
			request.put("mode", "mode");
			
			MainDispatcher.getInstance().callView(sub_package + "SchedaDelete", request);
			break;
		
			
			
			
		case "CHECK":
			int id_scheda = Integer.parseInt(request.get("id_scheda").toString());
			int id_utente = Integer.parseInt(request.get("id_utente").toString());
			boolean chk = Boolean.parseBoolean(request.get("check").toString());

			if (chk) {
				scheda = schedaService.read(id_scheda);
				request.put("id_utente", id_utente);
				request.put("msg", "");
				request.put("domanda", scheda.getDomanda());
				request.put("risposta1", scheda.getRisposta1());
				request.put("risposta2", scheda.getRisposta2());
				request.put("risposta3", scheda.getRisposta3());
				request.put("id_scheda", id_scheda);
				MainDispatcher.getInstance().callView(sub_package1 + "Votazione", request);
			} else if(!chk) {
				
				String msg = "Hai già votato, torna indietro!!";
				request.put("msg", msg);
				request.put("id_utente", id_utente);
				MainDispatcher.getInstance().callView(sub_package1 + "Votazione", request);
			}
			break;
			
		case "GETCHOICE":
			switch (choice.toUpperCase()) {
			case "L":
				MainDispatcher.getInstance().callView(sub_package + "SchedaRead", null);
				break;
				
			case "I":
				MainDispatcher.getInstance().callView(sub_package + "SchedaInsert", null);
				break;				
			
			case "C":
				MainDispatcher.getInstance().callView(sub_package + "SchedaDelete", null);
				break;
				
			case "E":
				MainDispatcher.getInstance().callView("Login", null);
				break;

			case "B":
				this.req = new Request();
				this.req.put("mode", "SCHEDEGEST");
	        	this.req.put("choice", "choice");
	        	this.req.put("usertype", "ADMIN");
				MainDispatcher.getInstance().callAction("User", "doControl", this.req);
				break;
				
			}
			
		default:
			MainDispatcher.getInstance().callView("Login", null);
		
		}
		
	}
}




