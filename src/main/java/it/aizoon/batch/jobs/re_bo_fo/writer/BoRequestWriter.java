package it.aizoon.batch.jobs.re_bo_fo.writer;

import javax.sql.DataSource;

import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import it.aizoon.batch.jobs.re_bo_fo.model.Request;

@Component
public class BoRequestWriter extends JdbcBatchItemWriter<Request> {

    public BoRequestWriter(@Qualifier("backOfficeDB") DataSource dataSource) {
        super();

        setDataSource(dataSource);
        setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>());

        setAssertUpdates(false);

        setSql(
                "UPDATE BO_DOMANDE SET rendicontazione = :approved, money_amount_finale = :moneyAmountFinale, note = :note " +
                "WHERE id_domanda = :requestId;"
        );
    }
}
