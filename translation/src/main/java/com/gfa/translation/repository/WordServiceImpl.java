package com.gfa.translation.repository;

import com.gfa.translation.model.Word;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WordServiceImpl implements WordService {

    private WordRepository repo;

    @Autowired
    public WordServiceImpl (WordRepository repo){
        this.repo = repo;
    }

    @Override
    public Word getWordById(long id) {
        return repo.findById(id).get();
    }

    @Override
    public void addWord(Word word) {
        repo.save(word);
    }

    @Override
    public Word getWordByHungarian(String hun) {
        return repo.findWordByHungarian(hun);
    }

    @Override
    public Word getWordByCzech(String cz) {
        return repo.findWordByCzech(cz);
    }

    @Override
    public String[] splitInputText(String inputText) {
        inputText = inputText.toLowerCase();
        String[] words = inputText.split("\\s");
        return words;
    }

    @Override
    public List<Word> wordListFromInputTextHun(String[] words) {

        List<Word>wordsAsList = new ArrayList<>();

        if (words.length>0) {
            for (String word : words) {
                if (repo.findWordByHungarian(word) != null) {
                    wordsAsList.add(repo.findWordByHungarian(word));
                } else {
                    repo.save(new Word(word, word));
                    wordsAsList.add(repo.findWordByHungarian(word));
                }
            }
            return wordsAsList;
        } else {
            return null;
        }

    }

    @Override
    public List<Word> wordListFromInputTextCz(String[] words) {
        List<Word>wordsAsList = new ArrayList<>();

        if (words.length>0) {
            for (String word : words) {
                if (repo.findWordByCzech(word) != null) {
                    wordsAsList.add(repo.findWordByCzech(word));
                } else {
                    repo.save(new Word(word, word));
                    wordsAsList.add(repo.findWordByCzech(word));
                }
            }
            return wordsAsList;
        } else {
            return null;
        }
    }
}
