package it.contrader.model;

public class SchedaVotazione {
	private int id;
	private String Titolo;
	private String Domanda;
	private String Risposta1;
	private String Risposta2;
	private String Risposta3;
	
	
	public SchedaVotazione() {
		
	}
	
	public SchedaVotazione(String Titolo, String Domanda, String Risposta1, String Risposta2, String Risposta3) {
		this.Titolo = Titolo;
		this.Domanda = Domanda;
		
		this.Risposta1 = Risposta1;
		this.Risposta2 = Risposta2;
		this.Risposta3 = Risposta3;
		
	}
	
	public SchedaVotazione(int id, String Titolo, String Domanda, String Risposta1, String Risposta2, String Risposta3) {
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
			
			
		
		
	//metodo equals
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SchedaVotazione other = (SchedaVotazione) obj;
		if (id != other.id)
			return false;
		if (Titolo == null) {
			if (other.Titolo != null)
				return false;
		} else if (!Titolo.equals(other.Titolo))
			return false;
		if (Domanda == null) {
			if (other.Domanda != null)
				return false;
		} else if (!Domanda.equals(other.Domanda))
			return false;
		if (Risposta1 == null) {
			if (other.Risposta1 != null)
				return false;
		} else if (!Risposta1.equals(other.Risposta1))
			return false;
		if (Risposta2 == null) {
			if (other.Risposta2 != null)
				return false;
		} else if (!Risposta2.equals(other.Risposta2))
			return false;
		if (Risposta3 == null) {
			if (other.Risposta3 != null)
				return false;
		} else if (!Risposta3.equals(other.Risposta3))
			return false;
		
		return true;
	}
	

}
