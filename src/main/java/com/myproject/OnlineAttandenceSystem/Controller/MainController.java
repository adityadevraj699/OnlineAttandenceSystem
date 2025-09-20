package com.myproject.OnlineAttandenceSystem.Controller;

import com.myproject.OnlineAttandenceSystem.Model.Attendance;
import com.myproject.OnlineAttandenceSystem.Model.StudentDetail;
import com.myproject.OnlineAttandenceSystem.Repository.AttendanceRepository;
import com.myproject.OnlineAttandenceSystem.Repository.StudentDetailRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class MainController {

    @Autowired
    private StudentDetailRepository stuRepo;

    @Autowired
    private AttendanceRepository attendanceRepo;

    /** 🏠 Home Page */
    @GetMapping("/")
    public String index() {
        return "index";
    }

    /** 📋 Student page */
    @GetMapping("/student")
    public String student() {
        return "student";
    }

    /** ✅ Mark Attendance */
    @PostMapping("/student")
    public String student(@RequestParam("rollNo") String rollNo, RedirectAttributes attributes) {
        try {
            if (stuRepo.existsByRollNo(rollNo)) {
                StudentDetail student = stuRepo.findByRollNo(rollNo);
                String studentName = student.getName();

                LocalDateTime startOfDay = LocalDateTime.now().toLocalDate().atStartOfDay();
                LocalDateTime endOfDay = startOfDay.plusDays(1).minusNanos(1);

                boolean alreadyMarked = attendanceRepo
                        .findTodayAttendance(student, startOfDay, endOfDay)
                        .isPresent();

                if (!alreadyMarked) {
                    Attendance attendance = new Attendance();
                    attendance.setStudent(student);
                    attendanceRepo.save(attendance);
                    attributes.addFlashAttribute("message",
                            "Attendance marked successfully for " + studentName + "!");
                } else {
                    attributes.addFlashAttribute("error",
                            "Attendance already marked today for " + studentName + ".");
                }
            } else {
                attributes.addFlashAttribute("error", "Invalid Roll Number!");
            }
            return "redirect:/student";
        } catch (Exception e) {
            e.printStackTrace();
            attributes.addFlashAttribute("error", "Something went wrong!");
            return "redirect:/";
        }
    }

    /** 📅 Teacher dashboard initial load */
    @GetMapping("/teacher")
    public String teacher() {
        return "teacher";
    }

    /** 📊 Attendance fetch for selected date */
    @GetMapping("/teacher/attendance")
    public String getAttendance(
            @RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date,
            Model model) {

        // ✅ Fetch all students
        List<StudentDetail> allStudents = stuRepo.findAll();

        // ✅ Start and End of selected day
        LocalDateTime startOfDay = date.atStartOfDay();
        LocalDateTime endOfDay = startOfDay.plusDays(1).minusNanos(1);

        // ✅ Filter attendance for date
        List<Attendance> attendanceList = attendanceRepo.findAll().stream()
                .filter(a -> !a.getDate().isBefore(startOfDay) && !a.getDate().isAfter(endOfDay))
                .collect(Collectors.toList());

        // ✅ Roll numbers of present students
        Set<String> presentRolls = attendanceList.stream()
                .map(a -> a.getStudent().getRollNo())
                .collect(Collectors.toSet());

        // ✅ Prepare table data
        List<Map<String, String>> tableData = new ArrayList<>();
        for (StudentDetail s : allStudents) {
            Map<String, String> row = new HashMap<>();
            row.put("name", s.getName());
            row.put("rollNo", s.getRollNo());
            row.put("status", presentRolls.contains(s.getRollNo()) ? "Present" : "Absent");
            tableData.add(row);
        }

        model.addAttribute("selectedDate", date);
        model.addAttribute("attendanceData", tableData);
        return "teacher"; // Render teacher.html
    }
}
