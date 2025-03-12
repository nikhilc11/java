package com.interview.aidash.round1;

import java.util.Map;
import java.util.List;

public class ElevatorController {

	Integer buildingNumberOfElevators;
	Integer buildingTopFloorNumber;
	Integer buildingBottomFloorNumber;
	
	Map<Integer, Elevator> elevatorsMap;
	Map<Integer, ButtonPanel> buttonPanelMap;

	List<Elevator> elevatorsListGoingUp;
	List<Elevator> elevatorsListGoingDown;
	List<Elevator> elevatorsListStatic;

	
	List<ButtonPanel> buttonPanelAction;
	
	public ElevatorController() {
		
		// Adding all number of elevators
		for (int elevatorIndex = 1; elevatorIndex <= buildingNumberOfElevators; elevatorIndex++)
			elevatorsMap.put(elevatorIndex, new Elevator());
		
		// Adding all Button Panels
	}
	
	public void ElevatorActionListAddEntry(ButtonPanel buttonPanel) {
		// Add the button
		buttonPanelAction.add(buttonPanel);
		
		// Process to identify the list for the best / optimal operation
		ProcessElevatorButtonAction(buttonPanel);
		
		// Enter the Elevator identified to the Elevator Action List
		Integer elevatorNumber = 1;
		Integer FloorNumber = 21;
		elevatorsMap.get(elevatorNumber).addFloorToTheElevatorNextFloorListInOrder(FloorNumber); //Position or order of the operation part of this function
	}
	
	private void ProcessElevatorButtonAction(ButtonPanel buttonPanel) {
		
		// Get Button Panel Details Which would include the Floor request and the direction of movement
		// Go through the list of Elevators that are available to serve:
		// 1. In the same direction + Closes Floor
		// 2. Static + Closes Floor
		// 3. Opposite Direction + Closes Floor
		
	}
}
