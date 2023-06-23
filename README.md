<h1>API Site de Seminovos</h1>
  <p>Olá, seja muito bem vindo ao meu primeiro projeto solo utilizando Spring👋🏼</p>
  <p>Este é um projeto de uma APIRest do "NetBank".</p>
  
  <h2> 🗂️ Sumário </h2>
    <li><a href="#funcionalidades">Funcionalidades</a></li>
    <li><a href="#tecnologiasUtilizadas">Tecnologias Utilizadas</a></li>
    <li><a href="#configurações">Configurações</a></li>
    <li><a href="#comoExecutar">Como Executar</a></li>
    <li><a href="#endpoints">Endpoints</a></li>
    <li><a href="#observações">Observações</a></li>
    <li><a href="#autor">Autor</a></li>
    <li><a href="#contatos">Contato</a></li>


  <h2  id="funcionalidades">📑Funcionalidades</h2>
  <ul>
     <h3>C.R.U.D (Create, Read, Update, Delete)</h3>
      <li>Listar todos os veiculos cadastrados</li>
      <li>Cadastrar um novo veiculo</li>
      <li>Detalhar veiculo</li>
      <li>Excluir um veiculo</li>
      <li>Listar todas as fotos de um veiculo</li>
     <h3>FILTROS</h3>
        <li>Filtrar veiculo por Ano</li>
        <li>Filtrar veiculo por Km</li>
        <li>Filtrar veiculo por Cambio</li>
  </ul>

  <h2  id="tecnologiasUtilizadas">🖥️Tecnologias Utilizadas</h2>
  <ul>
    <li>Java</li>
    <li>Spring</li>
    <li>JPA / Hibernate</li>
    <li>PostgreSQL</li>
    <li>JDBC</li>
    <li>Lombok</li>
    <li>Spring Validation</li>
  </ul>
        

<h2 id="configurações">⚙️Configurações</h2>
  <p>Antes de executar o projeto, é necessário realizar as seguintes configurações:</p>
  <ol>
    <li>Configurar o banco de dados PostgreSQL e criar o banco de dados "contas".</li>
    <li>Modificar as informações de conexão com o banco de dados (URL, usuário e senha) no pacote resources/application.properties</li>
  </ol>

  <h2 id="comoExecutar">❓Como Executar</h2>
  <ol>
    <li>Clone ou faça o download do projeto para o seu ambiente de desenvolvimento.</li>
    <li>Importe o projeto para a sua IDE Java (Eclipse, IntelliJ, etc.).</li>
    <li>Realize as configurações necessárias conforme descrito acima.</li>
    <li>Start o projeto.</li>
    <li>Acesse a aplicação pelo Insomnia, Postman, etc. Utilizando as requisições abaixo.</li>
  </ol>

  <h2 id="endpoints">🌐Endpoints</h2>

|   Endpoints   |  Parameters  |    Verb    |
| :---         |     :---:      |          ---: |
| /cadastrarVeiculo       |   *  |   POST    |
| /estoque  |   *  | GET    |
| /detalharVeiculo/{id}   |   *  | GET    |
| /excluirVeiculo/{id}        |   *  | DELETE   |
/fotos/{id}        |   *  | GET   |
/filtrarPorCambio        |   *  | GET   |
/filtrarPorKm        |   *  | GET   |
/filtrarPorAno        |   *  | GET   |

<details>
    <summary>CADASTRAR NOVO VEICULO - /cadastrarVeiculo  </summary>
    
  ### Descrição
  
  - Cadastra um novo veiculo instancia-lo no banco de dados.
  
  ### Códigos de Resposta
  
  - `201`: CREATED.
  
  ### Exemplo de Requisição
  
  - POST -  /cadastrarVeiculo 
  - HTTP/1.1
  - Host: localhost:8080
  - Content-Type: application/json
  
  ```json
 {
	"marca": "Toyota",
  "modelo": "Corola",
"anoFabEMod": "2022/2022",
	"versao": "XEI 2.0",
  "cambio": "Automático",
 "qtdePortas": 4,
  "combustivel": "Flex",
  "km": 21200,
   "placa": "PKM-9B26",
   "preco": 120.900,
   "descricao":"There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don't look even slightly believable..",
       "urlFotos": [
				 {"url": "https://th.bing.com/th/id/R.03d9e96b44a62713150494967867f57f?rik=7zPJiyQAU1fzFg&pid=ImgRaw&r=0"},
				 {"url": "https://th.bing.com/th/id/OIP.KqLjGk_VYQob-x0UlsVoFwHaFj?pid=ImgDet&rs=1"}
			 ]
}
  ```
  
  ### Exemplo de Resposta
  
  - HTTP/1.1 201 CREATED
  - Content-Type: application/json
  ```json
      {
	"id": 6,
	"marca": "Toyota",
	"modelo": "Corola",
	"anoFabEMod": "2022/2022",
	"versao": "XEI 2.0",
	"cambio": "Automático",
	"qtdePortas": 4,
	"combustivel": "Flex",
	"km": 21200,
	"placa": "PKM-9B26",
	"preco": 120.9,
	"descricao": "There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don't look even slightly believable.."
}
  ```
    
  </details>
  
  <details>
    <summary> LISTAR ESTOQUE - /estoque </summary>
    
  ### Descrição
  
  Lista os veiculos contidos no banco de dados.
  
  ### Códigos de Resposta
  
  - `200`: OK.
  
  ### Exemplo de Requisição
  
  - GET - /contas/getAll
  - HTTP/1.1
  - Host: localhost:8080
  
  ### Exemplo de Resposta
  
  - HTTP/1.1 200 OK
  - Content-Type: application/json
  ```json
 {
	"content": [
		{
			"marca": "Fiat",
			"modelo": "Uno",
			"anoFabEMod": "2015/2015",
			"versao": "Attractive 1.0",
			"cambio": "Manual",
			"km": 92664,
			"preco": 45.9
		},
		{
			"marca": "Honda",
			"modelo": "Civic",
			"anoFabEMod": "2019/2020",
			"versao": "EXL 2.0",
			"cambio": "Manual",
			"km": 25350,
			"preco": 99.9
		},
		{
			"marca": "Honda",
			"modelo": "Civic",
			"anoFabEMod": "2019/2020",
			"versao": "EXL 2.0",
			"cambio": "Manual",
			"km": 25350,
			"preco": 99.9
		},
		{
			"marca": "Nissan",
			"modelo": "Kicks",
			"anoFabEMod": "2022/2022",
			"versao": "Advance 1.6",
			"cambio": "Automático",
			"km": 21200,
			"preco": 120.9
		},
		{
			"marca": "Toyota",
			"modelo": "Corola",
			"anoFabEMod": "2022/2022",
			"versao": "XEI 2.0",
			"cambio": "Automático",
			"km": 21200,
			"preco": 120.9
		}
	],
	"pageable": {
		"sort": {
			"empty": false,
			"unsorted": false,
			"sorted": true
		},
		"offset": 0,
		"pageNumber": 0,
		"pageSize": 20,
		"unpaged": false,
		"paged": true
	},
	"last": true,
	"totalPages": 1,
	"totalElements": 5,
	"size": 20,
	"number": 0,
	"sort": {
		"empty": false,
		"unsorted": false,
		"sorted": true
	},
	"first": true,
	"numberOfElements": 5,
	"empty": false
}
  ```
    
  </details>
  
  <details>
    <summary>EXCLUIR CONTA- /contas/{id}</summary>
    
  ### Descrição
  
  Deletar a conta.
  
  ### Códigos de Resposta
  
  - `204`: No Content.
  
  ### Exemplo de Requisição
  
  - DELETE - /contas/{id}
  - HTTP/1.1
  - Host: localhost:8080
  
  </details>
  
  <details>
    <summary>EFETUAR SAQUE - /contas/saque</summary>
    
  ### Descrição
  
  Efetua um saque do saldo da conta.
  
  ### Códigos de Resposta
  
  - `200`: OK!.
  
  ### Exemplo de Requisição
  
  - PUT /contas
  - Host: localhost:8080
    
    ```json
    {
      "id": 1,
      "valor": "920.00"
  }   ```
  
  ### Exemplo de Resposta
  
  - HTTP/1.1 200 OK
  - Content-Type: application/json
      
  ```json
    Saque efetuado com sucesso - 2023-06-02T15:57:15.411927900
  ```
    
  </details>

  <details>
    <summary>EFETUAR DEPÓSITO - /contas/deposito</summary>
    
  ### Descrição
  
  Efetua um deposito para o saldo da conta.
  
  ### Códigos de Resposta
  
  - `200`: OK!.
  
  ### Exemplo de Requisição
  
  - PUT /contas
  - Host: localhost:8080
    
    ```json
    {
      "id": 1,
      "valor": "780.00"
  }   ```
  
  ### Exemplo de Resposta
  
  - HTTP/1.1 200 OK
  - Content-Type: application/json
      
  ```json
    Depósito efetuado com sucesso - 2023-06-02T15:57:15.411927900
  ```
    
  </details>

  <details>
    <summary>EFETUAR TRANSFERÊNCIA - /contas/transferencia</summary>
    
  ### Descrição
  
  Efetua uma transferência de uma quantia de saldo de uma conta para outra.
  
  ### Códigos de Resposta
  
  - `200`: OK!.
  
  ### Exemplo de Requisição
  
  - PUT /contas
  - Host: localhost:8080
    
    ```json
    {
        "idContaRemetente": "1",
        "valor": "200.00",
        "idContaDestino": "7"
    } ```
  
  ### Exemplo de Resposta
  
  - HTTP/1.1 200 OK
  - Content-Type: application/json
      
  ```json
    Transferência realizada com sucesso! - 2023-06-02T15:12:54.502614100
  ```
    
  </details>

  <h2 id="observações">❗Observações</h2>
  <p>Este projeto é apenas uma demonstração básica de um banco ("netbank") utilizando Spring e Banco de Dados. Para fins de aprendizado e desenvolvimento.</p>

  <h2 id="autor">🖐️Autor</h2>
  <p>Kauã Caldeira Vilas Boas</p>
  
  <h2 id="contatos">📞Contato</h2>
  <ul>
    <li>Email: kauacaldeira@hotmail.com</li>
    <li>LinkedIn: <a href="https://www.linkedin.com/in/kauavilasboas/">Kauã Vilas Boas</a></li>
  </ul>

