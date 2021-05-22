package ua.goit.jdbc.dao;

import ua.goit.jdbc.config.DatabaseConnectionManager;
import ua.goit.jdbc.dao.model.SkillDAO;
import ua.goit.jdbc.service.SkillConverter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SkillRepository implements Repository<SkillDAO> {
    private final DatabaseConnectionManager connectionManager;

    public SkillRepository(DatabaseConnectionManager connectionManager) {
        this.connectionManager = connectionManager;
    }

    @Override
    public SkillDAO findById(Integer id) {
        String findById = "SELECT skill_id, branch, skill_level " +
                "FROM skills WHERE skill_id = ?;";
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(findById)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            return SkillConverter.toDAO(resultSet);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public SkillDAO create(SkillDAO skillDAO) {
        String insert = "INSERT INTO skills (branch, level) " +
                "VALUES (?, ?);";
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(insert)) {
            statement.setString(1, skillDAO.getBranch().getName());
            statement.setString(2, skillDAO.getLevel().getName());
            ResultSet resultSet = statement.executeQuery();
            return SkillConverter.toDAO(resultSet);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;

    }

    @Override
    public void update(SkillDAO skillDAO) {
        String update = "UPDATE skills SET branch=?, skill_level=?, " +
                "WHERE skill_id=?;";
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(update)) {
            statement.setString(1, skillDAO.getBranch().getName());
            statement.setString(2, skillDAO.getLevel().getName());
            statement.setInt(3, skillDAO.getId());
            statement.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) {
        String delete = "DELETE FROM skills WHERE skill_id=?;";
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(delete)) {
            statement.setInt(1, id);
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Integer getLastId() {
        String FIND_LAST_ID = "SELECT max(skill_id) FROM skills;";
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
