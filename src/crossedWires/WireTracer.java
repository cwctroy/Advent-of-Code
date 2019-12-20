package crossedWires;

import java.util.Vector;

public class WireTracer {
	
	
	public static int getManhattanDistance(Location l) {
		
			int x = Math.abs(l.getX());
			int y =  Math.abs(l.getY());
			int distance = x + y;
			
			/* add checking for integer overflow */
			if (distance < x || distance < y) {
				return Integer.MAX_VALUE;
			}
			else return distance;
	}
	
	
	public static Vector<Location> getIntersections(Wire wire1, Wire wire2) {
		Vector<Location> path1 = wire1.getPath();
		Vector <Location> intersections = new Vector<Location>();
		
		for (Location l : path1) {
			if (wire2.hasLocation(l)) {
				intersections.add(l);
			}
		}
		
		return intersections;		
	}
	
	public static Location getNearestIntersectToOrigin(Wire wire1, Wire wire2) {
		Vector<Location> path;
		Wire wire;
		
		if (wire1.getSize() < wire2.getSize()) {
			path = wire1.getPath();
			wire = wire2;
		}
		else {
			path = wire2.getPath();
			wire = wire1;
		}
		Location nearest = new Location(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE);
		
		for (Location l : path) {
			if (wire.hasLocation(l)) {
				System.out.println("intersect found at " + l.getX() + "," + l.getY());
				if (getManhattanDistance(l) < getManhattanDistance(nearest)) {
					System.out.println("intersect updated");
					nearest = l;
				}

			}
		}
		
		return nearest;		
	}
	
	public static int getNearestManhattan(Wire wire1, Wire wire2) {
		Vector<Location> path;
		Wire wire;
		
		if (wire1.getSize() < wire2.getSize()) {
			path = wire1.getPath();
			wire = wire2;
		}
		else {
			path = wire2.getPath();
			wire = wire1;
		}
		Location nearest = new Location(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE);
		
		for (Location l : path) {
			if (wire.hasLocation(l)) {
				if (getManhattanDistance(l) < getManhattanDistance(nearest)) {
					nearest = l;
				}
			}
		}
		return getManhattanDistance(nearest);
	}
	
	public static int getShortestIntersect(Wire wire1, Wire wire2) {
		Vector<Location> path;
		Wire wire;
		
		if (wire1.getSize() < wire2.getSize()) {
			path = wire1.getPath();
			wire = wire2;
		}
		else {
			path = wire2.getPath();
			wire = wire1;
		}
		int nearest = Integer.MAX_VALUE;
		
		for (Location l : path) {
			if (wire.hasLocation(l)) {
				int distance = wire.getDistance(l.getX(), l.getY()) + l.getDistance();					
					if (distance < nearest) {
						nearest = distance;
					}
			}
		}
		return nearest;
	}

}
