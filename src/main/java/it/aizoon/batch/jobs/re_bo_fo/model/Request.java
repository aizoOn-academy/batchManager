package it.aizoon.batch.jobs.re_bo_fo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter @Builder @AllArgsConstructor
public class Request {
    
    private Long requestId;
    private Long announcementId;
    private Long operatorId;
    private String applicantFiscalCode;
    private String applicantName;
    private String applicantSurname;
    private String applicantAddress;
    private String applicantCityCap;
    private String applicantCity;
    private String applicantNation;
    private String applicantPhone;
    private String applicantIban;
    private Double moneyAmount;

    private Boolean approved;
    private Double moneyAmountFinale;
    private String note;
}
