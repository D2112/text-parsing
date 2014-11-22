package com.epam.parsing.entity;

public enum TextType {
    PARAGRAPH, SENTENCE, SENTENCE_ELEMENT, SYMBOL;

    public TextType next() {
        return (this.ordinal() < TextType.values().length - 1)
                ? TextType.values()[this.ordinal() + 1]
                : null;
    }
}
