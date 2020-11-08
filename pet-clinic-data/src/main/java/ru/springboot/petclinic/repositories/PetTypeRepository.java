package ru.springboot.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.springboot.petclinic.model.PetType;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
