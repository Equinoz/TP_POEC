async function loadEnv() {
    const response = await fetch("../js/env.json");
    const jsonData = await response.json();
    return jsonData.apikey;
}

async function getSpecificMoviePlot(movieName, apikey) {
    let url = apikey + "&t=" + movieName;
    const response = await fetch(url);
    const movie = await response.json();
    return movie.Plot;
}

function updateDetails() {
    document.getElementById('duree').innerHTML = document.getElementById('duree').innerHTML.replace(/PT/i, '').toLowerCase();
}

async function updateDescription() {
    const apikey = await loadEnv();
    let movieName = document.querySelector("#nom").innerHTML;
    document.querySelector("#description").innerHTML = await getSpecificMoviePlot("Star Wars", apikey);
}

updateDescription();  