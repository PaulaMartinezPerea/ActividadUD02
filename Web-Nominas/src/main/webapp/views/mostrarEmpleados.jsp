<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, model.Empleado" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Lista de Empleados</title>
    <link rel="stylesheet" href="../css/mostrarEmpleados.css">
</head>
<body>
    <h2>Lista de Empleados</h2>
    <table border="1">
        <tr>
            <th>Nombre</th>
            <th>DNI</th>
            <th>Sexo</th>
            <th>Categoría</th>
            <th>Años Trabajados</th>
        </tr>
        <%
            List<Empleado> empleados = (List<Empleado>) request.getAttribute("empleados");
            for (Empleado e : empleados) {
        %>
        <tr>
            <td><%= e.getNombre() %></td>
            <td><%= e.getDni() %></td>
            <td><%= e.getSexo() %></td>
            <td><%= e.getCategoria() %></td>
            <td><%= e.getAnyos() %></td>
        </tr>
        <% } %>
    </table>
    <br>
    <form action="../pagina.jsp">
        <input type="submit" value="Volver">
    </form>
</body>
</html>