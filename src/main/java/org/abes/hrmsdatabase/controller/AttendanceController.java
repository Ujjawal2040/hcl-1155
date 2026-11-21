
package org.abes.hrmsdatabase.controller;

import org.abes.hrmsdatabase.model.Attendance;
import org.abes.hrmsdatabase.service.AttendanceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/v1/attendance")
@CrossOrigin(origins = "http://localhost:5173")
public class AttendanceController {

    private final AttendanceService attendanceService;

    public AttendanceController(AttendanceService attendanceService) {
        this.attendanceService = attendanceService;
    }

    @PostMapping("/checkin")
    public ResponseEntity<?> checkIn(
            @RequestBody Map<String, Object> request) {
        try {
            Long employeeId = Long.valueOf(
                    request.get("employeeId").toString());

            String comment = request.get("comment") == null
                    ? ""
                    : request.get("comment").toString();

            Attendance attendance =
                    attendanceService.markAttendance(employeeId, comment);

            return ResponseEntity.ok(attendance);

        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest()
                    .body(Map.of("message", e.getMessage()));
        }
    }

    @PutMapping("/checkout/{attendanceId}")
    public ResponseEntity<?> checkOut(
            @PathVariable Long attendanceId) {
        try {
            return ResponseEntity.ok(
                    attendanceService.markCheckOut(attendanceId));

        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest()
                    .body(Map.of("message", e.getMessage()));
        }
    }

    @GetMapping("/all")
    public List<Attendance> getAllAttendance() {
        return attendanceService.getAllAttendance();
    }

    @GetMapping("/employee/{employeeId}")
    public List<Attendance> getAttendanceByEmployee(
            @PathVariable Long employeeId) {
        return attendanceService.getAttendanceByEmployee(employeeId);
    }
}
