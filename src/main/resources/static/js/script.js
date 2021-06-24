/* Change opacity of navigation bar when scrolling */
$(function () {
  $(window).on("scroll", function () {
    if ($(window).scrollTop() > 1) {
      $(".navbar").addClass("active");
    } else {
      $(".navbar").removeClass("active");
    }
  });
});

/* Stop YouTube video when closing modal */
$(".modal").on("hide.bs.modal", function () {
  var memory = $(this).html();
  $(this).html(memory);
});

/* Return current input value of the quantity ordered of the product in the cart */
function getInputValue(cartDetailId) {
	document.getElementById('inputValue').value = document.getElementById(cartDetailId).value;
	document.getElementById('cartDetailId').value = cartDetailId;
	document.forms['inputValueForm'].submit();
}

/* Enable/disable button when called */
function toggleButton(buttonId, toggle) {
	document.getElementById(buttonId).value = "true";
}
