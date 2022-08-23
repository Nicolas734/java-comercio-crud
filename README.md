# API - ROTAS

  <h3> Comercio </h3>

* http://localhost:8082/springRest/search - GET
* http://localhost:8082/springRest/criar - POST
* http://localhost:8082/springRest/updateComercio/id - PUT
* http://localhost:8082/springRest/deleteComercio/id - DELETE

<br>

  <h3> Produto </h3>
  
* http://localhost:8082/springRest/searchProduto - GET
* http://localhost:8082/springRest/criarProduto/id  - POST
* http://localhost:8082/springRest/updateProduto/id - PUT
* http://localhost:8082/springRest/deleteProduto/id - DELETE

<br>

  <h3> Serviço </h3>
  
* http://localhost:8082/springRest/searchServico - GET
* http://localhost:8082/springRest/criarServico/id  - POST
* http://localhost:8082/springRest/updateServico/id - PUT
* http://localhost:8082/springRest/deleteServico/id - DELETE

<br>

  <h3> Produto </h3>
  
* http://localhost:8082/springRest/searchEndereco - GET
* http://localhost:8082/springRest/criarEndereco/id  - POST
* http://localhost:8082/springRest/updateEndereco/id - PUT
* http://localhost:8082/springRest/deleteEndereco/id - DELETE

<br>

<h1> Json Format </h1>

<br>

  <h3> Comercio </h3>
  
* Post 
  {
	"nome":"ABC LTDA",
	"cnpj":"123.321.123-123",
	"email":"abcltda@gmail.com",
	"tell":"(12)99999-9999"
 }

* PUT 
{
	"nome":HIGH CODE LTDA",
	"cnpj":"333.333.333-33",
	"email":"highcodeltda@gmail.com",
	"tell":"(12)33333-3333"
}

<br>

<h3> Produto </h3>
  
  * Post 
{
		"nome":"Papel",
		"descricao":"Para escrever",
		"preco":"5.00"
}

* PUT 
{
    "nome":"agua",
		"descricao":"Para beber",
		"preco":"1.00"
}

<br>

<h3> Serviço </h3>
  
  * Post 
{
		"nome":"limpeza",
		"descricao":"limpa os bagui",
		"preco":"30.00"
}

  * PUT 
{
		"nome":"marceneiro",
		"descricao":"controi os bagui",
		"preco":"300.00"
}

<br>

<h3> Endereço </h3>
  
  * Post 
{
		"estado":"SP",
		"cidade":"sjc",
		"bairro":"eugenio de melo",
		"rua":"eugenio branco de melo",
		"numero":"2121",
		"cep":"21212-323"
}

  * PUT 
{
		"estado":"SP",
		"cidade":"Caçapava",
		"bairro":"sei la",
		"rua":"alguma rua ai",
		"numero":"2121",
		"cep":"11111-111"
}
  
