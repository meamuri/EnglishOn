package edu.jschool.enon.data.dto;

public class CreateWordDto {
    private String spelling;
    private String valueInLanguage;

    public CreateWordDto(){}
    public CreateWordDto(String spelling, String valueInLanguage){
        this.spelling = spelling;
        this.valueInLanguage = valueInLanguage;
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
