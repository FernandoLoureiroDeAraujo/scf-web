$(function() {
	$('input.data').bootstrapMaterialDatePicker({ 
		format : 'DD/MM/YYYY',
		lang: 'pt-BR',
		weekStart : 0, 
		time: false
	});	

	$('input.data-inicio').bootstrapMaterialDatePicker({ 
		format : 'DD/MM/YYYY',
		lang: 'pt-BR',
		weekStart : 0, 
		time: false
	}).on('change', function(e, date){
		$('input.data-final').bootstrapMaterialDatePicker('setMinDate', date);}
	);
	$('input.data-final').bootstrapMaterialDatePicker({ 
		format : 'DD/MM/YYYY',
		lang: 'pt-BR',
		weekStart : 0, 
		time: false 
	});
	
	$(".alert.alert-success").fadeTo(2500, 500).slideUp(500, function(){
	    $(".success-alert").slideUp(500);
	});
	
	$("input.mascara-moeda").mask("000.000,00", {reverse: true}); 
//	$("input.mascara-data").mask('00/00/0000');
});