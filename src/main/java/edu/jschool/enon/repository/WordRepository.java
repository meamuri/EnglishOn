package edu.jschool.enon.repository;

import edu.jschool.enon.entity.Word;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WordRepository extends CrudRepository<Word, Long> {

    Word findBySpelling(String spelling);

    @Query("SELECT w FROM Word w WHERE w.Spelling = ?1")
    Word findBySpellingHql(String spelling);
}
