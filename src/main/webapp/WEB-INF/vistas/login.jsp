<%@page contentType="text/html" pageEncoding="UTF-8" %>

<jsp:include page="arriba.jsp"></jsp:include>

<form autocomplete="on" method="POST" action="">
Correo: <input required autocomplete="on" type="email"    id="ucorreo"     placeholder="correo"     /><br/>
Contraseña: <input required autocomplete="on" type="password" id="ucontrasena" placeholder="contrasena" /><br/>
<input type="submit" value="iniciar sesion" onclick="iniciarSesion()" />
</form>

<jsp:include page="abajo.jsp"></jsp:include>
