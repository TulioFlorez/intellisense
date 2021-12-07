package com.intellisense.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

public class PeriodDto {

	@Min(value= 0)
	@Max(value = 180)
	private int period;

	
	
	/**
	 * @return the period
	 */
	public int getPeriod() {
		return period;
	}

	/**
	 * @param period the period to set
	 */
	public void setPeriod(int period) {
		this.period = period;
	}

	

}
