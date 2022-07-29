package it.aizoon.batch.jobs.fo_bo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter @Builder @AllArgsConstructor
public class Request {
    
    private Long requestId;
    private Long announcementId;
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

}
