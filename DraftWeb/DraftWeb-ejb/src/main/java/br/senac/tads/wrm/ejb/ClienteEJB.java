/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.wrm.ejb;

import br.senac.tads.wrm.entidade.Cliente;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;



/**
 *
 * @author Marcos
 */
@Stateless
public class ClienteEJB implements ClienteEJBLocal {

  @PersistenceContext
    private EntityManager em;
    
    @Override
    public void cadastrar(Cliente cliente) {
        em.persist(cliente);        
    }

  
}
