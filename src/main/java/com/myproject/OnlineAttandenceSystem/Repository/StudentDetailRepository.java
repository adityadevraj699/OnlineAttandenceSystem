package com.myproject.OnlineAttandenceSystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myproject.OnlineAttandenceSystem.Model.StudentDetail;

public interface StudentDetailRepository extends JpaRepository<StudentDetail, Long>{

	boolean existsByRollNo(String rollNo);

	StudentDetail findByRollNo(String rollNo);

}
