## Przychodnia - aplikacja desktopowa usprawniająca pracę kliniki

#### Opis ogólny
Aplikacja ma na celu usprawnienie pracy małej kliniki medycznej. Aplikacja umożliwia przechowywanie danych o wizytach pacjentów, dane osobowe pacjentów i lekarzy, a także informacje o chorobach i medykamentach.

#### Wykorzystane technologie
Aplikacja została napisana w całości w języku Java z wykorzystaniem bazy danych Firebird.

#### Cel powstania aplikacji
Aplikacja została napisana w roku 2016 na zaliczenie przedmiotu. Celem było przećwiczenie umiejętności implementacji bazy danych wraz z wykonaniem interfejsu graficznego i wygenerowaniem raportów.

#### Kompletność aplikacji
Wszystkie założenia projektowe zostały osiągnięte, funkcjonalności zaimplementowane, a aplikacja została wygenerowana do pliku wykonywalnego. Aby używać aplikacji konieczne było utworzenie bazy danych na środowisku docelowym.

#### Zaimplementowane funkcjonalności:

-  Wizyty
	- Dodawanie nowej wizyty
	- Wyszukiwanie wizyty (archiwum)
	- Drukowanie podsumowania wizyty
	- Drukowanie recepty
-  Pacjenci
	- Dodawanie nowego pacjenta
	- Wyszukiwanie pacjenta
	- Usuwanie pacjenta z bazy
	- Edytowanie danych pacjenta
-  Lekarze
	- Wyszukiwanie lekarza
	- Dodawanie nowego lekarza
	- Usuwanie lekarza z bazy
	- Edytowanie danych lekarza
-  Katalog jednostek chorobowych
	- Wyszukiwanie jednostek chorobowych
-  Katalog lekarstw
	- Wyszukiwanie lekarstw
	- Drukowanie ulotki lekarstwach
-  Raporty
	- Generowanie raportów
		- Spis lekarstw zapisywanych przez lekarzy (z określeniem daty od i do)
		- Spis lekarstw leczących dane jednostki chorobowe
		- Ilość wizyt obsługiwanych przez każdego lekarza
-  Funkcje dodatkowe
	- Dodawanie nowej jednostki chorobowej
	- Dodawanie nowego lekarstwa


#### Wygląd wybranych widoków GUI
* Menu

![Main Page View](/images/menu.png)

* Pacjenci

![patients 1](/images/pacjenci1.png)

* Dodawanie pacjenta

![patients 2](/images/pacjenci2.png)

* Wizyta
 
![visit](/images/wizyta.png)

* Katalog lekarstw

![medicines catalog](/images/katalog_lekarstw.png)

* Archiwum wizyt

![visits archives](/images/archiwum.png)

* Generowanie raportów

![generate raports](/images/raporty.png)

* Wygenerowana recepta

![prescription](/images/recepta.png)

* Wygenerowane podsumowanie wizyty

![recap](/images/podsumowanie_wizyty.png)


## Baza danych

#### Model UML

![uml model](/images/model_UML.png) 

#### Kod SQL
Kod SQL bazy został załączony w pliku 'clinic_database_sql.sql'





