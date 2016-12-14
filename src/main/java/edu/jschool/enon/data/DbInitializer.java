package edu.jschool.enon.data;

import edu.jschool.enon.entity.Word;
import edu.jschool.enon.repository.WordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;

@Component
public class DbInitializer {

    @Autowired
    private WordRepository wordRepository;

    @PostConstruct
    @Transactional
    public void init(){
        Word word = new Word();
        word.setSpelling("Word");
        word.setValueInLanguage("Слово");
        wordRepository.save(word);

        Word word1 = new Word();
        word1.setSpelling("Meaning");
        word1.setValueInLanguage("Значение");
        wordRepository.save(word1);

        Word word2 = new Word();
        word2.setSpelling("Collection");
        word2.setValueInLanguage("Коллекция");
        wordRepository.save(word2);
    }
}