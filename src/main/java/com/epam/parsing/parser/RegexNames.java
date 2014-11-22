package com.epam.parsing.parser;

import com.epam.parsing.entity.TextType;

public class RegexNames {
    public static final String REGEX_FILE_BASE_NAME = "regex";

    public static String getRegexNameForTextType(TextType type) {
        return type.name().toLowerCase();
    }
}
