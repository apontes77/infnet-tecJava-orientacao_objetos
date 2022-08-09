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
      <nav class="navbar navbar-expand-sm bg-light navbar-light">
         <div class="container-fluid">
            <ul class="navbar-nav">
               <li class="nav-item">
                  <a class="nav-link active" href="#">Active</a>
               </li>
               <li class="nav-item">
                  <a class="nav-link" href="/cliente/lista">Cliente</a>
               </li>
               <li class="nav-item">
                  <a class="nav-link" href="/consumo/lista">Consumo</a>
               </li>
               <li class="nav-item">
                  <a class="nav-link" href="/conta/lista">Conta</a>
               </li>
               <li class="nav-item">
                  <a class="nav-link" href="/extra/lista">Extra</a>
               </li>
               <li class="nav-item">
                  <a class="nav-link" href="/pagamento/lista">Pagamento</a>
               </li>
               <li class="nav-item">
                  <a class="nav-link" href="/tributo/lista">Tributo</a>
               </li>
            </ul>
         </div>
      </nav>
      <div class="container mt-3">
         <h4>Classe: Extra</h4>
         <table class="table table-striped">
            <thead>
               <tr>
                  <th>Atributo</th>
                  <th>Tipo</th>
                  <th>Descrição</th>
               </tr>
            </thead>
            <tbody>
               <tr>
                  <td>numeroDeParcelas</td>
                  <td>Integer</td>
                  <td>quantidade de parcelas da conta</td>
               </tr>
               <tr>
                  <td>pagamentoLote</td>
                  <td>boolean</td>
                  <td>indica se o pagamento é em lote</td>
               </tr>
               <tr>
                  <td>pagamentoUnico</td>
                  <td>booelan</td>
                  <td>indica se o pagamento é único</td>
               </tr>
            </tbody>
         </table>
      </div>
   </body>
</html>