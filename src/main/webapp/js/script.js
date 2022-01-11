let sceance = []; // tableau de recherche
function cherche() {
	// on recupere le nom du film pour afficher les sceances disponible
	let nom = document.getElementById("sceance").value;
	document.getElementById("sceance").value = ""; // on vide le champ input
	let url = sceance.includes(nom);
	console.log(url);
}

function loadSceance(urlBase) {
	var httprequest;
	let url = window.location.protocol;
	url += urlBase;
	// Tous les navigateurs sauf IE
	if (window.XMLHttpRequest) {
		httprequest = new XMLHttpRequest();
	} else {
		// Pour IE
		httprequest = new ActiveXObject("Msxm12.XMLHTTP");
	}

	httprequest.onreadystatechange = function() {
		if (httprequest.readyState == 4) {
			if (httprequest.status == 200) {
				var contenuJSON = JSON.parse(httprequest.responseText);
				document.querySelector("#divDisplaySceance").innerHTML = "";
				for (let i = 0; i < contenuJSON.length; i++) {
					let newSceance = document.importNode(
						document.querySelector("#templateDisplaySceance").content,
						true
					);
					newSceance.querySelector("#movieName").innerHTML = contenuJSON[i].filmAssocie.nom;;
					newSceance.querySelector("#diffusionDate").innerHTML = new Date(contenuJSON[i].horaireSceance).toLocaleString('fr-FR', { timeZone: 'GMT' })
					document.querySelector("#divDisplaySceance").appendChild(newSceance);
				}
			} else {
				alert("Une erreur s'est produite : " + httprequest.responseText);
			}
		}
	};

	httprequest.open("GET", url + "/rest/sceance", true);
	httprequest.send();

}
function afficherSceance() {

	var httprequest;
	if (window.XMLHttpRequest) {
		// Tous les navigateurs sauf l'ami Internet Explorer
		httprequest = new XMLHttpRequest();
	} else {
		// Que pour internet explorer
		httprequest = new ActiveXObject("Msxm12.XMLHTTP");
	}

	httprequest.onreadystatechange = function() {
		if (httprequest.readyState == 4) {
			if (httprequest.status == 200) {
				var contenuJSON = JSON.parse(httprequest.responseText);
				var maDivS = document.getElementById("sceance_holder");
				maDivS.innerHTML = "";

				for (i = 0; i < contenuJSON.length; i++) {
					var oSceance = document.createElement("option");
					oSceance.innerHTML = new Date(contenuJSON[i].horaireSceance).toLocaleString('fr-FR', { timeZone: 'GMT' });
					maDivS.appendChild(oSceance);

				}

			} else {

			}
		}
	};
	httprequest.open("GET", "http://localhost:8080/TP_POEC/rest/sceance", true);
	httprequest.send();
}
function afficherFilm() {

	var httprequest;

	if (window.XMLHttpRequest) {
		// Tous les navigateurs sauf l'ami Internet Explorer
		httprequest = new XMLHttpRequest();
	} else {
		// Que pour internet explorer
		httprequest = new ActiveXObject("Msxm12.XMLHTTP");
	}

	httprequest.onreadystatechange = function() {
		if (httprequest.readyState == 4) {
			if (httprequest.status == 200) {
				var contenuJSON = JSON.parse(httprequest.responseText);
				var maDivF = document.getElementById("browsers");
				var maDivFM = document.getElementById("browsersM");
				maDivF.innerHTML = "";
maDivFM.innerHTML = "";
				for (i = 0; i < contenuJSON.length; i++) {

					var oFilm = document.createElement("option");
					oFilm.innerHTML = contenuJSON[i].nom;
					oFilm.value = contenuJSON[i].filmId;
					maDivF.appendChild(oFilm);

					var oFilmM = document.createElement("option");
					oFilmM.innerHTML = contenuJSON[i].nom;
					oFilmM.value = contenuJSON[i].filmId;
					maDivFM.appendChild(oFilmM);
				}

			} else {

			}
		}
	};
	httprequest.open("GET", "http://localhost:8080/TP_POEC/rest/film", true);
	httprequest.send();
}
function idSalle() {

	var httprequest;

	if (window.XMLHttpRequest) {
		// Tous les navigateurs sauf l'ami Internet Explorer
		httprequest = new XMLHttpRequest();
	} else {
		// Que pour internet explorer
		httprequest = new ActiveXObject("Msxm12.XMLHTTP");
	}

	httprequest.onreadystatechange = function() {
		if (httprequest.readyState == 4) {
			if (httprequest.status == 200) {
				var contenuJSON = JSON.parse(httprequest.responseText);
				var maDivF = document.getElementById("salleid_holder");
				var maDivFM = document.getElementById("salleid_holderM");
				maDivF.innerHTML = "";
				maDivFM.innerHTML = "";

				for (i = 0; i < contenuJSON.length; i++) {

					var oFilm = document.createElement("option");
					oFilm.innerHTML = contenuJSON[i].salle_id;
					maDivF.appendChild(oFilm);
					
					var oFilmM = document.createElement("option");
					oFilmM.innerHTML = contenuJSON[i].salle_id;
					maDivFM.appendChild(oFilmM);

				}

			} else {

			}
		}
	};
	httprequest.open("GET", "http://localhost:8080/TP_POEC/rest/salle", true);
	httprequest.send();
}
function ajouterSceance() {
	afficherSceance();
	afficherFilm();
	idSalle()
}
function EnvoyerSceance() {
	var httprequest;
	if (window.XMLHttpRequest) {
		// Tous les navigateurs sauf l'ami Internet Explorer
		httprequest = new XMLHttpRequest();
	} else {
		// Que pour internet explorer
		httprequest = new ActiveXObject("Msxm12.XMLHTTP");
	}

	httprequest.onreadystatechange = function() {
		if (httprequest.readyState == 4) {
			if (httprequest.status == 200) {
				// alert("Succès : insertion de la couleur : " + httprequest.responseText);
				console.log(dataFormulaire);
				
			} else {
				alert("Une erreur s'est produite." + httprequest.responseText);
			}
		}
	};
	var date = document.getElementById("dateHSceance").value;
	var film = document.getElementById("browsers").value;
	var prix = document.getElementById("prix").value;
	var langue = document.getElementById("langue").value;
	var id_salle = document.getElementById("salleid_holder").value;

	var dataFormulaire = "&date=" + encodeURIComponent(date);
		dataFormulaire += "&film=" + encodeURIComponent(film);
		dataFormulaire += "&prix=" + encodeURIComponent(prix);
		dataFormulaire += "&langue=" + encodeURIComponent(langue);
		dataFormulaire += "&id_salle=" + encodeURIComponent(id_salle);

	httprequest.open("POST", "http://localhost:8080/TP_POEC/rest/sceance", true);
	httprequest.setRequestHeader("Accept", "application/json");
	httprequest.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	httprequest.send(dataFormulaire);

}
function modifierSceance(id) {
	var httprequest;
	if (window.XMLHttpRequest) {
		// Tous les navigateurs sauf l'ami Internet Explorer
		httprequest = new XMLHttpRequest();
	} else {
		// Que pour internet explorer
		httprequest = new ActiveXObject("Msxm12.XMLHTTP");
	}

	httprequest.onreadystatechange = function() {
		if (httprequest.readyState == 4) {
			if (httprequest.status == 200) {
				// alert("Succès : insertion de la couleur : " + httprequest.responseText);
				console.log(dataFormulaire);
				
			} else {
				alert("Une erreur s'est produite." + httprequest.responseText);
			}
		}
	};
	var date = document.getElementById("dateHSceance"+ id).value;
	var film = document.getElementById("browsers"+ id).value;
	var prix = document.getElementById("prix" +id).value;
	var langue = document.getElementById("langue"+id).value;
	var id_salle = document.getElementById("salleid_holder"+id).value;

	var dataFormulaire = "&date=" + encodeURIComponent(date);
		dataFormulaire += "&film=" + encodeURIComponent(film);
		dataFormulaire += "&prix=" + encodeURIComponent(prix);
		dataFormulaire += "&langue=" + encodeURIComponent(langue);
		dataFormulaire += "&id_salle=" + encodeURIComponent(id_salle);

	httprequest.open("PUT", "http://localhost:8080/TP_POEC/rest/sceance/"+id, true);
	httprequest.setRequestHeader("Accept", "application/json");
	httprequest.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	httprequest.send(dataFormulaire);

}
	



/*function prepareHttpRequest() {
	var httprequest;
	// Tous les navigateurs sauf IE
	if (window.XMLHttpRequest) {
		httprequest = new XMLHttpRequest();
	} else {
		// Pour IE
		httprequest = new ActiveXObject("Msxm12.XMLHTTP");
	}

	httprequest.onreadystatechange = function() {
		if (httprequest.readyState == 4) {
			if (httprequest.status == 200) {
				loadNotes();
			} else {
				alert("Une erreur s'est produite : " + httprequest.responseText);
			}
		}
	};
	return httprequest;
}

function sendNote() {
	let httprequest = prepareHttpRequest();
	let dataToSend = document.getElementById("newNoteContent").value;
	let form = "content=" + encodeURIComponent(dataToSend);
	httprequest.open("POST", "http://localhost:8080/gestionCinema/rest/sceance", true);
	httprequest.setRequestHeader("Accept", "application/json");
	httprequest.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	httprequest.send(form);
	dataToSend.value = "";
}

function updateNote(e) {
	let httprequest = prepareHttpRequest();
	let id = getIdNoteFromElement(e);
	let dataToSend = document.getElementById(id).parentElement.querySelector("#noteContent").value;
	let form = "content=" + encodeURIComponent(dataToSend);
	httprequest.open("PUT", "http://localhost:8080/gestionCinema/rest/sceance" + id, true);
	httprequest.setRequestHeader("Accept", "application/json");
	httprequest.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	httprequest.send(form);
}

function deleteNote(e) {
	let httprequest = prepareHttpRequest();
	let id = getIdNoteFromElement(e);
	httprequest.open("DELETE", "http://localhost:8080/gestionCinema/rest/sceance" + id, true);
	httprequest.setRequestHeader("Accept", "application/json");
	httprequest.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	httprequest.send();
}
*/



