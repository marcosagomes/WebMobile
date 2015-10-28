/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.wrm.beans;

import br.senac.tads.wrm.entidade.Produto;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

/**
 *
 * @author ramonhonorio
 */
@ManagedBean
@SessionScoped
public class ProdutoBean implements Serializable{

  private ArrayList<Produto> ofertasSemana;
  
  private Produto produtoDetalhe;

  public ProdutoBean() {
    
    ofertasSemana = new ArrayList<>();
    
    for (int i = 0; i < 5; i++) {
      Produto p = new Produto(i, "(#"+i+") Processador Intel Core i7 3770 3° Geração", null, 1099.0f-i, 1299.0f+i);
      
      p.setDescricao(" - Marca: Intel <br/>\n" +
"              - Modelo:  BX80637I73770 <br/>\n" +
"              - Tipo: CPU / Microprocessador <br/>\n" +
"              - Família: Intel Core i7 <br/>\n" +
"              - Número do modelo: i7-3770 <br/>\n" +
"              - Frequência: 3400 MHz <br/>\n" +
"              - Freqüência Turbo: 3900 MHz <br/>\n" +
"              - Multiplicador de clock: 34 <br/>\n" +
"              - Pacote: 1155 terra-Flip-Chip Land Grid Array <br/>\n" +
"              - Soquete: 1155 (soquete H2) <br/>\n" +
"              - Microarquitetura: Ivy Bridge<br/>\n" +
"              - Núcleo do processador: Ivy Bridge <br/>\n" +
"              - Processo de fabricação: 0,022 micron <br/>\n" +
"              - Largura de dados: 64 bits<br/>\n" +
"              - 4x núcleos <br/>\n" +
"              - 8x threads <br/>\n" +
"              - Unidade de Ponto Flutuante: Integrado <br/>\n" +
"              - Nível tamanho do cache de um: 4 x 32 KB cache de instrução  <br/>\n" +
"              - 4 x 32 caches de dados KB <br/>\n" +
"              - Nível tamanho do cache de 2: 4 x 256 KB <br/>\n" +
"              - Nível tamanho do cache de 3: 8 MB de cache compartilhado <br/>\n" +
"              - Multiprocessamento: Uniprocessor <br/>\n" +
"              - Dual-channel controlador de memória DDR3 <br/>\n" +
"              - Interface: PCI Express 3.0 <br/>\n" +
"              - HD 4000 controlador de gráficos <br/>\n" +
"              - Parâmetros elétricos / térmica: Thermal Design Power: 77 Watt </p>\n" +
"            <p>\n" +
"              <strong>ATENÇÃO! </strong> Verifique se sua placa-mãe suporta a terceira geração de processadores da Intel (Ivy Bridge).<br/>\n" +
"              Para o funcionamento correto dos novos processadores Ivy Bridge (3º geração da Intel), é altamente recomendável <br/>\n" +
"              a atualização da BIOS para a mais nova versão. Para tal procedimento, é necessário que um técnico de sua confiança o faça. <br/>\n" +
"              Qualquer erro na atualização por falta de conhecimento técnico, poderá ocasionar a perda irreversível da placa mãe. \n" +
"            </p>");
      
      ofertasSemana.add(p);
    }
    
  }
  
  public String carregarDetalhes(){
    this.produtoDetalhe = this.getProduto();
    
    System.out.println("NOMEEEEE: "+this.produtoDetalhe.getNome());
    
    return "/detalhe.xhtml";
  }

  public ArrayList<Produto> getOfertasSemana() {
    return ofertasSemana;
  }
  
  public Produto getProduto() {
    FacesContext contexto = FacesContext.getCurrentInstance();
    System.out.println("Produto id "+ofertasSemana.get(getId(contexto)).getId()+"//"+ofertasSemana.get(getId(contexto)).getPreco());
    return ofertasSemana.get(getId(contexto));
  }
    
  private int getId(FacesContext fc) {
    Map<String, String> params = fc.getExternalContext().getRequestParameterMap();
    return Integer.parseInt(params.get("id"));
  }
  
  public Produto getProdutoDetalhe() {
    return produtoDetalhe;
  }

  public void setProdutoDetalhe(Produto produtoDetalhe) {
    this.produtoDetalhe = produtoDetalhe;
  }
}
