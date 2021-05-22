package ua.goit.jdbc.service;

import ua.goit.jdbc.dao.Repository;
import ua.goit.jdbc.dao.model.SkillDAO;
import ua.goit.jdbc.dto.SkillDTO;

import java.util.Objects;


public class SkillService {
    private final Repository<SkillDAO> repository;

    public SkillService(Repository<SkillDAO> repository) {
        this.repository = repository;
    }

    public SkillDTO create(SkillDTO entityDTO) {
        SkillDAO skillDAO = SkillConverter.toDAO(entityDTO);
        SkillDAO created = repository.create(skillDAO);
        return SkillConverter.fromDAO(created);
    }

    public SkillDTO update(SkillDTO skillDTO) {
        SkillDAO skillDAO = SkillConverter.toDAO(skillDTO);
        repository.update(skillDAO);
        SkillDAO updated = repository.findById(skillDTO.getId());
        return SkillConverter.fromDAO(updated);
    }

    public void delete(Integer id) {
        SkillDAO skillDAO = repository.findById(id);
        if (Objects.isNull(skillDAO)) {
            System.out.println("There is no object with id=" + id);
        } else {
            repository.delete(id);
        }
    }

}
