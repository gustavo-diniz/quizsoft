package br.com.gustavodiniz.quiz.core.service;

public interface TemplateService {

	public String insereFormulario(String formJson);
	
	public String listaFormularios(String id);
	
	public String deleteFormulario(String id);
	
}
