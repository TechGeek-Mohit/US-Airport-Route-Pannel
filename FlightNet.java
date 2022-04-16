package airlines;
import java.util.HashSet;

public class FlightNet extends HashSet<Airport> {

/**
 * To check if airport can be added in Flight Net  
 * @param name of the airport to be checked in FlightNet list of a airport 
 * @return false if the airport name is there in the FlightNet list of the airport
 */
	public boolean nameIsAvailable(String name) {
		for(Airport a : this) {
			if(a.getName().equals(name)) 
				return false;
		}
		return true;	
	}
	
/**
* Creates a flight route between two airports
* @param a1 airport to be connected from
* @param a2 airport to be connected to
*/
	public void connect(Airport a1, Airport a2) {
		a1.connectTo(a2);
		a2.connectTo(a1);
	}
	
/**
* Deletes a flight route between two airports
* @param a1 airport to be disconnected from
* @param a2 airport to be disconnected to
*/
	public void disconnect(Airport a1, Airport a2) {
		a1.disconnectFrom(a2);
		a2.disconnectFrom(a1);
	}

/**
 * Remove the airport from the US map and disconnects all its route with other airports
 * @param removeMe the airport to be removed from the map
 */
	public void removeAndDisconnect(Airport removeMe) {
		this.remove(removeMe);
		for(Airport a : this) {
			a.disconnectFrom(removeMe);
		}	
	}
	
/**
 * Gets the nearest airport within the maximum Distance a flight can travel
 * @param x the horizontal coordinate of  airport to be found
 * @param y the vertical coordinate of airport to be found
 * @param maximumDistance the distance which flight can travel
 * @return the airport within the maximum Distance a flight can travel
 */
	public Airport getAirportNearXY(int x, int y, int maximumDistance) {
		
		for(Airport a : this) {
			int distance = (int) Math.hypot(a.getX() - x, a.getY() - y);
			if(distance <= maximumDistance)
				return a;
		}
    	return null;
	}
    
	
	
	
	

}
