package words;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SeparateWordsTest {

    @Test
    public void outputLineHasMax30Chars() {

        String input = "The quick brown fox jumped over the lazy dog & the end /";
        SeparateWords separateWords = new SeparateWords();
        List<String> outputLines = separateWords.extractLines(input);

        for(String outputLine : outputLines) {
            System.out.println(outputLine);
            assertTrue(outputLine.length() <= 30);
        }
    }

    @Test
    public void outputLinesAreExpectedOnes() {

        String input = "The quick brown fox jumped over the lazy dog & the end /";
        SeparateWords separateWords = new SeparateWords();
        List<String> outputLines = separateWords.extractLines(input);


        assertTrue( outputLines.size() == 3);
        assertEquals("The quick brown fox jumped", outputLines.get(0));
        assertEquals("over the lazy dog", outputLines.get(1));
        assertEquals("the end", outputLines.get(2));
    }


    @Test
    public void textAfterEndOfTextIgnored() {

        String input = "The quick brown/wewegwegweg";
        SeparateWords separateWords = new SeparateWords();
        List<String> outputLines = separateWords.extractLines(input);


        assertEquals(1, outputLines.size());
        assertEquals("The quick brown", outputLines.get(0));

    }

    @Test
    public void escapeCharsRemoved() {

        String input = "The quick \n\r";
        SeparateWords separateWords = new SeparateWords();
        List<String> outputLines = separateWords.extractLines(input);

        assertTrue( outputLines.size() == 1);
        assertEquals("The quick", outputLines.get(0));
    }
}



