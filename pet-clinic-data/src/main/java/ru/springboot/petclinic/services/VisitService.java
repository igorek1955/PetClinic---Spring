package ru.springboot.petclinic.services;

import ru.springboot.petclinic.model.Visit;

import java.util.List;

public interface VisitService extends CrudService<Visit, Long>{
    List<Visit> findByPetId(Long petId);
}
