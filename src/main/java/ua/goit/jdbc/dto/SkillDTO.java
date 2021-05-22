package ua.goit.jdbc.dto;

import ua.goit.jdbc.dao.model.en.Branch;
import ua.goit.jdbc.dao.model.en.SkillLevel;


public class SkillDTO {
    private Integer id;
    private Branch branch;
    private SkillLevel level;

    public SkillDTO() {
    }

    public SkillDTO(Integer id, Branch branch, SkillLevel level) {
        this.id = id;
        this.branch = branch;
        this.level = level;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    public SkillLevel getLevel() {
        return level;
    }

    public void setLevel(SkillLevel level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "SkillDTO{" +
                "id=" + id +
                ", branch=" + branch +
                ", level=" + level +
                '}';
    }
}
