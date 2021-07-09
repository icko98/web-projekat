$(document).ready(function () {

    $.ajax({
        type: "GET",                                                // HTTP metoda
        url: "http://localhost:8080/termini",                 // URL koji se gađa
        dataType: "json",                                           // tip povratne vrednosti
        success: function (response) {                              // ova f-ja se izvršava posle uspešnog zahteva
                                // ispisujemo u konzoli povratnu vrednost radi provere

            for (let termin of response) {                        // prolazimo kroz listu svih zaposlenih

                let row = "<tr>";                                   // kreiramo red za tabelu
                row += "<td>" + termin.id + "</td>";
                row += "<td>" + termin.cena + "</td>";
                row += "<td>" + termin.pocetak + "</td>";
                row += "<td>" + termin.trening.tip + "</td>";
                if(window.localStorage.getItem('Uloga')=='Administrator'){
                                let btn2 = "<button class='btnSeeMore2' data-id=" + termin.id + ">Obrisi</button>";
                                                row += "<td>" + btn2 + "</td>";}

                $('#termini').append(row);}

                if(window.localStorage.getItem('Uloga')=='Trener'){
                let btn = document.createElement("button");
                btn.innerHTML = "Napravi novi termin";
                btn.onclick= function () {
                               location.href="/newTermin.html";
                             };
                document.body.appendChild(btn);}

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
                url: "http://localhost:8080/termini/" + korid,
                success: function (response) {
                    alert("obrisan:\n");
                    location.reload();
                    }
                });
 });

function nadji(){
    var input, fil, tab, tr, td, i , txt;
    input = document.getElementById("input3");
    fil = input.value.toUpperCase();
    tab = document.getElementById("termini");
    tr = tab.getElementsByTagName("tr");

    for (i=0;i<tr.length;i++){
    td=tr[i].getElementsByTagName("td")[0];
    if(td){
        txt=td.textContent ;
        if(txt.toUpperCase().indexOf(fil) > -1){
        tr[i].style.display = "";}
        else{
        tr[i].style.display = "none";}
    }
    }

}
function nadji2(){
    var input, fil, tab, tr, td, i , txt;
    input = document.getElementById("input1");
    fil = input.value.toUpperCase();
    tab = document.getElementById("termini");
    tr = tab.getElementsByTagName("tr");

    for (i=0;i<tr.length;i++){
    td=tr[i].getElementsByTagName("td")[1];
    if(td){
        txt=td.textContent ;
        if(txt.toUpperCase().indexOf(fil) > -1){
        tr[i].style.display = "";}
        else{
        tr[i].style.display = "none";}
    }
    }
    }

function nadji3(){
    var input, fil, tab, tr, td, i , txt;
    input = document.getElementById("input2");
    fil = input.value.toUpperCase();
    tab = document.getElementById("termini");
    tr = tab.getElementsByTagName("tr");

    for (i=0;i<tr.length;i++){
    td=tr[i].getElementsByTagName("td")[2];
    if(td){
        txt=td.textContent ;
        if(txt.toUpperCase().indexOf(fil) > -1){
        tr[i].style.display = "";}
        else{
        tr[i].style.display = "none";}
    }
    }
    }


function nadji5(){
    var input, fil, tab, tr, td, i , txt;
    input = document.getElementById("input5");
    fil = input.value.toUpperCase();
    tab = document.getElementById("termini");
    tr = tab.getElementsByTagName("tr");

    for (i=0;i<tr.length;i++){
    td=tr[i].getElementsByTagName("td")[4];
    if(td){
        txt=td.textContent ;
        if(txt.toUpperCase().indexOf(fil) > -1){
        tr[i].style.display = "";}
        else{
        tr[i].style.display = "none";}
    }
    }
    }

$(document).on("submit", "#addTerminForm", function (event) {
    event.preventDefault();

    // preuzimamo vrednosti unete u formi
    let cena = $("#cena").val();
    let pocetak = $("#pocetak").val();
    let sala = $("#sala").val();
    let trening = $("#adresacen").val();

    let newTermin = {
    cena,
    pocetak,
    sala,
    trening,
    }
    $.ajax({
            type: "POST",
            url: "http://localhost:8080/termini",
            dataType: "json",
            contentType: "application/json",
            data: JSON.stringify(newTermin),
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