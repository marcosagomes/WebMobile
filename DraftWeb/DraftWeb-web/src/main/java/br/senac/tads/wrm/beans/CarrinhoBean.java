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
import javax.faces.bean.ManagedBean;
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
    private float precoTotoal;

    public float getPrecoTotoal() {
        return calcularPrecoCarrinho();
    }

    public CarrinhoBean() {
        this.itens = new ArrayList();
    }

    public ArrayList<ProdutoCarrinho> getItens() {
        return itens;
    }

    public void adicionar(Produto produto) {
        ProdutoCarrinho pc = new ProdutoCarrinho(produto, new Date());
        this.itens.add(pc);

        System.out.println("Adicionando...");
        this.imprimirCarrinho();
    }

    public void adicionar(Produto produto, int quantidade) {
        ProdutoCarrinho pc = new ProdutoCarrinho(produto, new Date(), quantidade);
        this.itens.add(pc);
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
        return "home.xhtml";
    }

    public float calcularPrecoCarrinho() {
        float valor = 0;

        for (ProdutoCarrinho pc : this.getItens()) {
            valor += pc.getProduto().getPreco();
        }

        return valor;
    }
}
