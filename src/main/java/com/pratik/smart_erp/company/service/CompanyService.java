package com.pratik.smart_erp.company.service;

import com.pratik.smart_erp.company.entity.Company;
import com.pratik.smart_erp.company.repository.CompanyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {

    private final CompanyRepository companyRepository;

    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public Company saveCompany(Company company) {
        return companyRepository.save(company);
    }

    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    public Company updateCompany(Long id, Company company) {

        Company existing = companyRepository
                .findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Company not found"));

        existing.setCompanyCode(company.getCompanyCode());
        existing.setCompanyName(company.getCompanyName());
        existing.setAddress(company.getAddress());
        existing.setEmail(company.getEmail());
        existing.setPhone(company.getPhone());
        existing.setActive(company.getActive());

        return companyRepository.save(existing);
    }

    public void deleteCompany(Long id) {

        companyRepository.deleteById(id);
    }
}