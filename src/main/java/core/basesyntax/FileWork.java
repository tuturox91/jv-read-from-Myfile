package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileWork {
    private static final Pattern regexPattern = Pattern.compile("(?i)\\bw\\w+");

    public static String[] readFromFile(String fileName) {
        List<String> wordsList = new ArrayList<>();

        Path path = Paths.get(fileName);
        if (Files.exists(path)) {
            try {
                for (String strings : Files.readAllLines(path)) {
                    Matcher matcher = regexPattern.matcher(strings);
                    while (matcher.find()) {
                        wordsList.add(matcher.group().toLowerCase());
                    }
                }
                String[] words = wordsList.toArray(String[]::new);
                Arrays.sort(words);
                return words;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return new String[0];
    }
}
