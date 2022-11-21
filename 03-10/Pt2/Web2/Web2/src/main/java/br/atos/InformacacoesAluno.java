package br.atos;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InformacacoesAluno
 */
@WebServlet("/InformacacoesAluno")
public class InformacacoesAluno extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InformacacoesAluno() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter wr = response.getWriter();
		wr.println("<!DOCTYPE html>");
		wr.println("<html>");
		
		wr.print("<head>");
		wr.println("<meta charset=\"ISO-8859-1\">");
		wr.println("<title>Dados</title>");
		wr.println("</head>");
		wr.println("<body>");
		wr.println("<h1>Dados</h1>");
		wr.println("<h2>Nome:</h2>");
		wr.println("<p>Arthur Vinicius Fogaça de Andrade</p>");
	
		wr.println("<h2>Idade: </h2>");
		wr.println("<p>23</p>");
		
		wr.println("<h2>Como se enxerga daqui 5 anos dentro do universo java: </h2>");
		wr.println("<p>Desenvovedor senior com alto conhecimento em arquitetura de software e soluções </p>");
		
		wr.println("</body>");
		wr.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
