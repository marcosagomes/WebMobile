/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.wrm.beans;

import br.senac.tads.wrm.entidade.Produto;
import br.senac.tads.wrm.entidade.ProdutoCarrinho;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author ramonhonorio
 */
@ManagedBean
@SessionScoped
public class CarrinhoBean implements Serializable {

    private ArrayList<ProdutoCarrinho> itens;
    private HashMap<Produto, ProdutoCarrinho> mapaItens;

    @ManagedProperty(value = "#{produtoBean}")
    private ProdutoBean produtoBean;
    
    public float getPrecoTotal() {
        return calcularPrecoCarrinho();
    }

    public CarrinhoBean() {
        this.itens = new ArrayList();
        this.mapaItens = new HashMap<>();
    }

    public ArrayList<ProdutoCarrinho> getItens() {
        return itens;
    }

    public void adicionar(Produto produto) {
      System.out.println("MARCOLA ZOEIRO 2");
      ProdutoCarrinho pc = this.mapaItens.get(produto);
      
      if (pc == null) {
          this.mapaItens.put(produto, new ProdutoCarrinho(produto, new Date()));
      } else {
        pc.setQuantidade(pc.getQuantidade()+1);
      }
        
      for (Produto item : this.mapaItens.keySet()) {
        
        System.out.println("ITEM: "+item.getNome());
        
      }
      
    }

    public void adicionar(Produto produto, int quantidade) {
      System.out.println("Adicionando "+quantidade+" prod...");
        ProdutoCarrinho pc = new ProdutoCarrinho(produto, new Date(), quantidade);
        this.itens.add(pc);
    }
    
    public void adicionarDetalhe() {
      System.out.println("Adiciona detalhe...");
      
      List<Produto> lista = this.produtoBean.getOfertasSemana();
      
      for (Produto p : lista) {
        System.out.println("p: "+p.getNome());
      }
      
      Produto prod = this.produtoBean.getProdutoDetalhe();
      
      ProdutoCarrinho p = new ProdutoCarrinho(prod, new Date());
      this.itens.add(p);
      
    }

    public boolean removerProduto(Produto produto) {
        System.out.println("Removendo " + produto.getNome());
        return this.itens.remove(produto);
    }

    public void removerProdutoNoIndice(int index) {
        System.out.println("Removendo " + this.itens.get(index).getProduto().getNome());
        this.itens.remove(index);
        this.animarCarrinho();

    }

    public void alterarQuantidade(ProdutoCarrinho produto, int quantidade) {
        this.itens.get(this.itens.indexOf(produto)).setQuantidade(quantidade);
    }

    public void alterarQuantidade(int indexProduto, int quantidade) {
        this.itens.get(indexProduto).setQuantidade(quantidade);
    }

    public void limparCarrinho() {
        this.itens.clear();
        this.itens = new ArrayList<>();
        System.out.println("O carrinho foi limpo!");
    }

    public void checkout() {
        System.out.println("Bem, aqui temos que realizar a compra...");
    }

    public void animarCarrinho() {
        String script = "animacaoAdicionouItens(" + itens.size() + ")";
        FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add(script);
    }

    public void imprimirCarrinho() {
        System.out.println("Carrinho de compras:");
        for (ProdutoCarrinho item : itens) {
            System.out.println("-> " + item.getProduto().getNome());
        }
        System.out.println("--------------------");
    }

    public String finalizarCompra() {
        this.itens = new ArrayList<>();
        return "/carrinho.xhtml";
    }

    public float calcularPrecoCarrinho() {
        float valor = 0;

        for (ProdutoCarrinho pc : this.getItens()) {
            valor += pc.getProduto().getPreco() * pc.getQuantidade();
        }

        return valor;
    }

  public ProdutoBean getProdutoBean() {
    return produtoBean;
  }

  public void setProdutoBean(ProdutoBean produtoBean) {
    this.produtoBean = produtoBean;
  }

  public HashMap<Produto, ProdutoCarrinho> getMapaItens() {
    return mapaItens;
  }

  public void setMapaItens(HashMap<Produto, ProdutoCarrinho> mapaItens) {
    this.mapaItens = mapaItens;
  }
  
//  public List<Map.Entry<Produto, ProdutoCarrinho>> getMapaItensEntrySet() {
//    List<Map.Entry<Produto, ProdutoCarrinho>> list = new ArrayList<>();
//    list.addAll(this.mapaItens.entrySet());
//    return list;
//  }
    
  public List<Produto> getMapaKeys(){
    return new ArrayList<>(this.mapaItens.keySet());
  }
  
  public List<ProdutoCarrinho> getMapaValues(){
    return new ArrayList<>(this.mapaItens.values());
  }
  
}
