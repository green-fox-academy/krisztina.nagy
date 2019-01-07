package com.greenfoxacademy.animalclub.repository;

import com.greenfoxacademy.animalclub.model.FoxTrick;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface FoxTrickRepository extends CrudRepository<FoxTrick, Long> {

}
