$(document).ready(function () {

    $.ajax({
        type: "GET",                                                // HTTP metoda
        url: "http://localhost:8080/Sale",                 // URL koji se gađa
        dataType: "json",                                           // tip povratne vrednosti
        success: function (response) {                              // ova f-ja se izvršava posle uspešnog zahteva
            console.log("SUCCESS:\n", response);                    // ispisujemo u konzoli povratnu vrednost radi provere

            for (let fc of response) {                        // prolazimo kroz listu svih zaposlenih
              if(fc.fitnessCentar.id==window.localStorage.getItem('id')){
                let row = "<tr>";                                   // kreiramo red za tabelu
                row += "<td>" + fc.id + "</td>";
                row += "<td>" + fc.kapacitet + "</td>";
                row += "<td>" + fc.oznaka + "</td>";
                row += "<td>" + fc.fitnessCentar.id + "</td>";
                if(window.localStorage.getItem('Uloga')=='Administrator'){
                let btn = "<button class='btnSeeMore' data-id=" + fc.id + ">Obrisi</button>";
                                row += "<td>" + btn + "</td>";}
                $('#sale').append(row);}}

            if(window.localStorage.getItem('Uloga')=='Administrator'){
                let btn = document.createElement("button");
                                btn.innerHTML = "Dodaj novu salu";
                                btn.onclick= function () {
                                               location.href="/SaleAdd.html";
                                             };
                document.body.appendChild(btn);}

        },
        error: function (response) {
            console.log("ERROR:\n", response);
        }
    });
});

$(document).on('click', '.btnSeeMore', function () {
        let korid = this.dataset.id;
        $.ajax({
                type: "DELETE",
                url: "http://localhost:8080/Sale/" + korid,
                success: function (response) {
                    alert("obrisan:\n");
                    location.reload();
                    }
                });
 });