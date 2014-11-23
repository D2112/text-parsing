package com.epam.parsing.parser;

import com.epam.parsing.entity.TextElement;
import com.epam.parsing.entity.TextLeaf;
import com.epam.parsing.entity.TextNode;
import com.epam.parsing.entity.TextType;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextParser {
    private Locale currentLocale;
    private ResourceBundle regexBundles;

    public TextParser() {
        currentLocale = new Locale("en");
        regexBundles = ResourceBundle.getBundle(RegexNames.REGEX_FILE_BASE_NAME, currentLocale);
    }

    public List<TextElement> parse(String textToParse, TextType parsingType) {
        Matcher m = getMatcher(textToParse, parsingType);
        TextElement textElement;
        List<TextElement> elements = new ArrayList<>();
            while (m.find()) {
                if(parsingType.equals(TextType.SYMBOL)) {
                    textElement = new TextLeaf(m.group().charAt(0));
                } else {
                    textElement = new TextNode(parsingType, parse(m.group(), parsingType.next()));
                }
                elements.add(textElement);
            }
        return elements;
    }

    private Matcher getMatcher(String text, TextType type) {
        String regex = regexBundles.getString(RegexNames.getRegexNameForTextType(type));
        Pattern p = Pattern.compile(regex);
        return p.matcher(text);
    }
}
