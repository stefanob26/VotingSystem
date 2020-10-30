package it.contrader.controller;


import it.contrader.dto.SchedaVotazioneDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.service.SchedaVotazioneService;



public class SchedaVotazioneController implements Controller{
	
	private SchedaVotazioneService schedaService;
	private String sub_package = "user.";
	private SchedaVotazioneDTO scheda = new SchedaVotazioneDTO();
	
	public SchedaVotazioneController() {
		this.schedaService = new SchedaVotazioneService();
	}


	public void doControl(Request request) {
		String mode = (String) request.get("mode");
		//String choice = (String) request.get("choice");
		int id_scheda = Integer.parseInt(request.get("id_scheda").toString());
		int id_utente = Integer.parseInt(request.get("id_utente").toString());
		boolean chk = Boolean.parseBoolean(request.get("check").toString());
		int voto;
		
		if (chk) {
			scheda = schedaService.read(id_scheda);
			request.put("id_utente", id_utente);
			request.put("msg", "");
			request.put("domanda", scheda.getDomanda());
			request.put("risposta1", scheda.getRisposta1());
			request.put("risposta2", scheda.getRisposta2());
			request.put("risposta3", scheda.getRisposta3());
			request.put("id_scheda", id_scheda);
			MainDispatcher.getInstance().callView(sub_package + "Votazione", request);
		} else if(!chk) {
		
			String msg = "Hai già votato, torna indietro!!";
			request.put("msg", msg);
			request.put("id_utente", id_utente);
			MainDispatcher.getInstance().callView(sub_package + "Votazione", request);
		}
		
	}
}




