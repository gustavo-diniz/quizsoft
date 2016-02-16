package br.com.gustavodiniz.quiz.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

import br.com.gustavodiniz.quiz.core.domain.Messages;
import br.com.gustavodiniz.quiz.core.model.FormularioModel;
import br.com.gustavodiniz.quiz.core.service.TemplateService;
import br.com.gustavodiniz.quiz.core.spring.SpringMongo;

@Service
public class TemplateServiceImpl implements TemplateService{

	@Autowired
	private SpringMongo springMongo;
	
	@Override
	public String insereFormulario(String formJson) {
		
		FormularioModel model = new Gson().fromJson(formJson, FormularioModel.class);
		springMongo.getMongoOperations().save(model);
		
		Messages messages = new Messages();
		messages.setMessage("Registro inserido com sucesso !");
		
		return new Gson().toJson(messages);
	}

	@Override
	public String listaFormularios(String id) {
		if(id == null || id.equals("")){
			List<FormularioModel> formularioList = springMongo.getMongoOperations().findAll(FormularioModel.class);
			return exibeListaFormularioJson(formularioList);
		}else{
			Query search = new Query(Criteria.where("_id").is(id));
			List<FormularioModel> formularioList = springMongo.getMongoOperations().find(search, FormularioModel.class);
			return exibeListaFormularioJson(formularioList);
		}
	}

	private String exibeListaFormularioJson(List<FormularioModel> formularioList) {
		if(formularioList == null || formularioList.size() == 0){
			Messages messages = new Messages();
			messages.setMessage("Nenhum registro encontrado !");
			String json = new Gson().toJson(messages);
			return json;
		}else{
			String json = new Gson().toJson(formularioList);
			return json;
		}
	}

	@Override
	public String deleteFormulario(String id) {
		
		Query search = new Query(Criteria.where("_id").is(id));
		springMongo.getMongoOperations().remove(search,FormularioModel.class);
		
		Messages messages = new Messages();
		messages.setMessage("Registro removido com sucesso !");
		
		return new Gson().toJson(messages); 
	}

}
