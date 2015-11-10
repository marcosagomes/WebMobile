package br.senac.tads.wrm.beans;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


//import br.senac.tads.dsw.cake.jsf2.entity.UsuarioSistema;
import br.senac.tads.wrm.entidade.UsuarioSistema;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 * http://www.itcuties.com/j2ee/jsf-2-login-filter-example/
 *
 * @author Fernando
 */
@ManagedBean
@SessionScoped
public class UsuarioBean implements Serializable {

  // OBS: Usuarios mantidos em um mapa somente como exemplo.
  // A validação deve ser feita com os dados armazenados no BD.
  private static final Map<String, UsuarioSistema> USUARIOS_CADASTRADOS;

  static {
    USUARIOS_CADASTRADOS = new HashMap<>();
    USUARIOS_CADASTRADOS.put("a", new UsuarioSistema("a", "a", new String[]{"ADMIN", "BASICO"}));
    USUARIOS_CADASTRADOS.put("fulano", new UsuarioSistema("fulano", "1234", new String[]{"BASICO"}));
  }

  private String nome;
  private String senha;
  private UsuarioSistema usuario;
  
  public String doLogin() {
    UsuarioSistema usuarioSis = validar(nome, senha);
    if (usuarioSis != null) {
      this.usuario = usuarioSis;
//      return "/lista.xhtml?faces-redirect=true";
      System.out.println(">> Login efetuado com sucesso");
      return "/perfil.xhtml?faces-redirect=true";
    }

    // Set login ERROR
    FacesMessage msg = new FacesMessage("Login error!", "ERROR MSG");
    msg.setSeverity(FacesMessage.SEVERITY_ERROR);
    FacesContext.getCurrentInstance().addMessage(null, msg);

    // To to login page
//    return "/login.xhtml?faces-redirect=true";
    System.out.println(">> Erro no login");
    return "/home.xhtml?faces-redirect=true";
  }

  /**
   * Logout operation.
   *
   * @return
   */
  public String doLogout() {
    // Set the paremeter indicating that user is logged in to false
    usuario = null;

    // Set logout message
    FacesMessage msg = new FacesMessage("Logout success!", "INFO MSG");
    msg.setSeverity(FacesMessage.SEVERITY_INFO);
    FacesContext.getCurrentInstance().addMessage(null, msg);

    return "/home.xhtml?faces-redirect=true";
  }

  // Implementar aqui a validação do usuário com os dados
  // armazenados no banco de dados.
  private static UsuarioSistema validar(String nome, String senha) {
    UsuarioSistema usuario = USUARIOS_CADASTRADOS.get(nome);
    if (usuario != null && usuario.autenticar(nome, senha)) {
      return usuario;
    }
    return null;
  }

  /* Getters e Setters */
  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getSenha() {
    return senha;
  }

  public void setSenha(String senha) {
    this.senha = senha;
  }

  public UsuarioSistema getUsuario() {
    return usuario;
  }

  public void setUsuario(UsuarioSistema usuario) {
    this.usuario = usuario;
  }

}
