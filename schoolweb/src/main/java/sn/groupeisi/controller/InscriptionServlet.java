package sn.groupeisi.controller;

import java.io.IOException;
import java.util.List;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import sn.groupeisi.entities.Coures;
import sn.groupeisi.entities.Inscription;
import sn.groupeisi.entities.Student;
import sn.groupeisi.entities.Year;
import sn.groupeisi.interfaces.IInscription;
import sn.groupeisi.interfaces.Icoures;
import sn.groupeisi.interfaces.Istudent;
import sn.groupeisi.interfaces.Iyear;

@WebServlet("/Inscription")
public class InscriptionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String VIEW_PATH = "/view/inscriptions/";
	@EJB
	private Icoures coursdao;
	@EJB
	private Istudent sdao;
	@EJB
	private Iyear yeardao;
	@EJB
	private IInscription Inscriptiondao;
	
	public InscriptionServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// List courses
		Coures coures = new Coures();
		List<Coures> couresList = coursdao.list(coures);
		// List students
		Student s = new Student();
		List<Student> studentList = sdao.list(s);
		// List years
		Year y = new Year();
		List<Year> yearList = yeardao.list(y);
		request.setAttribute("yearList", yearList);
		request.setAttribute("studentList", studentList);
		request.setAttribute("couresList", couresList);
		
		Inscription inscription = new Inscription();
		List<Inscription> inscriptionList=Inscriptiondao.list(inscription);
		request.setAttribute("inscriptionList",inscriptionList);
		request.getRequestDispatcher(VIEW_PATH + "list.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
		String action = request.getParameter("action");
		if (action.equals("Inscrire")) {
			//************recuperation depuis formulaire
			String details = request.getParameter("details");
			int idstudent = Integer.parseInt(request.getParameter("studentID"));
			int icours = Integer.parseInt(request.getParameter("coursID"));
			int iyears = Integer.parseInt(request.getParameter("yearsID"));
			if (details.isEmpty()) {
				// Ajouter un message de confirmation
	        	request.setAttribute("error", "Veuillez renseigner tous les champs");
	            this.getServletContext().getRequestDispatcher(VIEW_PATH + "list.jsp").forward(request, response);
			}else {
				//************recupere ID des objects definie dans les interfaces 
				Year year = yeardao.getYearById(iyears);
				Coures course = coursdao.getCouresById(icours);
				Student student = sdao.getStudentById(idstudent);
				//************pour l'insertion  
				Inscription inscription = new Inscription();
				inscription.setDetails(details);
				inscription.setCourses(course);
				inscription.setStudent(student);
				inscription.setYears(year);
				Inscriptiondao.add(inscription);
				//affichage des listes
				Inscription inscription2 = new Inscription();
				List<Inscription> inscriptionList=Inscriptiondao.list(inscription2);
				request.setAttribute(" inscriptionList",  inscriptionList);
				
				request.getRequestDispatcher(VIEW_PATH + "list.jsp").forward(request, response);
			}
         
		}
     }
}

