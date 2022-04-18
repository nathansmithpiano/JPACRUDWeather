<script>

	/* Other thing to add comma (don't want this in actual value) */
	/* $(document).ready(function(){
	    $("input[data-type='number']").keyup(function(event){
	      // skip for arrow keys
	      if(event.which >= 37 && event.which <= 40){
	          event.preventDefault();
	      }
	      var $this = $(this);
	      var num = $this.val().replace(/,/gi, "");
	      var num2 = num.split(/(?=(?:\d{3})+$)/).join(",");
	      console.log(num2);
	      // the following line has been simplified. Revision history contains original.
	      $this.val(num2);
	  });
	}); */
	
	// FORMATTER from https://jsfiddle.net/KarmaProd/hw8j34f2/4/
	// Restricts input for each element in the set of matched elements to the given inputFilter.
	(function($) {
	  $.fn.inputFilter = function(callback, errMsg) {
	    return this.on("input keydown keyup mousedown mouseup select contextmenu drop focusout", function(e) {
	      if (callback(this.value)) {
	        // Accepted value
	        if (["keydown","mousedown","focusout"].indexOf(e.type) >= 0){
	          $(this).removeClass("input-error");
	          this.setCustomValidity("");
	        }
	        this.oldValue = this.value;
	        this.oldSelectionStart = this.selectionStart;
	        this.oldSelectionEnd = this.selectionEnd;
	      } else if (this.hasOwnProperty("oldValue")) {
	        // Rejected value - restore the previous one
	        $(this).addClass("input-error");
	        this.setCustomValidity(errMsg);
	        this.reportValidity();
	        this.value = this.oldValue;
	        this.setSelectionRange(this.oldSelectionStart, this.oldSelectionEnd);
	      } else {
	        // Rejected value - nothing to restore
	        this.value = "";
	      }
	    });
	  };
	}(jQuery));


	// Install input filters.
	
	$("#elevation").inputFilter(function(value) {
  		return /^\d*$/.test(value) && (value === "" || parseInt(value) <= 29032); }, "Must be between 0 and 29032.\nNumbers only, no decimals or fractions.");
	$("#latitude").inputFilter(function(value) {
		return /^-?\d*[.,]?\d*$/.test(value) && (value === "" || parseFloat(value) <= 90) 
				&& (value === "" || parseFloat(value) >= 0); }, "Must be between 0 and 90, decimals OK.\nNorthern hemisphere only - no negative latitudes.");
	$("#longitude").inputFilter(function(value) {
		return /^-?\d*[.,]?\d*$/.test(value) && (value === "" || parseFloat(value) <= 180) 
				&& (value === "" || parseFloat(value) >= 0); }, "Must be between 0 and 180, decimals OK.\nWestern hemisphere only - automatically adds negative.");
/* 	$("#intTextBox").inputFilter(function(value) {
	  return /^-?\d*$/.test(value); }, "Must be an integer");
	$("#uintTextBox").inputFilter(function(value) {
	  return /^\d*$/.test(value); }, "Must be an unsigned integer"); */
/* 	$("#floatTextBox").inputFilter(function(value) {
	  return /^-?\d*[.,]?\d*$/.test(value); }, "Must be a floating (real) number"); */
/* 	$("#currencyTextBox").inputFilter(function(value) {
	  return /^-?\d*[.,]?\d{0,2}$/.test(value); }, "Must be a currency value");
	$("#latinTextBox").inputFilter(function(value) {
	  return /^[a-z]*$/i.test(value); }, "Must use alphabetic latin characters");
	$("#hexTextBox").inputFilter(function(value) {
	  return /^[0-9a-f]*$/i.test(value); }, "Must use hexadecimal characters"); */
	  
	//Other Category stuff adapted from https://stackoverflow.com/questions/1228504/how-can-i-add-an-other-text-input-to-a-set-of-radio-buttons-in-an-html-form
	//DISABLED - difficulty implementing with object mapping via Spring
	/* function otherCategory() {
		a=document.getElementById('other_category');
		a.checked=true;
	}
	function regularCategory() {
		a=document.getElementById('other_category');
		a.value="";
	} */
	

</script>