package it.aizoon.batch.jobs.bo_re.readers;

import javax.sql.DataSource;

import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import it.aizoon.batch.jobs.bo_re.mappers.RequestMapper;
import it.aizoon.batch.jobs.bo_re.model.Request;

@Component
public class BoRequestReader extends JdbcCursorItemReader<Request> {
    
    public BoRequestReader(@Qualifier("backOfficeDB") DataSource dataSource) {
        super();
        
        setRowMapper(new RequestMapper());
        setDataSource(dataSource);
        setSql(
            "SELECT * FROM BO_DOMANDE WHERE approvazione = TRUE"
        );
    }

}
