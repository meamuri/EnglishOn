package edu.jschool.enon.component;


import java.io.IOException;

public interface Translator {
    public String translate(String word, String lang) throws IOException;
    public String translateEnToRu(String word) throws IOException;
}
