package it.aizoon.batch.jobs.bo_re.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter @Builder @AllArgsConstructor
public class Operator {
    
    private Long operatorId;
    private String username; 

}
