package com.lio.martianrobots.model;

import com.lio.martianrobots.controller.InstructionsController;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verifyZeroInteractions;

public class MarsPlanetTest {
	
	@Mock
	private InstructionsController controller;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void shouldMoveRobotInsideTheGrid() {
		Position position = new Position(5, 3);
		Robot robort = new Robot(new Position(1, 1), Direction.W, Arrays.asList(Instruction.R, Instruction.F, Instruction.L));
		List<Robot> robots = new ArrayList<>();
		robots.add(robort);
		MarsPlanet planet = new MarsPlanet(position, new InstructionsController(), robots);
		
		String output = planet.executeInstructions();
	
		assertEquals(false, robort.isLost());
		assertEquals("1 2 W\n", output);
	}
	
	@Test
	public void shouldRobotBeMarkedIfLost() {
		Position position = new Position(5, 3);
		Robot robort = new Robot(new Position(0, 0), Direction.S, Arrays.asList(Instruction.F, Instruction.F));
		List<Robot> robots = new ArrayList<>();
		robots.add(robort);
		MarsPlanet planet = new MarsPlanet(position, new InstructionsController(), robots);
		
		String output = planet.executeInstructions();
	
		assertEquals(true, robort.isLost());
		assertEquals("0 0 S LOST\n", output);
	}
	
	@Test
	public void shouldNotInteractWithControllerIfNoRobotsOnThePlanet() {
		Position position = new Position(5, 3);
		MarsPlanet planet = new MarsPlanet(position, controller, new ArrayList<>());
		
		String output = planet.executeInstructions();
		
		assertEquals(true, output.isEmpty());
		verifyZeroInteractions(controller);
	}
}
