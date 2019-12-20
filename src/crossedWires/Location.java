package crossedWires;

public class Location {
	
	private int x;
	private int y;
	private int distance;
	
/***** GETTERS AND SETTERS *****/
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}
	
	public Location(int x, int y, int distance) {
		this.x = x;
		this.y = y;
		this.distance = distance;
	}

}
