package ua.goit.jdbc.service;

import ua.goit.jdbc.dao.Repository;
import ua.goit.jdbc.dao.model.CompanyDAO;
import ua.goit.jdbc.dto.CompanyDTO;

import java.util.Objects;

public class CompanyService {
    private final Repository<CompanyDAO> repository;

    public CompanyService(Repository<CompanyDAO> repository) {
        this.repository = repository;
    }

    public CompanyDTO create(CompanyDTO entityDTO) {
        CompanyDAO companyDAO = CompanyConverter.toDAO(entityDTO);
        CompanyDAO created = repository.create(companyDAO);
        return CompanyConverter.fromDAO(created);
    }

    public CompanyDTO update(CompanyDTO companyDTO) {
        CompanyDAO companyDAO = CompanyConverter.toDAO(companyDTO);
        repository.update(companyDAO);
        CompanyDAO updated = repository.findById(companyDTO.getId());
        return CompanyConverter.fromDAO(updated);
    }

    public void delete(Integer id) {
        CompanyDAO byId = repository.findById(id);
        if (Objects.isNull(byId)) {
            System.out.println("There is no object with id=" + id);
        } else {
            repository.delete(id);
        }
    }
}
