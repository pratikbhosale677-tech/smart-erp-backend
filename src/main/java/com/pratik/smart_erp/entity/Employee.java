package com.pratik.smart_erp.entity;
import com.pratik.smart_erp.company.entity.Company;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;


@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String address;
    private String mobileNo;
    private Integer experience;
    private String qualification;
    public Long getId() {
        return id;


    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getaddress() {
        return address;
    }

    public void setaddress(String address) {
        this.address = address;
    }


    public String getmobileNo() {
        return mobileNo;
    }

    public void setmobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public Integer getexperience() {
        return experience;
    }

    public void setexperience(Integer    experience) {
        this.experience = experience;
    }

    public String getqualification() {
        return qualification;
    }

    public void setqualification(String qualification) {
        this.qualification = qualification;
    }
    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}