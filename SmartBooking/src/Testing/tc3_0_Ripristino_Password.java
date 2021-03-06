package Testing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import Controller.CambioPasswordServlet;
import Controller.RipristinoPassword;
import DBConnection.DriverManagerConnectionPool;
import Model.Docente;
import Model.DocenteModel;
import Model.Studente;
import Model.Utente;
import Model.UtenteModel;

public class tc3_0_Ripristino_Password {
	
	RipristinoPassword myServlet;
	
	@Mock
	HttpServletRequest request;
	
	@Mock
	HttpServletResponse response;
	
	@Mock
	HttpSession session;
	@Mock
	Utente utente;

	@BeforeEach
	public void beforeEachTestCase() throws SQLException{
		request = mock(HttpServletRequest.class);
		response = mock(HttpServletResponse.class);
		session = mock(HttpSession.class);
		myServlet = new RipristinoPassword();
		UtenteModel md = new UtenteModel();	
		utente = md.doRetrieveByKey("05121");
	}
	
	
	
	@Test
	public void tc_1_0_1() throws IOException, ServletException{
		StringWriter output = new StringWriter();
		PrintWriter out = new PrintWriter(output);
	
		
		when(request.getParameter("email")).thenReturn("c@libero.it");
		when(response.getWriter()).thenReturn(out);
		
		
		myServlet.doPost(request, response);
		
		System.out.println(output.toString());
		
		
		assertEquals("non corretto",output.toString().toString());
	}
	
	
	@Test
	public void tc_1_0_2() throws IOException, ServletException{
		StringWriter output = new StringWriter();
		PrintWriter out = new PrintWriter(output);
	
		
		when(request.getParameter("email")).thenReturn("carminesorrentino50carminesorrentino50@studenti.unisa.it");
		when(response.getWriter()).thenReturn(out);
		
		
		myServlet.doPost(request, response);
		
		System.out.println(output.toString());
		
		
		assertEquals("non corretto",output.toString().toString());
	}
	
	
	@Test
	public void tc_1_0_3() throws IOException, ServletException{
		StringWriter output = new StringWriter();
		PrintWriter out = new PrintWriter(output);
	
		
		when(request.getParameter("email")).thenReturn("carminesorrentino50@gmail.com");
		when(response.getWriter()).thenReturn(out);
		
		
		myServlet.doPost(request, response);
		
		System.out.println(output.toString());
		
		
		assertEquals("non corretto",output.toString().toString());
	}
	
	
	@Test
	public void tc_1_0_4() throws IOException, ServletException{
		StringWriter output = new StringWriter();
		PrintWriter out = new PrintWriter(output);
	
		
		when(request.getParameter("email")).thenReturn("carminesorrentino50@studenti.unisa.it");
		when(response.getWriter()).thenReturn(out);
		
		
		myServlet.doPost(request, response);
		
		System.out.println(output.toString());
		
		
		assertEquals("L'indirizzo email non esiste nel db",output.toString().toString());
	}
	
	@Test
	public void tc_1_0_5() throws IOException, ServletException{
		StringWriter output = new StringWriter();
		PrintWriter out = new PrintWriter(output);
		

	
		when(request.getParameter("email")).thenReturn("carminesorrentino51@studenti.unisa.it");
		when(response.getWriter()).thenReturn(out);
		
		
		myServlet.doPost(request, response);
		
		System.out.println(output.toString());
		
		
		assertEquals("email inviato",output.toString().toString());
	}
}