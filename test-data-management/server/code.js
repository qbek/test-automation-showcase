console.log("hi!");

$('#form').on('submit', function (event) {
	event.preventDefault()
	let login = $('#login').val()
	let password = $('#password').val()
	let auth = login + ':' + password
	$.post('http://localhost:8888/sign', auth)

		.done(function () {
			let alertDiv = $('<div class="alert alert-success" role="alert"></div>').text("Congratulations!!! You are in!")
			$('#alerts').append(alertDiv)



		})
		.fail(function ( data ) {
			console.dir(data)
			let msg = data.status + ": " + data.statusText
			let alertDiv = $('<div class="alert alert-danger" role="alert"></div>').text(msg)
			$('#alerts').append(alertDiv)

		})
})