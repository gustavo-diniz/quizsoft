# quizsoft
Exemplo utilizando Spring MVC com serviços rest e integração com mongoDB

frameworks utilizados:<br/>

•	JAVA 8 <br/>
•	SpringMVC <br/>
•	Spring Data <br/>
•	MongoDB <br/>
•	Maven <br/>
•	Wildfly 9 <br/>

O objettivo deste projeto é de prover alguns exemplos utilizando o framework MVC , SpringMvc com a utilização do spring Data com MongoDB
, o projeto principal esta separado em quizsoft-core: com as principais classes de negocio e de persistencia, e o projeto quizsoft-web, 
com os serviços rest expostos para consulta.

Listar formulários:<br/>
http://localhost:8080/quizsoft-web/template/listarFormularios<br/>

Listar formulários por id:<br/>
http://localhost:8080/quizsoft-web/template/listarFormularios?id=(idCollection)<br/>

Adiconar novo formulario (Post)<br/>
http://localhost:8080/quizsoft-web/template/adicionarFormulario<br/>
exemplo json: {"mensagem":"Teste de envio de formulario","nome":"Gustavo Diniz","email":"gustavo.diniz@teste.com","idade":29}<br/>

Remover formulario (Post)<br/>
http://localhost:8080/quizsoft-web/template/deleteFormulario?id=(idCollection)<br/>


