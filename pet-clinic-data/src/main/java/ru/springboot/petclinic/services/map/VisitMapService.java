package ru.springboot.petclinic.services.map;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import ru.springboot.petclinic.model.Visit;
import ru.springboot.petclinic.services.VisitService;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Profile({"default", "map"})
public class VisitMapService extends AbstractMapService<Visit, Long> implements VisitService {

    @Override
    public Set<Visit> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Visit object) {
        super.delete(object);
    }

    @Override
    public Visit save(Visit visit) {
        if (visit.getPet() == null ||
                visit.getPet().getId()==null ||
                visit.getPet().getOwner() == null ||
                visit.getPet().getOwner().getId() == null) {
            throw new RuntimeException("Invalid visit");
        }
        return super.save(visit);
    }

    @Override
    public Visit findById(Long id) {
        return super.findById(id);
    }

    @Override
    public List<Visit> findByPetId(Long petId) {
        List<Visit> v = null;
        try{
            v = this.findAll().stream()
                    .filter(visit -> visit.getPet().getId().equals(petId))
                    .collect(Collectors.toList());
        }
        catch (NullPointerException e){
            throw new NullPointerException("visit not found");
        }
        return v;
    }
}
