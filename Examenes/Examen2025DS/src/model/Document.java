package model;

import java.util.*;

public class Document {

    private String title;
    private String content;
    private List<Line> lines;

    public Document(String title, String content) {
        this.title = title;
        this.content = content;

        lines = new ArrayList<>();
        for (var line : content.split("\n"))
            lines.add(new Line(line));
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }
}
