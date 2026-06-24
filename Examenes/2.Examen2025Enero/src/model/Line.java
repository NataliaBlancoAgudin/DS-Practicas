package model;

import java.util.Collections;
import java.util.List;

public class Line {

    private String content;
    private List<String> words;

    public Line(String content) {
        this.content = content.trim();
        words = List.of(content.split(" "));
    }

    public String getContent() {
        return content;
    }

    public List<String> getWords() {
        return Collections.unmodifiableList(words);
    }

    public String getWord(int index) {
        return words.get(index);
    }

    /**
     * Counts the number of words in the line.
     *
     * Example: "Have   a  nice day!" -> 4
     */
    public int numberOfWords() {
        return words.size();
    }

    /**
     * Number of characters in the line (without counting spaces).
     *
     * Example: "Have   a  nice day!" -> 13
     */
    public int numberOfCharacters() {
        return getWords().stream().mapToInt(String::length).sum();
    }

    /**
     * Number of gaps between words (no matter how many spaces are in each one).
     *
     * Example: "Have   a  nice day!" -> 3
     */
    public int numberOfGaps() {
        return numberOfWords() - 1;
    }

    /**
     * Computes the width of the line if all words are separated by a single
     * space.
     *
     * Example: "Have   a  nice day!" -> 16
     */
    public int minimumWidth() {
        return numberOfCharacters() + numberOfGaps();
    }
}
