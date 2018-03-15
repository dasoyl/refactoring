package rental;

public class RentalPriceCalculator {
	public double class4AgeUnder25HighSeasonMult = 1.5;
	public double licenceUnder3YearsMult = 1.3;
	public double accidentsInHistoryUpcharge = 15;
	public double priceMaxCap = 1000;
	public double noMult = 1;
	public double noUpcharge = 0;
	public double rentalPrice;
	
	public void CalculateRentPrice(int driverAge, int licenceHoldingYears, int carClass, boolean hadAccidents, boolean isHighSeason) {
		
		if (canDriveCar(driverAge,carClass,licenceHoldingYears)) {
			rentalPrice = driverAge;
			rentalPrice = rentalPrice * LuxuryCarUnder25Multiplier(driverAge, carClass, isHighSeason)*RentalPriceMultiplierAccordingToYears(licenceHoldingYears) + RentalPriceAdditionAccordingAccidents(hadAccidents);
			rentalPrice = RentalPriceMaxCap(rentalPrice);
		}
	}
	public boolean validAge(int age) {
		if (age < 18) {
			throw new IllegalArgumentException("Driver too young - cannot quote the price");
		}
		return true;
	}
	
	public boolean canDriveCar(int age, int carClass, int licenceYears) {
		if (carClass >= 2 && age <= 21) {
				throw new UnsupportedOperationException("Drivers 21 y/o or less can only rent Class 1 vehicles");
		} else { boolean canDrive = validAge(age) && isValidLicenceHoldingYears(licenceYears);
			return canDrive;
		}
	}

	
	public double RentalPriceMultiplierAccordingToYears(int licenceHoldingYears) {
		if (licenceHoldingYears < 3) {
			return licenceUnder3YearsMult;
		}
		return noMult;
	}
	
	public double LuxuryCarUnder25Multiplier(int driverAge, int carClass, boolean isHighSeason) {
		
		if(carClass >=4 && driverAge <= 25 && isHighSeason != false) {
			return class4AgeUnder25HighSeasonMult;}
		else {
				return noMult;
			}
	}
	public double RentalPriceAdditionAccordingAccidents(boolean hasAccidents) {
		if (hasAccidents) {
			return accidentsInHistoryUpcharge;
		}
		return noUpcharge;
	}
	
	public boolean isValidLicenceHoldingYears(int year) {
		if (year < 1) {
			throw new IllegalArgumentException("Driver must hold driving licence at least for one year. Can not rent a car!");
		}
		return true;
	}
	public double RentalPriceMaxCap(double rentPrice) {
		if(rentPrice > 1000) {return priceMaxCap;} else {return rentPrice;}
	}
}