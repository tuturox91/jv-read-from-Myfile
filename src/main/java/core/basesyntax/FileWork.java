package core.basesyntax;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;


public class FileWork {
    public static final String STRING_SPLITTER = "[ \\-\n\r!?_.,;:'`]";
    public String[] readFromFile(String fileName) {
        ArrayList<String> myList = new ArrayList<>();
        try {
            for (String word: Files.readString(Path.of(fileName)).toLowerCase().split(STRING_SPLITTER)) {
                if(word.matches("(w|W).*")) {
                    myList.add(word);
                }
            }
            if(myList.isEmpty()) {
                return new String[0];
            } else {
                String[] tempResult = myList.toArray(String[]::new);
                Arrays.sort(tempResult);
                return tempResult;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
