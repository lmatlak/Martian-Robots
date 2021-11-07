package com.lio.martianrobots.controller;

import com.lio.martianrobots.model.*;

import java.util.ArrayList;
import java.util.List;

public class InstructionsController {
	private final List<Position> scents;

	public InstructionsController() {
		this.scents = new ArrayList<>();
	}

	public void executeInstruction(MarsPlanet grid, Robot robot, Instruction instruction) {
		switch (instruction) {
		case R:
			robot.setDirection(Direction.turnClockwise(robot.getDirection()));
			break;
		case L:
			robot.setDirection(Direction.turnAntiClockwise(robot.getDirection()));
			break;
		case F:
			Position position = move(robot);
			boolean isOffGrid;
			if ((isOffGrid = isOffGrid(grid, position)) && !isMarkedScent(scents, robot.getCurPosition())) {
				scents.add(robot.getCurPosition());
				robot.setPrvPosition(robot.getCurPosition());
				robot.setLost(true);
			} else if (!isOffGrid) {
				robot.setPrvPosition(robot.getCurPosition());
				robot.setCurPosition(position);
			}
			break;
		}
	}

	private Position move(Robot robot) {
		Position curPosition = robot.getCurPosition();
		int x = curPosition.getX();
		int y = curPosition.getY();
		switch (robot.getDirection()) {
		case N:
			curPosition = new Position(x, y + 1);
			break;
		case S:
			curPosition = new Position(x, y - 1);
			break;
		case E:
			curPosition = new Position(x + 1, y);
			break;
		case W:
			curPosition = new Position(x - 1, y);
			break;
		}
		return curPosition;
	}

	private boolean isOffGrid(MarsPlanet grid, Position position) {
		return (position.getX() < 0 || position.getY() < 0 || position.getX() > grid.getArea().getX()
				|| position.getY() > grid.getArea().getY());
	}

	private boolean isMarkedScent(List<Position> scents, Position position) {
		return scents.contains(position);
	}
}
