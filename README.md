# projekteszkozok

Lacinak:

Petőfi Sándor: SZERELEMNEK RÓZSÁKKAL...<br />

	 	
Szerelemnek rózsákkal<br />
Hintett nyoszolyája!<br />
Megint lefektettem a<br />
Lelkemet reája.<br />
Szerelem rózsáiból<br />
Tövis-e vagy illat,<br />
Mely szívemig, életem<br />
Gyökeréig elhat?<br />
<br />
Akár tövis jut nekem,<br />
Akár az illatja,<br />
Mindegy! feküdj rá lelkem,<br />
S álmodozzál rajta;<br />
Álmodd meg azt a nagy szót,<br />
Amely nincsen még meg,<br />
Amely kifejezze majd:<br />
Milyen forrón érzek!<br />
<br />
Nagybánya, 1846. szeptember végén<br />
<br />
Komolyra fordítva a billentyűzetet egy kis help<br />

Egy rövid leírás a programról, webes alkalmazás melynek célja, hogy az ide regisztrált felh-k tudjanak meglepetéseket küldeni kedves ismerőseiknek blabla, még felsorolhatod milyen eszközöket használtunk (spring boot, vaadin 8, stb.)<br />
<br />
Entitások: com.backend.entities mappába', majd eclipse-ben valami kieggel csinálj uml-t (ObjectAid, jobb klikk project create other onjectaid..., aztán az entitiket ráhúzod) azt elég bedobni, plusz egykét részlet a tulajdonságairól (táblázatban)pl:<br />
            Morder:  név:customer, típus: Muser, tulajdonság: sok-egykapcsolat Muser-el<br />
                      név: surprise, típus Surprise, tulajdonság: egy-egy kapcsolat Surprise táblával<br />
                      ...<br />
            Muser: hasonlóan<br />
            Surprise: hasonlóan<br />
            <br />
 Tesztelés leírása, milyen tesztek vannak hol leírva kimenet bemenet stb.<br />
<br />
Felület: Majd Krisztől kérd el a mockup linket moderálás után, és azokat be tudod rakni felületi tervekhez<br />

<br />
Csinálhatsz még egy user-eseti diagram, vagy hogy hívták az ilyet a századfordulón, tudod, hogy (azárt nem kell ennyire részletesen)<br />
user -> belépés gomb -> belépési ablak -> be tud lépni<br />
      -> bewlépési ablak -> regisztráció -> regisztrációs ablak -> tud regisztrálni<br />
      főoldal gomb -> oldal információk megjelenítése<br />
      böngészés gomb -> termékek böngészése -> szűrés névre, színre, állagra, viszkozitásra<br />
      Rendelés gomb -> rendelés információk megadása(név, csomagopciók, csomag címzés, üzenet a címzettnek) -> Küldés gomb -> rendelés          végbemenetele<br />
      <br />
      
 Leírást a projektről, fejlesztőnek, ha akar bele fejleszteni mit kell tennie. letölti a repot githubról, valamilyen ide-ben fejleszt benne, maven clean install, aztán el is tudja indítani, valami ilyesmire gondolok.     
 asszem ennyi elég lesz     
