package com.begin.chapter4.PropertyEditor.PropertyEditorSupport;

import java.beans.PropertyEditorSupport;

public class Support extends PropertyEditorSupport {

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        String[] name = text.split("\\s");
        setValue(new User(name[0], name[1]));
    }
}
