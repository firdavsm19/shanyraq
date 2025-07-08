package com.Firdavs.shanyraq.announcement_service.repository;

import com.Firdavs.shanyraq.announcement_service.model.HousingRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface HousingRequestRepository  extends JpaRepository<HousingRequest, Long> {

    @Query("""
        SELECT r FROM HousingRequest r
        WHERE (:occupation IS NULL OR r.occupation = :occupation)
        AND (:monthlyIncome IS NULL OR r.monthlyIncome >= :monthlyIncome)
        AND (:hasPests IS NULL OR r.hasPets = :hasPests)
        AND (:isStudent IS NULL OR r.isStudent = :isStudent)
        AND (:isSmoker IS NULL OR r.isSmoker = :isSmoker)
        AND (:maxRent IS NULL OR r.maxMonthlyRent <= :maxRent)
        AND (:maxDeposit IS NULL OR r.maxDeposit <= :maxDeposit)
    """)
    Page<HousingRequest> searchRequests(
            @Param("occupation") String occupation,
            @Param("monthlyIncome") Integer monthlyIncome,
            @Param("hasPests") Boolean hasPests,
            @Param("isStudent") Boolean isStudent,
            @Param("isSmoker") Boolean isSmoker,
            @Param("maxRent") Integer maxRent,
            @Param("maxDeposit") Integer maxDeposit,
            Pageable pageable
    );
}
