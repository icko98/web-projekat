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
                
                if(Lozinka==response.lozinka){
                alert("Uspeh!");
                localStorage.setItem('ime', response.ime);
                localStorage.setItem('Uloga', response.uloga);
                window.location.href = "treneri.html";}
                else{alert("nemoze!");}



            },
              error: (error) => {
                                 console.log(JSON.stringify(error));
               }

        });
    });