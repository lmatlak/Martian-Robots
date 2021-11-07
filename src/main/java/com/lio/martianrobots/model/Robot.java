package com.lio.martianrobots.model;

import java.util.List;

public class Robot {
	private Position prvPosition;
	private Position curPosition;
	private Direction direction;
	private final List<Instruction> instructions;
	private boolean isLost;

	public Robot(Position curPosition, Direction direction, List<Instruction> instructions) {
		this.prvPosition = null;
		this.curPosition = curPosition;
		this.direction = direction;
		this.instructions = instructions;
		this.isLost = false;
	}

	public Position getPrvPosition() {
		return prvPosition;
	}

	public void setPrvPosition(Position prvPosition) {
		this.prvPosition = prvPosition;
	}

	public Position getCurPosition() {
		return curPosition;
	}

	public void setCurPosition(Position curPosition) {
		this.curPosition = curPosition;
	}

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	public List<Instruction> getInstructions() {
		return instructions;
	}

	public boolean isLost() {
		return isLost;
	}

	public void setLost(boolean lost) {
		isLost = lost;
	}

	public String robotStateToString() {
		if (isLost) {
			return String.format("%s %s %s LOST", prvPosition.getX(), prvPosition.getY(), direction.toString());
		} else {
			return String.format("%s %s %s", curPosition.getX(), curPosition.getY(), direction.toString());
		}

	}
}
