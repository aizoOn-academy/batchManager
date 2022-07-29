package it.aizoon.batch.jobs.fo_bo;

import javax.sql.DataSource;

import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import it.aizoon.batch.jobs.fo_bo.model.Request;

@Component
public class FoReader extends JdbcCursorItemReader<Request> {
    
    public FoReader(@Qualifier("frontOfficeDB") DataSource dataSource) {
        super();
        
        setRowMapper(new RequestMapper());
        setDataSource(dataSource);
        setSql(
            "SELECT * FROM fo_user_info WHERE finish_announcement = TRUE"
        );
    }

}
