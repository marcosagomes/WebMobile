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
import javax.faces.event.ValueChangeEvent;

/**
 *
 * @author ramonhonorio
 */
@ManagedBean
@SessionScoped
public class CarrinhoBean implements Serializable {

    private ArrayList<ProdutoCarrinho> itens;
    private HashMap<Produto, ProdutoCarrinho> itensMap;
    private int quantidadeItensMap;

    @ManagedProperty(value = "#{produtoBean}")
    private ProdutoBean produtoBean;
    
    public float getPrecoTotal() {
      float preco = calcularPrecoCarrinho();
      if (preco < 0)
        return calcularPrecoCarrinho();
      return preco;
    }

    public CarrinhoBean() {
        this.itens = new ArrayList();
        this.itensMap = new HashMap<>();
        this.quantidadeItensMap = 0;
    }

    public ArrayList<ProdutoCarrinho> getItens() {
        return itens;
    }

    public void adicionar(Produto produto) {
      System.out.println("Adicionando o produto "+produto.getNome()+" ao carrinho...");
      ProdutoCarrinho pc = this.itensMap.get(produto);
      
      if (pc == null) {
          this.itensMap.put(produto, new ProdutoCarrinho(produto, new Date()));
      } else {
        pc.setQuantidade(pc.getQuantidade()+1);
      }
      this.quantidadeItensMap++;
      
    }
    
    // TODO
    public void adicionarDetalhe() {
      System.out.println("Adicionando pela tela de detalhe...");
      
//      List<Produto> lista = this.produtoBean.getOfertasSemana();
//      for (Produto p : lista) {
//        System.out.println("p: "+p.getNome());
//      }
      
      Produto prod = this.produtoBean.getProdutoDetalhe();
      this.adicionar(prod);
      
//      ProdutoCarrinho p = new ProdutoCarrinho(prod, new Date());
//      this.itens.add(p);
      
    }

    public boolean removerProduto(Produto produto) {
      ProdutoCarrinho pc = this.itensMap.get(produto);
      
      if (pc != null) {
        System.out.println(produto.getNome()+" foi removido com sucesso.");
        this.quantidadeItensMap-=pc.getQuantidade();
        this.itensMap.remove(produto);
        return true;
      }
      System.out.println("Erro ao tentar remover "+produto.getNome());
        
      return false;
    }

//    public void removerProdutoNoIndice(int index) {
//        System.out.println("Removendo " + this.itens.get(index).getProduto().getNome());
//        this.itens.remove(index);
//        this.animarCarrinho();
//
//    }

//    public void setQuantidadeProduto(Produto produto, int quantidade) {
////        this.itens.get(this.itens.indexOf(produto)).setQuantidade(quantidade);
////        ProdutoCarrinho pc = this.getProdutoCarrinhoFromMap(itensMap, produto);
//      ProdutoCarrinho pc = this.itensMap.get(produto);
//      if (pc != null) {
//        System.out.println("PC GETQTD: "+pc.getQuantidade()+" // QTDITENSMAP "+this.quantidadeItensMap);
//        int aux = this.quantidadeItensMap - pc.getQuantidade();
//        System.out.println("AUX: "+aux);
//        aux += quantidade;
//        System.out.println("AUX: "+aux);
//        System.out.println("PC GETQTD: "+pc.getQuantidade()+" // QTDITENSMAP "+this.quantidadeItensMap);
//      } else {
//        System.out.println("null asdifjbasdf");
//      }
//    }
    
    public void handleChange(ValueChangeEvent event){  
      if (Integer.parseInt(event.getNewValue().toString())>0){
        this.quantidadeItensMap -= Integer.parseInt(event.getOldValue().toString());
        this.quantidadeItensMap += Integer.parseInt(event.getNewValue().toString());
      }
    }
    
    public int getQuantidadeProduto(Produto produto, int quantidade){
      ProdutoCarrinho pc = this.itensMap.get(produto);
      return pc.getQuantidade();
    }

//    public void alterarQuantidade(int indexProduto, int quantidade) {
//        this.itens.get(indexProduto).setQuantidade(quantidade);
//    }

    public void limparCarrinho() {
//        this.itens.clear();
//        this.itens = new ArrayList<>();
        this.itensMap.clear();
        this.itensMap = new HashMap<>();
        this.quantidadeItensMap = 0;
        System.out.println("O carrinho foi limpo!");
    }

    public void checkout() {
        System.out.println("Bem, aqui temos que realizar a compra...");
    }

    public void animarCarrinho() {
        String script = "animacaoAdicionouItens(" + this.quantidadeItensMap + ")";
        FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add(script);
    }

    public void imprimirCarrinho() {
      System.out.println("Carrinho de compras:");
      for (Produto item : this.itensMap.keySet()) {
        System.out.println("ITEM: "+item.getNome());
      }
      System.out.println("--------------------");
    }

    public String finalizarCompra() {
//        this.itens = new ArrayList<>();
        this.itensMap = new HashMap<>();
        return "/carrinho.xhtml";
    }

    public float calcularPrecoCarrinho() {
        float valor = 0;

        for (ProdutoCarrinho pc : this.getItensMapValues()) {
          if (pc.getQuantidade() < 1)
            return -1;
          
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

  public HashMap<Produto, ProdutoCarrinho> getItensMap() {
    return itensMap;
  }

  public void setItensMap(HashMap<Produto, ProdutoCarrinho> mapaItens) {
    this.itensMap = mapaItens;
    this.quantidadeItensMap = this.itensMapRecount(mapaItens);
  }
    
  public List<Produto> getItensMapKeys(){
    return new ArrayList<>(this.itensMap.keySet());
  }
  
  public List<ProdutoCarrinho> getItensMapValues(){
    return new ArrayList<>(this.itensMap.values());
  }

  public int getQuantidadeItensMap() {
    return quantidadeItensMap;
  }

  public void setQuantidadeItensMap(int quantidadeItensMap) {
    this.quantidadeItensMap = quantidadeItensMap;
    this.animarCarrinho();
  }
  
  private ProdutoCarrinho getProdutoCarrinhoFromMap(Map<Produto, ProdutoCarrinho> hm, ProdutoCarrinho value) {
    for (Produto o : hm.keySet()) {
      if (hm.get(o).equals(value)) {
        return hm.get(o);
      }
    }
    return null;
  }
  
  public int itensMapRecount(HashMap<Produto, ProdutoCarrinho> mapaItens){
    int soma = 0;
    for (ProdutoCarrinho pc : mapaItens.values()){
      soma+=pc.getQuantidade();
    }
    return soma;
  }
  
}
