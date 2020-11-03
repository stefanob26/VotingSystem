package it.contrader.dto;

public class SchedaVotazioneDTO {
	private int id;
	private String Titolo;
	private String Domanda;
	private String Risposta1;
	private String Risposta2;
	private String Risposta3;
	
	
	public SchedaVotazioneDTO() {
		
	}
	
	public SchedaVotazioneDTO(String Titolo, String Domanda, String Risposta1, String Risposta2, String Risposta3) {
		this.Titolo = Titolo;
		this.Domanda = Domanda;
		
		this.Risposta1 = Risposta1;
		this.Risposta2 = Risposta2;
		this.Risposta3 = Risposta3;
		
	}
	
	public SchedaVotazioneDTO(int id, String Titolo, String Domanda, String Risposta1, String Risposta2, String Risposta3) {
		this.id = id;
		this.Titolo = Titolo;
		this.Domanda = Domanda;
		this.Risposta1 = Risposta1;
		this.Risposta2 = Risposta2;
		this.Risposta3 = Risposta3;
	}
	
	//metodi get e set
	
	public int getId() {
		return this.id;
		}
		public void setId(int id) {
		this.id = id;
		}
		public String getTitolo() {
		return this.Titolo;
		}
		public void setTitolo(String Titolo) {
		this.Titolo = Titolo;
		}
		public String getDomanda() {
		return this.Domanda;
		}
		public void setDomanda(String Domanda) {
		this.Domanda = Domanda;
		}
		
		public String getRisposta1() {
			return this.Risposta1;
		}
		public void setRisposta1(String Risposta1) {
			this.Risposta1 = Risposta1;
		}
		
		public String getRisposta2() {
			return this.Risposta2;
		}
		public void setRisposta2(String Risposta2) {
			this.Risposta2 = Risposta2;
		}
		
		public String getRisposta3() {
			return this.Risposta3;
		}
		public void setRisposta3(String Risposta3) {
			this.Risposta3 = Risposta3;
		}

}
