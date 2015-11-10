/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wrm.draftstore.common.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ramonhonorio
 */
@Entity
@Table(name = "TB_PRODUTO")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "Produto.findAll", query = "SELECT p FROM Produto p"),
  @NamedQuery(name = "Produto.findByIdProduto", query = "SELECT p FROM Produto p WHERE p.idProduto = :idProduto"),
  @NamedQuery(name = "Produto.findByPrecoVenda", query = "SELECT p FROM Produto p WHERE p.precoVenda = :precoVenda"),
  @NamedQuery(name = "Produto.findByPercentualLucro", query = "SELECT p FROM Produto p WHERE p.percentualLucro = :percentualLucro"),
  @NamedQuery(name = "Produto.findByModelo", query = "SELECT p FROM Produto p WHERE p.modelo = :modelo"),
  @NamedQuery(name = "Produto.findByMarca", query = "SELECT p FROM Produto p WHERE p.marca = :marca"),
  @NamedQuery(name = "Produto.findByTipoProduto", query = "SELECT p FROM Produto p WHERE p.tipoProduto = :tipoProduto"),
  @NamedQuery(name = "Produto.findByCusto", query = "SELECT p FROM Produto p WHERE p.custo = :custo"),
  @NamedQuery(name = "Produto.findByDataCriacao", query = "SELECT p FROM Produto p WHERE p.dataCriacao = :dataCriacao"),
  @NamedQuery(name = "Produto.findByNomeFornecedor", query = "SELECT p FROM Produto p WHERE p.nomeFornecedor = :nomeFornecedor"),
  @NamedQuery(name = "Produto.findByNomeUsuario", query = "SELECT p FROM Produto p WHERE p.nomeUsuario = :nomeUsuario"),
  @NamedQuery(name = "Produto.findByQuantidade", query = "SELECT p FROM Produto p WHERE p.quantidade = :quantidade"),
  @NamedQuery(name = "Produto.findByCaminhoImagem", query = "SELECT p FROM Produto p WHERE p.caminhoImagem = :caminhoImagem"),
  @NamedQuery(name = "Produto.findByDescricao", query = "SELECT p FROM Produto p WHERE p.descricao = :descricao"),
  @NamedQuery(name = "Produto.findByDescricaoImagem", query = "SELECT p FROM Produto p WHERE p.descricaoImagem = :descricaoImagem")})
public class Produto implements Serializable {
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "ID_PRODUTO")
  private Integer idProduto;
  // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
  @Basic(optional = false)
  @NotNull
  @Column(name = "PRECO_VENDA")
  private BigDecimal precoVenda;
  @Basic(optional = false)
  @NotNull
  @Column(name = "PERCENTUAL_LUCRO")
  private BigDecimal percentualLucro;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 20)
  @Column(name = "MODELO")
  private String modelo;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 20)
  @Column(name = "MARCA")
  private String marca;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 20)
  @Column(name = "TIPO_PRODUTO")
  private String tipoProduto;
  @Basic(optional = false)
  @NotNull
  @Column(name = "CUSTO")
  private BigDecimal custo;
  @Basic(optional = false)
  @NotNull
  @Column(name = "DATA_CRIACAO")
  @Temporal(TemporalType.TIMESTAMP)
  private Date dataCriacao;
  @Size(max = 100)
  @Column(name = "NOME_FORNECEDOR")
  private String nomeFornecedor;
  @Size(max = 50)
  @Column(name = "NOME_USUARIO")
  private String nomeUsuario;
  @Column(name = "QUANTIDADE")
  private Integer quantidade;
  @Size(max = 250)
  @Column(name = "CAMINHO_IMAGEM")
  private String caminhoImagem;
  @Size(max = 3000)
  @Column(name = "DESCRICAO")
  private String descricao;
  @Size(max = 300)
  @Column(name = "DESCRICAO_IMAGEM")
  private String descricaoImagem;
  @JoinColumn(name = "FK_FORNECEDOR", referencedColumnName = "ID_FORNECEDOR")
  @ManyToOne(optional = false)
  private Fornecedor fkFornecedor;
  @JoinColumn(name = "FK_FUNCIONARIO", referencedColumnName = "ID_FUNCIONARIO")
  @ManyToOne(optional = false)
  private Funcionario fkFuncionario;

  public Produto() {
  }

  public Produto(Integer idProduto) {
    this.idProduto = idProduto;
  }

  public Produto(Integer idProduto, BigDecimal precoVenda, BigDecimal percentualLucro, String modelo, String marca, String tipoProduto, BigDecimal custo, Date dataCriacao) {
    this.idProduto = idProduto;
    this.precoVenda = precoVenda;
    this.percentualLucro = percentualLucro;
    this.modelo = modelo;
    this.marca = marca;
    this.tipoProduto = tipoProduto;
    this.custo = custo;
    this.dataCriacao = dataCriacao;
  }

  public Integer getIdProduto() {
    return idProduto;
  }

  public void setIdProduto(Integer idProduto) {
    this.idProduto = idProduto;
  }

  public BigDecimal getPrecoVenda() {
    return precoVenda;
  }

  public void setPrecoVenda(BigDecimal precoVenda) {
    this.precoVenda = precoVenda;
  }

  public BigDecimal getPercentualLucro() {
    return percentualLucro;
  }

  public void setPercentualLucro(BigDecimal percentualLucro) {
    this.percentualLucro = percentualLucro;
  }

  public String getModelo() {
    return modelo;
  }

  public void setModelo(String modelo) {
    this.modelo = modelo;
  }

  public String getMarca() {
    return marca;
  }

  public void setMarca(String marca) {
    this.marca = marca;
  }

  public String getTipoProduto() {
    return tipoProduto;
  }

  public void setTipoProduto(String tipoProduto) {
    this.tipoProduto = tipoProduto;
  }

  public BigDecimal getCusto() {
    return custo;
  }

  public void setCusto(BigDecimal custo) {
    this.custo = custo;
  }

  public Date getDataCriacao() {
    return dataCriacao;
  }

  public void setDataCriacao(Date dataCriacao) {
    this.dataCriacao = dataCriacao;
  }

  public String getNomeFornecedor() {
    return nomeFornecedor;
  }

  public void setNomeFornecedor(String nomeFornecedor) {
    this.nomeFornecedor = nomeFornecedor;
  }

  public String getNomeUsuario() {
    return nomeUsuario;
  }

  public void setNomeUsuario(String nomeUsuario) {
    this.nomeUsuario = nomeUsuario;
  }

  public Integer getQuantidade() {
    return quantidade;
  }

  public void setQuantidade(Integer quantidade) {
    this.quantidade = quantidade;
  }

  public String getCaminhoImagem() {
    return caminhoImagem;
  }

  public void setCaminhoImagem(String caminhoImagem) {
    this.caminhoImagem = caminhoImagem;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  public String getDescricaoImagem() {
    return descricaoImagem;
  }

  public void setDescricaoImagem(String descricaoImagem) {
    this.descricaoImagem = descricaoImagem;
  }

  public Fornecedor getFkFornecedor() {
    return fkFornecedor;
  }

  public void setFkFornecedor(Fornecedor fkFornecedor) {
    this.fkFornecedor = fkFornecedor;
  }

  public Funcionario getFkFuncionario() {
    return fkFuncionario;
  }

  public void setFkFuncionario(Funcionario fkFuncionario) {
    this.fkFuncionario = fkFuncionario;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (idProduto != null ? idProduto.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Produto)) {
      return false;
    }
    Produto other = (Produto) object;
    if ((this.idProduto == null && other.idProduto != null) || (this.idProduto != null && !this.idProduto.equals(other.idProduto))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "com.wrm.draftstore.common.entidades.Produto[ idProduto=" + idProduto + " ]";
  }
  
}
