package it.aizoon.batch.jobs.fo_bo;

import javax.sql.DataSource;

import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import it.aizoon.batch.jobs.fo_bo.model.Request;

@Component
public class BoWriter extends JdbcBatchItemWriter<Request> {
    
    public BoWriter(@Qualifier("backOfficeDB") DataSource dataSource) {
        super();
        
        setDataSource(dataSource);
        setItemSqlParameterSourceProvider( new BeanPropertyItemSqlParameterSourceProvider<>() );

        setAssertUpdates(false);
        setSql(
            "INSERT IGNORE INTO BO_DOMANDE (id_domanda, id_bando, cf_beneficiario, nome, " +
                "cognome, indirizzo, cap, citta, " +
                "nazione, telefono, importo, iban, note) " +
                "VALUES (:requestId, :announcementId, :applicantFiscalCode, :applicantName, " +
                ":applicantSurname, :applicantAddress, :applicantCityCap, :applicantCity, " +
                ":applicantNation, :applicantPhone, :moneyAmount, :applicantIban, :note)"
        );
        
    }

}
