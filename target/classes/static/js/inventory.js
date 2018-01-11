$(document).ready(function() {

	loadInventory();

})

function loadInventory() {
	// set up clear inventory

	var cellarListing = $('#cellarListing');

	$.ajax({
		type : 'GET',
		url : 'http://localhost:8080/beers',
		success : function(data, status) {
			$.each(data, function(index, beer) {
				var name = beer.name;

				var test = '<p>';
				test += name + '</p>';
				cellarListing.append(test);
			});

		},
		error : function() {

		}
	});
}