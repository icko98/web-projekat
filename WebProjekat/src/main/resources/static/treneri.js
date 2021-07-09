$(document).ready(function () {

    $.ajax({
        type: "GET",
        url: "http://localhost:8080/treneri",
        dataType: "json",
        success: function (response) {
            console.log("SUCCESS:\n", response);

            for (let Korisnik of response) {
                if(Korisnik.aktivan==false){
                if(Korisnik.uloga=='Trener'){
                let row = "<tr>";
                row += "<td>" + Korisnik.id + "</td>";
                row += "<td>" + Korisnik.ime + "</td>";
                row += "<td>" + Korisnik.prezime + "</td>";
                row += "<td>" + Korisnik.korisnickoIme + "</td>";
                row += "<td>" + Korisnik.email + "</td>";
                row += "<td>" + Korisnik.telefon + "</td>";
                row += "<td>" + Korisnik.datumRodjenja + "</td>";
                row += "<td>" + Korisnik.aktivan + "</td>";
                if(window.localStorage.getItem('Uloga')=='Administrator'){
                let btn = "<button class='btnSeeMore' data-id=" + Korisnik.id + ">Accept</button>";
                row += "<td>" + btn + "</td>";
                let btn2 = "<button class='btnSeeMore2' data-id=" + Korisnik.id + ">Decline</button>";
                                row += "<td>" + btn2 + "</td>";}
                row += "</tr>";

                $('#korisnici').append(row);}}
            }
        },
        error: function (response) {
            console.log("ERROR:\n", response);
        }
    });
});



$(document).on('click', '.btnSeeMore', function () {
        let korid = this.dataset.id;
        function handle(data){
            data["aktivan"]=true;
            $.ajax({
                                type: "PUT",
                                url: "http://localhost:8080/treneri/" + korid,
                                dataType: "json",
                                contentType: "application/json",
                                data: JSON.stringify(data),
                                success: function (response) {
                                    console.log("SUCCESS:\n", response);
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
                        error: function (response) {
                            console.log("ERROR:\n", response);
                        }
                    });
                   return handle;

        }();




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

