package com.myproject.OnlineAttandenceSystem.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.myproject.OnlineAttandenceSystem.Model.Attendance;
import com.myproject.OnlineAttandenceSystem.Model.StudentDetail;

public interface AttendanceRepository extends JpaRepository<Attendance, Long> {

    // Check if attendance exists today for this student
    @Query("SELECT a FROM Attendance a WHERE a.student = :student AND a.date BETWEEN :startOfDay AND :endOfDay")
    Optional<Attendance> findTodayAttendance(@Param("student") StudentDetail student,
                                            @Param("startOfDay") LocalDateTime startOfDay,
                                            @Param("endOfDay") LocalDateTime endOfDay);
}
