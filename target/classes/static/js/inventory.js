$(document).ready(function() {
	hideAllNavBarLinks();
	loadInventory();

})

function loadInventory() {
	clearInventory();
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
			$('#cellarListing').DataTable({
				'pageLength' : 10
			});

		},
		error : function() {

		}
	});
}

function addBeerToInventory() {
	$('#add-beer').click(function(event) {
		$.ajax({
			type : 'POST',
			url : '/addBeer',
			data : JSON.stringify({
				name : $('#add-beer-name').val(),
				brewery : $('#add-brewery-name').val(),
				style : $('#select-style-name').val(),
				bottleDate : $('#add-bottle-date').val(),
				vol : $('#add-volume').val(),
				quantity : $('#add-quantity').val(),
			}),
			headers : {
				'Accept' : 'application/json',
				'Content-Type' : 'application/json'
			},
			'dataType' : 'json',
			success : function() {
				showHome();
				console.log('success');
			},

			error : function() {
				console.log('error');
			}

		});
	});
}

function hideAllNavBarLinks() {
	$('#addBeer').hide();
	$('#updateBeer').hide();
	$('#deleteBeer').hide();
	$('#search').hide();
}

function clearInventory() {
	$('#cellarListing').empty();
}

function showHome() {
	hideAllNavBarLinks();
	loadInventory();
	$('#mainPage').show();
	$('#search').hide();
}

$('#takeMeHome').on('click', function() {
	hideAllNavBarLinks();
	loadInventory();
	$('#mainPage').show();
	$('#search').hide();
});

$('#addBeerLink').on('click', function() {
	$('#addBeer').show();
	$('#deleteBeer').hide();
	$('#updateBeer').hide();
	$('#mainPage').hide();
	$('#search').hide();
	addBeerToInventory();
});

$('#updateBeerLink').on('click', function() {
	$('#updateBeer').show();
	$('#addBeer').hide();
	$('#deleteBeer').hide();
	$('#mainPage').hide();
	$('#search').hide();
});

$('#deleteBeerLink').on('click', function() {
	$('#deleteBeer').show();
	$('#updateBeer').hide();
	$('#addBeer').hide();
	$('#mainPage').hide();
	$('#search').hide();
});

$('#searchLink').on('click', function() {
	$('#mainPage').hide();
	$('#addBeer').hide();
	$('#deleteBeer').hide();
	$('#mainPage').hide();
	$('#search').show();
});