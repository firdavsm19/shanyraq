package com.Firdavs.shanyraq.announcement_service.repository;

import com.Firdavs.shanyraq.announcement_service.model.HousingOffer;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import org.springframework.data.domain.Pageable;


@Repository
public interface HousingOfferRepository extends JpaRepository<HousingOffer, Long> {


    @Query("SELECT h FROM HousingOffer h " +
            "WHERE (:region IS NULL OR h.locationInfo.regionId = :region) " +
            "AND (:minRooms IS NULL OR h.apartmentInfo.quantityOfRooms >= :minRooms) " +
            "AND (:maxRent IS NULL OR h.pricingInfo.monthlyRent <= :maxRent)")
    Page<HousingOffer> searchOffers(@Param("region") Long region,
                                    @Param("minRooms") Integer minRooms,
                                    @Param("maxRent") Integer maxRent,
                                    Pageable pageable);
}
