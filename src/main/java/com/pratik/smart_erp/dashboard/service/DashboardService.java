package com.pratik.smart_erp.dashboard.service;

import com.pratik.smart_erp.dashboard.dto.DashboardDTO;
import com.pratik.smart_erp.dashboard.dto.CompanyEmployeeReportDTO;
import java.util.List;

public interface DashboardService {

    DashboardDTO getDashboardStats();

    List<CompanyEmployeeReportDTO> getCompanyEmployeeReport();
}