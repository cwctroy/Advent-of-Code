package crossedWires;

import java.util.Vector;

public class Wire {
	private Vector<Location> path = new Vector<Location>();
		
		
/***** CONSTRUCTORS *****/

	//Default
	public Wire() {
		
	}
	
	public Wire(String[] path) {
		tracePath(path);
	}
		
/***** GETTERS AND SETTERS *****/
	public Vector<Location> getPath() {
		return this.path;
	}
	
	public int getSize() {
		return this.path.size();
	}
	
	public int getDistance(int x, int y) {
		for (Location l : path) {
			if (l.getX() == x && l.getY() == y) {
				return l.getDistance();
			}
		}
		return -1;
	}

/***** UTILITY METHODS *****/
 	private void tracePath(String[] instructions) {
		int x = 0;
		int y = 0;
		int distance = 1;
		
		for (String instruction : instructions) {
			
			Location loc = new Location(0,0,0);
			
			/* get direction and length of instruction, then add each point along the way to the path */
			switch(instruction.charAt(0)) {
			
				case 'R': {
					int length = (Integer.parseInt(instruction.substring(1)));
					
					for (int i = 0; i < length; i++) {
						x++;
						loc = new Location(x, y, distance);
						path.add(loc);
						distance++;

					}
					
				}
				break;
				
				case 'L': {
					
					int length = (Integer.parseInt(instruction.substring(1)));
					
					for (int i = 0; i < length; i++) {
						x--;
						loc = new Location(x, y, distance);
						path.add(loc);
						distance++;
					}
					
				}
				break;
				
				case 'U': {
					
					int length = (Integer.parseInt(instruction.substring(1)));
					
					for (int i = 0; i < length; i++) {
						y++;
						loc = new Location(x, y, distance);
						path.add(loc);
						distance++;
					}
					
				}
				break;
				case 'D': {
					
					int length = (Integer.parseInt(instruction.substring(1)));
					
					for (int i = 0; i < length; i++) {
						y--;
						loc = new Location(x, y, distance);
						path.add(loc);
						distance++;
					}
					
				}
				break;
			
			}
			
		}
				
	}

	public void printPath() {
		for (Location loc : path) {
			System.out.print(loc.getX() + "," + loc.getY() + " ");
		}
	}
	
	public boolean hasLocation(Location loc) {
		
		boolean result = false;
		
		for (Location l : path) {
			if (l.getX() == loc.getX() && l.getY() == loc.getY()) {
				result = true;
				break;
			}
		}
		
		return result;
	}

}
