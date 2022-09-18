<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
   <meta charset="utf-8">
   <meta name="viewport" content="width=device-width, initial-scale=1">
   <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
      rel="stylesheet">
</head>
<html>
   <body>
      <c:import url="/WEB-INF/jsp/menu.jsp"/>
     <div class="container mt-3">
		  <h3>Cadastramento de Pagamento</h3>
		 <table class="table table-striped">
		  <form action="/pagamento/incluir" method="post">
		    <div class="mb-3 mt-3">	
		      <label for="numeroCartao">Número do Cartão:</label>
		      <input class="form-control" placeholder="Número do Cartão:" name="numeroCartao">
		    </div>
		    
		    <div class="mb-3 mt-3">	
		      <label for="bandeira">Bandeira:</label>
		      <input class="form-control" placeholder="bandeira:" name="bandeira">
		    </div>
		    
		    <div class="mb-3">
		      <label for="valor">Valor:</label>
		      <input class="form-control" placeholder="valor:" name="valor">
		    </div>

		  <div class="mb-3">
			  <label for="cliente">Cliente:</label>
			  <select class="form-control" id="sel1">
				  <option>1</option>
				  <option>2</option>
				  <option>3</option>
				  <option>4</option>
			  </select>
		  </div>


		  <div class="mb-3">
			  <label for="contas">Contas:</label>
			  <div class="checkbox">
				  <label><input type="checkbox" value="">Tributo</label>
			  </div>
			  <div class="checkbox">
				  <label><input type="checkbox" value="">Extra</label>
			  </div>
			  <div class="checkbox">
				  <label><input type="checkbox" value="">Consumo</label>
			  </div>
		  </div>
		    
		    <button type="submit" class="btn btn-primary">Cadastrar</button>
		  </form>
	  </table>
	 </div>
   </body>
</html>