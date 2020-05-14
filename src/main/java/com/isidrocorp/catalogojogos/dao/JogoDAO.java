package com.isidrocorp.catalogojogos.dao;

import org.springframework.data.repository.CrudRepository;

import com.isidrocorp.catalogojogos.model.Jogo;

/* aqui acontece a "mágica": o CrudRepository é uma interface genérica que já entrega
 * métodos básicos para manipulação de objetos em bancos de dados
 * É essa a interface que irá invocar a implementação para gravar, alterar, excluir ou recuperar
 *  objetos do banco de dados
 *  
 *  	Exemplos de métodos já existentes:
 *  		save(Jogo)   - grava/altera um Objeto na tabela
 *          findAll()    - retorna a lista de objetos
 *          findById(id) - retorna o objeto pelo ID
 * 
 */
public interface JogoDAO extends CrudRepository<Jogo, Integer> {

}
