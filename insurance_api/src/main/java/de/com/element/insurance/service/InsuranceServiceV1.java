package de.com.element.insurance.service;

import org.springframework.data.domain.Page;

import com.querydsl.core.types.Predicate;

import de.com.element.insurance.dto.InsuranceRequestDTO;
import de.com.element.insurance.dto.InsuranceResponseDTO;
import de.com.element.insurance.entity.InsuranceEntity;

/**
 * @author diegosanteri
 *
 */
public interface InsuranceServiceV1 {
	
	Page<InsuranceEntity> getAllInsurance(int page, int size, Predicate predicate);
	InsuranceResponseDTO getInsurance(final String insuranceId);
	InsuranceResponseDTO saveInsurance(final InsuranceRequestDTO insuranceDTO);
	void updateInsurance(final String insuranceId, final InsuranceRequestDTO insuranceDTO);
	void deleteInsurance(final String insuranceId);
	void updateInsuranceStatus(String insuranceId);
}
