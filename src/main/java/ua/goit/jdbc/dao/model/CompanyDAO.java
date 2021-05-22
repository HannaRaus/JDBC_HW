package ua.goit.jdbc.dao.model;

public class CompanyDAO {
    private Integer id;
    private String companyName;
    private String headquarters;

    public CompanyDAO() {
    }

    public CompanyDAO(Integer id, String companyName, String headquarters) {
        this.id = id;
        this.companyName = companyName;
        this.headquarters = headquarters;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getHeadquarters() {
        return headquarters;
    }

    public void setHeadquarters(String headquarters) {
        this.headquarters = headquarters;
    }

}
