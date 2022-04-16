package airlines;

import java.util.*;


public class Airport implements Comparable<Airport>
{
	private String					name;
	private int						x;
	private int						y;
	private Set<Airport>			connections;	// all airports with a direct route from this airport
	
	
	public Airport(String name, int x, int y)
	{
		this.name = name;
		this.x = x;
		this.y = y;
		connections = new TreeSet<>();
	}
	
	
	public String getName()
	{
		return name;
	}
	
	
	public int getX()
	{
		return x;
	}
	
	
	public int getY()
	{
		return y;
	}
	
	
	public List<Airport> getConnections()
	{
		return new ArrayList<>(connections);
	}
	
	
	// Adds that airport to the list of connections. This is a one-way route, so
	// don’t add this airport to that’s list of connections.
	public void connectTo(Airport that)
	{
		connections.add(that);
	}
	
	
	//
	// Does nothing if this airport is not connected to that.
	//
	public void disconnectFrom(Airport that)
	{
		if(that.isConnectedTo(this))
		connections.remove(that);	
	}
	
	
	// Use best practice.
	@Override
	public boolean equals(Object x)
	{
		Airport that = (Airport) x;
		return compareTo(that) == 0;
	}
	
	
	// Just compare by airport name.
	@Override
	public int compareTo(Airport that)
	{
		return this.name.compareTo(that.name);
		
	}
	
	//Check if the two airports are still connected
	public boolean isConnectedTo(Airport that)
	{
		return connections.contains(that);
	}
	
	
	@Override
	public String toString()
	{
		return "Airport " + name + " @(" + x + "," + y + ")";
	}
	
// Debugging the code
public static void main(String[] args) {
	Airport a1 = new Airport("SEA", 100, 150);
	Airport a2 = new Airport("SFO", 80, 350);
	Airport a3 = new Airport("SEA", 100, 150);
	Airport a4 = new Airport("JFK", 900, 250);
	//SEA-> SFO, JFK
	a1.connectTo(a2);
	a1.connectTo(a4);
	//SFO-> JFK, SEA
	a2.connectTo(a4);
	a2.connectTo(a1);
	//JFK-> SEA, SFO
	a4.connectTo(a2);
	a4.connectTo(a1);
	System.out.println(a4.getConnections());
	//JFK-> SFO
	a4.disconnectFrom(a1);
	System.out.println(a4.getConnections());
	//checking for two same airports by its name
	System.out.println(a1.equals(a3));
	//checking compare toMethod
	System.out.println(a1.compareTo(a3));
	//check if two airports have flights
	System.out.println(a2.isConnectedTo(a4));
	//check toString method
	System.out.println(a2.toString());
	}
}

