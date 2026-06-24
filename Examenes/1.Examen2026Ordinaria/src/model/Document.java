package model;

import java.io.IOException;
import java.nio.file.Paths;
import static java.nio.file.Files.readAllBytes;
import static java.nio.charset.StandardCharsets.UTF_8;

public class Document {

    private String content;

    public static Document fromFile(String fileName) throws IOException {
        byte[] bytes = readAllBytes(Paths.get(fileName));
        return new Document(new String(bytes, UTF_8));
    }

    public Document() {
        this("");
    }

    public Document(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}