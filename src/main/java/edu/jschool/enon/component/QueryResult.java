package edu.jschool.enon.component;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Arrays;

@JsonIgnoreProperties(ignoreUnknown = true)
public class QueryResult {
    private Long code;

    private String lang;

    private String[] text;

    public QueryResult() { }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }


    public String[] getText() {
        return text;
    }

    public void setText(String[] text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "QueryResult{" +
                "code=" + code +
                ", lang='" + lang + '\'' +
                ", text=" + Arrays.toString(text) +
                '}';
    }
}
