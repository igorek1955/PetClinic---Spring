package ru.springboot.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.springboot.petclinic.model.Speciality;

public interface SpecialityRepository extends CrudRepository<Speciality, Long> {
}
