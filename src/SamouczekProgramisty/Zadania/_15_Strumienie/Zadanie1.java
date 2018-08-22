package SamouczekProgramisty.Zadania._15_Strumienie;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Zadanie1 {

    private int zmienna;

    public Zadanie1(int zmienna) {
        this.zmienna = zmienna;
    }

    public static void main(String[] args) {

        double highestRanking = 0;
        BoardGame bestGame = null;
        for (BoardGame game : BoardGame.GAMES) {
            if (game.name.contains("a")) {
                if (game.rating > highestRanking) {
                    highestRanking = game.rating;
                    bestGame = game;
                }
            }
        }
        System.out.println(bestGame.name);

        //


        BoardGame najlepszaGra =  BoardGame.GAMES.stream()
                .filter(x -> x.name.contains("a"))
                .max(Comparator.comparingDouble(x -> x.rating)).get();
        System.out.println("najlepsza gra: "+ najlepszaGra.name);


        List<Zadanie1> testList = Arrays.asList(new Zadanie1(70), new Zadanie1(20), new Zadanie1(90));

        Zadanie1 numbersStream = testList.stream()
                .max(Comparator.comparingInt(x -> x.zmienna)).get();

        //to działa
        //metoda .max na strumieniu przyjmuje Comparator na ktorym wywoluje metode
        // statyczna comparingInt ktora przyjmuje interface funkcyjny ToIntFunction<T>
        // z meotda int applyAsInt(T value)

        testList.stream()
                .max(Comparator.comparingInt(x ->x.zmienna)).get();




        //Stream<Zadanie1> numbersStream2 = testList.stream()
        //        .max(Comparator.comparingInt(x -> x.zmienna)).get();
        //to nie dziala


        System.out.println("Porownanie: ");
        Comparator<Integer> porownanie = (x,y) -> x-y;
        System.out.println(porownanie.compare(20,8));

        Comparator.comparingDouble(x -> 10);






    }
}


class BoardGame {

    public final String name;
    public final double rating;
    public final BigDecimal price;
    public final int minPlayers;
    public final int maxPlayers;

    public BoardGame(String name, double rating, BigDecimal price, int minPlayers, int maxPlayers) {
        this.name = name;
        this.rating = rating;
        this.price = price;
        this.minPlayers = minPlayers;
        this.maxPlayers = maxPlayers;
    }
    public static final List<BoardGame> GAMES = Arrays.asList(
            new BoardGame("Terraforming Mars", 8.38, new BigDecimal("123.49"), 1, 5),
            new BoardGame("Codenames", 7.82, new BigDecimal("64.95"), 2, 8),
            new BoardGame("Puerto Rico", 8.07, new BigDecimal("149.99"), 2, 5),
            new BoardGame("Terra Mystica", 8.26, new BigDecimal("252.99"), 2, 5),
            new BoardGame("Scythe", 8.3, new BigDecimal("314.95"), 1, 5),
            new BoardGame("Power Grid", 7.92, new BigDecimal("145"), 2, 6),
            new BoardGame("7 Wonders Duel", 8.15, new BigDecimal("109.95"), 2, 2),
            new BoardGame("Dominion: Intrigue", 7.77, new BigDecimal("159.95"), 2, 4),
            new BoardGame("Patchwork", 7.77, new BigDecimal("75"), 2, 2),
            new BoardGame("The Castles of Burgundy", 8.12, new BigDecimal("129.95"), 2, 4)
    );

}