package de.com.element.insurance.factory;

import de.com.element.insurance.context.exception.BusinessErrorException;

/**
 * @author diegosanteri
 *
 */
public class Insurance {

	private final double min;
	private final double max;
	private final double risk;

	public Insurance(final double min, final double max, final double risk) {

		this.min = min;
		this.max = max;
		this.risk = risk;
	}

	public final double calculate(final double productValue) {
		
		validate(productValue);
		return productValue * risk;
	}
	
	private void validate(final double productValue) {
		
		if (productValue <= min || productValue > max) {

			throw new BusinessErrorException(
					"Product value must be between " + min + " and " + max);
		}
	}

}
