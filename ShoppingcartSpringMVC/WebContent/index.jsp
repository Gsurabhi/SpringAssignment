<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="container">
	<div class="row">
		<div class="col m2"></div>
		<div class="col m8">
			<h2>Login Page</h2>

			<form:form commandName="user" method="POST" action="login">
				<table>
					
					<tr>
						<td><form:label path="username">Username</form:label></td>
						<td><form:input path="username" /></td>
						<td><font color="red"><form:errors  path="username" /></font></td>
					</tr>
					<tr>
						<td><form:label path="password">Password</form:label></td>
						<td><form:password path="password" /></td>
						<td><font color="red"><form:errors  path="password" /></font></td>
						
					</tr>
					<tr>
						<td></td>
						<td colspan="2"><input  type="submit" value="Submit" /></td>
					</tr>
				</table>
			</form:form>
		</div>
		<div class="col m2"></div>
	</div>
</div>


