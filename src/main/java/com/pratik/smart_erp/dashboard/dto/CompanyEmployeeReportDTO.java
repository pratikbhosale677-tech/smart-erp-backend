package com.pratik.smart_erp.dashboard.dto;

public class CompanyEmployeeReportDTO {

    private String companyName;
    private Long employeeCount;

    public CompanyEmployeeReportDTO(String companyName, Long employeeCount) {
        this.companyName = companyName;
        this.employeeCount = employeeCount;
    }

    public String getCompanyName() {
        return companyName;
    }

    public Long getEmployeeCount() {
        return employeeCount;
    }
}