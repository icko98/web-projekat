$(document).on("submit", "#login3", function (event) {
    event.preventDefault();


    let Lozinka = $("#inputPassword").val();
    let Email = $("#staticEmail").val();




    $.ajax({
            type: "POST",
            url: "http://localhost:8080/loogin",
            dataType: "json",
            contentType: "application/json",
            data: Email,
            success: function (response) {
                
                if(Lozinka==response.lozinka && response.aktivan==true){
                alert("Uspeh!");
                window.localStorage.setItem('ime', response.ime);
                window.localStorage.setItem('Uloga', response.uloga);
                window.location.href = "home.html";}
                else{alert("ne moze!");}



            },
              error: (error) => {
                                 alert("Korisnik ne postoji");
               }

        });
    });