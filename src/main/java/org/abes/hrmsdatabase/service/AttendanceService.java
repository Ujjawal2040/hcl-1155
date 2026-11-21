
package org.abes.hrmsdatabase.service;

import org.abes.hrmsdatabase.model.Attendance;
import org.abes.hrmsdatabase.repository.AttendanceRepository;
import org.abes.hrmsdatabase.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class AttendanceService {

    private final AttendanceRepository attendanceRepository;
    private final EmployeeRepository employeeRepository;

    public AttendanceService(
            AttendanceRepository attendanceRepository,
            EmployeeRepository employeeRepository) {
        this.attendanceRepository = attendanceRepository;
        this.employeeRepository = employeeRepository;
    }

    public Attendance markAttendance(
            Long employeeId, String comment) {

        var employee = employeeRepository.findById(employeeId)
                .orElseThrow(() ->
                        new IllegalArgumentException(
                                "Employee not found"));

        LocalDate today = LocalDate.now();

        if (attendanceRepository
                .findByEmployee_EmpIdAndAttendancedate(
                        employeeId, today).isPresent()) {
            throw new IllegalArgumentException(
                    "Attendance already marked today");
        }

        Attendance attendance = new Attendance();
        attendance.setEmployee(employee);
        attendance.setAttendancedate(today);
        attendance.setInTime(LocalDateTime.now());
        attendance.setComment(comment);

        return attendanceRepository.save(attendance);
    }

    public Attendance markCheckOut(Long attendanceId) {
        Attendance attendance = attendanceRepository
                .findById(attendanceId)
                .orElseThrow(() ->
                        new IllegalArgumentException(
                                "Attendance record not found"));

        if (attendance.getOutTime() != null) {
            throw new IllegalArgumentException(
                    "Check-out already marked");
        }

        attendance.setOutTime(LocalDateTime.now());

        return attendanceRepository.save(attendance);
    }

    public List<Attendance> getAllAttendance() {
        return attendanceRepository.findAll();
    }

    public List<Attendance> getAttendanceByEmployee(
            Long employeeId) {
        return attendanceRepository
                .findByEmployee_EmpId(employeeId);
    }
}
