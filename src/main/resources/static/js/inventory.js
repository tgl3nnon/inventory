$(document).ready(function() {
	hideAllNavBarLinks();
	loadInventory();

})

function loadInventory() {
	// set up clear inventory

	var cellarListing = $('#cellarListing');

	$.ajax({
		type : 'GET',
		url : '/beers',
		success : function(data, status) {
			$.each(data, function(index, beer) {
				var beerName = beer.name;
				var breweryName = beer.brewery;
				var style = beer.style;
				var bottleDate = beer.bottleDate;
				var volume = beer.vol;
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
			$("#cellarListing").DataTable({
				'pageLength':10
			});

		},
		error : function() {

		}
	});
}

function hideAllNavBarLinks() {
	$("#addBeer").hide();
	$("#updateBeer").hide();
	$("#deleteBeer").hide();
	$("#search").hide();
}

$("#takeMeHome").on("click", function() {
	hideAllNavBarLinks();
	loadInventory();
	$("#mainPage").show();
	$("#search").hide();
});

$("#addBeerLink").on("click", function() {
	$("#addBeer").show();
	$("#deleteBeer").hide();
	$("#updateBeer").hide();
	$("#mainPage").hide();
	$("#search").hide();
});

$("#updateBeerLink").on("click", function() {
	$("#updateBeer").show();
	$("#addBeer").hide();
	$("#deleteBeer").hide();
	$("#mainPage").hide();
	$("#search").hide();
});

$("#deleteBeerLink").on("click", function() {
	$("#deleteBeer").show();
	$("#updateBeer").hide();
	$("#addBeer").hide();
	$("#mainPage").hide();
	$("#search").hide();
});

$("#searchLink").on("click", function() {
	$("#mainPage").hide();
	$("#addBeer").hide();
	$("#deleteBeer").hide();
	$("#mainPage").hide();
	$("#search").show();
});
