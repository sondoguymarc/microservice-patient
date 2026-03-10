/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pm.patient_service.dto;

import java.time.LocalDate;
import lombok.Data;

/**
 *
 * @author guyma
 */
@Data
public class PatientResponseDto {

    private String id;

    private String name;

    private String email;

    private String address;

    private LocalDate dateOfBirth;

}
