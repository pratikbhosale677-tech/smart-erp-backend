package com.pratik.smart_erp.dashboard.dto;

public class DashboardDTO {

    private long totalCompanies;
    private long totalEmployees;
    private long activeCompanies;

    public long getTotalCompanies() {
        return totalCompanies;
    }

    public void setTotalCompanies(long totalCompanies) {
        this.totalCompanies = totalCompanies;
    }

    public long getTotalEmployees() {
        return totalEmployees;
    }

    public void setTotalEmployees(long totalEmployees) {
        this.totalEmployees = totalEmployees;
    }

    public long getActiveCompanies() {
        return activeCompanies;
    }

    public void setActiveCompanies(long activeCompanies) {
        this.activeCompanies = activeCompanies;
    }
}