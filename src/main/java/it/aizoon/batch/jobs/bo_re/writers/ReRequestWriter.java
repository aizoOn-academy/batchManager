package it.aizoon.batch.jobs.bo_re.writers;

import javax.sql.DataSource;

import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import it.aizoon.batch.jobs.bo_re.model.Request;

@Component
public class ReRequestWriter extends JdbcBatchItemWriter<Request> {
    
    public ReRequestWriter(@Qualifier("rendicontazioneDB") DataSource dataSource) {
        super();
        
        setDataSource(dataSource);
        setItemSqlParameterSourceProvider( new BeanPropertyItemSqlParameterSourceProvider<>() );

        setAssertUpdates(false);

        setSql(
            "INSERT IGNORE INTO RE_AnnouncementApplications (announcement_application_id, operator_id, announcement_id, applicant_fiscal_code," +
                                                    "applicant_name, applicant_surname, applicant_address, applicant_city_cap," +
                                                    "applicant_city, applicant_nation, applicant_phone, money_amount, applicant_iban, note)" + 
            "VALUES (:requestId, :operatorId, :announcementId, :applicantFiscalCode, :applicantName, " +
                    ":applicantSurname, :applicantAddress, :applicantCityCap, :applicantCity, " +
                    ":applicantNation, :applicantPhone, :moneyAmount, :applicantIban, :note) "
        );
        
    }

}
