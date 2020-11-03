package it.contrader.servlets;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import it.contrader.dto.SchedaVotazioneDTO;
import it.contrader.service.Service;
import it.contrader.service.SchedaVotazioneService;


public class SchedaVotazioneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public SchedaVotazioneServlet() {	
	}
	
	public void updateList(HttpServletRequest request) {
		Service<SchedaVotazioneDTO> service = new SchedaVotazioneService();
		List<SchedaVotazioneDTO>listDTO = service.getAll();
		request.setAttribute("list", listDTO);
	}
	
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Service<SchedaVotazioneDTO> service = new SchedaVotazioneService();
		SchedaVotazioneDTO scheda = new SchedaVotazioneDTO();
		String mode = request.getParameter("mode");
		SchedaVotazioneDTO dto;
		int id_scheda;
		boolean ans;
		
		switch (mode.toUpperCase()) {
		
		case "SCHEDELIST":
			updateList(request);
			getServletContext().getRequestDispatcher("/user/usermanager.jsp").forward(request, response);
			break;
			
		case "READ":
			id_scheda = Integer.parseInt(request.getParameter("id_scheda"));
			dto = service.read(id_scheda);
			request.setAttribute("dto", dto);
			
			if (request.getParameter("update") == null) {
				 getServletContext().getRequestDispatcher("/user/readscheda.jsp").forward(request, response);
				
			}
			
			else getServletContext().getRequestDispatcher("/user/updatescheda.jsp").forward(request, response);
			
			break;	
			
		case "INSERT":
			String titolo = request.getParameter("titolo").toString();
			String domanda = request.getParameter("domanda").toString();
			String risposta1 = request.getParameter("risposta1").toString();
			String risposta2 = request.getParameter("risposta2").toString();
			String risposta3 = request.getParameter("risposta3").toString();
			dto = new SchedaVotazioneDTO(titolo,domanda,risposta1, risposta2, risposta3);
			ans = service.insert(dto);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/user/schedemanager.jsp").forward(request, response);
			break;
			
			
		case "UPDATE":
			titolo = request.getParameter("titolo");
			domanda = request.getParameter("domanda");
			risposta1 = request.getParameter("risposta1");
			risposta2 = request.getParameter("risposta2");
			risposta3 = request.getParameter("risposta3");
			id_scheda = Integer.parseInt(request.getParameter("id_scheda"));
			dto = new SchedaVotazioneDTO(titolo,domanda,risposta1, risposta2, risposta3);
			ans = service.update(dto);
			updateList(request);
			getServletContext().getRequestDispatcher("/user/schedemanager.jsp").forward(request, response);
			break;	
			
		case "DELETE":
			id_scheda = Integer.parseInt(request.getParameter("id_scheda"));
			ans = service.delete(id_scheda);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/user/schedemanager.jsp").forward(request, response);
			break;	
		
		case "CHECK":
			id_scheda = Integer.parseInt(request.getParameter("id_scheda"));
			int id_utente = Integer.parseInt(request.getParameter("id_utente"));
			boolean check = Boolean.parseBoolean(request.getParameter("check"));
			scheda = service.read(id_scheda);
			request.setAttribute("id_scheda", id_scheda);
			request.setAttribute("id_utente", id_utente);
			request.setAttribute("domanda", scheda.getDomanda());
			request.setAttribute("risposta1",scheda.getRisposta1());
			request.setAttribute("risposta2",scheda.getRisposta2());
			request.setAttribute("risposta3",scheda.getRisposta3());
			request.setAttribute("check", check);
			getServletContext().getRequestDispatcher("/user/VotazioneView.jsp").forward(request, response);
			
			break;
		}
		
	
	
	}
}
