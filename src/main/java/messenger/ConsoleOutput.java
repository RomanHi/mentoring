package messenger;

/**
 * @author Roman_Khairullin
 */
public class ConsoleOutput implements Output {

    @Override
    public void output(String message) {
        System.out.println(message);
    }
}
