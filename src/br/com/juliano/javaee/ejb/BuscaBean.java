package br.com.juliano.javaee.ejb;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.Stateful;
/**
 * Service of search a word in the dictionary.
 * @author Juliano R. Américo
 *
 */
@Stateful
public class BuscaBean {

	private List<String> dictionary = Arrays.asList("Feijão","Macaco","Resposta","Inglês","Professor");

	/**
	 * Search words that matches with a part of a string.
	 * @param busca String suppose to be match
	 * @return a list of word matches with the part of a string.
	 */
	public List<String> buscar(String busca){
		return dictionary.stream()
			.filter(e -> e.toUpperCase().contains(busca.toUpperCase()))
			.collect(Collectors.toList());
	}
}
