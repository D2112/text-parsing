package com.epam.parsing.entity;

import java.util.Set;

public class TextLeaf extends TextElement {
    private static final TextType LEAF_TYPE = TextType.SYMBOL;
    private char value;

    public TextLeaf(char value) {
        super(LEAF_TYPE);
        this.value = value;
    }

    @Override
    public String toText() {
        return String.valueOf(value);
    }
    @Override
    public boolean isNode() {
        return false;
    }
}
