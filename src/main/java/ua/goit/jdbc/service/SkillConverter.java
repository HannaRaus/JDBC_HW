package ua.goit.jdbc.service;

import ua.goit.jdbc.dao.model.SkillDAO;
import ua.goit.jdbc.dto.SkillDTO;
import ua.goit.jdbc.dao.model.en.Branch;
import ua.goit.jdbc.dao.model.en.SkillLevel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SkillConverter {

    public static SkillDAO toDAO(SkillDTO skillDTO) {
        return new SkillDAO(skillDTO.getId(), skillDTO.getBranch(), skillDTO.getLevel());
    }

    public static SkillDTO fromDAO(SkillDAO skillDAO) {
        return new SkillDTO(skillDAO.getId(), skillDAO.getBranch(), skillDAO.getLevel());
    }

    public static SkillDTO fromDAO(ResultSet resultSet) throws SQLException {
        SkillDTO skillDAO = new SkillDTO();
        while (resultSet.next()) {
            skillDAO.setId(resultSet.getInt("skill_id"));
            skillDAO.setBranch(Branch.findByName(resultSet.getString("branch")));
            skillDAO.setLevel(SkillLevel.findByName(resultSet.getString("skill_level")));
        }
        return skillDAO;
    }

    public static SkillDAO toDAO(ResultSet resultSet) throws SQLException {
        SkillDAO skillDAO = new SkillDAO();
        while (resultSet.next()) {
            skillDAO.setId(resultSet.getInt("skill_id"));
            skillDAO.setBranch(Branch.findByName(resultSet.getString("branch")));
            skillDAO.setLevel(SkillLevel.findByName(resultSet.getString("skill_level")));
        }
        return skillDAO;
    }
}
