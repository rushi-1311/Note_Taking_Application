<%@page import="org.hibernate.Transaction"%>
<%@page import="com.entities.Note"%>
<%@page import="com.utility.Hibutility"%>
<%@page import="org.hibernate.Session"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="All_js_css.jsp" %>
</head>
<body>
            <div class = "container">
           <%@include file="Nav.jsp" %>
             <h1>Edit Your Note</h1>
             <br>
             
             <%
             Session s = Hibutility.getSessionFactory().getCurrentSession();
             Transaction tx = s.beginTransaction();
             int note_Id = Integer.parseInt(request.getParameter("note_id").trim());
             Note note = (Note) s.get(Note.class, note_Id);
             %>
             <form action  ="UpdateServlet" method = "post">
             
             <input value="<%= note.getId() %>" name="noteId" type="hidden">
  <div class="form-group">
    <label for="title">Note Title</label>
    <input name = "title"
     required type="text" class="form-control" 
     id = "title" 
    aria-describedby="emailHelp"
     placeholder="Enter Here"
     value="<%= note.getTitle()%>"/>
    
  </div>
  <div class="form-group">
    <label for="content">Note Content</label>
    <textarea 
    name = "content"
    id = "content" 
    placeholder = "Enter Your Content"
    class = "form-control"
    style = "height:300px;"><%= note.getContent() %>
    </textarea>
  </div>   
        <div class = "container text-center">
        <button type="submit" class="btn btn-success">Save Your Note</button>
        </div>
  
</form>
            <%
               tx.commit();
            %>
             </div>
</body>
</html>