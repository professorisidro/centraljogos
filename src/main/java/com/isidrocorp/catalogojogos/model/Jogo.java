package com.isidrocorp.catalogojogos.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/* O objeto do MODEL Jogo é o objeto que a gente vai gravar/recuperar do banco
 * Ele precisa ser anotado para indicar que, além de ser um objeto armazenável, é possível
 * mapear nome de tabela, nome campo, tamanho de campo, tipo de geração de campo, se o atributo é
 * um campo chave primária e assim por diante...
 * 
 */
@Entity                      // indica que o objeto é uma entidade armazenável
@Table(name = "tbl_jogo")    // vinculo o nome da tabela
public class Jogo {
	
	@Column(name = "id")                                 // especifico o nome da coluna
	@Id                                                  // digo que eh chave primaria
	@GeneratedValue(strategy = GenerationType.IDENTITY)  // eh um valor gerado pelo banco
	private int    id;
	
	@Column(name = "nome", length = 100)                 // além do nome, especifico o tamanho
	private String nome;
	
	@Column(name = "classificacao")
	private int    classificacao;
	
	@Column(name = "plataforma", length = 40)
	private String plataforma;
	
	@Column(name = "descricao", length = 200)
	private String descricao;
	
	@Column(name = "preco")
	private float  preco;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getClassificacao() {
		return classificacao;
	}
	public void setClassificacao(int classificacao) {
		this.classificacao = classificacao;
	}
	public String getPlataforma() {
		return plataforma;
	}
	public void setPlataforma(String plataforma) {
		this.plataforma = plataforma;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public float getPreco() {
		return preco;
	}
	public void setPreco(float preco) {
		this.preco = preco;
	}
}
