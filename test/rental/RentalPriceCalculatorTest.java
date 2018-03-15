package rental;

import static org.junit.Assert.*;

import org.junit.Test;

public class RentalPriceCalculatorTest {
	RentalPriceCalculator newRental = new RentalPriceCalculator();
	int driverAge = 20; 
	int licenceHoldingYears = 1;
	int carClass = 1;
	boolean hadAccidents = false;
	boolean isHighSeason = false;
	
	@Test(expected = IllegalArgumentException.class)
	public void Younger18CannotRentCar() {
		driverAge = 17;
		newRental.validAge(driverAge);
	}
	
	@Test(expected = UnsupportedOperationException.class)
	public void Younger21CannotRentClass2() {
		driverAge = 17;
		carClass = 2;
		newRental.canDriveCar(driverAge, carClass,licenceHoldingYears);
	}
	@Test(expected = IllegalArgumentException.class)
	public void LicenceUnder1YearCannotRent() {
		licenceHoldingYears = 0;
		newRental.isValidLicenceHoldingYears(licenceHoldingYears);
	}
	@Test
	public void PriceIs50pctMoreTest() {
		carClass = 5;
		driverAge = 24;
		isHighSeason = true;
		double expectedMult= 1.5;
		double actualMult = newRental.LuxuryCarUnder25Multiplier(24, 5, true);
		assertEquals(expectedMult, actualMult,0.1);
	}
	
}
