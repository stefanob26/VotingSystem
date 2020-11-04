package it.contrader.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.contrader.dto.UtenteVotanteDTO;
import it.contrader.service.UtenteVotanteService;

 public class UtenteVotanteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UtenteVotanteServlet() {
	}
	
 public void updateList(HttpServletRequest request) {
		UtenteVotanteService service = new UtenteVotanteService();
		List<UtenteVotanteDTO>listDTO = service.getAll();
		request.setAttribute("list", listDTO);
	}

 	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			UtenteVotanteService service = new UtenteVotanteService();
			String mode = request.getParameter("mode");
			UtenteVotanteDTO dto;
			int id_scheda;
			int id_utente;
			int voto;
	

	switch (mode.toUpperCase()) {

	case "VOTOLIST":
		updateList(request);
		getServletContext().getRequestDispatcher("/user/usermanager.jsp").forward(request, response);
		break;
	
	case "CONTROL":
		id_scheda = Integer.parseInt(request.getParameter("id_scheda"));
		id_utente = Integer.parseInt(request.getParameter("id_utente"));
		boolean check = service.checkUser(id_scheda, id_utente);
		request.setAttribute("id_scheda", id_scheda);
		request.setAttribute("id_utente", id_utente);
		request.setAttribute("check", check);
		request.setAttribute("mode", "CHECK");
		getServletContext().getRequestDispatcher("/src/main/java/it/contrader/servlets/SchedaVotazioneServlet.java").forward(request, response);
		break;
	
	case "INSERT":
		id_scheda = Integer.parseInt(request.getParameter("id_scheda"));
		id_utente = Integer.parseInt(request.getParameter("id_utente"));
		voto = Integer.parseInt(request.getParameter("voto"));
		dto = new UtenteVotanteDTO (id_utente,id_scheda,voto);
		boolean ans = service.insert(dto);
		request.setAttribute("ans", ans);
		updateList(request);
		getServletContext().getRequestDispatcher("/user/votantimanager.jsp").forward(request, response);
		break;
	
	case "STAT":
		id_scheda = Integer.parseInt(request.getParameter("id_scheda"));
		double[] risultati = service.getStatistca(id_scheda);
		double totale = risultati[0] + risultati[1] + risultati[2];
		risultati[0] = (risultati[0]/totale)*100;
		risultati[1] = (risultati[1]/totale)*100;
		risultati[2] = (risultati[2]/totale)*100;
		request.setAttribute("risultati", risultati);
		request.setAttribute("id_scheda", id_scheda);
		getServletContext().getRequestDispatcher("/user/statisticheview.jsp").forward(request, response);
		break;
		}
	}	
	
}