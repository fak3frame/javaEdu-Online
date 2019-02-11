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








     */
}
