/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.wrm.ejb;

import br.senac.tads.wrm.entidade.Cliente;
import javax.ejb.Local;

/**
 *
 * @author Marcos
 */
@Local
public interface ClienteEJBLocal {
    public void cadastrar(Cliente cliente);
}
