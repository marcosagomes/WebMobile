package br.senac.tads.wrm.listener;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import br.senac.tads.wrm.beans.UsuarioBean;
import br.senac.tads.wrm.entidade.UsuarioSistema;
import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

/**
 *
 * @author Fernando
 */
public class AutorizacaoListener implements PhaseListener {
  /*
   * Referencias:
   * http://semprejava.wordpress.com/2010/08/04/25/
   * http://archsofty.blogspot.com.br/2008/11/login-autenticao-e-autorizao-usando.html
   * http://rodrigolazoti.com.br/2008/09/01/filtrando-usuarios-logados-em-jsf-com-phaselistener/
   * http://stackoverflow.com/questions/8975154/how-to-access-a-named-bean-in-phaselistener
   */

  @Override
  public void afterPhase(PhaseEvent event) {

    FacesContext facesContext = event.getFacesContext();

    UsuarioBean usuarioBean = facesContext.getApplication()
            .evaluateExpressionGet(facesContext, "#{usuarioBean}", UsuarioBean.class);

    String currentPage = facesContext.getViewRoot().getViewId();
    System.out.println("current page:" + currentPage);

    NavigationHandler nh = facesContext.getApplication().getNavigationHandler();
    
    if (currentPage.contains("/admin/")) {
      if (usuarioBean == null || usuarioBean.getUsuario() == null) {
        nh.handleNavigation(facesContext, null, "/login.xhtml?faces-redirect=true");
        return;
      }
      if (!verificarAcesso(usuarioBean.getUsuario(), currentPage)) {
        nh.handleNavigation(facesContext, null, "/erroNaoAutorizado.xhtml?faces-redirect=true");
      }
    }

    // se fluxo chegou aqui, continua normalmente
  }

  @Override
  public void beforePhase(PhaseEvent event) {
  }

  /**
   * Método que verifica se o usuário possui o(s) papel(is) necessário(s) para
   * acessar a funcionalidade
   *
   * @param usuario
   * @param pagina
   * @return
   */
  private static boolean verificarAcesso(UsuarioSistema usuario, String pagina) {
    if (pagina.lastIndexOf("formulario.xhtml") > -1
            && usuario.autorizado("ADMIN")) {
      return true;
    }
    return false;
  }

  @Override
  public PhaseId getPhaseId() {
    return PhaseId.RESTORE_VIEW;
  }

}
