package edu.jschool.enon.data.dto;

public class OnlySpellingCreateWordDto {
    private String spelling;

    public OnlySpellingCreateWordDto (){}
    public OnlySpellingCreateWordDto (String spelling){
        this.spelling = spelling;
    }

    public String getSpelling() {
        return spelling;
    }

    public void setSpelling(String spelling) {
        this.spelling = spelling;
    }


}
