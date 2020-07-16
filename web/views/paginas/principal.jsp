<%-- 
    Document   : principal
    Created on : 16-Jul-2020, 11:55:57
    Author     : diego
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<div class="container">
    <div class="panel panel-primary">
        <div class="panel-heading">
            Cursos
        </div>
        <div class="panel-body">
            <div class="row">
                <div class="col-md-12">
                    <div id="msgInfo" class="alert alert-info" style="display: none;"></div>
                </div>
            </div>
            <form id="form-cursos" role="form" method="POST" action="inicio" target="_blanc">
                <div class="row">
                    <div class="col-md-12">
                        <table id="tableCursos" class="table table-responsive table-bordered">
                            <colgroup>
                                <col span="1" style="width: 10%">
                                <col span="1" style="width: 30%">
                                <col span="1" style="width: 45%">
                                <col span="1" style="width: 10%">
                                <col span="1" style="width: 5%">
                            </colgroup>
                            <thead>
                                <tr class="info">
                                    <td>Id</td>
                                    <td>Nombre</td>
                                    <td>Descripcion</td>
                                    <td>Estatus</td>
                                    <td></td>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${cursos}" var="element">
                                    <tr>
                                        <td>${element.id}</td>
                                        <td>${element.nombre}</td>
                                        <td>${element.descripcion}</td>
                                        <td>
                                            <c:choose>
                                                <c:when test="${element.status == 'A'}">Activo</c:when>
                                                <c:otherwise>Inactivo</c:otherwise>
                                            </c:choose>
                                        </td>
                                        <td>
                                            <input name="${element.id}" type="checkbox"/>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-12" align="right">
                        <button type="submit" class="btn btn-primary btn-sm"><i class="fa fa-check"></i> Aceptar</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
