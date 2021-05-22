package ua.goit.jdbc.dto;

public class CompanyDTO {
    private Integer id;
    private String companyName;
    private String headquarters;

    public CompanyDTO() {
    }

    public CompanyDTO(Integer id, String companyName, String headquarters) {
        this.id = id;
        this.companyName = companyName;
        this.headquarters = headquarters;
    }

    public CompanyDTO(String companyName, String headquarters) {
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

    @Override
    public String toString() {
        return "CompanyDTO{" +
                "id=" + id +
                ", companyName='" + companyName + '\'' +
                ", headquarters='" + headquarters + '\'' +
                '}';
    }
}
