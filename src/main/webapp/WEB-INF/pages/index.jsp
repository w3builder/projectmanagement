<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@page 
	contentType="text/html" 
	pageEncoding="UTF-8"
	import="com.project.management.domain.enums.Status"
	import="com.project.management.domain.enums.RiskLevel"
%>

<!DOCTYPE html>
<html lang="pt-BR">
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
				
		<title>CADASTRAR PROJETO</title>
		
		<link href="/static/libs/bootstrap/css/bootstrap.5.3.0.min.css" rel="stylesheet">
		<link rel="stylesheet" href="/static/libs/bootstrap/css/bootstrap-datepicker.1.9.0.min.css">
		<link href="/static/css/main.css" rel="stylesheet">
	</head>
	<body>
		<%@ include file="header.jsp" %>
	
		<div class="alert alert-warning alert-dismissible fade show text-center" role="alert" style="display:${displayAlert};">
			<strong>${message}!</strong>
			<button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
		</div>
	
		<div class="container mt-5">
			<div class="card">
				<div class="card-body">
					<h4 class="card-title mb-3">PROJETOS</h4>
			        <table class="table table-striped custom-table">
			            <thead>
			                <tr>
			                    <th scope="col">Nome</th>
			                    <th scope="col">Data de Início</th>
			                    <th scope="col">Gerente Responsável</th>
			                    <th scope="col">Classificação</th>
			                    <th scope="col">Orçamento Total</th>
			                    <th scope="col">Status</th>
			                    <th scope="col">Ações</th>
			                </tr>
			            </thead>
			            <tbody>
			                <c:forEach items="${projects}" var="project">
			                    <tr>
			                        <td>${project.name}</td>
			                        <td><fmt:formatDate value="${project.startDate}" pattern="dd/MM/yyyy" /></td>
			                        <td>${project.manager.name}</td>
			                        <td>${project.risk.description}</td>
			                        <td class="text-end"><fmt:formatNumber value="${project.budget}" type="currency" currencyCode="BRL" /></td>
			                        <td>${project.status.description}</td>
			                        <td>
			                            <a href="/projects/edit/${project.id}">Editar</a> |
			                            <a class="deletar" href="/projects/delete/${project.id}" 
			                            	data-bs-toggle="modal" 
			                            	data-bs-target="#confirmModal">Deletar</a>
			                        </td>
			                    </tr>
			                </c:forEach>
			            </tbody>
			        </table>
				</div>
			</div>
		</div>
		
		<div class="modal fade" id="confirmModal" tabindex="-1" aria-labelledby="confirmModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="confirmModalLabel">Confirmação</h5>
						<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
					</div>
					<div class="modal-body">Tem certeza de que deseja prosseguir?</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
						<form id="deleteForm">
							<button type="submit" class="btn btn-primary">Confirmar</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</body>

	<script src="/static/libs/jquery/jquery.3.5.1.min.js"></script>
	<script src="/static/libs/jquery/jquery.inputmask.5.0.6.min.js"></script>
	<script src="/static/libs/bootstrap/js/bootstrap.bundle.5.3.0.min.js"></script>
	<script	src="/static/libs/bootstrap/js/bootstrap-datepicker.1.9.0.min.js"></script>
	<script	src="/static/libs/bootstrap/js/bootstrap-datepicker.pt-BR.1.9.0.min.js"></script>
	
	<script src="/static/js/main.js"></script>
	
	<script>
		$(".deletar").click(function(event){
			$("#deleteForm").attr("action", event.target);
		});
	</script>
</html>