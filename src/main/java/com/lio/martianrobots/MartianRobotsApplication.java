package com.lio.martianrobots;

import com.lio.martianrobots.model.MarsPlanet;
import com.lio.martianrobots.parser.InstructionsFileParser;

import java.io.IOException;

public class MartianRobotsApplication {
	public static void main(String[] args) throws IOException {
		String instructionsFileName = args[0]; //e.g. ./src/main/resources/input_instructions_file.txt
		
		InstructionsFileParser fileParser = new InstructionsFileParser(instructionsFileName);

		MarsPlanet marsPlanet = fileParser.generateMarsPlanet();

		String output = marsPlanet.executeInstructions();

		System.out.println(output);
	}
}
