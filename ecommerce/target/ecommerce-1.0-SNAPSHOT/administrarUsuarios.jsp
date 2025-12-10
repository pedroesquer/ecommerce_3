<%-- 
    Document   : administrarUsuarios
    Created on : Nov 11, 2025, 6:22:11 PM
    Author     : pedro
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>        
    <html>  
      <head>
        <meta charset="UTF-8">
        <title>Administrar Usuarios</title>
        <link rel="stylesheet" href="./styles.css">
      </head>  
      <body>
          <%@include file="./WEB-INF/fragmentos/nav-bar.jspf" %>
            <main>
                <div class="layout-admin">
                    <%@include file="./WEB-INF/fragmentos/aside-admin.jspf" %>
                    <div class="contenido-general">
                        <div class = "botonRegresar">
                    <a href="./menuadministrador.jsp">
                        <img src="./imgs/svg/regresar.svg" alt="Regresar" height="40px" width="40px">
                    </a>
                </div>
                <div>
                    <h1>Clientes</h1>
                </div>


                <div class="contenedorClientes">
                    <c:forEach var="u" items="${usuarios}">
                        <div class="usuario">
                            <p class="nombre"><strong>Nombre: </strong>${u.nombre}</p>
                            <p class="correo"><strong>Correo: </strong>${u.correo}</p>

                            <p class="Estado">
                                <strong>Estado: </strong>
                                <c:choose>
                                    <c:when test="${u.esActivo}">
                                        <span style="color: green;">Activo</span>
                                    </c:when>
                                    <c:otherwise>
                                        <span style="color: red;">Inactivo</span>
                                    </c:otherwise>
                                </c:choose>
                            </p>

                            <div class="acciones" style="display: flex; gap: 15px; justify-content: center; margin-top: 10px;">
                                <c:choose>
                                    <c:when test="${u.esActivo}">
                                        <form action="administrar-usuarios" method="POST">
                                            <input type="hidden" name="accion" value="desactivar">
                                            <input type="hidden" name="idUsuario" value="${u.id}">
                                            <button type="submit" title="Desactivar Usuario" style="border:none; background:none; cursor:pointer; font-size: 1.2rem;">
                                                ❌
                                            </button>
                                        </form>
                                    </c:when>
                                    <c:otherwise>
                                        <form action="administrar-usuarios" method="POST">
                                            <input type="hidden" name="accion" value="activar">
                                            <input type="hidden" name="idUsuario" value="${u.id}">
                                            <button type="submit" title="Activar Usuario" style="border:none; background:none; cursor:pointer; font-size: 1.2rem;">
                                                ✅
                                            </button>
                                        </form>
                                    </c:otherwise>
                                </c:choose>

                                <c:if test="${!u.esActivo}">
                                    <form action="administrar-usuarios" method="POST" onsubmit="return confirm('¿Estás seguro de eliminar este usuario?');">
                                        <input type="hidden" name="accion" value="eliminar">
                                        <input type="hidden" name="idUsuario" value="${u.id}">
                                        <button type="submit" title="Eliminar Usuario" style="border:none; background:none; cursor:pointer; font-size: 1.2rem;">
                                            🗑️
                                        </button>
                                    </form>
                                </c:if>
                                 <c:if test="${u.esActivo}">
                                     <button type="button" title="Debes desactivar primero para eliminar" style="border:none; background:none; opacity: 0.3; cursor: not-allowed; font-size: 1.2rem;">
                                        🗑️
                                    </button>
                                 </c:if>
                            </div>
                        </div>
                    </c:forEach>
                </div>


                 <table class="tabla-usuarios">
                    <thead>
                        <tr>
                            <th>Nombre</th>
                            <th>Correo</th>
                            <th>Estado</th>
                            <th>Acciones</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="u" items="${usuarios}">
                            <tr>
                                <td>${u.nombre}</td>
                                <td>${u.correo}</td>
                                <td>
                                    <c:choose>
                                        <c:when test="${u.esActivo}">
                                            <span style="color: green;">Activo</span>
                                        </c:when>
                                        <c:otherwise>
                                            <span style="color: red;">Inactivo</span>
                                        </c:otherwise>
                                    </c:choose>
                                </td>
                                <td>
                                    <div class="acciones" style="display: flex; gap: 10px;">

                                        <c:choose>
                                            <c:when test="${u.esActivo}">
                                                <form action="administrar-usuarios" method="POST">
                                                    <input type="hidden" name="accion" value="desactivar">
                                                    <input type="hidden" name="idUsuario" value="${u.id}">
                                                    <button type="submit" title="Desactivar Usuario" style="border:none; background:none; cursor:pointer;">
                                                        ❌ </button>
                                                </form>
                                            </c:when>
                                            <c:otherwise>
                                                <form action="administrar-usuarios" method="POST">
                                                    <input type="hidden" name="accion" value="activar">
                                                    <input type="hidden" name="idUsuario" value="${u.id}">
                                                    <button type="submit" title="Activar Usuario" style="border:none; background:none; cursor:pointer;">
                                                        ✅ </button>
                                                </form>
                                            </c:otherwise>
                                        </c:choose>

                                        <c:if test="${!u.esActivo}">
                                            <form action="administrar-usuarios" method="POST" onsubmit="return confirm('¿Estás seguro de eliminar este usuario?');">
                                                <input type="hidden" name="accion" value="eliminar">
                                                <input type="hidden" name="idUsuario" value="${u.id}">
                                                <button type="submit" title="Eliminar Usuario" style="border:none; background:none; cursor:pointer;">
                                                    🗑️
                                                </button>
                                            </form>
                                        </c:if>

                                        <c:if test="${u.esActivo}">
                                             <button type="button" title="Debes desactivar primero para eliminar" style="border:none; background:none; opacity: 0.3; cursor: not-allowed;">
                                                🗑️
                                            </button>
                                         </c:if>

                                    </div>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                    </div>
                </div>


            </main>

            <%@include file="./WEB-INF/fragmentos/nav-mobile.jspf" %>        
            <%@include file="./WEB-INF/fragmentos/footer.jspf" %>
      </body>


    </html>
