package de.com.element.insurance.api;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;

import com.querydsl.core.types.Predicate;

import de.com.element.insurance.dto.InsuranceRequestDTO;
import de.com.element.insurance.dto.InsuranceResponseDTO;
import de.com.element.insurance.entity.InsuranceEntity;


public interface InsuranceAPIV1 {

	ResponseEntity<InsuranceResponseDTO> getInsurance(String insuranceId);

	ResponseEntity<InsuranceResponseDTO> deleteInsurance(String insuranceId);

	ResponseEntity<Page<InsuranceEntity>> getAllInsurance(int page, int size, Predicate predicate);

	ResponseEntity<InsuranceResponseDTO> updateInsuranceStatus(String insuranceId);

	ResponseEntity<InsuranceResponseDTO> createInsurance(InsuranceRequestDTO insuranceDTO, Errors errors);

	ResponseEntity<InsuranceResponseDTO> updateInsurance(String insuranceId, InsuranceRequestDTO insuranceDTO,
			Errors errors);

}