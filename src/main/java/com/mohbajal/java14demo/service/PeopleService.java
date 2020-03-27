package com.mohbajal.java14demo.service;

import com.mohbajal.java14demo.model.EmotionalState;
import com.mohbajal.java14demo.model.Person;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Service;

import java.sql.Types;
import java.util.List;

@Service
public class PeopleService {

    private final JdbcTemplate template;

    private final String findByIdSql =
            """
                    select * from PEOPLE 
                    where ID = ? 
            """;

    private final String insertSql =
            """
                insert into PEOPLE(name, emotional_state)
                values (?,?);
            """;

    private final RowMapper<Person> personRowMapper =
            (rs, rowNum) -> new Person(rs.getInt("id"),
                    rs.getString("name"),
                    rs.getInt("emotional_state"));

    PeopleService(JdbcTemplate template) {
        this.template = template;
    }

    public Person create(String name, EmotionalState state) {
        //FEAT1 smart switch
        // Return a value from the branch of a switch case and then assign that to a variable.
        // Also, auto type inference with `var`
        var index = switch (state) {
            case SAD -> -1;
            case HAPPY -> 1;
            case NEUTRAL -> 0;
        };

        var declaredParameters = List.of(
                new SqlParameter(Types.VARCHAR, "name"),
                new SqlParameter(Types.INTEGER, "emotional_state"));

        var pscf = new PreparedStatementCreatorFactory(this.insertSql, declaredParameters) {
            {
                setReturnGeneratedKeys(true);
                setGeneratedKeysColumnNames("id");
            }
        };

        var psc = pscf.newPreparedStatementCreator(List.of(name, index));
        var kh = new GeneratedKeyHolder();
        this.template.update(psc, kh);
        //FEAT2 Smart casting allows us to avoid a redundant cast after testing for a type in an instanceof test.
        //Here kh.getKey() returns a `java.lang.Number`
        if (kh.getKey() instanceof Integer id) {
            return findById(id);
        }
        throw new IllegalArgumentException("we couldn't create the " + Person.class.getName() + "!");
    }

    public Person findById(Integer id) {
        return this.template.queryForObject(this.findByIdSql, new Object[]{id}, this.personRowMapper);
    }
}
