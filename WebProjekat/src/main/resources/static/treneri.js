$(document).ready(function () {    // Čeka se trenutak kada je DOM(Document Object Model) učitan da bi JS mogao sa njim da manipuliše.
    // ajax poziv za dobavljanje svih zaposlenih sa backend-a i prikaz u tabeli
    $.ajax({
        type: "GET",                                                // HTTP metoda
        url: "http://localhost:8080/treneri",                 // URL koji se gađa
        dataType: "json",                                           // tip povratne vrednosti
        success: function (response) {                              // ova f-ja se izvršava posle uspešnog zahteva
            console.log("SUCCESS:\n", response);                    // ispisujemo u konzoli povratnu vrednost radi provere

            for (let Korisnik of response) {                        // prolazimo kroz listu svih zaposlenih
                if(Korisnik.aktivan==false){
                let row = "<tr>";                                   // kreiramo red za tabelu
                row += "<td>" + Korisnik.id + "</td>";
                row += "<td>" + Korisnik.ime + "</td>";
                row += "<td>" + Korisnik.prezime + "</td>";
                row += "<td>" + Korisnik.korisnickoIme + "</td>";
                row += "<td>" + Korisnik.email + "</td>";
                row += "<td>" + Korisnik.telefon + "</td>";
                row += "<td>" + Korisnik.datumRodjenja + "</td>";
                row += "<td" + Korisnik.aktivan + "</td>";
                let btn = "<button class='btnSeeMore' data-id=" + Korisnik.id + ">Accept</button>";
                row += "<td>" + btn + "</td>";
                let btn2 = "<button class='btnSeeMore2' data-id=" + Korisnik.id + ">Decline</button>";
                                row += "<td>" + btn2 + "</td>";
                row += "</tr>";

                $('#korisnici').append(row);}
            }
        },
        error: function (response) {
            console.log("ERROR:\n", response);
        }
    });
});



$(document).on('click', '.btnSeeMore', function () {            // kada je kliknut button čija je klasa class = btnSeeMore
        let korid = this.dataset.id;
        function handle(data){
            data["aktivan"]=true;
            $.ajax({
                                type: "PUT",
                                url: "http://localhost:8080/treneri/" + korid,
                                dataType: "json",
                                contentType: "application/json",
                                data: JSON.stringify(data),
                                success: function (response) {                          // ova f-ja se izvršava posle uspešnog zahteva
                                    console.log("SUCCESS:\n", response);                // ispisujemo u konzoli povratnu vrednost radi provere
                                    alert("prihvacen");
                                    location.reload();
                                },
                                error: function() {
                                    alert("greska");
                                }
                    });

        return data;};

        var return_first = function() {
            var tmp= null;
            $.ajax({
                        type: "GET",
                        url: "http://localhost:8080/treneri/" + korid,
                        dataType: "json",
                        success: handle,
                        error: function (response) {                            // ova f-ja se izvršava posle neuspešnog zahteva
                            console.log("ERROR:\n", response);
                        }
                    });
                   return handle;

        }();




 });

 $(document).on('click', '.btnSeeMore2', function () {   // Kada kliknemo decline
        let korid = this.dataset.id;
        $.ajax({
                type: "DELETE",                                                // HTTP metoda
                url: "http://localhost:8080/treneri/" + korid,                 // URL koji se gađa
                success: function (response) {
                    alert("obrisan:\n");
                    location.reload();
                    }
                });
 });

