
package org.abes.hrmsdatabase.repository;

import org.abes.hrmsdatabase.model.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface AttendanceRepository
        extends JpaRepository<Attendance, Long> {

    Optional<Attendance> findByEmployee_EmpIdAndAttendancedate(
            long employeeId, LocalDate attendancedate);

    List<Attendance> findByEmployee_EmpId(long employeeId);
}
