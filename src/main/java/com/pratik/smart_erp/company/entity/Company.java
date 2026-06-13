    package com.pratik.smart_erp.company.entity;

    import jakarta.persistence.*;
    import com.pratik.smart_erp.entity.Employee;
    import jakarta.persistence.OneToMany;
    import java.util.List;
    import com.fasterxml.jackson.annotation.JsonIgnore;

    @Entity
    @Table(name = "companies")
    public class Company {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @JsonIgnore
        @OneToMany(mappedBy = "company")
        private List<Employee> employees;

        private String companyCode;
        private String companyName;
        private String address;
        private String email;
        private String phone;
        private Boolean active = true;

        public Company() {
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getCompanyCode() {
            return companyCode;
        }

        public void setCompanyCode(String companyCode) {
            this.companyCode = companyCode;
        }

        public String getCompanyName() {
            return companyName;
        }

        public void setCompanyName(String companyName) {
            this.companyName = companyName;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public Boolean getActive() {
            return active;
        }

        public void setActive(Boolean active) {
            this.active = active;
        }

        public List<Employee> getEmployees() {
            return employees;
        }

        public void setEmployees(List<Employee> employees) {
            this.employees = employees;
        }
    }