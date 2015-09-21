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
    $('#carrinho').click(function () {


//    Testando uma animacao na contagem xD
        var texto = parseInt($('#labelCarrinho').text());

        if (texto == 0) {
            $('#labelCarrinho')
                    .transition('browse right');
        }

        $('#labelCarrinho')
                .text(texto + 1)
                .transition('jiggle');
    });
    // Função do Slider da pagina de detalhes
      $('#slides').slidesjs({
        width: 1000,
        height: 1000,
        navigation: false
      });

});