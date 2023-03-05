package sn.groupeisi.controller;

import java.io.IOException;
import java.util.List;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import sn.groupeisi.entities.Year;
import sn.groupeisi.interfaces.Iyear;

@WebServlet(name = "years",urlPatterns ={"*.sn"})
public class YearServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String VIEW_PATH = "/view/years/";
    @EJB	
    Iyear yeardao;
    public YearServlet() {super(); }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Year y = new Year();
        List<Year> yearList = yeardao.list(y);
        request.setAttribute("yearList", yearList);
		request.getRequestDispatcher(VIEW_PATH + "list.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action =request.getParameter("action");
		if (action.equals("Enregistrer")) {
			String name = request.getParameter("name");
			Year y = new Year();
			y.setName(name);
			yeardao.add(y);
			List<Year> yearList = yeardao.list(y);
	        request.setAttribute("yearList", yearList);
			request.getRequestDispatcher(VIEW_PATH + "list.jsp").forward(request, response);
		}
	}

}
