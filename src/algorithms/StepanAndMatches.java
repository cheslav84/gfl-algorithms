package algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class StepanAndMatches {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int numberOfSets = getNumberOfSets(reader);
        List<List<Integer>> matchesSets = getMatchesSets(reader, numberOfSets);

        checkSets(matchesSets);

    }

    private static void checkSets(List<List<Integer>> matchesSets) {
        for (List<Integer> matchesSet : matchesSets) {
            int sum = matchesSet.stream()
                    .mapToInt(Integer::intValue)
                    .sum();
            System.out.println((sum % 4 == 0) ? "yes" : "no");
        }
    }

    private static List<List<Integer>> getMatchesSets(BufferedReader reader, int numberOfSets) throws IOException {
        List<List<Integer>> matchesSets = new ArrayList<>();
        for (int i = 0; i < numberOfSets; i++) {
            List<Integer> matchesSet = getSet(reader);
            matchesSets.add(matchesSet);
        }
        return matchesSets;
    }

//    private static boolean isParallelepiped(List<Integer> matchesSet ) {
//        Collections.sort(matchesSet);
//        for (int i = 0; i < matchesSet.size(); i += 4) {
//            if (matchesSet.get(i) != matchesSet.get(i + 3)) {
//                return false;
//            }
//        }
//        return true;
//    }

    private static List<Integer> getSet(BufferedReader reader) throws IOException {
        String[] input = reader.readLine().split(" ");
        List<Integer> matches = new ArrayList<>();
        for (String s : input) {
            matches.add(Integer.valueOf(s));
        }
        return matches;
    }

    private static int getNumberOfSets(BufferedReader reader) throws IOException {
        String input = reader.readLine();
        return Integer.parseInt(input.strip());
    }
}
