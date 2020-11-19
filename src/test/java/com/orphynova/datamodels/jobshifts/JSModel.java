package com.orphynova.datamodels.jobshifts;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.orphynova.datamodels.UserModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class JSModel {
    private UserModel user;
    private String shiftname;
    private String action;
    private String fromtime;
    private String totime;
    private String employee;
}