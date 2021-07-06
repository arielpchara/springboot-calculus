package com.pchara.app.calculus;

import java.util.List;

import com.pchara.app.calculus.model.Calculus;
import com.pchara.app.calculus.model.GroupByOperation;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface CalculusRepository extends JpaRepository<Calculus, Long> {
    @Query("SELECT new com.pchara.app.calculus.model.GroupByOperation(c.operation, COUNT(c.operation) as occurrence)"
            + "FROM Calculus AS c GROUP BY operation ORDER BY occurrence DESC")
    List<GroupByOperation> groupByOperations(Pageable pageable);

    @Query(value = "SELECT c.operations as operations"
    + "FROM Calculus AS c", nativeQuery = true)
    List<Calculus> highCalculus();

    Page<Calculus> findAll(Pageable pageable);
}
