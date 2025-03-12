package com.interview.aidash.round1;

import java.util.List;

public class Elevator {

	Integer floorNumber; // (-n - +m)
	Integer direction;   // (-1 => Down, 0 => Stopped, 1=> Up)
	Boolean active;      // True => Active / False => Inactive
	
	List<Integer> nextFloorList;
	
	Elevator() {
		floorNumber = 0;
		direction = 0;
		active = true;
	}
	
	public void addFloorToTheElevatorNextFloorListInOrder(Integer floorNumber) {
		
	}
}
