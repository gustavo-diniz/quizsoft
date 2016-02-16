# quizsoft
Exemplo utilizando Spring MVC com serviços rest e integração com mongoDB

frameworks utilizados:

•	JAVA 8
•	SpringMVC
•	Spring Data
•	MongoDB
•	Maven
•	Wildfly 9

O objettivo deste projeto é de prover alguns exemplos utilizando o framework MVC , SpringMvc com a utilização do spring Data com MongoDB
, o projeto principal esta separado em quizsoft-core: com as principais classes de negocio e de persistencia, e o projeto quizsoft-web, 
com os serviços rest expostos para consulta.

Listar formulários:
http://localhost:8080/quizsoft-web/template/listarFormularios

Listar formulários por id:
http://localhost:8080/quizsoft-web/template/listarFormularios?id=(idCollection)

Adiconar novo formulario (Post)
http://localhost:8080/quizsoft-web/template/adicionarFormulario
exemplo json: {"mensagem":"Teste de envio de formulario","nome":"Gustavo Diniz","email":"gustavo.diniz@teste.com","idade":29}

Remover formulario (Post)
http://localhost:8080/quizsoft-web/template/deleteFormulario?id=(idCollection)


