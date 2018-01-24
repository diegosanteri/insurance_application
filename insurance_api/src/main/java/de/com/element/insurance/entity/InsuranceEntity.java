package de.com.element.insurance.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.querydsl.core.annotations.QueryEntity;

import de.com.element.insurance.factory.InsuranceType;

/**
 * @author diegosanteri
 *
 */
@Entity
@Table(name="INSURANCE")
@QueryEntity
public class InsuranceEntity {
	
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String id;
	
	private String username;
	
	private double productValue;
	
	private double tariff;
	
	private InsuranceType insurance;
	
	private Date created;
	
	private boolean simulation;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public double getProductValue() {
		return productValue;
	}

	public void setProductValue(double productValue) {
		this.productValue = productValue;
	}
	
	public double getTariff() {
		return tariff;
	}

	public void setTariff(double tariff) {
		this.tariff = tariff;
	}

	public InsuranceType getInsurance() {
		return insurance;
	}

	public void setInsurance(InsuranceType insurance) {
		this.insurance = insurance;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public boolean isSimulation() {
		return simulation;
	}

	public void setSimulation(boolean simulation) {
		this.simulation = simulation;
	}
}
