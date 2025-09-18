package com.test.backend.repository;

import com.test.backend.entity.ProjectEntity;
import com.test.backend.entity.TimesheetEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

@Repository
public class TimesheetRepository {

    private final JdbcTemplate jdbcTemplate;

    public TimesheetRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<TimesheetWithProject> findAllWithProject() {
        String sql = """
            select t.id, t.project_id, t.work_date, t.hours, t.notes,
                   p.id as p_id, p.name as p_name, p.description as p_description
            from timesheets t
            join projects p on p.id = t.project_id
            order by t.id desc
        """;
        return jdbcTemplate.query(sql, (rs, rowNum) -> mapWithProject(rs));
    }

    private TimesheetWithProject mapWithProject(ResultSet rs) throws SQLException {
        TimesheetEntity t = new TimesheetEntity();
        t.setId(rs.getLong("id"));
        t.setProjectId(rs.getLong("project_id"));
        t.setWorkDate(rs.getObject("work_date", LocalDate.class));
        t.setHours(rs.getDouble("hours"));
        t.setNotes(rs.getString("notes"));
        ProjectEntity p = new ProjectEntity();
        p.setId(rs.getLong("p_id"));
        p.setName(rs.getString("p_name"));
        p.setDescription(rs.getString("p_description"));
        return new TimesheetWithProject(t, p);
    }

    public TimesheetEntity insert(TimesheetEntity t) {
        jdbcTemplate.update(
                "insert into timesheets(project_id, work_date, hours, notes) values (?, ?, ?, ?)",
                t.getProjectId(), t.getWorkDate(), t.getHours(), t.getNotes()
        );
        // Return object without generated id (not used by frontend on create)
        return t;
    }

    public void deleteById(Long id) {
        jdbcTemplate.update("delete from timesheets where id = ?", id);
    }
}


