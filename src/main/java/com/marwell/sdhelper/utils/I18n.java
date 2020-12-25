package com.marwell.sdhelper.utils;

import java.util.Locale;
import java.util.ResourceBundle;

public class I18n {

    ResourceBundle bundle = ResourceBundle.getBundle("TxtBundle", Locale.getDefault());

    public String getWord(String word) {
        return bundle.getString(word);
    }
}
