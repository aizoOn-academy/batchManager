package it.aizoon.batch.jobs.bo_re.writers;

import javax.sql.DataSource;

import it.aizoon.batch.jobs.bo_re.model.Operator;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class ReOperatorWriter extends JdbcBatchItemWriter<Operator> {
    
    public ReOperatorWriter(@Qualifier("rendicontazioneDB") DataSource dataSource) {
        super();
        
        setDataSource(dataSource);
        setItemSqlParameterSourceProvider( new BeanPropertyItemSqlParameterSourceProvider<>() );

        setAssertUpdates(false);

        //TODO: set the SQL query to write the data to the back office database 
        setSql(
            "INSERT IGNORE INTO RE_Operators (operator_id, username) " + 
            "VALUES (:operatorId, :username)"
        );
        
    }

}
