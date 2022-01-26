async function loadEnv() {
    const response = await fetch("../js/env.json");
    const jsonData = await response.json();
    apikey = jsonData.apikey;
}


function updateDetails() {
    document.getElementById('duree').innerHTML = document.getElementById('duree').innerHTML.replace(/PT/i, '').toLowerCase();
    const apikey = await loadEnv();
}