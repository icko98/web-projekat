$(document).ready(function () {

    $.ajax({
        type: "GET",
        url: "http://localhost:8080/profili",
        dataType: "json",
        success: function (response) {
            console.log("SUCCESS:\n", response);

            for (let Korisnik of response) {


                let row = "<tr>";
                row += "<td>" + Korisnik.ime + "</td>";
                row += "<td>" + Korisnik.prezime + "</td>";
                row += "<td>" + Korisnik.korisnickoIme + "</td>";
                row += "<td>" + Korisnik.email + "</td>";
                row += "<td>" + Korisnik.telefon + "</td>";
                row += "<td>" + Korisnik.datumRodjenja + "</td>";
                row += "<td>" + Korisnik.aktivan + "</td>";
                row += "<td>" + Korisnik.uloga + "</td>";
                let btn = "<button class='btnSeeMore' data-id=" + Korisnik.id + ">Profil</button>";
                                                row += "<td>" + btn + "</td>";

                if(window.localStorage.getItem('Uloga')=='Administrator'){
                let btn2 = "<button class='btnSeeMore2' data-id=" + Korisnik.id + ">Obrisi</button>";
                                row += "<td>" + btn2 + "</td>";}
                row += "</tr>";

                $('#korisnici').append(row);
            }
        },
        error: function (response) {
            console.log("ERROR:\n", response);
        }
    });
});

$(document).on('click', '.btnSeeMore2', function () {
        let korid = this.dataset.id;
        $.ajax({
                type: "DELETE",
                url: "http://localhost:8080/treneri/" + korid,
                success: function (response) {
                    alert("obrisan:\n");
                    location.reload();
                    }
                });
 });

 $(document).on('click', '.btnSeeMore', function () {
         let korid = this.dataset.id;
         window.localStorage.setItem('id', korid);
         window.location.href="profil.html";
  });
