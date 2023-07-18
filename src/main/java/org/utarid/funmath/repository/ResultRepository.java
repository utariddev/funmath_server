package org.utarid.funmath.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.utarid.funmath.entity.ResultEntity;

import java.util.List;
import java.util.Optional;

public interface ResultRepository extends JpaRepository<ResultEntity, Long> {

    @Query(value = "SELECT * FROM public.results WHERE DATE_PART('week', result_date) = ?1 ORDER BY result DESC", nativeQuery = true)
    List<ResultEntity> findAllByWeekOrder(int week);

    Optional<ResultEntity> findByUserId(Long userId);
}
