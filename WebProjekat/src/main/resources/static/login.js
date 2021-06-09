$(document).on("submit", "#login3", function (event) {
    event.preventDefault();


    let Lozinka = $("#inputPassword").val();
    let Email = $("#staticEmail").val();
    console.log(Email);


    let Koris = {
    Lozinka,
    Email,
    }
    $.ajax({
            type: "POST",
            url: "http://localhost:8080/loogin",
            dataType: "json",
            contentType: "application/json",
            data: JSON.stringify(Email),
            success: function (response) {
                console.log(response);



            },
            error: function () {
                alert("Greška!");
            }
        });
    });