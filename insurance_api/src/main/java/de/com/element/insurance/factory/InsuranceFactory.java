package de.com.element.insurance.factory;

/**
 * @author diegosanteri
 *
 */
public class InsuranceFactory {
	
	private static final String INVALID_INSURANCE_TYPE = "Invalid insurance selected";
	
	public static Insurance getInsurance(final InsuranceType type) {
		
		switch(type) {
			
			case BIKE: {
				
				return new BikeInsurance();
			}
			
			case JEWELRY: {
				
				return new JewelryInsurance();
			}
			
			case ELECTRONICS: {
				
				return new EletronicsInsurance();
			}
			
			case SPORT_EQUIPMENT: {
				
				return new SportsEquipmentInsurance();
			}
			default: {
				
				throw new IllegalArgumentException(INVALID_INSURANCE_TYPE);
			}
		}		
	}
}
