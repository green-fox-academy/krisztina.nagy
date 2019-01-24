package com.gfa.translation.repository;

import com.gfa.translation.model.Word;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WordRepository extends CrudRepository <Word, Long> {

    Word findWordByHungarian(String hun);
    Word findWordByCzech(String cz);

}
