/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pm.patient_service.service;

import com.pm.patient_service.dto.PatientRequestDto;
import com.pm.patient_service.dto.PatientResponseDto;
import com.pm.patient_service.exception.EmailAlreadyExistsException;
import com.pm.patient_service.exception.PatientNotFoundException;
import com.pm.patient_service.mapper.PatientMapper;
import com.pm.patient_service.model.Patient;
import com.pm.patient_service.repository.PatientRepository;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Service;

/**
 *
 * @author guyma
 */
@Service
public class PatientService {

    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;

    }

    public List<PatientResponseDto> getPatients() {
        List<PatientResponseDto> patientResponseDtos = new ArrayList<>();
        List<Patient> patients = patientRepository.findAll();
        if (patients != null && !patients.isEmpty()) {
            patientResponseDtos = PatientMapper.toListDto(patients);
        }
        return patientResponseDtos;
    }

    public PatientResponseDto createPatient(PatientRequestDto patientRequestDto) {

        PatientResponseDto patientResponseDto = new PatientResponseDto();
        Patient patientToSave = new Patient();
        if (patientRepository.existsByEmail(patientRequestDto.getEmail())) {
            throw new EmailAlreadyExistsException("A partient with this email alredy exists" + patientRequestDto.getEmail());
        }

        patientToSave.setName(patientRequestDto.getName());
        patientToSave.setEmail(patientRequestDto.getEmail());
        patientToSave.setDateOfBirth(LocalDate.parse(patientRequestDto.getDateOfBirh()));

        patientToSave = patientRepository.save(patientToSave);

        return PatientMapper.toDto(patientToSave);
    }

    public PatientResponseDto updatePatient(UUID id, PatientRequestDto patientRequestDto) {

        Patient patient = patientRepository.findById(id).orElseThrow(() -> new PatientNotFoundException("Patient not found with id: " + id));

        if (patientRepository.existsByEmail(patientRequestDto.getEmail())) {
            throw new EmailAlreadyExistsException("A partient with this email alredy exists" + patientRequestDto.getEmail());
        }

        patient.setName(patientRequestDto.getName());
        patient.setEmail(patientRequestDto.getEmail());
        patient.setDateOfBirth(LocalDate.parse(patientRequestDto.getDateOfBirh()));

        Patient updatedPatient = patientRepository.save(patient);

        return PatientMapper.toDto(updatedPatient);
    }

}
