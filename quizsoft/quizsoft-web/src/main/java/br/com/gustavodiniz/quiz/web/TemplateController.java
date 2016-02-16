package br.com.gustavodiniz.quiz.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import br.com.gustavodiniz.quiz.core.model.FormularioModel;
import br.com.gustavodiniz.quiz.core.service.TemplateService;


@Controller
@RequestMapping("/template")
public class TemplateController {

	@Autowired
	private TemplateService templateService;
	
	@RequestMapping(value="/listarFormularios", method = {RequestMethod.GET})
	@ResponseBody
	public String listarFormularios(@RequestParam(value = "id", required=false) String id ){
		String message = templateService.listaFormularios(id);
		return message;
	}
	
	@RequestMapping(value="/adicionarFormulario", method = {RequestMethod.POST})
	@ResponseBody
	public String adicionarFormulario(@ModelAttribute("formJson") String formJson){
		String message = templateService.insereFormulario(formJson);
		return message;
	}
	
	@RequestMapping(value="/deleteFormulario", method = {RequestMethod.GET})
	@ResponseBody
	public String deleteFormulario(@RequestParam(value = "id") String id ){
		String message = templateService.deleteFormulario(id);
		return message;
	}
	
}
