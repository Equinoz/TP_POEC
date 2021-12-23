/**
 *  Programme pour Chercher les sceances que on désire
 * 
 */

let sceance = []; // tableau de recherche
function cherche() {
    // on recupere le nom du film pour afficher les sceances disponible
    let nom = document.getElementById("sceance").value;
    document.getElementById("sceance").value = ""; // on vide le champ input
    let url = sceance.includes(nom);
    console.log(url);
    // fetch(url)
    //   .then((response) => response.json()) // retourn au 2em then le body = contenu JSON
    //   .then((data) => {
    //     // si il y a  des reponses
    //     if (data.Error == undefined) {
    //       let template = document.querySelector("#templateRecherche");
    //       let destination = document.querySelector("#tbody");
    //       // vider le tableau
    //       destination.innerHTML = "";
    //       films = data.Search;
    //       for (let film of films) {
    //         // je viens cloner le template
    //         let clone = template.content.cloneNode(true);
    //         clone.querySelector(".titre").innerHTML = film.Title;
    //         clone.querySelector("img").setAttribute("src", film.Poster);

    //         clone.querySelector(".ajouter").onclick = function () {
    //           let indice = this.parentElement.parentElement.rowIndex - 1;
    //           // je copie le film de l'inidice i dans le 2eme tableau
    //           favoris.push(films[indice]);
    //           afficherFavoris();
    //           localStorage.fav = JSON.stringify(favoris);
    //         };
    //         destination.appendChild(clone);
    //       }
    //     } else {
    //       console.log(data.Error);
    //     }
    //   });
}

function clearDiv(div) {
    let selector = document.querySelector(div);
    while (selector.firstChild) {
        selector.removeChild(selector.firstChild);
    }
}
async function displaySceanceFromServer() {
    let url = "http://localhost:8080/gestionCinema/SceanceServlet?param=getAllSceance";
    /*     const response = await fetch(url);
        sceance = JSON.parse(await response.json());
        console.log(sceance); */
    fetch(url)
        .then((response) => response.json()) // retourn au 2em then le body = contenu JSON
        .then((sceance) => {
            for (let sc of sceance.Search) {
                let newSceance = document.importNode(
                    document.querySelector("#templateDisplaySceance").content,
                    true
                );
                newSceance.querySelector("#movieName").innerHTML = sc.FilmAssocie.Nom;
                newSceance.querySelector("#diffusionDate").innerHTML = sc.HoraireSceance;
                document.querySelector("#divDisplaySceance").appendChild(newSceance);
            }
            console.log(sceance.Search);
        });
    // Clear Sceance div
    //clearDiv("#divDisplaySceance");
    // Add to HTML
    /*          for (let sc of sceance) {
                let newSceance = document.importNode(
                    document.querySelector("#templateFavorites").content,
                    true
                );
                newSceance.querySelector("#movieName").innerHTML = sc.Nom;
                newSceance.querySelector("#diffusionDate").innerHTML = sc.HoraireSceance;
                document.querySelector("#divFavorites").appendChild(newSceance);
            }  */
}
displaySceanceFromServer();