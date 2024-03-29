package main;

import puzzles.FuelCalculator;
import puzzles.IntcodeReader;
import puzzles.PasswordCounter;

public class Main {
	
	public static void testFuelCalculater() {
		
		int[] massArray = { 148623, 147663,	67990, 108663, 62204, 140999, 123277, 52459, 143331, 71135, 76282, 
				69509, 72977, 120407, 62278, 136882, 131667, 146225, 112216, 108600, 127267, 149149, 72977, 
				149639, 101527, 70059, 124825, 69539, 141444, 64138, 71145, 68178, 134752, 79431, 126342, 
				134161, 135424, 95647, 54507, 104852, 100164, 118799, 57387, 93136, 133359, 144942, 89337, 
				60441, 131825, 93943, 98142, 108306, 55355, 115813, 83431, 125883, 101115, 107938, 103484, 
				61174, 123502, 73670, 91619, 136860, 93268, 149648, 105328, 53194, 115351, 130953, 85611,
				71134, 141663, 106590, 56437, 147797, 98484, 60851, 121252, 66898, 56502, 103796, 86497, 121534,
				70914, 122642, 53151, 131939, 108394, 128239, 103490, 122304, 113810, 141469, 79176, 108002, 
				91942, 84400, 101217, 116287
		};
		
		int total = FuelCalculator.calculateFuel(massArray);
		
		System.out.println("Total fuel required: " + total);
		
	}
	
	public static void testIntcodeReader() {
		
		int outputGoal = 19690720;
		
		int noun;
		int verb;
		
		for (int i = 0; i < 99; i++) {
			for (int j = 0; j < 99; j++) {
				noun = i;
				verb = j;
			
				int[] memory = {
						1,noun,verb,3,
						1,1,2,3,
						1,3,4,3,
						1,5,0,3,
						2,9,1,19,
						1,5,19,23,
						2,9,23,27,
						1,27,5,31,
						2,31,13,35,
						1,35,9,39,
						1,39,10,43,
						2,43,9,47,
						1,47,5,51,
						2,13,51,55,
						1,9,55,59,
						1,5,59,63,
						2,6,63,67,
						1,5,67,71,
						1,6,71,75,
						2,9,75,79,
						1,79,13,83,
						1,83,13,87,
						1,87,5,91,
						1,6,91,95,
						2,95,13,99,
						2,13,99,103,
						1,5,103,107,
						1,107,10,111,
						1,111,13,115,
						1,10,115,119,
						1,9,119,123,
						2,6,123,127,
						1,5,127,131,
						2,6,131,135,
						1,135,2,139,
						1,139,9,0,99,
						2,14,0,0
					};
			
					IntcodeReader reader = new IntcodeReader(memory, 0);
					
					reader.read();
					
					if (memory[0] == outputGoal) {
						
						System.out.println("Noun = " + i + ". Verb = " + j);
						
					}
			}
			
		}		
	}

	public static void testPasswordCounter() {
		
		PasswordCounter pwc = new PasswordCounter();
		
		int total = pwc.getNumPasswords();
		
		System.out.println(total);
		
	}
	
	public static void main(String[] args) {

		testPasswordCounter();
		
	}
	
}
