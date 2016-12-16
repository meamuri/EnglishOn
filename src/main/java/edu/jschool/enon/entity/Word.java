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

    private Long trainingTimes = 0L;

    private Long positiveAnswers = 0L;

    public Long getTrainingTimes() {
        return trainingTimes;
    }

    public void setTrainingTimes(Long trainingTimes) {
        this.trainingTimes = trainingTimes;
    }

    public Long getPositiveAnswers() {
        return positiveAnswers;
    }

    public void setPositiveAnswers(Long positiveAnswers) {
        this.positiveAnswers = positiveAnswers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Word word = (Word) o;

        if (id != null ? !id.equals(word.id) : word.id != null) return false;
        if (spelling != null ? !spelling.equals(word.spelling) : word.spelling != null) return false;
        if (valueInLanguage != null ? !valueInLanguage.equals(word.valueInLanguage) : word.valueInLanguage != null)
            return false;
        if (trainingTimes != null ? !trainingTimes.equals(word.trainingTimes) : word.trainingTimes != null)
            return false;
        return positiveAnswers != null ? positiveAnswers.equals(word.positiveAnswers) : word.positiveAnswers == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (spelling != null ? spelling.hashCode() : 0);
        result = 31 * result + (valueInLanguage != null ? valueInLanguage.hashCode() : 0);
        result = 31 * result + (trainingTimes != null ? trainingTimes.hashCode() : 0);
        result = 31 * result + (positiveAnswers != null ? positiveAnswers.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Word{" +
                "id=" + id +
                ", spelling='" + spelling + '\'' +
                ", valueInLanguage='" + valueInLanguage + '\'' +
                ", trainingTimes=" + trainingTimes +
                ", positiveAnswers=" + positiveAnswers +
                '}';
    }

    public void incCountOfPositiveTrainings(){
        trainingTimes += 1;
        positiveAnswers += 1;
    }
    public void incCountOfTrainings(){
        trainingTimes += 1;
    }
}
