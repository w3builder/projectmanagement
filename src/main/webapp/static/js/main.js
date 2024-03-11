/**
 * 
 */

$('.datepicker').datepicker({
  format: 'dd/mm/yyyy',
  autoclose: true,
  language: 'pt-BR' 
});

$(document).ready(function(){
	
	$('.datepicker').inputmask('99/99/9999', {
        placeholder: 'dd/mm/yyyy',
        clearIncomplete: true,
        clearMaskOnLostFocus: true, 
        showMaskOnHover: false 
    });
});