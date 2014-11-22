package com.epam.parsing.entity;

import java.util.List;

public class TextNode extends TextElement {
    private List<TextElement> children;

    public TextNode(TextType type) {
        super(type);
    }

    public TextNode(TextType type, List<TextElement> elements) {
        super(type);
        children = elements;
    }

    public TextElement get(int index) {
        if(index < 0 || index > children.size()) return null;
        return children.get(index);
    }

    public boolean add(TextElement element) {
        if(!type.equals(element.getType())) return false;
        return children.add(element);
    }

    public boolean remove(int index) {
        if(index < 0 || index > children.size()) return false;
        children.remove(index);
        return true;
    }

    @Override
    public boolean isNode() {
        return true;
    }

    @Override
    public String toText() {
        StringBuilder sb = new StringBuilder();
        for(TextElement element : children) {
            sb.append(element.toText());
        }
        return sb.toString();
    }
}
