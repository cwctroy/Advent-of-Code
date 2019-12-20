package puzzles;

public class IntcodeReader {
	
	int index;
	int opcode;
	int[] code;
	
	public IntcodeReader(int[] code, int index) {
		this.index = index;
		this.code = code;
		this.opcode = code[index];
	}
	
	public void read() {
		
		while(true) {
			switch (opcode) {
			
				case 1: {
					int value = (code[index + 1]) + code[index + 2];
					code[index + 3] = value;
				}
				break;
				
				case 2: {
					int value = (code[index + 1]) * code[index + 2];
					code[index + 3] = value;
					
				}
				break;
				
//TODO				case 99: {
					
				}
				break;
				
//TODO				default: {
					
				}
			
			}
			
			//advance index
			index += 4;
		}
		
	}
	

}
