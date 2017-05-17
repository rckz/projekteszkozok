# projekteszkozok

Lacinak:

Petőfi Sándor: SZERELEMNEK RÓZSÁKKAL...

	 	
Szerelemnek rózsákkal
Hintett nyoszolyája!
Megint lefektettem a
Lelkemet reája.
Szerelem rózsáiból
Tövis-e vagy illat,
Mely szívemig, életem
Gyökeréig elhat?

Akár tövis jut nekem,
Akár az illatja,
Mindegy! feküdj rá lelkem,
S álmodozzál rajta;
Álmodd meg azt a nagy szót,
Amely nincsen még meg,
Amely kifejezze majd:
Milyen forrón érzek!

Nagybánya, 1846. szeptember végén

Komolyra fordítva a billentyűzetet egy kis help

Egy rövid leírás a programról, webes alkalmazás melynek célja, hogy az ide regisztrált felh-k tudjanak meglepetéseket küldeni kedves ismerőseiknek blabla, még felsorolhatod milyen eszközöket használtunk (spring boot, vaadin 8, stb.)

Entitások: com.backend.entities mappába', majd eclipse-ben valami kieggel csinálj uml-t (ObjectAid, jobb klikk project create other onjectaid..., aztán az entitiket ráhúzod) azt elég bedobni, plusz egykét részlet a tulajdonságairól (táblázatban)pl:
            Morder:  név:customer, típus: Muser, tulajdonság: sok-egykapcsolat Muser-el
                      név: surprise, típus Surprise, tulajdonság: egy-egy kapcsolat Surprise táblával
                      ...
            Muser: hasonlóan
            Surprise: hasonlóan
            
 Tesztelés leírása, milyen tesztek vannak hol leírva kimenet bemenet stb.

Felület: Majd Krisztől kérd el a mockup linket moderálás után, és azokat be tudod rakni felületi tervekhez

Csinálhatsz még egy user-eseti diagram, vagy hogy hívták az ilyet a századfordulón, tudod, hogy (azárt nem kell ennyire részletesen)
user -> belépés gomb -> belépési ablak -> be tud lépni
      -> bewlépési ablak -> regisztráció -> regisztrációs ablak -> tud regisztrálni
      főoldal gomb -> oldal információk megjelenítése
      böngészés gomb -> termékek böngészése -> szűrés névre, színre, állagra, viszkozitásra
      Rendelés gomb -> rendelés információk megadása(név, csomagopciók, csomag címzés, üzenet a címzettnek) -> Küldés gomb -> rendelés          végbemenetele
      
 asszem ennyi elég lesz     
