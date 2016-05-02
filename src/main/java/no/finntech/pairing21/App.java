package no.finntech.pairing21;

import java.util.OptionalInt;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.joining;

public class App {

    public static void main(String[] args) {
        if (args.length > 0) {
            OptionalInt numberOfGamesToPlay = runs(args[0]);
            numberOfGamesToPlay.ifPresent(numberOfGames -> {
                String result = IntStream.range(0, numberOfGames).mapToObj(gameNo -> {
                    Game g = new Game();
                    return g.play();
                }).collect(groupingBy(f -> f))
                  .entrySet()
                  .stream()
                  .map(e -> e.getKey() + " " + e.getValue().size())
                  .collect(joining("\n"));
                System.out.println(result);
            });

        } else {
            Game g = new Game();
            System.out.println(g.play());
        }
    }

    public static OptionalInt runs(String arg) {
        try {
            return OptionalInt.of(Integer.parseInt(arg));
        } catch (NumberFormatException nfe) {
            return OptionalInt.empty();
        }
    }
}
