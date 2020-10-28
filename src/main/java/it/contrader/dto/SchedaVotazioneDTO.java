package it.contrader.dto;
import java.util.HashMap;

import it.contrader.model.User;


public class SchedaVotazioneDTO {
	private int id;
	private String Titolo;
	private String Domanda;
	private String[] Risposte;
	private HashMap<User, String> ListaVotanti;
	
	public SchedaVotazioneDTO() {
		
	}
	
	public SchedaVotazioneDTO(int id, String Titolo, String Domanda, String[] Risposte) {
		this.id = id;
		this.Titolo = Titolo;
		this.Domanda = Domanda;
		this.Risposte = new String[3]; 
		this.Risposte[0] = Risposte[0];
		this.Risposte[1] = Risposte[1];
		this.Risposte[2] = "Nulla";
		
		this.ListaVotanti = new HashMap<User, String>();
		
	}
	
	//metodi get e set
	
	//metodo equals	
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SchedaVotazioneDTO other = (SchedaVotazioneDTO) obj;
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
		if(Risposte == null) {
			if(other.Risposte != null)
				return false;
		}else if(!Risposte.equals(other.Risposte))
			return false;
		if(ListaVotanti.isEmpty()) {
			if(!ListaVotanti.isEmpty())
				return false;
		}else if(!ListaVotanti.equals(other.ListaVotanti))
			return false;
		return true;
	}
	
	//metodo aggiungi Votanti
	
	
	
}
