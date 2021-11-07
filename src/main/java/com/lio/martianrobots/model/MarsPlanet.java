package com.lio.martianrobots.model;

import java.util.Iterator;
import java.util.List;

public class MarsPlanet {
	private final Position area;
	private final List<Robot> robots;

	public MarsPlanet(Position area, List<Robot> robots) {
		this.area = area;
		this.robots = robots;
	}

	public Position getArea() {
		return area;
	}

	public List<Robot> getRobots() {
		return robots;
	}
}
