/**
 * Manage a Business Owner view
 */

package it.contrader.view;


/**
 * Per Ulteriori dettagli vedi Guida sez 9 View.
 * Per la descrizione dei metodi vedi l'interfaccia View in questo pacchetto.
 */
import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;

public class HomeAdminView extends AbstractView {

    private String choice;
    private String usertype = "ADMIN"; 
	private Request request;

	/**
	 * Se la request non nulla mostra un messaggio di benvenuto
	 */
    public void showResults(Request request) {
    	if(request!=null) {
    	System.out.println("\n Benvenuto in SAMPLE PROJECT "+request.get("username").toString() + "\n");
    	}
    }


    /**
     * Chiede all'utente di effettuare una scelta (da console)
     */
    public void showOptions() {
        System.out.println("-------------MENU------------\n");
        System.out.println(" Seleziona cosa vuoi gestire:");
        System.out.println("[U]tenti [S]tatistiche [L]ista Votanti [G]estione Schede [E]sci");
        //Il metodo che salva l'input nella stringa choice.
        //getInput() definito in AbstractView.
        choice = this.getInput();
    }

    /**
     * Impacchetta una request (in base alla scelta sarà diversa) che invia ai controller tramite il
     * Dispatcher
     */
    public void submit() {    
    	//crea una nuova Request (vedi classe Request)
    	request = new Request();
        switch (choice) {
        case "u":
        	this.request.put("mode", "USERLIST");
        	MainDispatcher.getInstance().callAction("User", "doControl", request);
        	break;
 
        case "s":
        	this.request.put("mode", "SCHEDELIST");
        	this.request.put("choice", "choice");
        	this.request.put("usertype", this.usertype);
        	
        	MainDispatcher.getInstance().callAction("User", "doControl", request);
        	break;
        	
        case "l":
        	this.request.put("mode", "VOTILIST");
        	this.request.put("choice", "choice");
        	this.request.put("usertype", this.usertype);
        	
        	MainDispatcher.getInstance().callAction("ListaVotanti", "doControl", request);
        	break;
        	
        case "g":
        	this.request.put("mode", "SCHEDEGEST");
        	this.request.put("choice", "choice");
        	this.request.put("usertype", this.usertype);
        	
        	MainDispatcher.getInstance().callAction("User", "doControl", request);
        	break;
        	
        case "e":
        	MainDispatcher.getInstance().callAction("Login", "doControl", null);
        	break;
        default:
        	
            request.put("choice", choice);
        	MainDispatcher.getInstance().callAction("Login", "doControl", request);
        }
    }
}