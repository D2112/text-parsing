package com.epam.parsing.entity;

public abstract class TextElement {
    TextType type;

    protected TextElement(TextType type) {
        this.type = type;
    }

    public TextType getType() {
        return type;
    }

    public abstract String toText();
    public abstract boolean isNode();
}
