package puzzles;


/*
 * this file calculates the fuel needed to launch a module.
 * Fuel required to launch a given module is based on its mass. Specifically, to find the fuel required for a module,
 *  take its mass, divide by three, round down, and subtract 2.
 *
 * For example:
 *
 * For a mass of 12, divide by 3 and round down to get 4, then subtract 2 to get 2.
 * For a mass of 14, dividing by 3 and rounding down still yields 4, so the fuel required is also 2.
 * For a mass of 1969, the fuel required is 654.
 * For a mass of 100756, the fuel required is 33583.
 */
public class FuelCalculator {
	
	private static int calculateFuel(int mass) {
		
		mass /= 3;
		if (mass <= 2) {
			return 0;
		}
		else {
			mass -= 2;
			return mass;
		}
		
	}
	
	private static int calculateTotalFuel(int mass) {

		int sum = 0;		
		int fuel = calculateFuel(mass);
		
		while (fuel > 0) {			
			sum += fuel;
			fuel = calculateFuel(fuel);			
			
		}
		
		return sum;
		
	}
	
	
	public static int calculateFuel(int[] massArray) {
		int sum = 0;
		
		for (int mass : massArray) {
			sum += calculateTotalFuel(mass);		
		}
		
		return sum;
		
	}

}
