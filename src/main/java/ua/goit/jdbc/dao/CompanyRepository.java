package ua.goit.jdbc.dao;

import ua.goit.jdbc.config.DatabaseConnectionManager;
import ua.goit.jdbc.dao.model.CompanyDAO;
import ua.goit.jdbc.service.CompanyConverter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CompanyRepository implements Repository<CompanyDAO> {
    private final DatabaseConnectionManager connectionManager;

    public CompanyRepository(DatabaseConnectionManager connectionManager) {
        this.connectionManager = connectionManager;
    }

    @Override
    public CompanyDAO findById(Integer id) {
        String findByID = "SELECT company_id, company_name, headquarters " +
                "FROM companies WHERE company_id = ?;";
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(findByID)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            return CompanyConverter.toDAO(resultSet);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public CompanyDAO create(CompanyDAO companyDAO) {
        String insert = "INSERT INTO companies (company_id, company_name, headquarters) " +
                " VALUES (?, ?, ?);";
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(insert)) {
            companyDAO.setId(getLastId() + 1);
            statement.setInt(1, companyDAO.getId());
            statement.setString(2, companyDAO.getCompanyName());
            statement.setString(3, companyDAO.getHeadquarters());
            ResultSet resultSet = statement.executeQuery();
            return CompanyConverter.toDAO(resultSet);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public void update(CompanyDAO companyDAO) {
        String update = "UPDATE companies SET company_name=?, headquarters=? " +
                "WHERE company_id=?;";
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(update)) {
            statement.setString(1, companyDAO.getCompanyName());
            statement.setString(2, companyDAO.getHeadquarters());
            statement.setInt(3, companyDAO.getId());
            statement.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) {
        String delete = "DELETE FROM companies WHERE company_id=?;";
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(delete)) {
            statement.setInt(1, id);
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Integer getLastId() {
        String FIND_LAST_ID = "SELECT max(company_id) FROM companies;";
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_LAST_ID)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            int result = 0;
            while (resultSet.next()) {
                result = resultSet.getInt("max");
            }
            return result;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

}
