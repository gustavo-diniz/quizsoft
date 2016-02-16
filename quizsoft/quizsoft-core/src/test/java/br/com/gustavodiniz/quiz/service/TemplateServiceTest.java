package br.com.gustavodiniz.quiz.service;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.gustavodiniz.quiz.core.model.FormularioModel;
import br.com.gustavodiniz.quiz.core.service.TemplateService;
import br.com.gustavodiniz.quiz.core.spring.SpringMongo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class TemplateServiceTest {

	@Autowired
	private TemplateService templateService;
	
	@Autowired
	private SpringMongo springMongo;
	
	@Test
	public void insereFormularioTest(){
		String param = "{\"mensagem\":\"Exemplo de formulario 1\",\"nome\":\"Gustavo Diniz2\",\"email\":\"gustavo.diniz1ontracker.com.br\",\"idade\":29}";
		String msg = templateService.insereFormulario(param);
		Assert.assertTrue(msg.equals("{\"message\":\"Registro inserido com sucesso !\"}"));
	}
	
	@Test
	public void listarFormularioTest(){
		String param = "{\"mensagem\":\"Exemplo de formulario 1\",\"nome\":\"Gustavo Diniz2\",\"email\":\"gustavo.diniz1ontracker.com.br\",\"idade\":29}";
		templateService.insereFormulario(param);
		List<FormularioModel> formularioList = springMongo.getMongoOperations().findAll(FormularioModel.class);
		
		Assert.assertTrue(formularioList.size() > 0);
	}
	
	
	
}
