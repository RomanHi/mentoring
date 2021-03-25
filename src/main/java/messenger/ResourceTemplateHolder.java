package messenger;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author Roman_Khairullin
 */
public class ResourceTemplateHolder implements TemplateHolder {
    public static final String TEMPLATE_FILE = "template.txt";
    public static final ClassLoader CLASS_LOADER = Messenger.class.getClassLoader();

    @Override
    public String getTemplate() {
        try {
            String template;
            Path path = Paths.get(Paths.get(CLASS_LOADER.getResource(TEMPLATE_FILE).toURI()).toString());
            template = new String(Files.readAllBytes(path), StandardCharsets.UTF_8);
            return template;
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
}
