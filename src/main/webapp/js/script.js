// Effets sur le menu
$(function(){
    $('nav li a').each(function(){
        if($(this).attr('href').indexOf(location.pathname) != -1){
            $(this).css('color','red');
            $(this).css('font-weight','bold');
        }
    })
})
// Fin effets sur le menu

let bubble = 0;
$('#bubble').text(bubble);
let tabBags = [0];
let netToPay = 0;
$('.addToCart').click(function () {
  bubble = bubble + 1;
  $('#bubble').text(bubble);

  // Table counting each type of bags ordered

  let parent = $(this).parent();
  let cell = (parent.prop('class')).substr(23);
  if (isNaN(tabBags[parseInt(cell)])) {
    tabBags[parseInt(cell)] = 1;
  } else {
    tabBags[parseInt(cell)]++;
  }
});

$('.shopping-bag').click(function () {
  if (bubble > 0) {
    $('body').append('<div class="invoice"><div class="innerInvoice"><a href="#"><span class="fa fa-times"></span></a></div></div>');
    $('.innerInvoice').append(
      '<div class="mb-5">'+
        '<h2>MY SHOPPING BAG <span>(' + bubble + ')</span></h2>'+
      '</div>'+
      '<div class="container">'+
      '</div>');
    for (let index = 1; index < tabBags.length; index++) {
      let quantity = parseInt(tabBags[index]);
      let price = parseInt($('.label'+index+' .money').text());
      if (quantity > 0) {
        $('.innerInvoice>.container').append(
          '<div class="row mx-4 pb-3 border-bottom border-info">'+
            '<div class="col-12 mt-4">'+
              '<h4>'+$('.label' + index).find('a').text() + ' :</h4>'+
            '</div>'+
            '<div class="col-sm-4 col-12 mt-2">Quantité : '+ quantity +'</div>'+
            '<div class="col-sm-4 col-12 mt-2">Prix : '+ price +' €</div>'+
            '<div class="col-sm-4 col-12 mt-2">Total : '+ quantity * price +' €</div>'+
            '<div class="row">'+
              '<div class="increment1">-</div>'+
              '<div class="increment2"></div>'+
              '<div class="increment3">+</div>'+
            '</div>'+
          '</div>');
        netToPay = netToPay + quantity * price;
      }
    }
    $('.innerInvoice>.container').append(
      '<div class="row ml-3 pb-5">'+
        '<div class="col-sm-8 col-12 mt-4"><h5>Net à payer : '+ netToPay +' €</h5></div>'+
        '<div class="col-sm-4 col-12 mt-3"><button type="button" class="btn btn-secondary addToCart">Checkout</button></div>'+
      '</div>');
  }

  $('.fa-times').click(function () {
    $('.invoice').hide();
  });
});

