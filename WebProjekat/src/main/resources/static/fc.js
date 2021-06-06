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
$(document).on("submit", "#addCentarForm", function (event) {     // kada je submit-ovana forma za kreiranje novog zaposlenog
    event.preventDefault();                                         // sprečavamo automatsko slanje zahteva da bismo pokupili (i validirali) podatke iz forme

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
            type: "POST",                                               // HTTP metoda je POST
            url: "http://localhost:8080/centri",                 // URL na koji se šalju podaci
            dataType: "json",                                           // tip povratne vrednosti
            contentType: "application/json",                            // tip podataka koje šaljemo
            data: JSON.stringify(newCentar),                          // u body-ju šaljemo novog zaposlenog (JSON.stringify() pretvara JavaScript objekat u JSON)
            success: function (response) {                              // ova f-ja se izvršava posle uspešnog zahteva
                console.log(response);                                  // ispisujemo u konzoli povratnu vrednost radi provere

                alert("Centar " + response.id + " je uspešno kreiran!");// prikazujemo poruku uspeha korisniku
                window.location.href = "centri.html";                // redirektujemo ga na employees.html stranicu
            },
            error: function () {                                        // ova f-ja se izvršava posle neuspešnog zahteva
                alert("Greška!");
            }
        });
    });