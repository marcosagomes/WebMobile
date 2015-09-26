/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.wrm.negocio;

import javax.ejb.Stateless;

/**
 *
 * @author ramonhonorio
 */
@Stateless(mappedName = "ejb/teste")
public class Teste implements InterfaceTeste {
  private String nome = "dasfuiyvdfoalsbdfijnk";

  @Override
  public String retornaNome() {
    return this.nome;
  }
}
