$(document).on('click','.btnagregarmedicamento', function(){
    $("#txtnombre").val($(this).attr("data-nombre"))
    $("#precioUnitario").val($(this).attr("data-preciounitario"))
    $("#stock").val($(this).attr("data-stock"))
	$('#cantidad').val('0')
	$('#resultado').val('0')
    $("#hiddenproducto").val( $(this).attr("data-id"))
    $('#modalAgregarProducto').modal("show")
})

/*
function calcular(){
	var can = document.getElementById("cantidad").value;
	var precunidad = document.getElementById("precioUnitario").value;
	var res;
	if(can <= 0){
		alert("Se informa que la cantidad no puede ser negativa o igual a cero");
		document.getElementById("cantidad").value = 0;
		document.getElementById("resultado").value = 0;
	}else{
		res = parseFloat(can) * parseFloat(precunidad);
		document.getElementById("resultado").value = res.toFixed(2);
	}
}
*/

$(document).on("click", "#calcular", function(){
	const precunidad = $("#precioUnitario").val();
	let can = $("#cantidad").val();
	let res;
	
	if(can <= 0){
		$("#cantidad").val(0);
		$("#resultado").val(0);
		
		alert("Se informa que la cantidad no puede ser negativa o igual a cero");
	}else{
		res = parseFloat(can) * parseFloat(precunidad);
		
		$("#resultado").val(res.toFixed(2));
	}
	
});

//---------codigo del switch de modo oscuro

$(document).on("click", "#checkoscuro", function() {
    var modo = $(this).prop('checked');

    if (modo) {
	//color total
		$("body").removeClass("fondoclaro");
		$("body").addClass("fondodark");
	//los cards
        $(".card-body").removeClass("cardclaro ");
        $(".card-body").addClass("carddark"); 
	//el boton comprar
    	$(".btnagregarmedicamento").removeClass("btncomprarclaro text-light");
    	$(".btnagregarmedicamento").addClass("btncomprardark text-light");
   	//los borders de cards
    //	$(".card").removeClass("border-dark");
    //	$(".card").addClass("border-warning");
	//SPAN
		$(".info").removeClass("bg-info");
		$(".info").addClass("bg-primary");

		
        //Modal
        
   	$(".modal-content").removeClass("modalfondo");
   	$(".modal-content").addClass("modalfondodark ");

	$(".botones").removeClass(" btn-primary text-light");
	$(".botones").addClass("botonesdark");

        
    } else {
		//
		$("body").removeClass("fondodark");
		$("body").addClass("fondoclaro");
		//
        $(".card-body").removeClass("carddark");
        $(".card-body").addClass("cardclaro");
		//
		$(".btnagregarmedicamento").removeClass("btncomprardark text-light");
    	$(".btnagregarmedicamento").addClass("btncomprarclaro text-light");
    	//
	//	$(".card").removeClass("border-warning");
	//	$(".card").addClass("border-dark");
		//SPAN
		$(".info").removeClass("bg-primary");
		$(".info").addClass("bg-info");

		
		$(".botones").removeClass("botonesdark");
		$(".botones").addClass("btn-primary text-light");

   	$(".modal-content").removeClass("modalfondodark ");
   	$(".modal-content").addClass("modalfondo ");

	
    }
});

//El login
 


//Cambio de letra Brian

$(document).on('click', '#pequeña', function() {
	$('.card-body').animate({ 'font-size': '15px' }, 2000)
	$('.card-title').animate({ 'font-size': '15px' }, 2000)
	$('.card-text').animate({ 'font-size': '15px' }, 2000)
		;
});

$(document).on('click', '#mediana', function() {
	$('.card-body').animate({ 'font-size': '25px' }, 2000)
	$('.card-title').animate({ 'font-size': '25px' }, 2000)
	$('.card-text').animate({ 'font-size': '25px' }, 2000)
		;
});

$(document).on('click', '#grande', function() {
	$('.card-body').animate({ 'font-size': '35px' }, 2000)
	$('.card-title').animate({ 'font-size': '35px' }, 2000)
	$('.card-text').animate({ 'font-size': '35px' }, 2000)
		;
});















/* CODIGO JS DE VALORACION */
$(document).on('click','#calificar', function(){
	let usuario = $("#idcliente").val()	;
	
	let valor = $("#restvaloramiento").val();
	console.log(usuario + " " + valor);
    $.ajax({
        type: 'POST',
        contentType: 'application/json',
        url: '/Valoracion/registrarvaloramiento',
        data: JSON.stringify({
            idvalor: $("#hiddenvaloramiento").val(),
            calificacion: valor,
			idcli: usuario,
           
        }),
        success: function(resultado){
            if(resultado.respuesta){
                //alert(resultado.mensaje);
                swal.fire({
                    position: 'center',
                    icon: 'success',
                    title: resultado.mensaje,
                    showConfirmButton: false,
                    timer: 1500
                  })
               
            }else{
                swal.fire({
                    position: 'center',
                    icon: 'error',
                    title: resultado.mensaje,
                    showConfirmButton: false,
                    timer: 1500
                  })
                //alert(resultado.mensaje);
            }
        }		
    });
    
})

$(document).on("click",".vernota",function(){
	$("txtidvalor").val($(this).attr("data-calificacion"));
	$("txtcalificacion").val($(this).attr("data-idvalor"))
});







$(document).ready(function (){
	let calificacion = $("#restvaloramiento").val();
	calificarvaloramiento(calificacion);	
});

function calificarvaloramiento(contador) {
			let nombre = "estrella";
			for (let i = 0; i < 5; i++) {

				if (i < contador) {

					document.getElementById((i + 1) + nombre).style.color = "orange";
				} else {
					document.getElementById((i + 1) + nombre).style.color = "black";
					
				} 

			}
		}



$(document).on('click','.actualizarValoracion', function(){
    $("#calificacion").val($(this).attr("data-cali"))
    $('#modalProducto').modal("show")
})