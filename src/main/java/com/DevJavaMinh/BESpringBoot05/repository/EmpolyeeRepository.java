package com.DevJavaMinh.BESpringBoot05.repository;

import com.DevJavaMinh.BESpringBoot05.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpolyeeRepository extends JpaRepository<Employee, Long> {
}
