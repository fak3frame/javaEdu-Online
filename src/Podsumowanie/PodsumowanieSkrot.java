package Podsumowanie;

public class PodsumowanieSkrot {

    /*

    zwróci wszystkie wiersze z tabeli track, dla których: unitprice jest mniejsze niż 1
 i znak % zawarty jest w kolumnie name oraz kolumna name kończy się na e

 SELECT *
 FROM track
 WHERE unitprice < 1
 AND name LIKE %e%%e ESCAPE 'e';


 zwróci wszystkie wiersze z tabeli invoice, które mają uzupełnioną kolumnę billingstate
 i nie są ze Stanów Zjednoczonych

 SELECT *
 FROM invoice
 WHERE billingstate IN NOT NULL
 AND country != 'USA';


 zwróci wszystkie wiersze z tabeli invoice, które dotyczą Polski, Czech albo Węgier dla
 których wartość faktury przekracza 10,

 SELECT *
 FROM invoice
 WHERE country IN('PL', 'CZ', 'HU')
 AND price > 10


 zwróci imiona pracowników z tabeli employee, które dotyczą pracowników urodzonych w latach 60.

 SELECT name
 FROM employee
 WHERE birthdate BETWEEN '1960-' AND '1970-';


zwróci dziesięć najdłuższych ścieżek (tabela track), weź pod
 uwagę tylko te, których kompozytor (kolumna composer) zawiera literę b,

 SELECT name
 FROM track
 WHERE composer LIKE '%b%'
 ORDER BY time DESC
 LIMIT 10


 zwróci pięć najtańszych ścieżek (tabela track) dłuższych niż minuta,

 SELECT name
 FROM track
 WHERE time > 60
 ORDER BY price
 LIMIT 5


 zwróci unikalną listę dwudziestu kompozytorów (artist) których ścieżki kosztują
 mniej niż 2$ posortowanych malejąco według identyfikatora gatunku
 (kolumna genreid) i rosnąco według rozmiaru (kolumna bytes),

 SELECT DISTINCT composer
 FROM artist
 WHERE price < 2
 ORDER BY genereid DESC, bytes
 LIMIT 20;


 zwróci dwie kolumny. Pierwsza z nich powinna zawierać ścieżki droższe niż 1$
 i poprawnych kompozytorów pod nazwą magic thingy. Druga powinna zawierać
 liczbę bajtów. Wynik powinien zawierać dziesięć wierszy i być posortowany
 rosnąco po liczbie bajtów

//SELECT name AS 'magic thingy', bytes
//FROM track
//WHERE unitpirce > 1 AND composer IS NOT NULL
//ORDER BY bytes
//LIMIT 10;

SELECT name AS 'magic thingy'
        ,bytes
    FROM track
   WHERE unitprice > 1
   UNION
  SELECT composer
        ,bytes
    FROM track
   WHERE composer IS NOT NULL
ORDER BY bytes ASC
   LIMIT 10;


 zwróci piątą stronę z fakturami (tabela invoice) zakładając, że na stronie
 znajduje się dziesięć faktur i sortowane są według identyfikatora (kolumna invoiceid).

SELECT *
FROM invoice
ORDER BY invoiceid
LIMIT 10 OFFSET 40


Liczbę wierszy w iloczynie kartezjańskim tabel track, invoice i invoiceline

SELECT COUNT(*)
FROM track, invoice, invoiceline


tytuł albumu (tabela album) i nazwę artysty (tabela artist) dla wszystkich nazw artystów
 zaczynających się od s,

SELECT album.title, artist.name
FROM album JOIN artist
ON album.artistid = artist.artistid
WHERE artist.name LIKE 's%'


identyfikator i nazwę list utworów, które są puste,

SELECT playlist.id, playlist.name
FROM playlist
WHERE playlist.name IS NULL


nazwy trzech najczęściej występujących gatunków muzycznych wraz z odpowiadającą
    im liczbą utworów posortowaną malejąco po liczbie utworów

SELECT genre.name COUNT (track.id)
FROM genre JOIN track
ON genre.tackid = tack.trackid
LIMIT 3
SORT BY track







     */
}
