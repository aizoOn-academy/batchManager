package it.aizoon.batch.jobs.re_bo_fo.writer;

import javax.sql.DataSource;

import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import it.aizoon.batch.jobs.re_bo_fo.model.Request;

@Component
public class FoRequestWriter extends JdbcBatchItemWriter<Request> {

    public FoRequestWriter(@Qualifier("frontOfficeDB") DataSource dataSource) {
        super();

        setDataSource(dataSource);
        setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>());

        setAssertUpdates(false);

        setSql(
                "UPDATE fo_stato_domanda SET approvato = :approved, importo_concesso = :moneyAmountFinale, note = :note " +
                        "WHERE user_info_id = :requestId;"
        );
    }
}
