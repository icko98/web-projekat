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
                row += "<td>" + termin.sala.oznaka + "</td>";
                row += "<td>" + termin.trening.tip + "</td>";
                $('#termini').append(row);}

        },
        error: function (response) {
            console.log("ERROR:\n", response);
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

function nadji4(){
    var input, fil, tab, tr, td, i , txt;
    input = document.getElementById("input4");
    fil = input.value.toUpperCase();
    tab = document.getElementById("termini");
    tr = tab.getElementsByTagName("tr");

    for (i=0;i<tr.length;i++){
    td=tr[i].getElementsByTagName("td")[3];
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