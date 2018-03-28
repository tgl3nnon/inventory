$(document).ready(function () {
	hideAllNavBarLinks();
	loadInventory();

	function loadInventory() {
		clearInventory();
		var cellarListing = $('#cellarListing');

		$.ajax({
			type: 'GET',
			url: '/beers',
			success: function (data, status) {
				$.each(data, function (index, beer) {
					var beerName = beer.name;
					var breweryName = beer.brewery;
					var style = beer.style;
					var bottleDate = beer.bottleDate;
					var volume = beer.vol;
					var quantity = beer.quantity;
					var id = beer.id;
					//var beerLink = 'http://localhost:8080/getBeer/' + beer;

					var beer = '<div class="row" id="beer-button' + id + '">';
					beer += '<div class="col" id="beer-name">' + beerName + '</div>';
					beer += '<div class="col" id="brewery-name">' + breweryName + '</div>';
					beer += '<div class="col" id="beer-style">' + style + '</div>';
					beer += '<div class="col" id="beer-bottle-date">' + bottleDate + '</div>';
					beer += '<div class="col" id="beer-volume">' + volume + '</div>';
					beer += '<div class="col" id="beer-quantity">' + quantity + '</div>';
					beer += '</div>';
					cellarListing.append(beer);

					$('#beer-button' + id).on('click', function () {
						hideSelectedBeer();
						$('#selectedBeer').fadeIn("slow");
						$('#selectedBeerName').append('Beer Name:' + beerName);
						$('#selectedBeerBrewery').append('Brewery Name: ' + breweryName);
						$('#selectedBeerStyle').append('Style: ' + style);
						$('#selectedBeerDate').append('Botle Date: ' + bottleDate);
						$('#selectedBeerVolume').append('Volume: ' + volume);
						$('#selectedBeerQuantity').append('Quantity: ' + quantity);
					});

				});

			},
			error: function () {
				console.log('Error loading inventory');
			}
		});
	}

	function addBeerToInventory() {
		$('#add-beer').click(function (event) {
			$.ajax({
				type: 'POST',
				url: '/addBeer',
				data: JSON.stringify({
					name: $('#add-beer-name').val(),
					brewery: $('#add-brewery-name').val(),
					style: $('#select-style-name').val(),
					bottleDate: $('#add-bottle-date').val(),
					vol: $('#add-volume').val(),
					quantity: $('#add-quantity').val(),
				}),
				headers: {
					'Accept': 'application/json',
					'Content-Type': 'application/json'
				},
				'dataType': 'json',
				success: function () {
					showHome();
					console.log('success');
				},

				error: function () {
					console.log('error');
				}

			});
		});
	}

	// function getBeer(beer) {
	// 	$.ajax({
	// 		type: 'POST',
	// 		url: '/getBeer',
	// 		data: JSON.stringify(beer),
	// 		headers: {
	// 			'Accept': 'application/json',
	// 			'Content-Type': 'application/json'
	// 		},
	// 		'dataType': 'json',
	// 		success: function () {
	// 			console.log('success');
	// 		},

	// 		error: function () {
	// 			console.log('error');
	// 		}

	// 	});
	// }

	function hideAllNavBarLinks() {
		$('#addBeer').hide();
		$('#updateBeer').hide();
		$('#deleteBeer').hide();
		$('#search').hide();
		hideSelectedBeer();

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

	$('#takeMeHome').on('click', function () {
		hideAllNavBarLinks();
		loadInventory();
		$('#mainPage').show();
		$('#search').hide();
		hideSelectedBeer();
	});

	$('#addBeerLink').on('click', function () {
		$('#addBeer').show();
		$('#deleteBeer').hide();
		$('#updateBeer').hide();
		$('#mainPage').hide();
		$('#search').hide();
		addBeerToInventory();
		hideSelectedBeer();
	});

	$('#updateBeerLink').on('click', function () {
		$('#updateBeer').show();
		$('#addBeer').hide();
		$('#deleteBeer').hide();
		$('#mainPage').hide();
		$('#search').hide();
		hideSelectedBeer();
	});

	$('#deleteBeerLink').on('click', function () {
		$('#deleteBeer').show();
		$('#updateBeer').hide();
		$('#addBeer').hide();
		$('#mainPage').hide();
		$('#search').hide();
		hideSelectedBeer();
	});

	$('#searchLink').on('click', function () {
		$('#mainPage').hide();
		$('#addBeer').hide();
		$('#deleteBeer').hide();
		$('#updateBeer').hide();
		$('#search').show();
		hideSelectedBeer();
	});

	function hideSelectedBeer() {
		$('#selectedBeer').hide();
		$('#selectedBeerName').empty();
		$('#selectedBeerBrewery').empty();
		$('#selectedBeerStyle').empty();
		$('#selectedBeerDate').empty();
		$('#selectedBeerVolume').empty();
		$('#selectedBeerQuantity').empty();
	};


})