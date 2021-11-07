package com.lio.martianrobots.model;

import com.lio.martianrobots.controller.InstructionsController;

import java.util.Iterator;
import java.util.List;

public class MarsPlanet {
	private final Position area;
	private final InstructionsController controller;
	private final List<Robot> robots;

	public MarsPlanet(Position area, InstructionsController controller, List<Robot> robots) {
		this.area = area;
		this.controller = controller;
		this.robots = robots;
	}

	public Position getArea() {
		return area;
	}

	public String executeInstructions() {
		StringBuilder sb = new StringBuilder();
		for (Robot robot : robots) {
			Iterator<Instruction> it = robot.getInstructions().iterator();
			do {
				controller.executeInstruction(this, robot, it.next());
			} while (it.hasNext() && !robot.isLost());

			sb.append(robot.robotStateToString() + "\n");
		}
		return sb.toString();
	}
}
