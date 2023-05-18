
$(document).on("click", "#acepto", () => {
	$("#boton_aceptar").prop("disabled", false);
});

$(document).on("click", "#registronuevo", () => {
	$("#nomcli").val("");
	$("#alertNOMBRE").hide();
	$("#apecli").val("");
	$("#alertAPELLIDO").hide();
	$("#dnicli").val("");
	$("#alertDNI").hide();
	$("#fc_nac").val("");
	$("#alertFECHA").hide();
	$("#corcli").val("");
	$("#alertCORREO").hide();
	$("#concli").val("");
	$("#alertCONTRASENIA").hide();
	$("#boton_aceptar").prop("disabled", true);
	$("#hiddencliente").val("0");
});

$(document).on("keyup", "#nomcli, #apecli, #dnicli, #corcli, #concli", () => {
	$("#alertNOMBRE").hide();
	$("#alertAPELLIDO").hide();
	$("#alertDNI").hide();
	$("#alertFECHA").hide();
	$("#alertCORREO").hide();
	$("#alertCONTRASENIA").hide();
	$("#boton_aceptar").prop("disabled", true);
});

$(document).on("change", "#fc_nac", () => {
	$("#boton_aceptar").prop("disabled", true);
	$("#alertFECHA").hide();
});

$(document).on("keyup", "#dnicli", () => {
	$("#nomcli").val("");
	$("#apecli").val("");
});

$(document).on("input", "#dnicli", function() {
	this.value = this.value.replace(/[^0-9]/g, '');
});

/*
$(document).on("input", "#nomcli", function() {
	this.value = this.value.replace(/[^[a-z A-Z]/g, '');
});

$(document).on("input", "#apecli", function() {
	this.value = this.value.replace(/[^[a-z A-Z]/g, '');
});
*/

$(document).on('click', '#boton_aceptar', function() {

	let nombre = $("#nomcli").val();
	let apellido = $("#apecli").val();
	let dni = $("#dnicli").val();
	let fecha = $("#fc_nac").val();
	let correo = $("#corcli").val();
	let contrasenia = $("#concli").val();

	let resnom = valNombre(nombre);
	//console.log(resnom);
	let resape = valApellido(apellido);
	//console.log(resape);
	let resdni = valDni(dni);
	//console.log(resdni);
	let resfecha = valFechaEdad(fecha);
	//console.log(resfecha);
	let rescor = valCorreo(correo);
	//console.log(rescor);
	let rescon = valContrasenia(contrasenia);
	//console.log(rescon);


	if (resnom && resape && resdni && resfecha && rescor && rescon) {

		$.get("/Catalogo/buscarDNI", { _dni: dni }, (data) => {
			if (data != "") {
				swal.fire({
					position: 'center',
					icon: 'info',
					title: "Este DNI ya esta REGISTRADO",
					text: data,
					showConfirmButton: false,
					timer: 2000
				})
			} else {
				$.get("/Catalogo/buscarCorreo", { _correo: correo }, (data) => {
					if (data != "") {
						swal.fire({
							position: 'center',
							icon: 'info',
							title: "Este correo ya EXISTE",
							text: data,
							showConfirmButton: false,
							timer: 2000
						})
					} else {
						$.ajax({
							type: 'POST',
							contentType: 'application/json',
							url: '/Catalogo/registrarCliente',
							data: JSON.stringify({
								idcli: $("#idcli").val(),
								nomcli: nombre,
								apecli: apellido,
								dnicli: dni,
								fc_nac: fecha,
								corcli: correo,
								concli: contrasenia,
							}),
							success: function(resultado) {
								if (resultado.respuesta) {
									swal.fire({
										position: 'center',
										icon: 'success',
										title: resultado.mensaje,
										showConfirmButton: false,
										timer: 2000
									})
									$("#registrarse").modal("hide");
								} else {
									swal.fire({
										position: 'center',
										icon: 'error',
										title: resultado.mensaje,
										showConfirmButton: false,
										timer: 2000
									})
								}
							}
						});
					}
				});
			}
		});
	} else {
		swal.fire({
			position: 'center',
			icon: 'warning',
			title: "ADVERTENCIA",
			text: "Revise los campos a corregir o completar",
			showConfirmButton: false,
			timer: 3000
		})
	}

})

function valNombre(nom) {
	let valnom = true;
	if (nom.length == 0) {
		$("#alertNOMBRE").html("El campo no puede estar vacio debes dar click en el boton 'VERIFICAR'.").show();
		valnom = false;
	}
	return valnom;
}

function valApellido(ape) {
	let valape = true;
	if (ape.length == 0) {
		$("#alertAPELLIDO").html("El campo no puede estar vacio debes dar click en el boton 'VERIFICAR'.").show();
		valape = false;
	}
	return valape;
}

$(document).on("click", "#llenardatos", () => {
	$("#boton_aceptar").prop("disabled", true);
	
	let dni = $("#dnicli").val();
	$.get(`/rest/dni/${dni}`, (data) => {

		let apellidos = `${data.apellidoPaterno} ${data.apellidoMaterno}`;

		if (data != "") {
			$("#nomcli").val(data.nombres);
			$("#apecli").val(apellidos)
			swal.fire({
				position: 'center',
				icon: 'success',
				title: "DNI VERIFICADO",
				text: `Nombre: ${data.nombre} DNI: ${data.numeroDocumento}`,
				showConfirmButton: false,
				timer: 2000
			})
		} else {
			$("#nomcli").val("");
			$("#apecli").val("")
			swal.fire({
				position: 'center',
				icon: 'error',
				title: "DNI NO VALIDO",
				text: `El DNI debe tener 8 caracteres o DNI invalido`,
				showConfirmButton: false,
				timer: 3000
			})
		}

	}).fail(
		//error
	);
});

function valDni(dni) {
	let valdni = true;
	if (dni.length == 0 || dni.length < 8) {
		$("#alertDNI").html("El campo DNI acepta 8 caracteres.").show();
		valdni = false;
	}
	return valdni;
}

function valFechaEdad(fecha) {
	let valedad = true;
	const edad = mostrarEdad(fecha);
	if (fecha == "") {
		$("#alertFECHA").html("Debes poner tu fecha de nacimiento.").show();
		
		valedad = false;
	} else {
		if (edad < 18) {
			$("#alertFECHA").html("Debes ser mayor de edad para crear una cuenta de usuario.").show();
			valedad = false;
		}
	}

	return valedad;
}

function valCorreo(correo) {
	let valcor = true;
	if (correo.indexOf('@', 0) == -1 || correo.indexOf('.', 0) == -1) {
		$("#alertCORREO").html('Debe introducir un correo correcto -- ejemplo@ejemplo.com').show();
		valcor = false;
	}
	return valcor;
}

function valContrasenia(contrasenia) {
	var exReg = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[$@$!%*?&])([A-Za-z\d$@$!%*?&]|[^ ]){6,25}$/;
	let valcon = true;
	if (contrasenia.length == 0) {
		$("#alertCONTRASENIA").html('Campo vacio, si desea crear una cuenta de usuario. Debe llenar este campo.').show();
		valcon = false;
	} else if (!(exReg.test(contrasenia))) {
		$("#alertCONTRASENIA").html("Posible error: La contraseña debe tener como mínimo  de 6 caracteres a 25. Requiere de caracteres especiales y/o alphanumerico. '[A-Z a-z 0-9 @.!$?/&]' ").show();
		valcon = false;
	}
	return valcon;
}

function mostrarEdad(fc_nacDate) {
	let hoy = new Date();
	let fechaNacimiento = new Date(fc_nacDate);
	let edad = hoy.getFullYear() - fechaNacimiento.getFullYear();
	let diferenciaMeses = hoy.getMonth() - fechaNacimiento.getMonth();
	if (diferenciaMeses < 0 || (diferenciaMeses === 0 && hoy.getDate() < fechaNacimiento.getDate())) {
		edad--;
	}
	return edad;
}
