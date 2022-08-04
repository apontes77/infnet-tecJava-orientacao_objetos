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
        <td>Id</td>
        <td>Integer</td>
        <td>atributo identificador</td>
      </tr>
      <tr>
        <td>estado</td>
        <td>EstadoPagamento</td>
        <td>Indica o status do pagamento</td>
      </tr>
      <tr>
        <td>descrição</td>
        <td>String</td>
        <td>descrição do pagamento</td>
      </tr>
    </tbody>
  </table>
  
  <h4>Classe: PagamentoComPix</h4>        
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
        <td>dataVencimento</td>
        <td>LocalDate</td>
        <td>data de vencimento do pagamento</td>
      </tr>
      <tr>
        <td>dataPagamento</td>
        <td>LocalDate</td>
        <td>data de realização do pagamento</td>
      </tr>
      <tr>
        <td>chavePixParaPagar</td>
        <td>String</td>
        <td>chave pix para ser copiada e usada para a transferência monetária</td>
      </tr>
    </tbody>
  </table>
  
  <h4>Classe: PagamentoComBoleto</h4>        
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
        <td>dataVencimento</td>
        <td>LocalDate</td>
        <td>data de vencimento do pagamento</td>
      </tr>
      <tr>
        <td>dataPagamento</td>
        <td>LocalDate</td>
        <td>data de realização do pagamento</td>
      </tr>
      <tr>
        <td>codigo</td>
        <td>String</td>
        <td>codigo numerico referente ao código de barras do boleto</td>
      </tr>
    </tbody>
  </table>
  
  <h4>Classe: PagamentoComCartao</h4>        
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
        <td>quantidade de parcelas a pagar</td>
      </tr>
      <tr>
        <td>bandeira</td>
        <td>String</td>
        <td>intermediario de transações financeiras do cartão</td>
      </tr>
      <tr>
        <td>numeroCartao</td>
        <td>String</td>
        <td>numero do cartão em questão</td>
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
      <tr>
        <td>tipo</td>
        <td>TipoCliente</td>
        <td>indica se o cliente é pessoa física ou jurídica</td>
      </tr>
    </tbody>
  </table>
  
  <h4>Classe: Telefone</h4>        
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
        <td>numero</td>
        <td>String</td>
        <td>numero de telefone</td>
      </tr>
      <tr>
        <td>DDD</td>
        <td>String</td>
        <td>Discagem Direta à Distância - identificador da UF do numero de telefone</td>
      </tr>
      <tr>
        <td>prefixo</td>
        <td>String</td>
        <td>indica o país do número de telefone em questão</td>
      </tr>
      <tr>
        <td>tipo</td>
        <td>TipoCliente</td>
        <td>indica se o cliente é pessoa física ou jurídica</td>
      </tr>
    </tbody>
  </table>
  
</div>

</body>
</html>
