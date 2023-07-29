package com.kbl.kundgolservice.repository;

import com.kbl.kundgolservice.entity.ServiceView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReportRepository  extends JpaRepository<ServiceView,Long> {

    @Query("SELECT sv FROM ServiceView sv where sv.personId=:personId or " +
            "(sv.placeCode= :placeCode and sv.wardCode=:wardCode and sv.personId is null) or " +
            "(sv.placeCode= :placeCode and sv.wardCode='WD-ALL') or " +
            "sv.placeCode = 'PL-ALL'")
    List<ServiceView> findByPersonIdAndPlace(@Param("personId") Long personId, @Param("placeCode") String placeCode, @Param("wardCode") String wardCode);

    @Query("SELECT sv FROM ServiceView sv where " +
            "(sv.placeCode= :placeCode and sv.wardCode=:wardCode and sv.personId is null) " +
            "or (sv.placeCode= :placeCode and sv.wardCode='WD-ALL') " +
            "or sv.placeCode = 'PL-ALL'")
    List<ServiceView> findByWard(@Param("placeCode") String placeCode, @Param("wardCode") String wardCode);

    @Query("SELECT sv FROM ServiceView sv where (sv.placeCode= :placeCode and sv.wardCode='WD-ALL') " +
            "or sv.placeCode = 'PL-ALL'")
    List<ServiceView> findByPlace(@Param("placeCode") String placeCode);
}
