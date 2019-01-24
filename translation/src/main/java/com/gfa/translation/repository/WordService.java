package com.gfa.translation.repository;

import com.gfa.translation.controller.WordDto;
import com.gfa.translation.model.Word;

import java.util.ArrayList;
import java.util.List;

public interface WordService {

    String[] splitInputText(String inputText);

    Word createWordFromString(String inputWord);

    Word createWordFromWordDto(WordDto dto);

    WordDto createWordDtoFromWord(Word word);

    Word getWordByHungarian(String hun);

    Word getWordByCzech(String cz);

    Word getWordById(long id);

    void incrementHitCount(long id);

    void addWord(Word word);

    List<Word> wordListFromInputTextHun(String[] words);

    List<Word> wordListFromInputTextCz(String[] words);


}
