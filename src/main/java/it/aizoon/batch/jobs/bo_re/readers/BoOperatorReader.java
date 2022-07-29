package it.aizoon.batch.jobs.bo_re.readers;

import javax.sql.DataSource;

import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import it.aizoon.batch.jobs.bo_re.mappers.OperatorMapper;
import it.aizoon.batch.jobs.bo_re.model.Operator;

@Component
public class BoOperatorReader extends JdbcCursorItemReader<Operator> {
    
    public BoOperatorReader(@Qualifier("backOfficeDB") DataSource dataSource) {
        super();
        
        setRowMapper(new OperatorMapper());
        setDataSource(dataSource);
        setSql(
            "SELECT * FROM BO_OPERATORI"
        );
    }

}
