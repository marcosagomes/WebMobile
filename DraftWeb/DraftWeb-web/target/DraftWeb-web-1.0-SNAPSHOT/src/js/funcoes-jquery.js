/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


// Permite a execucao inicial das funcionalidades javascript
$(function () { // Abreviação para $(document).ready(function() { ... });

//    Dimmer nas imagens
    $('.special.cards .image').dimmer({
        on: 'hover'
    });
//    Apresentar aquele alert (modal) daora
    $('#showModal').click(function () {
        $('.basic.modal')
                .modal('show')
                ;
    });
//    Quando clicar no carrinho fazer uma animacao
    $('.addCarrinho').click(function () {
        $(this).blur();
        var qtd = parseInt($('#labelCarrinho').text());
        animacaoAdicionouItens(qtd);
    });
    // Função do Slider da pagina de detalhes
    $('#slider').nivoSlider({});

    //Função para os tabs da paginda de detalhes
    $('.tabular.menu .item').tab();

    $(".addCarrinho").focus(function () {
        $(this).removeClass("ui-state-focus");
    });
    $("#btslide").click(function () {
        $('.ui.labeled.icon.sidebar')
                .sidebar('toggle')
                ;
    });

});

function animacaoAdicionouItens(quantidade) {
//    Testando uma animacao na contagem xD
//        var texto = parseInt($('#labelCarrinho').text());
    if (quantidade == 0) {
        $('#labelCarrinho')
                .transition('browse right');
    }

    $('#labelCarrinho')
            .text(quantidade + 1)
            .transition('jiggle');
}
