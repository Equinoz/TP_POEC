// Get the container element
let navToggler = document.getElementById("navbarToggler");
// Get all links with class="nav-link" inside the container
let ancors = navToggler.getElementsByClassName("nav-link");
// Loop through the buttons and add the active class to the current/clicked button
for (var i = 0; i < ancors.length; i++) {
    if (ancors[i].getAttribute("href") != window.location.pathname) {
        ancors[i].className.replace(" active", "");
    } else {
        ancors[i].className += " active";
    }
}