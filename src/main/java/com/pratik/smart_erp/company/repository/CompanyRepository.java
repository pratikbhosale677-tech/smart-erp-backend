package com.pratik.smart_erp.company.repository;

import com.pratik.smart_erp.company.entity.Company;
import com.pratik.smart_erp.dashboard.dto.CompanyEmployeeReportDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CompanyRepository extends JpaRepository<Company, Long> {

    long countByActiveTrue();

    @Query("""
           SELECT new com.pratik.smart_erp.dashboard.dto.CompanyEmployeeReportDTO(
               c.companyName,
               COUNT(e)
           )
           FROM Company c
           LEFT JOIN c.employees e
           GROUP BY c.companyName
           """)
    List<CompanyEmployeeReportDTO> getCompanyEmployeeReport();
}