package com.epam.parsing.entity;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TextLeaf textLeaf = (TextLeaf) o;

        return value == textLeaf.value;
    }

    @Override
    public int hashCode() {
        return (int) value;
    }
}
