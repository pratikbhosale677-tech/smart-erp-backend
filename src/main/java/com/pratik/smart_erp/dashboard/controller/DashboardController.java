package com.pratik.smart_erp.dashboard.controller;

import com.pratik.smart_erp.dashboard.dto.DashboardDTO;
import com.pratik.smart_erp.dashboard.service.DashboardService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import com.pratik.smart_erp.dashboard.dto.CompanyEmployeeReportDTO;

@RestController
@RequestMapping("/dashboard")
public class DashboardController {

    private final DashboardService dashboardService;

    public DashboardController(DashboardService dashboardService) {
        this.dashboardService = dashboardService;
    }

    @GetMapping("/stats")
    public DashboardDTO getStats() {
        return dashboardService.getDashboardStats();
    }
    @GetMapping("/company-report")
    public List<CompanyEmployeeReportDTO> getCompanyReport() {
        return dashboardService.getCompanyEmployeeReport();
    }
}