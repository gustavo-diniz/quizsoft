package br.com.gustavodiniz.quiz.service;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.google.gson.Gson;

import br.com.gustavodiniz.quiz.core.model.FormularioModel;
import br.com.gustavodiniz.quiz.core.model.QuizModel;
import br.com.gustavodiniz.quiz.core.spring.SpringMongo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class PerguntasServiceTest {

	@Autowired
	private SpringMongo springMongo;
	
//	@Test
	public void executaOperacoesMongoTest(){
		
		QuizModel quiz = new QuizModel();
		quiz.setPergunta("Tito Ortiz");
		
		springMongo.getMongoOperations().save(quiz);
		
		// now user object got the created id.
		System.out.println("1. user : " + quiz);
		
		Assert.assertTrue(true);
		
	}
	
	@Test
	public void pesquisaOperacoesMongoTest(){
		// query to search user
		Query searchUserQuery = new Query(Criteria.where("_id").is("56c28ed938b0b707d2bb3d8d"));

		// find the saved user again.
		// QuizModel savedUser = springMongo.getMongoOperations().findOne(searchUserQuery, QuizModel.class);
		List<QuizModel> listquiz = springMongo.getMongoOperations().findAll(QuizModel.class);
//		System.out.println("2. find - savedUser : " + savedUser.getId()+" - "+savedUser.getPergunta());
		for(QuizModel quiz : listquiz){
			System.out.println(quiz.getPergunta());
		}
	}
	
	@Test
	public void testJsonObjeto(){
		FormularioModel formularioModel = new FormularioModel();
		formularioModel.setMensagem("Qual o prazo para o teste ?");
		formularioModel.setNome("Gustavo Diniz");
		formularioModel.setIdade(29);
		formularioModel.setEmail("gustavo.diniz@ontracker.com.br");
		
		System.out.println(new Gson().toJson(formularioModel));
		
	}
	
}
