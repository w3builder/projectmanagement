<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	
		<div class="container mt-5">
			<div class="card">
				<div class="card-body">
					<h4 class="card-title mb-3">CADASTRO DE PROJETO</h4>
					<form action="/projects/save" method="post" class="mt-3">
						<div class="row mb-3">
							<div class="col-sm-8">
								<div class="form-group">
									<label for="name" class="form-label">Nome</label>
									<input type="text" class="form-control" id="name" name="name">
								</div>
							</div>
							<div class="col-sm-4">
								<div class="form-group">
									<label for="manager" class="form-label">Gerente Responsável</label> 
									<select class="form-select form-control" id="manager" name="manager.id">
					                  <option value="">Selecione</option>
						              <c:forEach var="item" items="${personList}">
						                  <option value="${item.id}">${item.name}</option>
						              </c:forEach>
					                </select>
								</div>
							</div>
						</div>
						<div class="row mb-3">
							<div class="col-md-4">
								<div class="form-group">
									<label for="startDate" class="form-label">Data de Início</label>
									<input type="text" class="form-control datepicker" id="startDate" name="startDate" placeholder="dd/mm/yyyy">
								</div>
							</div>
							<div class="col-md-4">
								<div class="form-group">
									<label for="expectedEndDate" class="form-label">Previsão de Término</label> 
									<input type="text"	class="form-control datepicker" id="expectedEndDate" name="expectedEndDate" placeholder="dd/mm/yyyy">
								</div>
							</div>
							<div class="col-md-4">
								<div class="form-group">
									<label for="endDate" class="form-label">Data Real de Término</label>
									<input type="text" class="form-control datepicker" id="endDate"	name="endDate" placeholder="dd/mm/yyyy">
								</div>
							</div>
						</div>
						<div class="row mb-3">
							<div class="col-md-4">
								<div class="form-group">
									<label for="status" class="form-label">Status</label> 
									<select class="form-select form-control" id="status" name="status">
					                  <option value="">Selecione</option>
						              <c:forEach var="item" items="${status}">
						                  <option value="${item}">${item.description}</option>
						              </c:forEach>
					                </select>
								</div>
							</div>
							<div class="col-md-4">
								<div class="form-group">
									<label for="risk" class="form-label">Risco</label>
									<select class="form-select form-control" id="risk" name="risk">
					                  <option value="">Selecione</option>
						              <c:forEach var="item" items="${risk}">
						                  <option value="${item}">${item.description}</option>
						              </c:forEach>
					                </select>
								</div>
							</div>
							<div class="col-md-4">
								<div class="form-group">
									<label for="budget" class="form-label">Orçamento Total</label> 
									<input type="number" class="form-control" id="budget" name="budget">
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-12">
								<div class="form-group">
									<label for="description" class="form-label">Descrição</label>
									<textarea class="form-control" id="description"	name="description" rows="3"></textarea>
								</div>
							</div>
						</div>
						<div class="row mt-3">
							<div class="col-12 text-end">
								<button type="submit" class="btn btn-primary ms-auto">Salvar</button>
							</div>
						</div>
					</form>
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
</html>