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
	url+= urlBase;
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
					newSceance.querySelector("#movieName").innerHTML = contenuJSON[i].filmAssocie.nom;
					newSceance.querySelector("#diffusionDate").innerHTML = new Date(contenuJSON[i].horaireSceance).toLocaleString('fr-FR', { timeZone: 'GMT' })
					document.querySelector("#divDisplaySceance").appendChild(newSceance);
				}
			} else {
				alert("Une erreur s'est produite : " + httprequest.responseText);
			}
		}
	};

	httprequest.open("GET", url+"/rest/sceance", true);
	httprequest.send();

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



