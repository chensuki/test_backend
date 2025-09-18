package com.test.backend.repository;

import com.test.backend.entity.ProjectEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

@Repository
public class ProjectRepository {

    private final JdbcTemplate jdbcTemplate;

    public ProjectRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<ProjectEntity> findAll() {
        return jdbcTemplate.query("select id, name, description from projects order by id desc",
                (rs, rn) -> {
                    ProjectEntity e = new ProjectEntity();
                    e.setId(rs.getLong("id"));
                    e.setName(rs.getString("name"));
                    e.setDescription(rs.getString("description"));
                    return e;
                });
    }

    public Optional<ProjectEntity> findById(Long id) {
        List<ProjectEntity> list = jdbcTemplate.query("select id, name, description from projects where id = ?",
                (rs, rn) -> {
                    ProjectEntity e = new ProjectEntity();
                    e.setId(rs.getLong("id"));
                    e.setName(rs.getString("name"));
                    e.setDescription(rs.getString("description"));
                    return e;
                }, id);
        return list.stream().findFirst();
    }

    public ProjectEntity insert(ProjectEntity project) {
        String sql = "insert into projects(name, description) values (?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(con -> {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, project.getName());
            ps.setString(2, project.getDescription());
            return ps;
        }, keyHolder);
        Number key = keyHolder.getKey();
        if (key != null) {
            project.setId(key.longValue());
        }
        return project;
    }

    public void deleteById(Long id) {
        jdbcTemplate.update("delete from projects where id = ?", id);
    }
}


