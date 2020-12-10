
<!-- header -->

<%@page import="domaine.Cours"%>
<%@page import="domaine.Etudiant"%>
<%@include file="header.jsp"%>
<!-- Navigation-->
<%@include file="menuhaut.jsp"%>

<!-- D�but ajout etudiant -->

<div class="container">
	<br /> <br /> <br /> <br /> <br /> <br />

	<a class="btn btn-primary mb-5  text-center " href="cours.jsp">Liste des cours</a>
	

	<!-- Masthead Heading-->
	<h1>Modifier un cours</h1>
	
	<div class="">
	
		<div class="pt-4 pb-3">
			<% Cours cours = (Cours) session.getAttribute("cours");%>
			<form action="ModifCoursServlet" method="post">
				<div class="form-row">
				
					<input type="text" id="id" name="id" hidden class="form-control" value="<%=cours.getId()%>">
				
					<div class="col">
						<div class="md-form md-outline mt-0">
							<label for="firstName">Course Theme</label>
							<input type="text" id="courseTheme" name="courseTheme" class="form-control" value="<%=cours.getThemeCourse()%>"> 
						</div>
					</div>
					
					<div class="col">
						<div class="md-form md-outline mt-0">
							<label for="lastName">Course Time</label>
							<input type="text" id="courseTime" name="courseTime" class="form-control" value="<%=cours.getNumberHours()%>"> 
						</div>
					</div>
					
				</div>
				<div class="text-center mt-3">
					<button type="submit" class="btn btn-primary mb-4">Submit</button>
				</div>
			</form>



		</div>

	</div>
	<!-- Card -->

</div>
<!-- Fin ajout etudiant -->

<!-- footer -->
<%@include file="footer.jsp"%>