$(document).on("submit", "#addTerminForm", function (event) {
    event.preventDefault();


    let cena = $("#cena").val();
    let pocetak = $("#pocetak").val();
    let sala = $("#sala").val();
    let centar = $("#centar").val();
    let trening = $("#trening").val();




    let noviTermin = {
        pocetak,
        cena,
        "fitnessCentar":{"id":centar},
        "sala":{"id":sala},
        "trening":{"id":trening}
    }
    $.ajax({
            type: "POST",
            url: "http://localhost:8080/termini",
            dataType: "json",
            contentType: "application/json",
            data: JSON.stringify(noviTermin),
            success: function (response) {
                console.log(response);

                alert("Termin " + response.id + " je uspešno kreiran!");
                window.location.href = "termini.html";
            },
            error: function () {
                alert("Greška!");
            }
        });
    });