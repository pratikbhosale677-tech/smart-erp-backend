package com.pratik.smart_erp.dashboard.service;

import com.pratik.smart_erp.dashboard.dto.CompanyEmployeeReportDTO;
import com.pratik.smart_erp.dashboard.dto.DashboardDTO;
import com.pratik.smart_erp.dashboard.service.DashboardService;
import com.pratik.smart_erp.company.repository.CompanyRepository;
import com.pratik.smart_erp.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DashboardServiceImpl implements DashboardService {

    private final CompanyRepository companyRepository;
    private final EmployeeRepository employeeRepository;

    public DashboardServiceImpl(CompanyRepository companyRepository,
                                EmployeeRepository employeeRepository) {
        this.companyRepository = companyRepository;
        this.employeeRepository = employeeRepository;
    }

    @Override
    public DashboardDTO getDashboardStats() {

        DashboardDTO dto = new DashboardDTO();

        dto.setTotalCompanies(companyRepository.count());
        dto.setTotalEmployees(employeeRepository.count());
        dto.setActiveCompanies(companyRepository.countByActiveTrue());

        return dto;
    }

    @Override
    public List<CompanyEmployeeReportDTO> getCompanyEmployeeReport() {
        return companyRepository.getCompanyEmployeeReport();
    }
}