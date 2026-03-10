/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pm.patient_service.mapper;

import com.pm.patient_service.dto.PatientResponseDto;
import com.pm.patient_service.model.Patient;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author guyma
 */
public class PatientMapper {

    public static PatientResponseDto toDto(Patient patient) {
        PatientResponseDto patientResponseDto = new PatientResponseDto();
        patientResponseDto.setId(patient.getId().toString());
        patientResponseDto.setName(patient.getName());
        patientResponseDto.setEmail(patient.getEmail());
        patientResponseDto.setAddress(patient.getAddress());
        patientResponseDto.setDateOfBirth(patient.getDateOfBirth());

        return patientResponseDto;
    }

    public static List<PatientResponseDto> toListDto(List<Patient> patients) {
        List<PatientResponseDto> patientResponseDtos = new ArrayList<>();
        for (Patient patient : patients) {
            PatientResponseDto patientResponseDto = new PatientResponseDto();
            patientResponseDto.setId(patient.getId().toString());
            patientResponseDto.setName(patient.getName());
            patientResponseDto.setEmail(patient.getEmail());
            patientResponseDto.setAddress(patient.getAddress());
            patientResponseDto.setDateOfBirth(patient.getDateOfBirth());
            patientResponseDtos.add(patientResponseDto);
        }
        return patientResponseDtos;
    }

}
