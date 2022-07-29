package it.aizoon.batch.jobs.re_bo_fo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter @Builder @AllArgsConstructor
public class Request {
    
    private Long requestId;
    private Boolean approved;
    private Double moneyAmountFinale;
    private String note;
}
