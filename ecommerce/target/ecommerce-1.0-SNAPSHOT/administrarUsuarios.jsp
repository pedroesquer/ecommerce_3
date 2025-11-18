<%-- 
    Document   : administrarUsuarios
    Created on : Nov 11, 2025, 6:22:11 PM
    Author     : pedro
--%>

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
                    <div class="usuario">
                        <p class="nombre">Gael Guerra</p>
                        <p class="correo">gaelwar@gmail.com</p>
                        <p class="Estado">Activo</p>
                        <div class="acciones">
                            <span class="activo">❌</span>
                            <span class="papelera">🗑️</span>
                        </div>
                    </div>


                    <!-- Usuario 2 -->
                    <div class="usuario">
                        <p class="nombre">Juan Heras</p>
                        <p class="correo">juanpi@gmail.com</p>
                        <p class="Estado">Inactivo</p>
                        <div class="acciones">
                            <span class="activo">❌</span>
                            <span class="papelera">🗑️</span>
                        </div>
                    </div>
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
                    <tr>
                        <td>Gael Guerra</td>
                        <td>gaelwar@gmailcom.com</td>
                        <td>Activo</td>
                        <td>
                        <div class="acciones">
                            <span class="activo">❌</span>
                            <span class="papelera">🗑️</span>
                        </div>
                        </td>
                    </tr>
                    <tr>
                        <td>Juan Heras</td>
                        <td>jaunpi@gmail.com</td>
                        <td>Inactivo</td>
                        <td>
                        <div class="acciones">
                            <span class="inactivo">✅</span>
                            <span class="papelera">🗑️</span>
                        </div>
                        </td>
                    </tr>
                    </tbody>
                </table>
                    </div>
                </div>


            </main>


            <%@include file="./WEB-INF/fragmentos/footer.jspf" %>
      </body>


    </html>
