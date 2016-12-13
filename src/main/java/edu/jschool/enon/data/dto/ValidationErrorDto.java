package edu.jschool.enon.data.dto;

public class ValidationErrorDto {
    private String fieldName;
    private String message;

    public ValidationErrorDto(){}
    public ValidationErrorDto(String fieldName, String msg){
        this.fieldName = fieldName;
        this.message = msg;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName){
        this.fieldName = fieldName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
