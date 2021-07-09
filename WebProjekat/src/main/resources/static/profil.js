$(document).ready(function () {
    let id = window.localStorage.getItem('id');
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/profili/" + id,
        dataType: "json",
        success: function (response) {




                let row = "<tr>";
                row += "<td>" + response.ime + "</td>";
                row += "<td>" + response.prezime + "</td>";
                row += "<td>" + response.korisnickoIme + "</td>";
                row += "<td>" + response.email + "</td>";
                row += "<td>" + response.telefon + "</td>";
                row += "<td>" + response.datumRodjenja + "</td>";
                row += "<td>" + response.aktivan + "</td>";
                row += "<td>" + response.uloga + "</td>";


                $('#korisnici').append(row);


                for (let termin of response.listaPrijavljenihTreninga){
                let x = "<tr>";
                    x += "<td>" + termin.pocetak + "</td>";
                    x += "<td>" + termin.cena + "</td>";
                    x += "<td>" + termin.sala.oznaka + "</td>";
                    x += "<td>" + termin.trening.tip + "</td>";
                    row += "</tr>";
                    $('#termini1').append(x);

                }


        },
        error: function (response) {
            console.log("ERROR:\n", response);
        }
    });
});