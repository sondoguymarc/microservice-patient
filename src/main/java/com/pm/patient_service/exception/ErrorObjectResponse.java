/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pm.patient_service.exception;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author guyma
 */
@Data
@AllArgsConstructor
@NoArgsConstructor

public class ErrorObjectResponse {

    private Date timestamp;
    private int status;
    private String message;

}
