package com.lio.martianrobots.model;

public enum Direction {
	E, S, W, N;

	public static Direction turnClockwise(Direction direction) {
		switch (direction) {
		case N:
			return E;
		case E:
			return S;
		case S:
			return W;
		case W:
			return N;
		}
		throw new UnsupportedOperationException();
	}

	public static Direction turnAntiClockwise(Direction direction) {
		switch (direction) {
		case N:
			return W;
		case W:
			return S;
		case S:
			return E;
		case E:
			return N;
		}
		throw new UnsupportedOperationException();
	}
}
