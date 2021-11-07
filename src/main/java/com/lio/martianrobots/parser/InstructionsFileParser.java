package com.lio.martianrobots.parser;

import com.lio.martianrobots.model.*;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class InstructionsFileParser {
	private final String instructionsFileName;
	private MarsPlanet marsGrid;
	private final List<Robot> robots;

	public InstructionsFileParser(String instructionsFileName) {
		this.instructionsFileName = instructionsFileName;
		this.robots = new ArrayList<>();
	}

	public MarsPlanet generateMarsPlanet() throws IOException {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(instructionsFileName)))) {
			String line;
			boolean gridLine = true;
			while ((line = br.readLine()) != null) {
				if (!line.isEmpty()) {
					if (gridLine) {
						String[] grid = line.split("\\s+");
						marsGrid = new MarsPlanet(new Position(Integer.parseInt(grid[0]), Integer.parseInt(grid[1])),
								this.robots);
						gridLine = false;
					} else {
						String[] robotPosition = line.split("\\s+");
						String robotInstructions = br.readLine();
						List<Instruction> instructions = generateInstructions(robotInstructions);

						Robot robot = new Robot(
								new Position(Integer.parseInt(robotPosition[0]), Integer.parseInt(robotPosition[1])),
								Direction.valueOf(robotPosition[2]), instructions);
						robots.add(robot);
					}
				}
			}
		}
		return marsGrid;
	}

	private List<Instruction> generateInstructions(String robotInstructions) {
		return robotInstructions.chars().mapToObj(i -> Instruction.valueOf(Character.toString((char) i)))
				.collect(Collectors.toList());
	}
}
