document.getElementById("logout-button").addEventListener("click", function() {
    fetch("/logout", {
        method: "GET"
    })
        .then(function(response) {
            localStorage.clear();
            window.location.href = "/login";
        })
        .catch(function(error) {
            console.log("Error:", error);
        });
});

function logout(){
    localStorage.clear();
    window.location.href = "/login";
}