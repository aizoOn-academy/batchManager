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
            "SELECT " +
                    "fo_user_info.user_info_id AS user_info_id," +
                    "cfBeneficiary, name, surname, address, cap, city, state," +
                    "phoneNumber, requiredAmount, iban, finish_announcement," +
                    "id_bando, approvato, importo_concesso, note" +
                    " FROM fo_user_info, fo_stato_domanda WHERE finish_announcement = TRUE" +
                    " AND fo_user_info.user_info_id = fo_stato_domanda.user_info_id" +
                    " AND approvato IS NULL;"
        );
    }

}
