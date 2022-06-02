<%-- 
    Document   : participante_form
    Created on : 31 may. 2022, 17:09:05
    Author     : MIGUEL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <!-- Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" rel="stylesheet">

    
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Segundo Parcial</title>
    </head>
        
    
    <body>
        <jsp:include page="META-INF/menu.jsp">
            <jsp:param name="opcion" value="participante"/>
        </jsp:include>        
        <div class="container" >

        <h1>Formulario de Participante</h1>
        <br>
        <form action="ParticipanteControlador" method="post"> 
            <input type="hidden" name="id" value="${participante.id}" >
                <div class="mb-3">
                    <label for="nombre" class="form-label">Nombre</label>
                    <input type="text"  name="nombre" value="${participante.apellidos}" class="form-control" id="nombre" >                    
                </div>
                <div class="mb-3">
                    <label for="correo" class="form-label">Correo Electronico</label>
                    <input type="email" name="correo" value="${partipante.nombres}" class="form-control" id="correo" >
                </div>
                <div class="mb-3">
                    <label for="celular" class="form-label">Celular</label>
                    <input type="text" name="celular" value="${participante.id_seminario}" class="form-control" id="celular" >
                </div>
                 <div class="mb-3">
                    <label for="celular" class="form-label">Celular</label>
                    <input type="text" name="celular" value="${participante.confirmado}" class="form-control" id="celular" >
                </div>
                <button type="submit" class="btn btn-primary">Procesar</button>
         </form>   
        </br>
        
    </body>
</html>
