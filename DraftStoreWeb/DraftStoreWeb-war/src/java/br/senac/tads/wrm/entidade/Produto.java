package br.senac.tads.wrm.entidade;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ramonhonorio
 */
public class Produto {
  
  // Identificador
  private int id;
  
  // Informacoes de texto
  private String nome;
  private String descricao;
  private String categoria;
  
  // Preco
  private float preco;
  private float precoAnterior;

  /* 
    Construtor da classe
  */
  public Produto(int id, String nome, String descricao, float preco) {
    this.id = id;
    this.nome = nome;
    this.descricao = descricao;
    this.preco = preco;
  }

  public Produto(int id, String nome, String categoria, float preco, float precoAnterior) {
    this.id = id;
    this.nome = nome;
    this.categoria = categoria;
    this.preco = preco;
    this.precoAnterior = precoAnterior;
  }
  
  /* 
    Metodos de acesso
  */
  public String getNome() {
    return nome;
  }
  public void setNome(String nome) {
    this.nome = nome;
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
  public int getId() {
    return id;
  }
  public void setId(int id) {
    this.id = id;
  }

  public String getCategoria() {
    return categoria;
  }

  public void setCategoria(String categoria) {
    this.categoria = categoria;
  }

  public float getPrecoAnterior() {
    return precoAnterior;
  }

  public void setPrecoAnterior(float precoAnterior) {
    this.precoAnterior = precoAnterior;
  }
  
  
  
}
