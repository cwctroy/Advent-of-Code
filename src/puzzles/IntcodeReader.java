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
		
		boolean flag = true;
		
		while(flag){
			
			opcode = code[index];
			
			switch (opcode) {
			
				case 1: {
					int value = (code[code[index + 1]]) + code[code[index + 2]];
					code[code[index + 3]] = value;
				}
				break;
				
				case 2: {
					int value = (code[code[index + 1]]) * code[code[index + 2]];
					code[code[index + 3]] = value;
					
				}
				break;
				
				case 99: {
					flag = false;
					
				}
				break;
				
				default: {
					System.out.println("Unknown opcade: " + opcode + ". Program terminating");
					
				}
			
			}
			
			//advance index
			index += 4;
		}
		
	}
	

}
