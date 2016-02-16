package br.com.gustavodiniz.quiz.core.domain;

import java.util.List;

public class Errors {

	private List<Messages> errors;

	public List<Messages> getErrors() {
		return errors;
	}

	public void setErrors(List<Messages> errors) {
		this.errors = errors;
	}

}
