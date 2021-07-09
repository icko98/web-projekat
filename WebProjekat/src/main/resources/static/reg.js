$(document).on("submit", "#addKorisnik", function (event) {
    event.preventDefault();


    let ime = $("#ime").val();
    let prezime = $("#prezime").val();
    let korisnickoIme = $("#username").val();
    let email = $("#email").val();
    let telefon = $("#brojtelefona").val();
    let password = $("#password").val();
    let datumRodjenja = $("#datum").val();
    let uloga = 2;
    let aktivan = true;



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

$(document).on("submit", "#addTrener", function (event) {
    event.preventDefault();


    let ime = $("#ime").val();
    let prezime = $("#prezime").val();
    let korisnickoIme = $("#username").val();
    let email = $("#email").val();
    let telefon = $("#brojtelefona").val();
    let password = $("#password").val();
    let datumRodjenja = $("#datum").val();
    let uloga = 1;
    let aktivan = false;
    if(window.localStorage.getItem('Uloga')=='Administrator'){
    aktivan=true;}



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
                window.location.href = "treneri2.html";
            },
            error: function () {
                alert("Greška!");
            }
        });
    });