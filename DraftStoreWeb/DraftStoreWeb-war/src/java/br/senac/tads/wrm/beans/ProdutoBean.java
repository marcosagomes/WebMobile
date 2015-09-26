/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.wrm.beans;

import br.senac.tads.wrm.entidade.Produto;
import br.senac.tads.wrm.negocio.InterfaceTeste;
import br.senac.tads.wrm.negocio.Teste;
import java.util.ArrayList;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author ramonhonorio
 */
@ManagedBean
@SessionScoped
public class ProdutoBean {

  private ArrayList<Produto> lista;
  
  @EJB
  private InterfaceTeste teste;
  
  /**
   * Creates a new instance of ProdutoControle
   */
  public ProdutoBean() {
    
    lista = new ArrayList<>();
    
    for (int i = 0; i < 5; i++) {
      lista.add(new Produto(i, "Processador Intel Core i7 3770 3° Geração", null, 1099.0f, 1299.0f));
    }
    
    teste = new Teste();
    
    System.out.println(teste.retornaNome());
    
  }

  public ArrayList<Produto> getLista() {
    return lista;
  }
  
}
