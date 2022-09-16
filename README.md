# AutSoftJavaInterview

## A feladat leírása
A feladat egy egyszerű blogmotort megvalósító, Spring Boot alapokra épülő backend elkészítése.

A blog bejegyezéseket tárol az adatbázisban, melyek kategóriákba rendezhetők. A bejegyzések egy
címből, egy hosszabb szöveges tartalmi részből, a hozzáadás időpontjából, illetve a legutolsó módosítás
időpontjából állnak. A kategóriák rendelkeznek egy egyedi névvel és egy szöveges címke listával.
Három karakternél rövidebb és tíz karakternél hosszabb címkék nem megengedettek. Egy bejegyzés
maximum 5 kategóriához rendelhető.

## A megvalósítás részletei

A fenti leírás szerinti kategóriákba rendezés még nem került megvalósításra, a többi funkció azonban igen. 

Az adatokat H2 adatbázisban, memóriában tárolom, indításkor az src/main/resources/data.sql fileban leírtak szerint inicializálódnak a táblák. Az adatbázis a http://localhost:8080 címen érhető el. A webes konzolra való bejelentkezéshez url: jdbc:h2:mem:blogdb, felhasználónév: sa, jelszó: . 

A bejegyzések és kategóriák összekapcsolásához szükséges táblát létrehoztam, de a funkcionalitás még nem került megvaósításra.

A leírt technológiai követelményeknek az alkalmazás megfelel.

Java SDK: 17.

### Megvalósult végpontok
#### Get
- /entries : Lekéri az összes bejegyzést
- /entry/title={title} : Lekér egy konkrét bejegyzést cím szerint
- /entry/id={id} : Lekér egy konkrét bejegyzést azonosító szerint

- /categories : Lekéri az összes kategóriát
- /category/name={name} : Lekér egy konkrét kategóriát név szerint
- /category/id={id} : Lekér egy konkrét kategóriát azonosító szerint

#### Post
- /entry : Ha megadunk egy, az adatbázisban már létező id-t akkor azt a bejegyzést frissíti, egyébként létrehoz egy új bejegyzést.
- /category : Ha megadunk egy, az adatbázisban már létező id-t akkor azt a kategóriát frissíti, egyébként létrehoz egy új kategóriát.

#### Delete
- /entry/{title} : Törli az adott című bejegyzést
- /category/{name} : Törli az adott című kategóriát
