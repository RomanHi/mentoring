package messenger;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @author Roman_Khairullin
 */
public class FileOutput implements Output {
    public static final ClassLoader CLASS_LOADER = Messenger.class.getClassLoader();


    private final String outputFileName;

    public FileOutput(String outputFileName) {
        this.outputFileName = outputFileName;
    }

    @Override
    public void output(String message) {
        try (FileWriter fileWriter = new FileWriter(CLASS_LOADER.getResource(outputFileName).getFile())) {
            fileWriter.write(message);
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
