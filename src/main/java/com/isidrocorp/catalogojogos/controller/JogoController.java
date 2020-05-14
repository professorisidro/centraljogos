package com.isidrocorp.catalogojogos.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.isidrocorp.catalogojogos.dao.JogoDAO;
import com.isidrocorp.catalogojogos.model.Jogo;

/* Toda e qualquer classe Controller é a classe que vai responder às requisições das URL
 * 
 * Cada URL é mapeada para um método. Esses mapeamentos são de acordo com os métodos HTTP (GET, POST, PUT, DELETE)
 * 
 * 
 */

@RestController                // indica que é um RestController (vai atender urls)
public class JogoController {

    @Autowired                 // indica que eu delego o "new" para a Máquina Virtual (Injeção de Dependência)
	private JogoDAO dao;       // declarei o DAO para fazer acesso ao banco de dados
	
	@GetMapping("/jogos")            // esse método atende à url http://localhost:8080/jogos
	public ArrayList<Jogo> recuperarTodos(){
		ArrayList<Jogo> lista;
		lista = (ArrayList<Jogo>)dao.findAll();  // ele usa o método findAll do CrudRepository e simplesmente convete para um ArrayList e retorna
		return lista;                            // nos bastidores rolou um select * from tbl_jogo
	}
	
	@PostMapping("/novojogo")         // esse método atende à url http://localhost:8080/novojogo, porém no método POST (recebe dados)
	public Jogo novoJogo(@RequestBody Jogo novo) {  // aqui eu mostro que ele recebe um objeto do tipo JOGO formatado em JSON no corpo da requisição
		dao.save(novo);  // basicamente na requisição recebo um objeto com todos os atributos preenchidos, exceto o ID, gravo no banco e
		return novo;     // retorno esse mesmo objeto, agora com ID atribuído
	}
	

	/* neste método eu quero fazer um negócio mais legal: mexer com o cabeçalho HTTP
	 *   - se ele encontrar o jogo correspondente, o status da requisição é 200 - ok
	 *   - senão, ao invés dele não retornar nada, ele vai retornar um status 404 - not found
	 */
	@GetMapping("/jogo/{id}")      // esse método vai atender à url http://localhost:8080/jogo/??
	public ResponseEntity<Jogo> recuperarPorId(@PathVariable int id) { // preciso indicar que essa variável vem na URL (@PathVariable)
		Jogo jogo = dao.findById(id).orElse(null);  // lá no DAO, uso o método findById (ou ele retorna o jogo correto, o retorna NULL)
		
		if (jogo != null) {   // se ele retornou o jogo correto
			return ResponseEntity.ok(jogo); // monto uma resposta com código ok (200) e o objeto no corpo da resposta
		}
		else {
			return ResponseEntity.notFound().build(); // senão, eu monto uma resposta de código 404
		}
		
	}
	
}
