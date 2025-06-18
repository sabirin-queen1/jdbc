package p.example.p;


import org.jetbrains.annotations.NotNull;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
    @Service
    public class StudentService {
        private final JdbcTemplate jdbcTemplate;

        public StudentService(JdbcTemplate jdbcTemplate) {
            this.jdbcTemplate = jdbcTemplate;
        }

        public List<Student> getStudents() {
            String sql = "SELECT id, name FROM Student";
            return jdbcTemplate.query(sql,
                    new BeanPropertyRowMapper<>(Student.class));
        }

        public void addStudent(@NotNull Student student) {
            String sql = "INSERT INTO Student VALUES(?, ?)";
            jdbcTemplate.update(sql, student.getId(), student.getName());
        }


    }

