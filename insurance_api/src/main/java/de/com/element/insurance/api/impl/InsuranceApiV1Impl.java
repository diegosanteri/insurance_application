package de.com.element.insurance.api.impl;

import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.querydsl.core.types.Predicate;

import de.com.element.insurance.api.InsuranceAPIV1;
import de.com.element.insurance.dto.InsuranceRequestDTO;
import de.com.element.insurance.dto.InsuranceResponseDTO;
import de.com.element.insurance.entity.InsuranceEntity;
import de.com.element.insurance.service.InsuranceServiceV1;

/**
 * @author diegosanteri
 *
 */
@RestController
@RequestMapping("/api/v1/insurance")
public class InsuranceApiV1Impl implements InsuranceAPIV1 {
	
	private InsuranceServiceV1 insuranceServiceV1;
	
	@Autowired
	public InsuranceApiV1Impl(InsuranceServiceV1 insuranceServiceV1) {
		
		this.insuranceServiceV1 = insuranceServiceV1;
	}
	
	@Override
	@GetMapping
	public ResponseEntity<Page<InsuranceEntity>> getAllInsurance(
			@RequestParam(name="page", defaultValue="1") int page,
			@RequestParam(name="size", defaultValue="10") int size,
			@QuerydslPredicate(root = InsuranceEntity.class) Predicate predicate) {
		
		return ResponseEntity.ok(insuranceServiceV1.getAllInsurance(page, size, predicate));
	}
	
	@Override
	@GetMapping("/{insuranceId}")
	public ResponseEntity<InsuranceResponseDTO> 
		getInsurance(@PathVariable("insuranceId") final String insuranceId) {
		
		return ResponseEntity.ok(insuranceServiceV1.getInsurance(insuranceId));
	}
	
	@Override
	@PostMapping
	public ResponseEntity<InsuranceResponseDTO> 
		createInsurance(
				@Valid  @RequestBody InsuranceRequestDTO insuranceDTO, Errors errors) {
		
		 if (errors.hasErrors()) {
			 String err = errors.getAllErrors()
						.stream()
						.map(x -> x.getDefaultMessage())
						.collect(Collectors.joining(","));
			 
			 throw new IllegalArgumentException(err);
		 }
		
		 
		return ResponseEntity.status(HttpStatus.CREATED).body(insuranceServiceV1.saveInsurance(insuranceDTO));
	}
	
	@Override
	@PutMapping("/{insuranceId}")
	public ResponseEntity<InsuranceResponseDTO> 
		updateInsurance(
				final @PathVariable("insuranceId") String insuranceId,
				final @Valid @RequestBody InsuranceRequestDTO insuranceDTO, Errors errors) {
		
		 if (errors.hasErrors()) {
			 String err = errors.getAllErrors()
						.stream()
						.map(x -> x.getDefaultMessage())
						.collect(Collectors.joining(","));
			 
			 throw new IllegalArgumentException(err);
		 }
		 
		insuranceServiceV1.updateInsurance(insuranceId, insuranceDTO);
		return ResponseEntity.noContent().build();
	}
	
	@Override
	@PutMapping("/{insuranceId}/status")
	public ResponseEntity<InsuranceResponseDTO> 
		updateInsuranceStatus(
				final @PathVariable("insuranceId") String insuranceId) {
		
		insuranceServiceV1.updateInsuranceStatus(insuranceId);
		return ResponseEntity.noContent().build();
	}
	
	@Override
	@DeleteMapping("/{insuranceId}")
	public ResponseEntity<InsuranceResponseDTO> 
		deleteInsurance(@PathVariable("insuranceId") final String insuranceId) {
		
		insuranceServiceV1.deleteInsurance(insuranceId);
		return ResponseEntity.noContent().build();
	}
}
