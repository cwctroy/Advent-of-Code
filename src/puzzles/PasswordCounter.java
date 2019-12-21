package puzzles;

import java.util.Arrays;

public class PasswordCounter {
	
	final int DEFAULT_LENGTH = 6;
	final int[] DEFAULT_START_ARRAY = {1,7,1,3,0,9};
	final int[] DEFAULT_END_ARRAY = {6,4,3,6,0,3};
	final int DEFAULT_START = 171309;
	final int DEFAULT_END = 643603;
	
	private int[] startArray;
	private int start;
	private int end;
	
	public PasswordCounter() {
		this.startArray = DEFAULT_START_ARRAY;
		this.start = DEFAULT_START;
		this.end = DEFAULT_END;
	}
	
	private int arrayToInt(int[] array) {
		int total = 0;
		for (int i = 0; i < array.length; i++) {
			total *= 10;
			total += array[i];
		}
		return total;
		
	}
	
	public int[] intToArray(int n) {
		String str = "" + n;
		String[] strArray = new String[str.length()];
		
		for (int i = 0; i < strArray.length; i++) {
			strArray[i] = Character.toString((str.charAt(i)));
		}
		
		int[] intArray = new int[strArray.length];
		
		for (int i = 0; i < strArray.length; i++) {
			intArray[i] = Integer.parseInt(strArray[i]);
		}
		
		return intArray;
	}
	
	public boolean isViablePassword(int[] array) {
		
		int value = arrayToInt(array);
		
		if (value < start || value > end) {
			return false;
		}
		
		boolean doubleIsPresent = false;
		
		for (int i = 0; i < array.length; i++) {
			
			//don't check past the end of the array
			if (i+1 < array.length) {
				//if next number decreases, password not viable
				if (array[i] > array[i+1]) {
					return false;
				}
				
				//if next number is equal, check for double
				else if (array[i] == array[i+1]) {
					
					//check if previous also matches
					if (i == 0) {
						if (array[i+2] != array[i]) {
							doubleIsPresent = true;
						}
					}
					else if (i+2 < array.length) {
						if (array[i-1] != array[i] && array[i+2] != array[i]) {
							doubleIsPresent = true;
						}
					}
					else if (array[i-1] != array[i]) {
						doubleIsPresent = true;
					}
				}
			}
		}
		return doubleIsPresent;
		
	}
	
	public int getNumPasswords() {
		int total = 0;
		
		//create array to check
		int[] array = Arrays.copyOf(startArray, startArray.length);
		
		for (int i = start; i < end; i++) {
			
			//test current password
			if (isViablePassword(array)) {
				total++;
			}
			
			//increment password
			int num = arrayToInt(array);
			num++;
			array = intToArray(num);
			
		}
		
		return total;
		

	}

}
