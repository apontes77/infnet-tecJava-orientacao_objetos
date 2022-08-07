<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<html>
<body>
<div class="container mt-3">
  <h2>Projeto App Pagamentos</h2>
  <h4>Classe: Conta</h4>        
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
        <td>Id</td>
        <td>Integer</td>
        <td>atributo identificador</td>
      </tr>
      <tr>
        <td>contaAtiva</td>
        <td>boolean</td>
        <td>Indica se a conta é ativa</td>
      </tr>
      <tr>
        <td>descrição</td>
        <td>String</td>
        <td>descrição da conta</td>
      </tr>
    </tbody>
  </table>
  
  <h4>Classe: Consumo</h4>        
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
        <td>item</td>
        <td>String</td>
        <td>descrição do item exsitente na conta</td>
      </tr>
      <tr>
        <td>quantidadeDeItens</td>
        <td>Integer</td>
        <td>quantidade de itens existentes na conta</td>
      </tr>
    </tbody>
  </table>
  
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
    </tbody>
  </table>
  
  <h4>Classe: Tributo</h4>        
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
        <td>ICMS</td>
        <td>BigDecimal</td>
        <td>imposto estadual</td>
      </tr>
      <tr>
        <td>IOF</td>
        <td>BigDecimal</td>
        <td>imposto sobre operações financeiras</td>
      </tr>
      <tr>
        <td>ISS</td>
        <td>BigDecimal</td>
        <td>imposto sobre serviços</td>
      </tr>
    </tbody>
  </table>
  
  <h4>Classe: Cliente</h4>        
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
        <td>Id</td>
        <td>Integer</td>
        <td>atributo identificador</td>
      </tr>
      <tr>
        <td>nome</td>
        <td>String</td>
        <td>nome do cliente</td>
      </tr>
      <tr>
        <td>email</td>
        <td>String</td>
        <td>email do cliente</td>
      </tr>
    </tbody>
  </table>
  
  <h4>Classe: Pagamento</h4>        
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
        <td>numeroCartao</td>
        <td>String</td>
        <td>numero do cartão para pagamento</td>
      </tr>
      <tr>
        <td>bandeira</td>
        <td>String</td>
        <td>bandeira do cartão</td>
      </tr>
      <tr>
        <td>valor</td>
        <td>BigDecimal</td>
        <td>valor do pagamento</td>
      </tr>
    </tbody>
  </table>
  
</div>

</body>
</html>
