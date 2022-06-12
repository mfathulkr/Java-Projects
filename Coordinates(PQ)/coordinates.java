//-----------------------------------------------------
// Title: coordinates class
// Author: Mehmet Fatih Ülker
// ID: 15431917506
// Section: 01
// Assignment: 04
// Description: This class is a node class for the coordinates.
//-----------------------------------------------------
public class coordinates {

	int x, y;
	
	double distance;	
	// the constructor
	coordinates (int x, int y){
		this.x = x;
		this.y = y;
		this.distance = Math.sqrt((x*x)+(y*y));
	}

}
