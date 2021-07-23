package com.pchara.app.calculus.reporitories;

import java.util.List;

import com.pchara.app.calculus.entities.Calculus;
import com.pchara.app.calculus.entities.GroupByOperation;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface CalculusRepository extends JpaRepository<Calculus, Long> {
    @Query("SELECT new com.pchara.app.calculus.entities.GroupByOperation(c.operation, COUNT(c.operation) as occurrence)"
            + "FROM Calculus AS c GROUP BY operation ORDER BY occurrence DESC")
    List<GroupByOperation> groupByOperations(Pageable pageable);
    
    @Query("SELECT new com.pchara.app.calculus.entities.GroupByOperation(c.operation, COUNT(c.operation) as occurrence)"
            + "FROM Calculus AS c GROUP BY operation ORDER BY occurrence DESC")
    List<GroupByOperation> groupByOperations();

    Page<Calculus> findAllByOperation(String operation, Pageable pageable);

    Page<Calculus> findAll(Pageable pageable);
}
