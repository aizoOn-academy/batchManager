package it.aizoon.batch.jobs.re_bo_fo.writer;

import it.aizoon.batch.jobs.bo_re.model.Operator;
import it.aizoon.batch.jobs.re_bo_fo.model.Request;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.sql.DataSource;

public class BoRequestWriter extends JdbcBatchItemWriter<Request> {

    public BoRequestWriter(@Qualifier("backOfficeDB") DataSource dataSource) {
        super();

        setDataSource(dataSource);
        setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>());

        setSql(
                "UPDATE BO_DOMANDE" +
                        "SET rendicontazione = :approved, money_amount_finale = :moneyAmountFinale, note = :note" +
                "WHERE id_domanda = :requestId;"
        );
    }
}
