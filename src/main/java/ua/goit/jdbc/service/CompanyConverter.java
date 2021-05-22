package ua.goit.jdbc.service;

import ua.goit.jdbc.dao.model.CompanyDAO;
import ua.goit.jdbc.dto.CompanyDTO;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CompanyConverter {

    public static CompanyDAO toDAO(CompanyDTO companyDTO) {
        return new CompanyDAO(companyDTO.getId(), companyDTO.getCompanyName(), companyDTO.getHeadquarters());
    }

    public static CompanyDTO fromDAO(CompanyDAO companyDAO) {
        return new CompanyDTO(companyDAO.getId(), companyDAO.getCompanyName(), companyDAO.getHeadquarters());
    }

    public static CompanyDTO fromDAO(ResultSet resultSet) throws SQLException {
        CompanyDTO companyDAO = new CompanyDTO();
        while (resultSet.next()) {
            companyDAO.setId(resultSet.getInt("company_id"));
            companyDAO.setCompanyName(resultSet.getString("company_name"));
            companyDAO.setHeadquarters(resultSet.getString("headquarters"));
        }
        return companyDAO;
    }

    public static CompanyDAO toDAO(ResultSet resultSet) throws SQLException {
        CompanyDAO companyDAO = null;
        while (resultSet.next()) {
            companyDAO = new CompanyDAO();
            companyDAO.setId(resultSet.getInt("company_id"));
            companyDAO.setCompanyName(resultSet.getString("company_name"));
            companyDAO.setHeadquarters(resultSet.getString("headquarters"));
        }
        return companyDAO;
    }

}
