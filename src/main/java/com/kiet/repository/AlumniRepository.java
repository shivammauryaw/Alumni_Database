package com.kiet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kiet.model.Alumni;
import java.util.List;

@Repository
public interface AlumniRepository extends JpaRepository<Alumni,Integer> {

	List<Alumni> findByBatch(String batch);

}
