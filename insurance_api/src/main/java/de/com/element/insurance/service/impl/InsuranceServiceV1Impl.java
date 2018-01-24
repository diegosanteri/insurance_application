package de.com.element.insurance.service.impl;

import java.util.Date;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.querydsl.core.types.Predicate;

import de.com.element.insurance.context.exception.NotFoundErrorException;
import de.com.element.insurance.dto.InsuranceRequestDTO;
import de.com.element.insurance.dto.InsuranceResponseDTO;
import de.com.element.insurance.entity.InsuranceEntity;
import de.com.element.insurance.factory.InsuranceFactory;
import de.com.element.insurance.repository.InsuranceRepository;
import de.com.element.insurance.service.InsuranceServiceV1;

/**
 * @author diegosanteri
 *
 */
@Service
public class InsuranceServiceV1Impl implements InsuranceServiceV1{

	private static final String INSURANCE_NOT_FOUND = "Insurance not found";
	
	private ModelMapper mapper;	
	private InsuranceRepository insuranceRepository;
	
	@Autowired
	public InsuranceServiceV1Impl(final ModelMapper mapper, final InsuranceRepository insuranceRepository) {
		this.mapper = mapper;
		this.insuranceRepository = insuranceRepository;
	}
	
	@Override
	public InsuranceResponseDTO saveInsurance(final InsuranceRequestDTO insuranceDTO) {
		
		final InsuranceEntity entity = mapper.map(insuranceDTO, InsuranceEntity.class);
		final double tariff = InsuranceFactory.getInsurance(insuranceDTO.getInsurance())
											  .calculate(insuranceDTO.getProductValue());
		
		entity.setTariff(tariff);
		entity.setSimulation(true);
		entity.setCreated(new Date());
		
		final InsuranceResponseDTO response = 
				mapper.map(insuranceRepository.save(entity), InsuranceResponseDTO.class);
		
		return response;
	}

	@Override
	public Page<InsuranceEntity> getAllInsurance(int page, int size, final Predicate predicate) {
		
		final PageRequest pageRequest = new PageRequest(page-1, size,  Sort.Direction.DESC, "created");
		
		return insuranceRepository.findAll(predicate, pageRequest);
	}

	@Override
	public InsuranceResponseDTO getInsurance(final String insuranceId) {
		
		final InsuranceEntity response = insuranceRepository.findOne(insuranceId);
		if(response == null) {
			
			throw new NotFoundErrorException(INSURANCE_NOT_FOUND);
		}
		
		return mapper.map(response, InsuranceResponseDTO.class);
	}

	@Override
	public void updateInsurance(final String insuranceId, final InsuranceRequestDTO insuranceDTO) {
		
		final InsuranceEntity insurance = insuranceRepository.findOne(insuranceId);
		if(insurance == null) {
			
			throw new NotFoundErrorException(INSURANCE_NOT_FOUND);
		}
		
		if(insuranceDTO.getInsurance() != null && insuranceDTO.getProductValue() > 0) {
			
			final double tariff = InsuranceFactory.getInsurance(insuranceDTO.getInsurance())
					  							  .calculate(insuranceDTO.getProductValue());
			
			insurance.setTariff(tariff);
			insurance.setInsurance(insuranceDTO.getInsurance());
		}
		
		if (insuranceDTO.getProductValue() != 0) {
			
			insurance.setProductValue(insuranceDTO.getProductValue());
		}
		
		if(insuranceDTO.getUsername() != null) {
			
			insurance.setUsername(insuranceDTO.getUsername());
		}
		
		insurance.setSimulation(true);		
		insuranceRepository.save(insurance);
	}
	
	@Override
	public void updateInsuranceStatus(String insuranceId) {
		final InsuranceEntity insurance = insuranceRepository.findOne(insuranceId);
		if(insurance == null) {
			
			throw new NotFoundErrorException(INSURANCE_NOT_FOUND);
		}
		
		insurance.setSimulation(false);
		
		insuranceRepository.save(insurance);
	}

	@Override
	public void deleteInsurance(final String insuranceId) {
		final InsuranceEntity response = insuranceRepository.findOne(insuranceId);
		if(response == null) {
			
			throw new NotFoundErrorException(INSURANCE_NOT_FOUND);
		}
		insuranceRepository.delete(response);
		
	}	
}
