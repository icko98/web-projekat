INSERT INTO FITNESS_CENTAR(ADRESA, NAZIV, BROJ_TELEFONA, EMAIL) values ('Ratka Jovica 3','wowooogym' ,'0605223344','wowoogym@gmail.com');
INSERT INTO SALA(KAPACITET, OZNAKA, FITNESS_CENTAR_ID) values (300, 2, 1);
INSERT INTO SALA(KAPACITET, OZNAKA, FITNESS_CENTAR_ID) values (100, 1, 1);
INSERT INTO KORISNIK(AKTIVAN, DATUM_RODJENJA, EMAIL, IME,PREZIME ,TELEFON, KORISNICKO_IME, LOZINKA, ULOGA,PROSECNA_OCENA) values (true, '2001-03-12 19:00:00.000000', 'raki2@gmail.com' , 'Radisav', 'Rasic', '0605221122', 'rasorasic','password2' ,0,1.1);
INSERT INTO KORISNIK(AKTIVAN, DATUM_RODJENJA, EMAIL, IME,PREZIME ,TELEFON, KORISNICKO_IME, LOZINKA, ULOGA,PROSECNA_OCENA) values (true, '2002-04-01 19:00:00.000000', 'baki2@gmail.com' , 'Ladisav', 'Vasic', '0605211223', 'basobasic','password3' ,0,1.1);
INSERT INTO KORISNIK(AKTIVAN, DATUM_RODJENJA, EMAIL, IME,PREZIME ,TELEFON, KORISNICKO_IME, LOZINKA, ULOGA,PROSECNA_OCENA) values (true, '2003-03-11 19:00:00.000000', 'caki2@gmail.com' , 'Cadisav', 'Basic', '0605221127', 'casocasic','password4' ,0,1.1);
INSERT INTO TRENING(NAZIV, OPIS, TIP, TRAJANJE, TRENER_ID) values ('trening1', 'dsa',1, 13, 1);
INSERT INTO TRENING(NAZIV, OPIS, TIP, TRAJANJE, TRENER_ID) values ('trening2', 'adsa',0, 133, 2);
INSERT INTO TRENING(NAZIV, OPIS, TIP, TRAJANJE, TRENER_ID) values ('trening3', 'dsa',3, 1, 1);
INSERT INTO TERMIN(CENA, POCETAK, SALA_ID, TRENING_ID) values (1000, '2021-11-01 11:00:00.000000', 1,1);
INSERT INTO TERMIN(CENA, POCETAK, SALA_ID, TRENING_ID) values (1000, '2021-11-10 12:00:00.000000', 1,2);
INSERT INTO TERMIN(CENA, POCETAK, SALA_ID, TRENING_ID) values (1000, '2021-11-11 11:00:00.000000', 2,3);
INSERT INTO KORISNIK(AKTIVAN, DATUM_RODJENJA, EMAIL, IME,PREZIME ,TELEFON, KORISNICKO_IME, LOZINKA, ULOGA,PROSECNA_OCENA)
values (false, '2000-03-11 19:00:00.000000', 'cakzzzi2@gmail.com' , 'Cadddisav', 'Bassic', '0685221127', 'casocsdasic','passwo44rd4' ,0,1.1);
INSERT INTO KORISNIK(AKTIVAN, DATUM_RODJENJA, EMAIL, IME,PREZIME ,TELEFON, KORISNICKO_IME, LOZINKA, ULOGA,PROSECNA_OCENA)
values (false, '2006-03-11 19:00:00.000000', '233cakzzzi2@gmail.com' , 'Qadddisav', 'BQassic', '033685221127', 'zzzcasocsdasic','ppasswo44rd4' ,0,1.1);
INSERT INTO KORISNIK(AKTIVAN, DATUM_RODJENJA, EMAIL, IME,PREZIME ,TELEFON, KORISNICKO_IME, LOZINKA, ULOGA,PROSECNA_OCENA)
values (false, '2000-06-11 19:00:00.000000', 'yakzzzi2@gmail.com' , 'Yadddisav', 'Lassic', '06835221127', 'WUUUUcasocsdasic','ppppppppasswo44rd4' ,0,1.1);
INSERT INTO KORISNIK(AKTIVAN, DATUM_RODJENJA, EMAIL, IME,PREZIME ,TELEFON, KORISNICKO_IME, LOZINKA, ULOGA,PROSECNA_OCENA)
values (false, '2000-06-11 19:00:00.000000', 'kaca@gmail.com' , 'Kaca', 'Veljkovic', '068333555', 'kacamaca','02051998k' ,0,1.1);
INSERT INTO KORISNIK(AKTIVAN, DATUM_RODJENJA, EMAIL, IME,PREZIME ,TELEFON, KORISNICKO_IME, LOZINKA, ULOGA,PROSECNA_OCENA)
values (false, '2000-06-13 19:00:00.000000', 'icko2298@gmail.com' , 'Ilija', 'Cvektovic', '06835311221127', 'icko2298','ppppppppasswo44rd4' ,0,1.1);
INSERT INTO KORISNIK(AKTIVAN, DATUM_RODJENJA, EMAIL, IME,PREZIME ,TELEFON, KORISNICKO_IME, LOZINKA, ULOGA,PROSECNA_OCENA)
values (false, '2000-06-12 19:00:00.000000', 'yakzzfzi2@gmail.com' , 'Yadddidsav', 'Lasdsic', '0683311335221127', 'WUUUUcassocsdasic','ppppppppasswo44rd4' ,0,1.1);
