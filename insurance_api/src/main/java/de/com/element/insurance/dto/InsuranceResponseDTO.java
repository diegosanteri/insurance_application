package de.com.element.insurance.dto;

import java.util.Date;

import de.com.element.insurance.factory.InsuranceType;

/**
 * @author diegosanteri
 *
 */
public class InsuranceResponseDTO {

	private String id;
	private String username;
	private double productValue;
	private InsuranceType insurance;
	private double tariff;
	private Date created;
	private boolean isSimulation;
	
	public InsuranceResponseDTO() {
		
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setProductValue(double productValue) {
		this.productValue = productValue;
	}

	public void setInsurance(InsuranceType insurance) {
		this.insurance = insurance;
	}

	public String getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public double getProductValue() {
		return productValue;
	}

	public InsuranceType getInsurance() {
		return insurance;
	}

	public double getTariff() {
		return tariff;
	}

	public void setTariff(double tariff) {
		this.tariff = tariff;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public boolean isSimulation() {
		return isSimulation;
	}

	public void setSimulation(boolean isSimulation) {
		this.isSimulation = isSimulation;
	}
}
