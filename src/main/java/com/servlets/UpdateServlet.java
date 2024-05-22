package com.servlets;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.entities.Note;
import com.utility.Hibutility;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 Session ses = null;
		 Transaction tx = null;
		 
		 ses = Hibutility.getSessionFactory().getCurrentSession();
		 tx  = ses.beginTransaction();
		
		try {
			  String title = request.getParameter("title");
			  String content = request.getParameter("content");
			  int note_id = Integer.parseInt(request.getParameter("noteId").trim());
			  
			  Note note = (Note) ses.get(Note.class, note_id);
			  
			  note.setTitle(title);
			  note.setContent(content);
			  note.setAddedDate(new Date());
			  
			  response.sendRedirect("all_notes.jsp");
			  
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		tx.commit();
	}

}
