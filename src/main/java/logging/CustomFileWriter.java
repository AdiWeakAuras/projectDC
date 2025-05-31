package logging;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CustomFileWriter {
    private File file;
    private FileWriter writer;

    public CustomFileWriter(String filePath) throws IOException {
        file = new File(filePath);
        writer = new FileWriter(file);
    }

    public void write(String content) throws IOException {
        writer.write(content);
    }

    public void close() throws IOException {
        writer.close();
    }
}
