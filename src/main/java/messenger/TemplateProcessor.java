package messenger;

import java.util.Map;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;

/**
 * @author Roman_Khairullin
 */
public class TemplateProcessor {
    public static final String TEMPLATE_PATTERN = "\\#\\{.+?\\}";
    public static final int PATTERN_START_OFFSET = 2;
    public static final int PATTERN_END_OFFSET = 1;


    public String processTemplate(Map<String, String> inputData, String template) {
        return Pattern.compile(TEMPLATE_PATTERN)
                .matcher(template)
                .replaceAll(matchResult -> replaceMatch(inputData, template, matchResult));
    }

    private String replaceMatch(Map<String, String> inputData, String line, MatchResult matchResult) {
        String replacement = line.substring(matchResult.start() + PATTERN_START_OFFSET, matchResult.end() - PATTERN_END_OFFSET);
        if (!inputData.containsKey(replacement)) {
            throw new IllegalArgumentException("Parameter " + replacement + " should be initialized");
        }
        return inputData.get(replacement);
    }
}
