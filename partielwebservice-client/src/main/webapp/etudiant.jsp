<%@page import="java.util.ArrayList"%>
<%@page import="domaine.User"%>
<%@page import="domaine.Etudiant"%>
<%@page import="java.util.List"%>

<!-- header -->
<%@include file="header.jsp"%>
<!-- Navigation-->
<%@include file="menuhaut.jsp"%>

<div class="container" style="margin-top: 150px">

	<% if(session.getAttribute("message")!=null) { %>
	
	<div class="alert alert-secondary alert-dismissible fade show" role="alert">
	  <strong> <%= session.getAttribute("message") %> </strong>
	  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
	    <span aria-hidden="true">&times;</span>
	  </button>
	</div>
	
	<% 
	}
    %>

	<a class="btn btn-primary mb-3 mt-10" href="AjoutEtudiantServlet">Ajout un étudiant</a>

	<form action="RechercheEtudiantServlet" method="post">

		<div class="form-row">

			<div class="col">
				<div class="md-form md-outline mt-0">
					<input type="text" id="firstNameR" name="firstNameR"
						class="form-control"> <label for="firstNameR">First
						Name</label>
				</div>
			</div>

			<div class="col">
				<div class="md-form md-outline mt-0">
					<input type="text" id="lastNameR" name="lastNameR"
						class="form-control"> <label for="lastNameR">Last
						Name</label>
				</div>
			</div>

			<div class="text-center mb-2">
				<button type="submit" class="btn btn-primary mb-4">Research</button>
			</div>
		</div>
	</form>

	<!-- Masthead Heading-->
	<%
		List<Etudiant> listEtudiant =  (List<Etudiant>) session.getAttribute("students");
		if (user.getProfil().equalsIgnoreCase("D")) {
			
		%>
		<h1>Liste des étudiants</h1>
		<%} else {	%>
		<h1>Informations sur un étudiant</h1>
		<%} %>
	

	<div class="table-responsive text-nowrap">
		<!--Table-->

		<table class="table table-striped" id="paginationFull">

			<!--Table head-->
			<thead>
				<tr>

					<th id="ID" name="ID">Id</th>
					<th style="width: 150px;">First Name</th>
					<th>Last Name</th>
					<th>Mail Address</th>
					<th>Address</th>
					<th style="width: 70px;">Phone Number</th>
					<th style="width: 70px;">BirthDay</th>
					<th>Action</th>
				</tr>
			</thead>
			<!--Table head-->

			<!--Table body-->
			<tbody>
				<%
					int i = 0;

				for (Etudiant student : listEtudiant) {
				%>

				<tr>
					<td><%=student.getId()%></td>
					<td><%=student.getFirst_name()%></td>
					<td><%=student.getLast_name()%></td>
					<td><%=student.getMail()%></td>
					<td><%=student.getAddress()%></td>
					<td><%=student.getPhone()%></td>
					<td><%=student.getDob()%></td>
					<td>

						
								<a href="EditerEtudiantServlet?id=<%=student.getId()%>" >Edit</a>				
								
								<a href="SupprimerEtudiantServlet?id=<%=student.getId()%>" style="color:red">Delete</a>
								
								<a href="ViewEtudiantServlet?id=<%=student.getId()%>" style="color:blue">View</a>
								
							  <a href="EtudiantCoursServlet?id=<%=student.getId()%>" style="color:blue">Cours</a> 
								
						

					</td>
				</tr>
				<%
					}
				%>
			</tbody>
			<!--Table body-->


		</table>
		<!--Table-->
	</div>

	<!--Section: Live preview-->

</div>




<!-- footer -->
<script>
	
</script>
<%@include file="footer.jsp"%>