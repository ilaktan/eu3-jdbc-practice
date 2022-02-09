package words;

import java.util.ArrayList;
import java.util.List;

public class SeparateWords {

    public List<String> extractLines(String input) {

        String escapedCharsRemoved = removeEscapedChars(input);
        String clearedAfterEndOfTextChar = removeAfterEndOfTextChar(escapedCharsRemoved);
        String [] linesSplitWithNewLine =  clearedAfterEndOfTextChar.split("&");

        List<String> lines = new ArrayList<>();

        for(String longLine : linesSplitWithNewLine) {
            List<String> linesUnder30Char = splitLinesWith30Char(longLine);
            lines.addAll(linesUnder30Char);
        }

        return lines;
    }

    private String removeAfterEndOfTextChar(String escapedCharsRemoved) {

        if(escapedCharsRemoved.contains("/")) {
            return escapedCharsRemoved.substring(0, escapedCharsRemoved.indexOf('/'));
        } else {
            return escapedCharsRemoved;
        }
    }

    private String removeEscapedChars(String input) {

        return input.replaceAll("\r|\n", "");
    }

    private List<String> splitLinesWith30Char(String longLine) {

        List<String> lines = new ArrayList<>();

        String [] words = longLine.split(" ");
        StringBuilder currentLine = new StringBuilder();
        for(String word: words) {
            if(currentLine.length() + word.length() >= 30) {
                lines.add(currentLine.toString());
                currentLine = new StringBuilder(word);
            } else {
                if(currentLine.length() == 0) {
                    currentLine.append(word);
                } else {
                    currentLine.append(" ").append(word);
                }
            }
        }
        lines.add(currentLine.toString());

        return lines;
    }
}



