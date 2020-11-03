package it.contrader.model;

public class UtenteVotante {
	private int id_utente;
	private int id_scheda;
	private int voto;
	
	public UtenteVotante() {
		
	}
	
	public UtenteVotante(int id_utente, int id_scheda,int voto) {
		this.id_utente = id_utente;
		this.id_scheda = id_scheda;
		this.voto = voto;
	}
	
	//metodi get e set
	public int getidutente() {
		return this.id_utente;
	}
	public int getidscheda() {
		return this.id_scheda;
	}
	public int getvoto() {
		return this.voto;
	}
	public void setidutente(int id) {
		this.id_utente = id;
	}
	public void setidscheda(int id) {
		this.id_scheda = id;
	}
	public void setvoto(int voto) {
		this.voto = voto;
	}
	
	
	
	//metodo equals
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UtenteVotante other = (UtenteVotante) obj;
		if (id_utente != other.id_utente)
			return false;
		if (id_scheda != other.id_scheda)
			return false;
		if (voto == 3) {
			if (other.voto != 3)
				return false;
		} else if (voto != other.voto)
			return false;
		return true;
	}
	
	//Conversione classe in string
	public String toString() {
		return Integer.toString(id_utente)+"\t"+Integer.toString(id_scheda)+"\t"+Integer.toString(voto);
	}
}
