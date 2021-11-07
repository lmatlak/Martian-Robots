package com.lio.martianrobots.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DirectionTest {

	@Test
	public void shouldTurnDirectionClockwise() {
		Direction d = Direction.turnClockwise(Direction.E);
		assertEquals(Direction.S, d);

		d = Direction.turnClockwise(d);
		assertEquals(Direction.W, d);

		d = Direction.turnClockwise(d);
		assertEquals(Direction.N, d);

		d = Direction.turnClockwise(d);
		assertEquals(Direction.E, d);
	}

	@Test
	public void shouldTurnDirectionAntiClockwise() {
		Direction d = Direction.turnAntiClockwise(Direction.E);
		assertEquals(Direction.N, d);

		d = Direction.turnAntiClockwise(d);
		assertEquals(Direction.W, d);

		d = Direction.turnAntiClockwise(d);
		assertEquals(Direction.S, d);

		d = Direction.turnAntiClockwise(d);
		assertEquals(Direction.E, d);
	}
}
