/**
 * @author diego
 *
 */
package de.com.element.insurance.factory;

import org.junit.Test;

import de.com.element.insurance.context.exception.BusinessErrorException;

public class InsuranceFactoryTest {
	
	@Test
	public void testBikeInsurance() {
		
		InsuranceFactory.getInsurance(InsuranceType.BIKE).calculate(500);
	}
	
	@Test(expected=BusinessErrorException.class)
	public void testBikeInsuranceHighestValue() {
		
		InsuranceFactory.getInsurance(InsuranceType.BIKE).calculate(50000);
	}
	
	@Test
	public void testJewelryInsurance() {
		
		InsuranceFactory.getInsurance(InsuranceType.JEWELRY).calculate(4500);
	}
	
	@Test(expected=BusinessErrorException.class)
	public void testJewelryInsuranceHighestValue() {
		
		InsuranceFactory.getInsurance(InsuranceType.JEWELRY).calculate(500000);
	}
	
	@Test
	public void testEletronicsInsurance() {
		
		InsuranceFactory.getInsurance(InsuranceType.ELECTRONICS).calculate(1500);
	}
	
	@Test(expected=BusinessErrorException.class)
	public void testEletronicsInsuranceHighestValue() {
		
		InsuranceFactory.getInsurance(InsuranceType.ELECTRONICS).calculate(50000);
	}
	
	@Test
	public void testSportEquipmentInsurance() {
		
		InsuranceFactory.getInsurance(InsuranceType.SPORT_EQUIPMENT).calculate(2500);
	}
	
	@Test(expected=BusinessErrorException.class)
	public void testSportEquipmentHighestValue() {
		
		InsuranceFactory.getInsurance(InsuranceType.SPORT_EQUIPMENT).calculate(50000);
	}
			
}