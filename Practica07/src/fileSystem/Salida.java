package fileSystem;

import java.io.IOException;

public interface Salida {
    void write(char c) throws IOException;
    void close() throws IOException;
}
