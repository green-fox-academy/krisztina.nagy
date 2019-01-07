package com.greenfoxacademy.animalclub.repository;

import com.greenfoxacademy.animalclub.model.Fox;
import com.greenfoxacademy.animalclub.model.FoxTrick;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoxRepository extends CrudRepository<Fox, Long> {

    Fox findFoxById(long Id);


}
