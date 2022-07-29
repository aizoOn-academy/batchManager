package it.aizoon.batch.jobs.re_bo_fo.reader;

import javax.sql.DataSource;

import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import it.aizoon.batch.jobs.re_bo_fo.RequestMapper;
import it.aizoon.batch.jobs.re_bo_fo.model.Request;

@Component
public class ReRequestReader extends JdbcCursorItemReader<Request> {

    public ReRequestReader(@Qualifier("rendicontazioneDB") DataSource dataSource) {
        super();

        setRowMapper(new RequestMapper());
        setDataSource(dataSource);
        setSql(
                "SELECT * FROM RE_AnnouncementApplications"
        );
    }

}
