package com.belum.apitemplate.utils;

import ch.qos.logback.classic.PatternLayout;
import ch.qos.logback.classic.spi.ILoggingEvent;
import com.belum.apitemplate.constants.ValueConstants;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*
 * A Utility Class that masks sensitive data in the server logs.
 */
@Component
public class PatternMaskingLayout extends PatternLayout {
    private Pattern multilinePattern;
    private List<String> maskPatterns = new ArrayList<>();

    /**
     * Invoked for every entry in the XML.
     * @param maskPattern the regex pattern for masking
     */
    public void addMaskPattern(String maskPattern) {
        maskPatterns.add(maskPattern);
        multilinePattern = Pattern.compile(
                maskPatterns.stream().collect(Collectors.joining(ValueConstants.VALUE_PIPE)), Pattern.MULTILINE
        );
    }

    /**
     * Transforms a logging event into a <code>String</code>
     * @param event the logging event
     * @return the string
     */
    @Override
    public String doLayout(ILoggingEvent event) {
        return maskMessage(super.doLayout(event));
    }

    private String maskMessage(String message) {
        if (Objects.isNull(multilinePattern)) {
            return message;
        }

        StringBuilder sb = new StringBuilder(message);
        Matcher matcher = multilinePattern.matcher(sb);

        while (matcher.find()) {
            IntStream.rangeClosed(1, matcher.groupCount()).forEach(group -> {
                if (StringUtils.isNotBlank(matcher.group(group))) {
                    IntStream.range(matcher.start(group), matcher.end(group))
                             .forEach(i -> sb.setCharAt(i, ValueConstants.VALUE_MASK.charAt(0)));
                }
            });
        }
        return sb.toString();
    }
}
