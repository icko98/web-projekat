$(document).on("submit", "#addKorisnik", function (event) {     // kada je submit-ovana forma za kreiranje novog zaposlenog
    event.preventDefault();                                         // sprečavamo automatsko slanje zahteva da bismo pokupili (i validirali) podatke iz forme

    // preuzimamo vrednosti unete u formi
    let ime = $("#ime").val();
    let prezime = $("#prezime").val();
    let korisnickoIme = $("#username").val();
    let email = $("#email").val();
    let telefon = $("#brojtelefona").val();
    let password = $("#password").val();
    let datumRodjenja = $("#datum").val();
    let uloga = 2;
    let aktivan = true;


    // kreiramo objekat zaposlenog
    // nazivi svih atributa moraju se poklapati sa nazivima na backend-u
    let noviKorisnik = {
        email,
        uloga,
        telefon,
        korisnickoIme,
        ime,
        prezime,
        aktivan,
        datumRodjenja
    }
    $.ajax({
            type: "POST",
            url: "http://localhost:8080/profili",
            dataType: "json",
            contentType: "application/json",
            data: JSON.stringify(noviKorisnik),
            success: function (response) {
                console.log(response);

                alert("Korisnik " + response.id + " je uspešno kreiran!");
                window.location.href = "profili.html";
            },
            error: function () {
                alert("Greška!");
            }
        });
    });