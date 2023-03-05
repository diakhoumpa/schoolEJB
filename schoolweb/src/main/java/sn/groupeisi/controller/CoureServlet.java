package sn.groupeisi.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.util.List;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import sn.groupeisi.entities.Coures;
import sn.groupeisi.interfaces.Icoures;

@WebServlet(name = "cours",urlPatterns ={"*.php"})
public class CoureServlet extends HttpServlet {
	 private static final long serialVersionUID = 1L;
	 private static String VIEW_PATH = "/view/coures/";
	@EJB
	private Icoures coursdao;
   
    public CoureServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Coures coures = new Coures();
		//coures.setId(0);
		//coures.setName("JEE");
		//coures.setProgramme("M1");
		//coursdao.add(coures);
		List<Coures> couresList = coursdao.list(coures);
        request.setAttribute("couresList", couresList);
		request.getRequestDispatcher(VIEW_PATH + "list.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action=request.getParameter("action");
		if (action.equals("Enregistrer")) {
			String name = request.getParameter("name");
	        String programme  = request.getParameter("programme");
	        if (name.isEmpty()||programme.isEmpty()) {
	        	// Ajouter un message de confirmation
	        	request.setAttribute("error", "Veuillez renseigner tous les champs");
	            this.getServletContext().getRequestDispatcher(VIEW_PATH + "list.jsp").forward(request, response);
			}
	        else {
	        	  Coures c = new Coures();
	 	         c.setName(name);
	 	         c.setProgramme(programme);
	 	         coursdao.add(c);
	             List<Coures> couresList = coursdao.list(c);
	             request.setAttribute("couresList", couresList);
	           // Ajouter un message de confirmation
	             String message = "L'objet a été ajouté avec succès.";
	             request.setAttribute("message", message);
	 		    request.getRequestDispatcher(VIEW_PATH + "list.jsp").forward(request, response);
			} 
	}

}
}
