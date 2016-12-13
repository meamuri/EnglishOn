package edu.jschool.enon.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class Word {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String spelling;
    private String valueInLanguage;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSpelling() {
        return spelling;
    }

    public void setSpelling(String spelling) {
        this.spelling = spelling;
    }

    public String getValueInLanguage() {
        return valueInLanguage;
    }

    public void setValueInLanguage(String valueInLanguage) {
        this.valueInLanguage = valueInLanguage;
    }
}
