package algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class FavoriteGame {
    private static Map<String, Integer> gamesAndTime = new HashMap<>();

    public static void main(String[] args) throws IOException {

        getGamesTime();

//        for (Map.Entry<String, Integer> gameAndTime  : gamesAndTime.entrySet()) {
//            System.out.println(gameAndTime.getKey() + ":" + gameAndTime.getValue());
//        }

        String favoriteGame = findFavoriteGame();
        System.out.println(favoriteGame);

    }

    private static String findFavoriteGame() {
        return Collections.max(gamesAndTime.entrySet(), Map.Entry.comparingByValue()).getKey();
    }


    private static void getGamesTime() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int totalGames = Integer.parseInt(reader.readLine());

        for (int i = 0; i < totalGames; i++) {
            String[] game = reader.readLine().split(" ");
            if (gameExists(game)) {
                sumGameTime(game);
            } else {
                addNewGame(game);
            }
        }
    }

    private static void addNewGame(String[] game) {
        int gameTime = Integer.parseInt(game[1]);
        gamesAndTime.put(game[0], gameTime);
    }

    private static void sumGameTime(String[] game) {
        int currentTime = gamesAndTime.get(game[0]);
        int additiveTime = Integer.parseInt(game[1]);
        gamesAndTime.put(game[0], currentTime + additiveTime);
    }

    private static boolean gameExists(String[] game) {
        return gamesAndTime.containsKey(game[0]);
    }
}
