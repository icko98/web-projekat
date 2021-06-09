$(document).ready(function () {

    $.ajax({
        type: "GET",                                                // HTTP metoda
        url: "http://localhost:8080/centri",                 // URL koji se gađa
        dataType: "json",                                           // tip povratne vrednosti
        success: function (response) {                              // ova f-ja se izvršava posle uspešnog zahteva
            console.log("SUCCESS:\n", response);                    // ispisujemo u konzoli povratnu vrednost radi provere

            for (let fc of response) {                        // prolazimo kroz listu svih zaposlenih

                let row = "<tr>";                                   // kreiramo red za tabelu
                row += "<td>" + fc.id + "</td>";
                row += "<td>" + fc.naziv + "</td>";
                row += "<td>" + fc.adresa + "</td>";
                row += "<td>" + fc.brojTelefona + "</td>";
                row += "<td>" + fc.email + "</td>";
                $('#centri').append(row);}

        },
        error: function (response) {
            console.log("ERROR:\n", response);
        }
    });
});
$(document).on("submit", "#addCentarForm", function (event) {
    event.preventDefault();

    // preuzimamo vrednosti unete u formi
    let naziv = $("#nazivcen").val();
    let brojTelefona = $("#brojcen").val();
    let email = $("#mailcen").val();
    let adresa = $("#adresacen").val();

    let newCentar = {
    naziv,
    brojTelefona,
    email,
    adresa,
    }
    $.ajax({
            type: "POST",
            url: "http://localhost:8080/centri",
            dataType: "json",
            contentType: "application/json",
            data: JSON.stringify(newCentar),
            success: function (response) {
                console.log(response);

                alert("Centar " + response.id + " je uspešno kreiran!");
                window.location.href = "centri.html";
            },
            error: function () {
                alert("Greška!");
            }
        });
    });