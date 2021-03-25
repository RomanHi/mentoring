package messenger;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * Represents the class that contains methods for running the app and selecting the processing application mode
 *
 * @author Olga Petrova
 */

public class Launcher {

    public static final int MIN_ARGUMENTS_NUMBER = 2;

    public static void main(String[] args) throws IOException, URISyntaxException {
        Messenger messenger;
        if (args.length < MIN_ARGUMENTS_NUMBER) {
            messenger = new Messenger(null, null, null, null);
        }  else {
            messenger = new Messenger(null, null, null, null);
        }
        messenger.processing();
    }

/* In case of file mode names of input and output files should be provided as program arguments.
 In case of less of two program arguments provided the program will be run in console mode. */

    public static void chooseOperationType(String[] args, Messenger messenger)
            throws IOException, URISyntaxException {
        if (args.length < MIN_ARGUMENTS_NUMBER) {
            messenger.processConsoleOperation();
        } else {
            messenger.processFileOperation(args[0], args[1]);
        }
    }
}