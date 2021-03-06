package edu.jschool.enon.service;

import edu.jschool.enon.data.dto.CreateWordDto;
import edu.jschool.enon.entity.Word;
import edu.jschool.enon.repository.WordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static java.util.stream.StreamSupport.stream;

@Service
public class WordService {
    @Autowired
    private WordRepository wordRepository;

    @Transactional
    public List<Word> getAll(){
        return stream(wordRepository.findAll().spliterator(), false).collect(toList());
    }

    @Transactional
    public Word save(CreateWordDto word){
        Word theWord = new Word();
        theWord.setSpelling(word.getSpelling());
        theWord.setValueInLanguage(word.getValueInLanguage());

        theWord.setTrainingTimes(0L);
        theWord.setPositiveAnswers(0L);
        return wordRepository.save(theWord);
    }

    @Transactional
    public Word getOne(Long id){
        return wordRepository.findOne(id);
    }

    @Transactional
    public void delete(Long id){
        wordRepository.delete(id);
    }

    @Transactional
    public Word create(Word word){
        return wordRepository.save(word);
    }

    @Transactional
    public Word update(Long id, CreateWordDto word){
        Word savedWord = wordRepository.findOne(id);
        savedWord.setSpelling(word.getSpelling());
        savedWord.setValueInLanguage(word.getValueInLanguage());
//        savedWord.setTrainingTimes(0L);
//        savedWord.setPositiveAnswers(0L);
        return wordRepository.save(savedWord);
    }

    @Transactional
    public Word incTrainingCount(Long id, boolean isTrueAnswer){
        Word savedWord = wordRepository.findOne(id);
        if (isTrueAnswer)
            savedWord.incCountOfPositiveTrainings();
        else
            savedWord.incCountOfTrainings();
        return wordRepository.save(savedWord);
    }
}
