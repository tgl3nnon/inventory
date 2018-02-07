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
				var beerName = beer.name;
				var breweryName = beer.brewery;
				var style = beer.style;
				var bottleDate = beer.bottleDate;
				var volume = beer.volume;
				var quantity = beer.quantity;
				
				var beer = '<tr>';
				beer += '<td>' + beerName + '</td>';
				beer += '<td>' + breweryName + '</td>';
				beer += '<td>' + style + '</td>';
				beer += '<td>' + bottleDate + '</td>';
				beer += '<td>' + volume + '</td>';
				beer += '<td>' + quantity + '</td>';
				beer += '</tr>';
				cellarListing.append(beer);
			});

		},
		error : function() {

		}
	});
}