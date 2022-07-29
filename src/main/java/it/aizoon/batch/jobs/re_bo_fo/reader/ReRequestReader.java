package it.aizoon.batch.jobs.re_bo_fo.reader;

import it.aizoon.batch.jobs.bo_re.model.Operator;
import it.aizoon.batch.jobs.re_bo_fo.RequestMapper;
import it.aizoon.batch.jobs.re_bo_fo.model.Request;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.sql.DataSource;

public class ReRequestReader extends JdbcCursorItemReader<Request> {

    public ReRequestReader(@Qualifier("rendicontazioneDB") DataSource dataSource) {
        super();

        setRowMapper(new RequestMapper());
        setDataSource(dataSource);
        setSql(
                "SELECT announcement_application_id, applicant_fiscal_code, applicant_name, applicant_surname, applicant_address,\n" +
                        "applicant_city_cap, applicant_city, applicant_nation, applicant_phone, applicant_iban, money_amount, approved_money_amount, \n" +
                        "note, approvation_status" +
                "FROM RE_AnnouncementApplications;"
        );
    }

}
