package com.trainingapps.stockapp.reportms.repository;

import com.trainingapps.stockapp.reportms.entity.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

/**
 * Author: Devesh Yadav
 * Repository interface
 */
@Repository
public interface IReportRepository extends JpaRepository<Report, Long> {

    @Query("from Report where startPeriod=:startDate and endPeriod=:endDate")
    List<Report> findReportInPeriod(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);

}
