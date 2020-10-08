package ru.springboot.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.springboot.petclinic.model.Visit;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
