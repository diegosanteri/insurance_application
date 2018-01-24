package de.com.element.insurance.factory;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author diegosanteri
 *
 */
public enum InsuranceType {
	@JsonProperty("BIKE")
	BIKE, 
	@JsonProperty("JEWELRY")
	JEWELRY, 
	@JsonProperty("ELECTRONICS")
	ELECTRONICS, 
	@JsonProperty("SPORT_EQUIPMENT")
	SPORT_EQUIPMENT
}
