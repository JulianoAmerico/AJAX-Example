package br.com.softblue.javaee.bean;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.com.juliano.javaee.ejb.BuscaBean;

/**
 * JSF Bean. It's kind of Controller that communicate with jsf page.
 * @author Juliano R. Américo
 *
 */
@Named("form")
@RequestScoped
public class FormBean implements Serializable {
	
	/**
	 * Binding to input text.
	 * User can input any word or part of it.
	 */
	private String busca;
	
	/**
	 * Represents list of words found.
	 */
	private List<String> filtrados;

	/**
	 * Represents Session Bean of type Stateful Bean.
	 * Annotation @EJB makes the container handler bean.
	 */
	@EJB
	BuscaBean buscador;
	
	/**
	 * Method is call by jsf page. The BuscaBean has a service of search words in a dictionary and
	 * the method buscar search words.
	 * @return list of words found.
	 */
	public String buscar() {
		filtrados = buscador.buscar(busca);
		return null;
	}

	//Getters and Setters
	
	public String getBusca() {
		return busca;
	}

	public void setBusca(String busca) {
		this.busca = busca;
	}

	public List<String> getFiltrados() {
		return filtrados;
	}

	public void setFiltrados(List<String> filtrado) {
		this.filtrados = filtrado;
	}

}
